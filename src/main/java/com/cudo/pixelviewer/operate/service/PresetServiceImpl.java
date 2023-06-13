package com.cudo.pixelviewer.operate.service;

import com.cudo.pixelviewer.operate.mapper.PresetMapper;
import com.cudo.pixelviewer.util.ParameterUtils;
import com.cudo.pixelviewer.util.ResponseCode;
import com.cudo.pixelviewer.vo.PresetVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PresetServiceImpl implements PresetService {

    final PresetMapper presetMapper;


    @Override
    public Map<String, Object> getPresetList() {
        Map<String, Object> resultMap = new HashMap<>();

        List<PresetVo> presetVoList = presetMapper.getPresetList();

        if(presetVoList.size() > 0){
            resultMap.put("data", presetVoList);
            resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
        }
        else{
            resultMap.putAll(ParameterUtils.responseOption(ResponseCode.NO_CONTENT.getCodeName()));
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getPreset(String presetId) {
        Map<String, Object> resultMap = new HashMap<>();

        PresetVo presetVo = presetMapper.getPreset(presetId);

        if(presetVo != null){
            resultMap.put("data", presetVo);
            resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
        }
        else{
            resultMap.putAll(ParameterUtils.responseOption(ResponseCode.NO_CONTENT.getCodeName()));
        }
        return resultMap;
    }

    // TODO : 중복체크, 에러코드
    @Override
    public Map<String, Object> postPreset(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();

//        int presetCheck = presetMapper.postPresetValid(param);
        int presetCheck = 0;

        if(presetCheck == 0){ // Not Exist : 0
            int postScreenResult = presetMapper.postPreset(param);

            if(postScreenResult == 1){ // Success : 1
                dataMap.put("presetId", param.get("presetId"));
                resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
                resultMap.put("data", dataMap);
            }
            else{
                resultMap.put("code", ResponseCode.FAIL_INSERT_PRESET.getCode());
                resultMap.put("message", ResponseCode.FAIL_INSERT_PRESET.getMessage());
            }
        }
        else{
            resultMap.put("code", ResponseCode.FAIL_DUPLICATE_PRESET.getCode());
            resultMap.put("message", ResponseCode.FAIL_DUPLICATE_PRESET.getMessage());
        }
        return resultMap;
    }

    // TODO : 에러코드
    @Override
    public Map<String, Object> deletePreset(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();

        int presetCheck = presetMapper.deletePresetValid(param);

        if(presetCheck == 1){  // Exist : 1
            int deletePresetResult = presetMapper.deletePreset(param);

            if(deletePresetResult == 1){ // Success : 1
                resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
            }
            else{
                resultMap.put("code", ResponseCode.FAIL_DELETE_PRESET.getCode());
                resultMap.put("message", ResponseCode.FAIL_DELETE_PRESET.getMessage());
            }
        }
        else{
            resultMap.put("code", ResponseCode.FAIL_NOT_EXIST_PRESET.getCode());
            resultMap.put("message", ResponseCode.FAIL_NOT_EXIST_PRESET.getMessage());
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> patchPresetName(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();

        int screenCheck = presetMapper.patchPresetNameValid(param);

        if(screenCheck == 1){  // Exist : 1
            int patchScreenNameResult = presetMapper.patchPresetName(param);

            if(patchScreenNameResult == 1){ // Success : 1
                resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
            }
            else{
                resultMap.put("code", ResponseCode.FAIL_UPDATE_PRESET.getCode());
                resultMap.put("message", ResponseCode.FAIL_UPDATE_PRESET.getMessage());
            }
        }
        else{
            resultMap.put("code", ResponseCode.FAIL_NOT_EXIST_PRESET.getCode());
            resultMap.put("message", ResponseCode.FAIL_NOT_EXIST_PRESET.getMessage());
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> patchPresetLayout(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
        return resultMap;
    }

    // TODO : LED 컨트롤러 연동
    @Override
    public Map<String, Object> patchPresetRun(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
        return resultMap;
    }

    // TODO : LED 컨트롤러 연동
    @Override
    public Map<String, Object> patchPresetStop(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
        return resultMap;
    }

}