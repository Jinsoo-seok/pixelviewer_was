package com.cudo.pixelviewer.operate.service;

import com.cudo.pixelviewer.operate.mapper.SettingMapper;
import com.cudo.pixelviewer.util.ParameterUtils;
import com.cudo.pixelviewer.util.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {

    final SettingMapper settingMapper;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> putSettingImageDefaultPlaytime(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();


        int patchSettingNameResult = settingMapper.putSettingImageDefaultPlaytime(param);

        if(patchSettingNameResult == 1){ // Success : 1
            resultMap.putAll(ParameterUtils.responseOption(ResponseCode.SUCCESS.getCodeName()));
        }
        else{
            resultMap.put("code", ResponseCode.FAIL_UPDATE_SETTING_IMAGE_DEFAULT_PLAYTIME.getCode());
            resultMap.put("message", ResponseCode.FAIL_UPDATE_SETTING_IMAGE_DEFAULT_PLAYTIME.getMessage());
        }

        return resultMap;
    }
}