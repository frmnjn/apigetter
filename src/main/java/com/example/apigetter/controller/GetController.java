package com.example.apigetter.controller;

import com.example.apigetter.entities.config.model.FILE_DETAIL_INPUT;
import com.example.apigetter.entities.config.repository.FileDetailInputRepository;
import com.example.apigetter.entities.report.model.FILE_QUEUE;
import com.example.apigetter.entities.report.repository.FileQueueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;


@RestController("/")
public class GetController {

    private static Logger log = LoggerFactory.getLogger(GetController.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private FileDetailInputRepository fileDetailInputRepository;

    @Autowired
    private FileQueueRepository fileQueueRepository;

    @GetMapping("/force")
    public FILE_DETAIL_INPUT hello() {
        //fetch data super simple
        //FILE_DETAIL_INPUT fdi = restTemplate.getForObject(url, FILE_DETAIL_INPUT.class);

        //fetch data ribet
        String url = "http://192.168.100.9:3000/api_ribet?username=frmnjn";
        HttpHeaders headers = createHttpHeaders("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImZybW5qbiIsImlhdCI6MTU4NTAzMzA4NCwiZXhwIjoxNTg1MDM2Njg0fQ.VGtaJpCawZr--_1-mFKgDKTBsofqRbumvS9F9_V8Elg");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<FILE_DETAIL_INPUT> object = restTemplate.exchange(url, HttpMethod.GET, entity, FILE_DETAIL_INPUT.class);
        FILE_DETAIL_INPUT fdi = object.getBody();
        log.info("Fetched Data : " + fdi.toString());

        //insert into file_detail_input
        FILE_DETAIL_INPUT inserted = fileDetailInputRepository.save(fdi);
        log.info("Inserted Data to FILE_DETAIL_INPUT : " + inserted.toString());

        //create and insert object into file_queue
        FILE_QUEUE fq = new FILE_QUEUE();
        fq.setFilenameInput(fdi.getFileIdName());
        fq.setStatus("0");
        fq.setChecksum("asd");
        fq.setCreatedDate(new Date());
        fq.setCreatedBy("APP");
        fq.setFileFormatId(fdi.getFileFormatId());
        fq.setFileId(fdi.getFileId());
        fq.setFileTypeId(fdi.getFileTypeId());
        fq.setRegional(fdi.getRegional());
        fq.setStep("COLLECTED");
        fq.setWorker("");
        fq.setSyncHadoop("asd");
        fq.setProcessDate("asd");
        fileQueueRepository.save(fq);
        log.info("Inserted data to FILE_QUEUE : " + fq.toString());

        return inserted;
    }

    private HttpHeaders createHttpHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);
        return headers;
    }
}
