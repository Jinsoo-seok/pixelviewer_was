package com.cudo.pixelviewer.operate.screen.controller;

import com.cudo.pixelviewer.operate.screen.service.ScreenService;
import com.cudo.pixelviewer.user.service.UserService;
import com.cudo.pixelviewer.util.ParameterUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/api-manager/operate/screen")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ScreenController {

    final ScreenService screenService;

    @GetMapping("")
    public Map<String, Object> getScreenList(HttpServletRequest request) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}]", apiInfo, startTime);

        Map<String, Object> responseMap = new HashMap<>();


        try {
            responseMap = screenService.getScreenList();
        }
        catch (Exception exception) {
            log.error("[Exception][getScreenList] - {}", exception.getMessage());
            responseMap.putAll(ParameterUtils.responseOption("FAIL"));
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

    @GetMapping("/{screenId}")
    public Map<String, Object> getScreen(HttpServletRequest request
                                        , @PathVariable String screenId) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, screenId);

        Map<String, Object> responseMap = new HashMap<>();


        try {
            responseMap = screenService.getScreen(screenId);
        }
        catch (Exception exception) {
            log.error("[Exception][getScreenList] - {}", exception.getMessage());
            responseMap.putAll(ParameterUtils.responseOption("FAIL"));
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }


    @PostMapping
    public Map<String, Object> postScreen(HttpServletRequest request
                                        , @RequestBody Map<String, Object> param) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);

        Map<String, Object> responseMap = new HashMap<>();

        String[] keyList = {"", ""};

        try {
//            parameterValidation(param, keyList);
//            parameterString("", param.get(""), true, 0, null);
            responseMap = screenService.postScreen(param);
        }
//        catch (ParamException paramException){
//            log.error("[paramException][postScreen] - {}", paramException.getMessage());
//            responseMap.put("code", paramException.getCode());
//            responseMap.put("message", paramException.getMessage());
//        }
        catch (Exception exception) {
            log.error("[Exception][postScreen] - {}", exception.getMessage());
            responseMap.putAll(ParameterUtils.responseOption("FAIL"));
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

    @DeleteMapping
    public Map<String, Object> deleteScreen(HttpServletRequest request
                                        , @RequestBody Map<String, Object> param) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);

        Map<String, Object> responseMap = new HashMap<>();

        String[] keyList = {"", ""};

        try {
//            parameterValidation(param, keyList);
//            parameterString("", param.get(""), true, 0, null);
            responseMap = screenService.deleteScreen(param);
        }
//        catch (ParamException paramException){
//            log.error("[paramException][deleteScreen] - {}", paramException.getMessage());
//            responseMap.put("code", paramException.getCode());
//            responseMap.put("message", paramException.getMessage());
//        }
        catch (Exception exception) {
            log.error("[Exception][deleteScreen] - {}", exception.getMessage());
            responseMap.putAll(ParameterUtils.responseOption("FAIL"));
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

    @PatchMapping("/name")
    public Map<String, Object> patchScreenName(HttpServletRequest request
                                        , @RequestBody Map<String, Object> param) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);

        Map<String, Object> responseMap = new HashMap<>();

        String[] keyList = {"", ""};

        try {
//            parameterValidation(param, keyList);
//            parameterString("", param.get(""), true, 0, null);
            responseMap = screenService.patchScreenName(param);
        }
//        catch (ParamException paramException){
//            log.error("[paramException][patchScreenName] - {}", paramException.getMessage());
//            responseMap.put("code", paramException.getCode());
//            responseMap.put("message", paramException.getMessage());
//        }
        catch (Exception exception) {
            log.error("[Exception][patchScreenName] - {}", exception.getMessage());
            responseMap.putAll(ParameterUtils.responseOption("FAIL"));
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

    @PutMapping("/set")
    public Map<String, Object> putScreenSet(HttpServletRequest request
                                        , @RequestBody Map<String, Object> param) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);

        Map<String, Object> responseMap = new HashMap<>();

        String[] keyList = {"", ""};

        try {
//            parameterValidation(param, keyList);
//            parameterString("", param.get(""), true, 0, null);
            responseMap = screenService.putScreenSet(param);
        }
//        catch (ParamException paramException){
//            log.error("[paramException][putScreenSet] - {}", paramException.getMessage());
//            responseMap.put("code", paramException.getCode());
//            responseMap.put("message", paramException.getMessage());
//        }
        catch (Exception exception) {
            log.error("[Exception][putScreenSet] - {}", exception.getMessage());
            responseMap.putAll(ParameterUtils.responseOption("FAIL"));
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

}
