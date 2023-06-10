package com.cudo.pixelviewer.operate.screen.service;

import com.cudo.pixelviewer.operate.screen.mapper.ScreenMapper;
import com.cudo.pixelviewer.user.mapper.UserMapper;
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

    // TODO : VO
    @Override
    public Map<String, Object> getScreenList() {
        Map<String, Object> resultMap = new HashMap<>();

        List<Map<String, Object>> screenList = screenMapper.getScreenList();

        resultMap.put("data", screenList);

        return resultMap;
    }

    // TODO : VO
    @Override
    public Map<String, Object> getScreen(String screenId) {
        Map<String, Object> resultMap = new HashMap<>();

        Map<String, Object> screenOne = screenMapper.getScreen(screenId);

        resultMap.put("data", screenOne);

        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> postScreen(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();

        // TODO : 어떤거를 기준으로 체크할지? >> 필드가 별로 없는데 전체가 겹치면?으로 해야하나?
//        int screenCheck = screenMapper.postScreenValid(param);
        int postScreenResult = screenMapper.postScreen(param);


        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> deleteScreen(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();

//        int screenCheck = screenMapper.deleteScreenValid(param);
        int deleteScreenResult = screenMapper.deleteScreen(param);


        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> patchScreenName(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();

//        int screenCheck = screenMapper.patchScreenValid(param);
        int patchScreenNameResult = screenMapper.patchScreenName(param);

        return resultMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> putScreenSet(Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();

//        int screenCheck = screenMapper.putScreenValid(param);
        int putScreenResult = screenMapper.putScreen(param);

        return resultMap;
    }
}
