package com.example.apigetter.controller;

import com.example.apigetter.common.CommonHelper;
import com.example.apigetter.entities.collected.Collected;
import com.example.apigetter.entities.config.model.FILE_DETAIL_INPUT;
import com.example.apigetter.entities.config.repository.FileDetailInputRepository;
import com.example.apigetter.entities.report.model.FILE_QUEUE;
import com.example.apigetter.entities.report.repository.FileQueueRepository;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;


@RestController("/")
public class GetController {
    private static Logger log = LoggerFactory.getLogger(GetController.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private Gson gson;

    @Autowired
    private Environment env;

    @Autowired
    private FileDetailInputRepository fileDetailInputRepository;

    @Autowired
    private FileQueueRepository fileQueueRepository;

    @GetMapping("/force")
    public ResponseEntity get() {
        //get config
        FILE_DETAIL_INPUT config = fileDetailInputRepository.findByFileId("API01");
        log.info("Fetched Config : " + config.toString());

        //fetch data ribet
        String url = String.format("http://%s:%d/api_ribet?username=%s", config.getIp(), config.getPort(), config.getUsername());
        HttpHeaders headers = createHttpHeaders(config.getToken());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity object = restTemplate.exchange(url, HttpMethod.GET, entity, Collected.class);

        //save to file
        saveToJson(object.getBody(), config.getFileId(), config.getFileIdName());

        //create and insert object into file_queue
        FILE_QUEUE fq = new FILE_QUEUE();
        fq.setFilenameInput(config.getFileIdName());
        fq.setFileId(config.getFileId());
        fq.setStep("COLLECTED");
        fileQueueRepository.save(fq);
        log.info("Inserted data to FILE_QUEUE : " + fq.toString());

        return object;
    }

    @PostMapping("/force")
    public ResponseEntity post() {
        //get config
        FILE_DETAIL_INPUT config = fileDetailInputRepository.findByFileId("API01");
        log.info("Fetched Config : " + config.toString());

        //fetch data ribet
        String url = String.format("http://%s:%d/api_ribet", config.getIp(), config.getPort());
        HttpHeaders headers = createHttpHeaders(config.getToken());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", config.getUsername());
        jsonObject.put("password", config.getPassword());
        HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), headers);
        ResponseEntity object = restTemplate.exchange(url, HttpMethod.POST, entity, Collected.class);

        //save to file
        saveToJson(object.getBody(), config.getFileId(), config.getFileIdName());

        //create and insert object into file_queue
        FILE_QUEUE fq = new FILE_QUEUE();
        fq.setFilenameInput(config.getFileIdName());
        fq.setFileId(config.getFileId());
        fq.setStep("COLLECTED");
        fileQueueRepository.save(fq);
        log.info("Inserted data to FILE_QUEUE : " + fq.toString());

        return object;
    }

    private HttpHeaders createHttpHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);
        return headers;
    }

    private void saveToJson(Object body, String FileId, String FileIdName) {
        Gson gson = new Gson();
        PrintWriter printWriter = null;
        String json = gson.toJson(body);
        String pathToSave = env.getProperty("localPath");
        String fullPath = pathToSave + FileId + "_" + FileIdName + "_" + CommonHelper.convertDateToString("yyyyMMddHHmmss", new Date()) + ".json";
        try {
            printWriter = new PrintWriter(new File(fullPath));
            printWriter.write(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
        log.info("Collected as json file at " + fullPath);
    }
}
