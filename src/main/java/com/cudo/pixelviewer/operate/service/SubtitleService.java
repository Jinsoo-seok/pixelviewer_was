package com.cudo.pixelviewer.operate.service;

import java.util.Map;

public interface SubtitleService {

    Map<String, Object> postSubtitle(Map<String, Object> param);

    Map<String, Object> patchSubtitleName(Map<String, Object> param);

}