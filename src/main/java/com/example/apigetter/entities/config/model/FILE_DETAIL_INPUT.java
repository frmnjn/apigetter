package com.example.apigetter.entities.config.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection = "FILE_DETAIL_INPUT")
public class FILE_DETAIL_INPUT implements Serializable {
    @Id
    private String id;
    private String fileId;
    private String fileIdName;
    private String fileTypeId;
    private String fileFormatId;
    private String regional;
    private int protocolType;
    private String ip;
    private String username;
    private String password;
    private int port;
    private List<String> remotePath;
    private String localPath;
    private String processType;
    private String processPath;
    private String pattern;
    private String cron;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private boolean active;
    private boolean collecting;
    private boolean writeToFile;
    private String logOption;// 0 --> to DB, 1 --> to File
    private String defaultFieldValue;
    private int fileTypeTransfer; // 1 --> ASCII, 2-->BINARY
    private boolean logToDB;
    private boolean logToFile;
    private boolean isAgregate;
    private String patternForOutput;
    private String specialCondition;
    private String forceRegexInput;
    private String forceRegexTake;
    private String isBypass;
    private String fileDispatchId;
    private String delimiter;
    private String cacValidation;
    private String cekAnotherSource;
    private String isRenamed;
    private String isArchived;
    private String renameTo;
    private String datePatternConversion;
    private String datePatternOutputConversion;
    private String hdfsPath;
    private String lookProcess;
    private String saveProcess;
    private String compressInput;
    private String queryId;
    private String worker;
    private String insertHourlyCountInputReport;
    private String missingTrunkQuery;
    private String token;
    private String rdbms;
    private String database;

    public FILE_DETAIL_INPUT() {
        super();
    }

    public FILE_DETAIL_INPUT(String id, String fileId, String fileIdName, String fileTypeId, String fileFormatId, String regional,
                             int protocolType, String ip, String username, String password, int port, List<String> remotePath,
                             String localPath, String processType, String processPath, String pattern, String cron, String createdBy,
                             Date createdDate, String modifiedBy, Date modifiedDate, boolean active, boolean collecting, boolean writeToFile, String logOption,
                             String defaultFieldValue, String specialCondition, String token, String rdbms, String database) {
        this.id = id;
        this.fileId = fileId;
        this.fileIdName = fileIdName;
        this.fileTypeId = fileTypeId;
        this.fileFormatId = fileFormatId;
        this.regional = regional;
        this.protocolType = protocolType;
        this.ip = ip;
        this.username = username;
        this.password = password;
        this.port = port;
        this.remotePath = remotePath;
        this.localPath = localPath;
        this.processType = processType;
        this.processPath = processPath;
        this.pattern = pattern;
        this.cron = cron;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.active = active;
        this.collecting = collecting;
        this.writeToFile = writeToFile;
        this.logOption = logOption;
        this.defaultFieldValue = defaultFieldValue;
        this.specialCondition = specialCondition;
        this.token = token;
        this.rdbms = rdbms;
        this.database = database;
    }

    public String getInsertHourlyCountInputReport() {
        return insertHourlyCountInputReport;
    }

