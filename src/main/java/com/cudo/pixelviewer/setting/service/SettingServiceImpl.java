package com.cudo.pixelviewer.setting.service;

import com.cudo.pixelviewer.setting.mapper.SettingMapper;
import com.cudo.pixelviewer.util.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SettingServiceImpl implements SettingService {

    private static final Logger logger = LoggerFactory.getLogger(SettingServiceImpl.class);

    final SettingMapper settingMapper;

    @Override
    public Map<String, Object> serviceGetValue() {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();

        resultMap.put("code", ResponseCode.NO_CONTENT.getCode());
        resultMap.put("message", ResponseCode.NO_CONTENT.getMessage());

        Map<String, Object> serviceGetValueResult = settingMapper.getSetting();
        if(serviceGetValueResult.size() > 0) {
            dataMap.put("list", serviceGetValueResult);

            resultMap.put("data", dataMap);
            resultMap.put("code", ResponseCode.SUCCESS.getCode());
            resultMap.put("message", ResponseCode.SUCCESS.getMessage());

        } else {
            logger.info("[serviceGetValue] No search serviceValue");
            resultMap.put("code", ResponseCode.FAIL.getCode());
            resultMap.put("message", ResponseCode.FAIL.getMessage());
        }
        return resultMap;
    }


}
