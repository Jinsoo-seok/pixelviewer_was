package com.cudo.pixelviewer.bo.controller;

import com.cudo.pixelviewer.bo.service.PwrconService;
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
@RequestMapping("/api-manager/pwrcon")
public class PwrconController {

    final PwrconService pwrconService;

    @GetMapping
    public Map<String, Object> getPwrconList(HttpServletRequest request) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}]", apiInfo, startTime);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));


        try {
            responseMap = pwrconService.getPwrconList();
        }
        catch (Exception exception) {
            log.error("[Exception][getPwrconList] - {}", exception.getMessage());
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

    @PostMapping
    public Map<String, Object> postPwrcon(HttpServletRequest request
                                        , @RequestBody Map<String, Object> param) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));


        try {
            responseMap = pwrconService.postPwrcon(param);
        }
        catch (Exception exception) {
            log.error("[Exception][postPwrcon] - {}", exception.getMessage());
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

    @DeleteMapping
    public Map<String, Object> deletePwrcon(HttpServletRequest request
                                        , @RequestBody Map<String, Object> param) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));

        String[] keyList = {"condeviceId"};

        try {
            parameterValidation(param, keyList);
            parameterInt("condeviceId", param.get("condeviceId"), true);

            responseMap = pwrconService.deletePwrcon(param);
        }
        catch (ParamException paramException){
            log.error("[paramException][deletePwrcon] - {}", paramException.getMessage());
            responseMap.put("code", paramException.getCode());
            responseMap.put("message", paramException.getMessage());
        }
        catch (Exception exception) {
            log.error("[Exception][deletePwrcon] - {}", exception.getMessage());
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

//    @PatchMapping("/name")
//    public Map<String, Object> patchPwrconName(HttpServletRequest request
//                                        , @RequestBody Map<String, Object> param) {
//        long startTime = System.currentTimeMillis();
//        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
//        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));
//
//        String[] keyList = {"pwrconId", "pwrconNm"};
//
//        try {
//            parameterValidation(param, keyList);
//            parameterInt("pwrconId", param.get("pwrconId"), true);
//            parameterString("pwrconNm", param.get("pwrconNm"), true, 0, null);
//
//            responseMap = pwrconService.patchPwrconName(param);
//        }
//        catch (ParamException paramException){
//            log.error("[paramException][patchPwrconName] - {}", paramException.getMessage());
//            responseMap.put("code", paramException.getCode());
//            responseMap.put("message", paramException.getMessage());
//        }
//        catch (Exception exception) {
//            log.error("[Exception][patchPwrconName] - {}", exception.getMessage());
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