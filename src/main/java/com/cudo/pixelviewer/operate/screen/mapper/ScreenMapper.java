package com.cudo.pixelviewer.operate.screen.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ScreenMapper {

    List<Map<String, Object>> getScreenList();

    Map<String, Object> getScreen(String screenId);

    int postScreen(Map<String, Object> param);

    int deleteScreen(Map<String, Object> param);

    int patchScreenName(Map<String, Object> param);

    int putScreen(Map<String, Object> param);

}
