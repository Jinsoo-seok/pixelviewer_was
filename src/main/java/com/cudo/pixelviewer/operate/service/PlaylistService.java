package com.cudo.pixelviewer.operate.service;

import java.util.Map;

public interface PlaylistService {

    Map<String, Object> getPlaylistList();

    Map<String, Object> getPlaylist(String Id);

    Map<String, Object> postPlaylist(Map<String, Object> param);

}