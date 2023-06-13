package com.cudo.pixelviewer.operate.controller;

import com.cudo.pixelviewer.config.ParamException;
import com.cudo.pixelviewer.operate.service.PlaylistService;
import com.cudo.pixelviewer.util.ParameterUtils;
import com.cudo.pixelviewer.util.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.cudo.pixelviewer.util.ParameterUtils.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api-manager/operate/playlist")
public class PlaylistController {

    final PlaylistService playlistService;

    @GetMapping
    public Map<String, Object> getPlaylistList(HttpServletRequest request) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}]", apiInfo, startTime);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));


        try {
            responseMap = playlistService.getPlaylistList();
        }
        catch (Exception exception) {
            log.error("[Exception][getPlaylistList] - {}", exception.getMessage());
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

    @GetMapping("/{Id}")
    public Map<String, Object> getPlaylist(HttpServletRequest request
                                        , @PathVariable String Id) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, Id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));


        try {
            responseMap = playlistService.getPlaylist(Id);
        }
        catch (Exception exception) {
            log.error("[Exception][getPlaylist] - {}", exception.getMessage());
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }


    @PostMapping
    public Map<String, Object> postPlaylist(HttpServletRequest request
                                        , @RequestBody Map<String, Object> param) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));

        String[] keyList = {"playlistNm", "layerId", "presetId", "screenId"};

        try {
            parameterValidation(param, keyList);
            parameterString("playlistNm", param.get("playlistNm"), true, 0, null);
            parameterInt("layerId", param.get("layerId"), true);
            parameterInt("presetId", param.get("presetId"), true);
            parameterInt("screenId", param.get("screenId"), true);

            responseMap = playlistService.postPlaylist(param);
        }
        catch (ParamException paramException){
            log.error("[paramException][postPlaylist] - {}", paramException.getMessage());
            responseMap.put("code", paramException.getCode());
            responseMap.put("message", paramException.getMessage());
        }
        catch (Exception exception) {
            log.error("[Exception][postPlaylist] - {}", exception.getMessage());
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }

//    @DeleteMapping
//    public Map<String, Object> deleteScreen(HttpServletRequest request
//                                        , @RequestBody Map<String, Object> param) {
//        long startTime = System.currentTimeMillis();
//        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
//        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));
//
//        String[] keyList = {"screenId"};
//
//        try {
//            parameterValidation(param, keyList);
//            parameterInt("screenId", param.get("screenId"), true);
//
//            responseMap = screenService.deleteScreen(param);
//        }
//        catch (ParamException paramException){
//            log.error("[paramException][deleteScreen] - {}", paramException.getMessage());
//            responseMap.put("code", paramException.getCode());
//            responseMap.put("message", paramException.getMessage());
//        }
//        catch (Exception exception) {
//            log.error("[Exception][deleteScreen] - {}", exception.getMessage());
//            responseMap.put("exceptionMessage", exception.getMessage());
//        }
//
//        long endTime = System.currentTimeMillis();
//        long procTime = endTime-startTime;
//        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));
//
//        return responseMap;
//    }
//
//    @PatchMapping("/name")
//    public Map<String, Object> patchScreenName(HttpServletRequest request
//                                        , @RequestBody Map<String, Object> param) {
//        long startTime = System.currentTimeMillis();
//        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
//        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));
//
//        String[] keyList = {"screenId", "screenNm"};
//
//        try {
//            parameterValidation(param, keyList);
//            parameterInt("screenId", param.get("screenId"), true);
//            parameterString("screenNm", param.get("screenNm"), true, 0, null);
//
//            responseMap = screenService.patchScreenName(param);
//        }
//        catch (ParamException paramException){
//            log.error("[paramException][patchScreenName] - {}", paramException.getMessage());
//            responseMap.put("code", paramException.getCode());
//            responseMap.put("message", paramException.getMessage());
//        }
//        catch (Exception exception) {
//            log.error("[Exception][patchScreenName] - {}", exception.getMessage());
//            responseMap.put("exceptionMessage", exception.getMessage());
//        }
//
//        long endTime = System.currentTimeMillis();
//        long procTime = endTime-startTime;
//        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));
//
//        return responseMap;
//    }
//
//    @PutMapping
//    public Map<String, Object> putScreenSet(HttpServletRequest request
//                                        , @RequestBody Map<String, Object> param) {
//        long startTime = System.currentTimeMillis();
//        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
//        log.info("{} [START] [{}] - {}", apiInfo, startTime, param);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.putAll(ParameterUtils.responseOption(ResponseCode.FAIL.getCodeName()));
//
//        String[] keyList = {"screenId", "screenNm", "rowsize", "columnsize"};
//
//        try {
//            parameterValidation(param, keyList);
//            parameterInt("screenId", param.get("screenId"), true);
//            parameterString("screenNm", param.get("screenNm"), true, 0, null);
//            parameterInt("rowsize", param.get("rowsize"), true);
//            parameterInt("columnsize", param.get("columnsize"), true);
//
//            responseMap = screenService.putScreenSet(param);
//        }
//        catch (ParamException paramException){
//            log.error("[paramException][putScreenSet] - {}", paramException.getMessage());
//            responseMap.put("code", paramException.getCode());
//            responseMap.put("message", paramException.getMessage());
//        }
//        catch (Exception exception) {
//            log.error("[Exception][putScreenSet] - {}", exception.getMessage());
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
