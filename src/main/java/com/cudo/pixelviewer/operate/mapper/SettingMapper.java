package com.cudo.pixelviewer.operate.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface SettingMapper {

    int putSettingImageDefaultPlaytime(Map<String, Object> param);

}