    public void setInsertHourlyCountInputReport(String insertHourlyCountInputReport) {
        this.insertHourlyCountInputReport = insertHourlyCountInputReport;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getSaveProcess() {
        return saveProcess;
    }

    public void setSaveProcess(String saveProcess) {
        this.saveProcess = saveProcess;
    }

    public String getCompressInput() {
        return compressInput;
    }

    public void setCompressInput(String compressInput) {
        this.compressInput = compressInput;
    }

    public String getLookProcess() {
        return lookProcess;
    }

    public void setLookProcess(String lookProcess) {
        this.lookProcess = lookProcess;
    }

    public String getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(String hdfsPath) {
        this.hdfsPath = hdfsPath;
    }

    public String getDatePatternOutputConversion() {
        return datePatternOutputConversion;
    }

    public void setDatePatternOutputConversion(String datePatternOutputConversion) {
        this.datePatternOutputConversion = datePatternOutputConversion;
    }

    public String getDatePatternConversion() {
        return datePatternConversion;
    }

    public void setDatePatternConversion(String datePatternConversion) {
        this.datePatternConversion = datePatternConversion;
    }

    public String getIsRenamed() {
        return isRenamed;
    }

    public void setIsRenamed(String isRenamed) {
        this.isRenamed = isRenamed;
    }

    public String getRenameTo() {
        return renameTo;
    }

    public void setRenameTo(String renameTo) {
        this.renameTo = renameTo;
    }

    public String getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(String isArchived) {
        this.isArchived = isArchived;
    }

    public String getCekAnotherSource() {
        return cekAnotherSource;
    }

    public void setCekAnotherSource(String cekAnotherSource) {
        this.cekAnotherSource = cekAnotherSource;
    }

    public String getCacValidation() {
        return cacValidation;
    }

    public void setCacValidation(String cacValidation) {
        this.cacValidation = cacValidation;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getFileDispatchId() {
        return fileDispatchId;
    }

    public void setFileDispatchId(String fileDispatchId) {
        this.fileDispatchId = fileDispatchId;
    }

    public String getIsBypass() {
        return isBypass;
    }

    public void setIsBypass(String isBypass) {
        this.isBypass = isBypass;
    }

    public String getForceRegexInput() {
        return forceRegexInput;
    }

    public void setForceRegexInput(String forceRegexInput) {
        this.forceRegexInput = forceRegexInput;
    }

    public String getForceRegexTake() {
        return forceRegexTake;
    }

    public void setForceRegexTake(String forceRegexTake) {
        this.forceRegexTake = forceRegexTake;
    }

    public boolean isAgregate() {
        return isAgregate;
    }

    public void setAgregate(boolean agregate) {
        isAgregate = agregate;
    }

    public int getFileTypeTransfer() {
        return fileTypeTransfer;
    }

    public void setFileTypeTransfer(int fileTypeTransfer) {
        this.fileTypeTransfer = fileTypeTransfer;
    }

    public String getDefaultFieldValue() {
        return defaultFieldValue;
    }

    public void setDefaultFieldValue(String defaultFieldValue) {
        this.defaultFieldValue = defaultFieldValue;
    }

    public String getLogOption() {
        return logOption;
    }

    public void setLogOption(String logOption) {
        this.logOption = logOption;
    }

    public boolean isWriteToFile() {
        return writeToFile;
    }

    public void setWriteToFile(boolean writeToFile) {
        this.writeToFile = writeToFile;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFileIdName() {
        return fileIdName;
    }

    public void setFileIdName(String fileIdName) {
        this.fileIdName = fileIdName;
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

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public int getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(int protocolType) {
        this.protocolType = protocolType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<String> getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(List<String> remotePath) {
        this.remotePath = remotePath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getProcessPath() {
        return processPath;
    }

    public void setProcessPath(String processPath) {
        this.processPath = processPath;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
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

    public boolean isCollecting() {
        return collecting;
    }

    public void setCollecting(boolean collecting) {
        this.collecting = collecting;
    }

    public boolean isLogToDB() {
        return logToDB;
    }

    public void setLogToDB(boolean logToDB) {
        this.logToDB = logToDB;
    }

    public boolean isLogToFile() {
        return logToFile;
    }

    public void setLogToFile(boolean logToFile) {
        this.logToFile = logToFile;
    }

    public String getPatternForOutput() {
        return patternForOutput;
    }

    public void setPatternForOutput(String patternForOutput) {
        this.patternForOutput = patternForOutput;
    }

    public String getSpecialCondition() {
        return specialCondition;
    }

    public void setSpecialCondition(String specialCondition) {
        this.specialCondition = specialCondition;
    }

    public String getMissingTrunkQuery() {
        return missingTrunkQuery;
    }

    public void setMissingTrunkQuery(String missingTrunkQuery) {
        this.missingTrunkQuery = missingTrunkQuery;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRdbms() {
        return rdbms;
    }

    public void setRdbms(String rdbms) {
        this.rdbms = rdbms;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
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
