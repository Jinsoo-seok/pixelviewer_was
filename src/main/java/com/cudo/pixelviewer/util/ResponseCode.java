package com.cudo.pixelviewer.util;

public enum ResponseCode {

    SUCCESS(200, "SUCCESS", "SUCCESS"),
    NO_DATA(201, "NO_DATA", "NO_DATA"),
    NO_CONTENT(204, "NO_CONTENT", "No Content"),
    FAIL(500, "FAIL", "FAIL"),
    FAIL_CONNECT(8888, "Fail Connect Server", "Fail Connect Server"),



    // API : 1000
    NO_REQUIRED_PARAM(1000, "NoRequiredParam", "No Required Parameter"),
    NO_REQUIRED_VALUE(1001, "NoRequiredValue", "No Required Parameter Value"),
    INVALID_PARAM_TYPE(1002, "InvalidParamType", "Invalid Parameter Type"),
    INVALID_PARAM_LENGTH(1003, "InvalidParamLength", "Invalid Parameter Length"),
    INVALID_PARAM_VALUE(1004, "InvalidParamValue", "Invalid Parameter Value"),



    // Login, SignUp : 2000
//    INVALID_ACCOUNT_ID(2000, "InvalidAccountId", "Invalid Account ID"),
//    INVALID_PASSWORD(2001, "InvalidPassword", "Invalid Password"),
//    DUPLICATE_ID(2002, "DuplicateId", "Duplicate ID"),
//    NOT_EXIST_ID(2003, "NotExistId", "Not Exist ID"),
//    FAIL_CHANGE_PW(2004, "FailedChangePW", "Failed Change PW"),
//    FAIL_SIGN(2005, "FailedSignUp", "Failed Sign-Up"),


    // Operate : 3000
    FAIL_INSERT_SCREEN(3000, "FailedInsertScreen", "Failed Insert Screen"),
    FAIL_UPDATE_SCREEN(3001, "FailedUpdateScreen", "Failed Update Screen"),
    FAIL_DUPLICATE_SCREEN(3002, "FailedDuplicateScreen", "Failed Duplicate Screen"),
    FAIL_DELETE_SCREEN(3003, "FailedDeleteScreen", "Failed Delete Screen"),
    FAIL_NOT_EXIST_SCREEN(3004, "FailedDeleteScreen", "Failed Delete Screen");

//    FAIL_INSERT_QD(4004, "FailedInsertQD", "Failed Insert QD"),
//    FAIL_UPDATE_QD(4005, "FailedUpdateQD", "Failed Update QD"),
//    FAIL_DUPLICATE_QD(4006, "FailedDuplicateQD", "Failed Duplicate QD"),
//    FAIL_INSERT_CHANNEL_SUB(4007, "FailedInsertChannelSub", "Failed Insert Channel Sub"),
//    FAIL_INSERT_CHANNEL(4008, "FailedInsertChannel", "Failed Insert Channel"),
//    FAIL_NOT_EXIST_CHANNEL(4009, "FailedNotExistChannel", "Failed Not Exist Channel"),
//    FAIL_NOT_EXIST_DATA(4010, "FailedNotExistData", "Failed Not Exist Data"),
//    FAIL_DUPLICATE_SERVICE_NAME(4011, "FailedDuplicateServiceName", "Failed Duplicate ServiceName"),
//    FAIL_SERVICE_INSERT_DB(4012, "FailedServiceInsertDB", "Failed Service Insert DB"),
//    FAIL_SERVICE_UPDATE_DB(4013, "FailedServiceUpdateDB", "Failed Service Update DB");



    private int code;
    private String codeName;
    private String message;

    ResponseCode(int code, String codeName, String message){
        this.code = code;
        this.codeName = codeName;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getMessage() {
        return message;
    }
}