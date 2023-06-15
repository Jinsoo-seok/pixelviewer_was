package com.cudo.pixelviewer.bo.controller;

import com.cudo.pixelviewer.bo.service.LedconService;
import com.cudo.pixelviewer.config.ParamException;
import com.cudo.pixelviewer.util.ParameterUtils;
import com.cudo.pixelviewer.util.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.cudo.pixelviewer.util.ParameterUtils.parameterInt;
import static com.cudo.pixelviewer.util.ParameterUtils.parameterValidation;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api-manager/ledcon")
public class LedconController {

    final LedconService ledconService;

    @GetMapping
    public Map<String, Object> getLedconList(HttpServletRequest request) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}]", apiInfo, startTime);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));


        try {
            responseMap = ledconService.getLedconList();
        }
        catch (Exception exception) {
            log.error("[Exception][getLedconList] - {}", exception.getMessage());
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

    // TODO : 필수값 체크
    @PostMapping
    public Map<String, Object> postLedcon(HttpServletRequest request
                                        , @RequestBody Map<String, Object> param) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));


        try {
            responseMap = ledconService.postLedcon(param);
        }
        catch (Exception exception) {
            log.error("[Exception][postLedcon] - {}", exception.getMessage());
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

    @DeleteMapping
    public Map<String, Object> deleteLedcon(HttpServletRequest request
                                        , @RequestBody Map<String, Object> param) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));

        String[] keyList = {"ledControllerId"};

        try {
            parameterValidation(param, keyList);
            parameterInt("ledControllerId", param.get("ledControllerId"), true);

            responseMap = ledconService.deleteLedcon(param);
        }
        catch (ParamException paramException){
            log.error("[paramException][deleteLedcon] - {}", paramException.getMessage());
            responseMap.put("code", paramException.getCode());
            responseMap.put("message", paramException.getMessage());
        }
        catch (Exception exception) {
            log.error("[Exception][deleteLedcon] - {}", exception.getMessage());
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

//    @PatchMapping("/name")
//    public Map<String, Object> patchLedconName(HttpServletRequest request
//                                        , @RequestBody Map<String, Object> param) {
//        long startTime = System.currentTimeMillis();
//        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
//        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));
//
//        String[] keyList = {"ledconId", "ledconNm"};
//
//        try {
//            parameterValidation(param, keyList);
//            parameterInt("ledconId", param.get("ledconId"), true);
//            parameterString("ledconNm", param.get("ledconNm"), true, 0, null);
//
//            responseMap = ledconService.patchLedconName(param);
//        }
//        catch (ParamException paramException){
//            log.error("[paramException][patchLedconName] - {}", paramException.getMessage());
//            responseMap.put("code", paramException.getCode());
//            responseMap.put("message", paramException.getMessage());
//        }
//        catch (Exception exception) {
//            log.error("[Exception][patchLedconName] - {}", exception.getMessage());
//            responseMap.put("exceptionMessage", exception.getMessage());
//        }
//
//        long endTime = System.currentTimeMillis();
//        long procTime = endTime-startTime;
//        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));
//
//        return responseMap;
//    }

}