package com.example.apigetter.controller;

import com.example.apigetter.common.CommonHelper;
import com.example.apigetter.entities.collected.Collected;
import com.example.apigetter.entities.collected.CollectedRdbms;
import com.example.apigetter.entities.config.model.FILE_DETAIL_INPUT;
import com.example.apigetter.entities.config.repository.FileDetailInputRepository;
import com.example.apigetter.entities.report.model.FILE_QUEUE;
import com.example.apigetter.entities.report.repository.FileQueueRepository;
import com.example.apigetter.entities.response.ResponseJson;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
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
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Properties;


@RestController("/")
public class GetController {
    private static Logger log = LoggerFactory.getLogger(GetController.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private Gson gson = new Gson();
    private Connection conn;

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

    @GetMapping("/force_rdbms")
    public ResponseJson get_rdbms() {
        FILE_DETAIL_INPUT config = fileDetailInputRepository.findByFileId("RDBMS01");
        log.info("Fetched Config : " + config.toString());
        JSONArray jsonArray = new JSONArray();
        String path = null;

        try {
            connect(config);

            //collect data from rdbms
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from actor");

//            //urutan bener tapi harus dimasukkin ke sebuah object dulu / ditaro hashmap
            while (rs.next()) {
                CollectedRdbms collectedRdbms = new CollectedRdbms(rs.getLong("actor_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getTimestamp("last_update"));
                jsonArray.add(collectedRdbms);
            }
            path = saveToJson(jsonArray, config.getFileId(), config.getFileIdName());

//            urutan nya kolomnya ngaco
//            ResultSetMetaData rsmd = rs.getMetaData();
//            while(rs.next()) {
//                int numColumns = rsmd.getColumnCount();
//                JSONObject obj = new JSONObject();
//                for (int i=1; i<=numColumns; i++) {
//                    String column_name = rsmd.getColumnName(i);
//                    obj.put(column_name, rs.getObject(column_name));
//                }
//                jsonArray.add(obj);
//            }
//            path = saveToJson(jsonArray,config.getFileId(),config.getFileIdName());

        } catch (Exception e) {
            log.error(e.toString());
        } finally {
            close();

            //create and insert object into file_queue
            FILE_QUEUE fq = new FILE_QUEUE();
            fq.setFilenameInput(config.getFileIdName());
            fq.setFileId(config.getFileId());
            fq.setStep("COLLECTED");
            fileQueueRepository.save(fq);
            log.info("Inserted data to FILE_QUEUE : " + fq.toString());
        }

        ResponseJson responseJson = new ResponseJson();
        if (jsonArray.size() != 0) {
            responseJson.setSuccess(true);
        } else {
            responseJson.setSuccess(false);
        }
        responseJson.setData(jsonArray);

        return responseJson;
    }

    @PostMapping("/force_rdbms")
    public ResponseJson post_rdbms() {
        FILE_DETAIL_INPUT config = fileDetailInputRepository.findByFileId("RDBMS01");
        log.info("Fetched Config : " + config.toString());
        JSONArray jsonArray = new JSONArray();
        String path = null;

        try {
            connect(config);

            //collect data from rdbms
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from actor");

//            //urutan bener tapi harus dimasukkin ke sebuah object dulu / ditaro hashmap
            while (rs.next()) {
                CollectedRdbms collectedRdbms = new CollectedRdbms(rs.getLong("actor_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getTimestamp("last_update"));
                jsonArray.add(collectedRdbms);
            }
            path = saveToJson(jsonArray, config.getFileId(), config.getFileIdName());

//            urutan nya kolomnya ngaco
//            ResultSetMetaData rsmd = rs.getMetaData();
//            while(rs.next()) {
//                int numColumns = rsmd.getColumnCount();
//                JSONObject obj = new JSONObject();
//                for (int i=1; i<=numColumns; i++) {
//                    String column_name = rsmd.getColumnName(i);
//                    obj.put(column_name, rs.getObject(column_name));
//                }
//                jsonArray.add(obj);
//            }
//            path = saveToJson(jsonArray,config.getFileId(),config.getFileIdName());

        } catch (Exception e) {
            log.error(e.toString());
        } finally {
            close();

            //create and insert object into file_queue
            FILE_QUEUE fq = new FILE_QUEUE();
            fq.setFilenameInput(config.getFileIdName());
            fq.setFileId(config.getFileId());
            fq.setStep("COLLECTED");
            fileQueueRepository.save(fq);
            log.info("Inserted data to FILE_QUEUE : " + fq.toString());
        }

        ResponseJson responseJson = new ResponseJson();
        if (jsonArray.size() != 0) {
            responseJson.setSuccess(true);
        } else {
            responseJson.setSuccess(false);
        }
        responseJson.setData(jsonArray);

        return responseJson;
    }

    private HttpHeaders createHttpHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);
        return headers;
    }

    private String saveToJson(Object body, String FileId, String FileIdName) {
        Gson gson = new Gson();
        PrintWriter printWriter = null;
        String json = gson.toJson(body);
        String pathToSave = null;
        if (CommonHelper.isLinuxsOs()) {
            pathToSave = env.getProperty("linuxPath");
        } else if (CommonHelper.isWindowsOs()) {
            pathToSave = env.getProperty("winPath");
        }

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
        return fullPath;
    }

    private String saveToJson(List body, String FileId, String FileIdName) {
        Gson gson = new Gson();
        PrintWriter printWriter = null;
        String json = gson.toJson(body);
        String pathToSave = null;
        if (CommonHelper.isLinuxsOs()) {
            pathToSave = env.getProperty("linuxPath");
        } else if (CommonHelper.isWindowsOs()) {
            pathToSave = env.getProperty("winPath");
        }
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
        return fullPath;
    }

    private Connection connect(FILE_DETAIL_INPUT config) {
        try {
            String url = String.format("jdbc:%s://%s:%d/%s", config.getRdbms(), config.getIp(), config.getPort(), config.getDatabase());
            Properties props = new Properties();
            props.setProperty("user", config.getUsername());
            props.setProperty("password", config.getPassword());
            conn = DriverManager.getConnection(url, props);
            if (conn != null) {
                log.info("Connected to " + conn.getMetaData().getURL());
            }
        } catch (SQLException e) {
            log.error(e.toString());
        }
        return conn;
    }

    private void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                String url = conn.getMetaData().getURL();
                log.info("Closing Connection to " + url);
                conn.close();
                if (conn.isClosed()) {
                    log.info(url + " Closed... ");
                }
            }
        } catch (SQLException e) {
            log.error(e.toString());
        }
    }
}