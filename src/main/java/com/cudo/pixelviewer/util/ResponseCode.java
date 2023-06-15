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
    // Screen : 3100
    FAIL_INSERT_SCREEN(3100, "FailedInsertScreen", "Failed Insert Screen"),
    FAIL_UPDATE_SCREEN(3101, "FailedUpdateScreen", "Failed Update Screen"),
    FAIL_DUPLICATE_SCREEN(3102, "FailedDuplicateScreen", "Failed Duplicate Screen"),
    FAIL_DELETE_SCREEN(3103, "FailedDeleteScreen", "Failed Delete Screen"),
    FAIL_NOT_EXIST_SCREEN(3104, "FailedNotExistScreen", "Failed Not Exist Screen"),

    // Display : 3200
    FAIL_UPDATE_DISPLAY(3200, "FailedUpdateDisplay", "Failed Update Display"),
    FAIL_NOT_EXIST_DISPLAY(3201, "FailedNotExistDisplay", "Failed Not Exist Display"),

    // Preset : 3300
    FAIL_INSERT_PRESET(3300, "FailedInsertPreset", "Failed Insert Preset"),
    FAIL_UPDATE_PRESET(3301, "FailedUpdatePreset", "Failed Update Preset"),
    FAIL_DUPLICATE_PRESET(3302, "FailedDuplicatePreset", "Failed Duplicate Preset"),
    FAIL_DELETE_PRESET(3303, "FailedDeletePreset", "Failed Delete Preset"),
    FAIL_NOT_EXIST_PRESET(3304, "FailedNotExistPreset", "Failed Not Exist Preset"),

    // Preset : 3400
    FAIL_INSERT_LAYER(3400, "FailedInsertLayer", "Failed Insert Layer"),
    FAIL_UPDATE_LAYER(3401, "FailedUpdateLayer", "Failed Update Layer"),
    FAIL_DUPLICATE_LAYER(3402, "FailedDuplicateLayer", "Failed Duplicate Layer"),
    FAIL_DELETE_LAYER(3403, "FailedDeleteLayer", "Failed Delete Layer"),
    FAIL_NOT_EXIST_LAYER(3404, "FailedNotExistLayer", "Failed Not Exist Layer"),


    // BO : 4000
    // Pwrcon : 4100
    FAIL_INSERT_PWRCON(4100, "FailedInsertPwrcon", "Failed Insert Pwrcon"),
    FAIL_UPDATE_PWRCON(4101, "FailedUpdatePwrcon", "Failed Update Pwrcon"),
    FAIL_DUPLICATE_PWRCON(4102, "FailedDuplicatePwrcon", "Failed Duplicate Pwrcon"),
    FAIL_DELETE_PWRCON(4103, "FailedDeletePwrcon", "Failed Delete Pwrcon"),
    FAIL_NOT_EXIST_PWRCON(4104, "FailedNotExistPwrcon", "Failed Not Exist Pwrcon");



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