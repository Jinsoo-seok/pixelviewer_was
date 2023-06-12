package com.cudo.pixelviewer.operate.service;

import com.cudo.pixelviewer.operate.mapper.ScreenMapper;
import com.cudo.pixelviewer.util.ParameterUtils;
import com.cudo.pixelviewer.util.ResponseCode;
import com.cudo.pixelviewer.vo.ScreenVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    final ScreenMapper screenMapper;

    @Override
    public Map<String, Object> getScreenList() {
        Map<String, Object> resultMap = new HashMap<>();

        List<ScreenVo> screenVoList = screenMapper.getScreenList();

        if(screenVoList.size() > 0){
            resultMap.put("data", screenVoList);
            resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
        }
        else{
            resultMap.putAll(ParameterUtils.responseOption(ResponseCode.NO_CONTENT.getCodeName()));
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getScreen(String screenId) {
        Map<String, Object> resultMap = new HashMap<>();

        ScreenVo screenVo = screenMapper.getScreen(screenId);

        if(screenVo != null){
            resultMap.put("data", screenVo);
            resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
        }
        else{
            resultMap.putAll(ParameterUtils.responseOption(ResponseCode.NO_CONTENT.getCodeName()));
        }
        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> postScreen(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();

        int screenCheck = screenMapper.postScreenValid(param);

        if(screenCheck == 0){ // Not Exist : 0
            int postScreenResult = screenMapper.postScreen(param);

            if(postScreenResult == 1){ // Success : 1
                dataMap.put("screenId", param.get("screenId"));
                resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
                resultMap.put("data", dataMap);
            }
            else{
                resultMap.put("code", ResponseCode.FAIL_INSERT_SCREEN.getCode());
                resultMap.put("message", ResponseCode.FAIL_INSERT_SCREEN.getMessage());
            }
        }
        else{
            resultMap.put("code", ResponseCode.FAIL_DUPLICATE_SCREEN.getCode());
            resultMap.put("message", ResponseCode.FAIL_DUPLICATE_SCREEN.getMessage());
        }
        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> deleteScreen(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();

        int screenCheck = screenMapper.deleteScreenValid(param);

        if(screenCheck == 1){  // Exist : 1
            int deleteScreenResult = screenMapper.deleteScreen(param);

            if(deleteScreenResult == 1){ // Success : 1
                resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
            }
            else{
                resultMap.put("code", ResponseCode.FAIL_DELETE_SCREEN.getCode());
                resultMap.put("message", ResponseCode.FAIL_DELETE_SCREEN.getMessage());
            }
        }
        else{
            resultMap.put("code", ResponseCode.FAIL_NOT_EXIST_SCREEN.getCode());
            resultMap.put("message", ResponseCode.FAIL_NOT_EXIST_SCREEN.getMessage());
        }
        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> patchScreenName(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();

        int screenCheck = screenMapper.patchScreenNameValid(param);

        if(screenCheck == 1){  // Exist : 1
            int patchScreenNameResult = screenMapper.patchScreenName(param);

            if(patchScreenNameResult == 1){ // Success : 1
                resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
            }
            else{
                resultMap.put("code", ResponseCode.FAIL_UPDATE_SCREEN.getCode());
                resultMap.put("message", ResponseCode.FAIL_UPDATE_SCREEN.getMessage());
            }
        }
        else{
            resultMap.put("code", ResponseCode.FAIL_NOT_EXIST_SCREEN.getCode());
            resultMap.put("message", ResponseCode.FAIL_NOT_EXIST_SCREEN.getMessage());
        }
        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> putScreenSet(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();

        int screenCheck = screenMapper.putScreenValid(param);

        if(screenCheck == 1){  // Exist : 1
            int putScreenResult = screenMapper.putScreen(param);

            if(putScreenResult == 1){ // Success : 1
                resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
            }
            else{
                resultMap.put("code", ResponseCode.FAIL_UPDATE_SCREEN.getCode());
                resultMap.put("message", ResponseCode.FAIL_UPDATE_SCREEN.getMessage());
            }
        }
        else{
            resultMap.put("code", ResponseCode.FAIL_NOT_EXIST_SCREEN.getCode());
            resultMap.put("message", ResponseCode.FAIL_NOT_EXIST_SCREEN.getMessage());
        }
        return resultMap;
    }
}
