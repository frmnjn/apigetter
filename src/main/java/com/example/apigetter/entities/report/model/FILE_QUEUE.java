package com.example.apigetter.entities.report.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "FILE_QUEUE")
public class FILE_QUEUE implements Serializable {
    @Id
    private String id;
    private String fileId;
    private String regional;
    private String fileTypeId;
    private String fileFormatId;
    private String filenameInput;
    private String status;
    private int statusCp;
    private String step;
    private String processDate;
    private String traficDate;
    private String checksum;
    private String message;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private String runningId;
    private String worker;
    private long convertedRecord;
    private String minRecordStartTime;
    private String maxRecordEndTime;
    private String elapsedTime;
    private Date startDate;
    private Date endDate;
    private String syncHadoop;
    private String messageStep;
    private String startFromStep;
    private String type;

    public FILE_QUEUE() {
        super();
    }

    public FILE_QUEUE(String id, String fileId, String regional, String fileTypeId, String fileFormatId, String filenameInput,
                      String status, int statusCp, String step, String processDate, String traficDate, String checksum,
                      String message, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String runningId, String worker,
                      long convertedRecord, String minRecordStartTime, String maxRecordEndTime, String elapsedTime, Date startDate, Date endDate,
                      String syncHadoop, String messageStep, String startFromStep) {
        this.id = id;
        this.fileId = fileId;
        this.regional = regional;
        this.fileTypeId = fileTypeId;
        this.fileFormatId = fileFormatId;
        this.filenameInput = filenameInput;
        this.status = status;
        this.statusCp = statusCp;
        this.step = step;
        this.processDate = processDate;
        this.traficDate = traficDate;
        this.checksum = checksum;
        this.message = message;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.runningId = runningId;
        this.worker = worker;
        this.convertedRecord = convertedRecord;
        this.minRecordStartTime = minRecordStartTime;
        this.maxRecordEndTime = maxRecordEndTime;
        this.elapsedTime = elapsedTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.syncHadoop = syncHadoop;
        this.messageStep = messageStep;
        this.startFromStep = startFromStep;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartFromStep() {
        return startFromStep;
    }

    public void setStartFromStep(String startFromStep) {
        this.startFromStep = startFromStep;
    }

    public String getMessageStep() {
        return messageStep;
    }

    public void setMessageStep(String messageStep) {
        this.messageStep = messageStep;
    }

    public String getSyncHadoop() {
        return syncHadoop;
    }

    public void setSyncHadoop(String syncHadoop) {
        this.syncHadoop = syncHadoop;
    }

    public String getMinRecordStartTime() {
        return minRecordStartTime;
    }

    public void setMinRecordStartTime(String minRecordStartTime) {
        this.minRecordStartTime = minRecordStartTime;
    }

    public String getMaxRecordEndTime() {
        return maxRecordEndTime;
    }

    public void setMaxRecordEndTime(String maxRecordEndTime) {
        this.maxRecordEndTime = maxRecordEndTime;
    }

    public long getConvertedRecord() {
        return convertedRecord;
    }

    public void setConvertedRecord(long convertedRecord) {
        this.convertedRecord = convertedRecord;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getRunningId() {
        return runningId;
    }

    public void setRunningId(String runningId) {
        this.runningId = runningId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    public String getFileFormatId() {
        return fileFormatId;
    }

    public void setFileFormatId(String fileFormatId) {
        this.fileFormatId = fileFormatId;
    }

    public String getFilenameInput() {
        return filenameInput;
    }

    public void setFilenameInput(String filenameInput) {
        this.filenameInput = filenameInput;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getTraficDate() {
        return traficDate;
    }

    public void setTraficDate(String traficDate) {
        this.traficDate = traficDate;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStatusCp() {
        return statusCp;
    }

    public void setStatusCp(int statusCp) {
        this.statusCp = statusCp;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return getClass().getName() + "#" + id;
        }
    }
}
