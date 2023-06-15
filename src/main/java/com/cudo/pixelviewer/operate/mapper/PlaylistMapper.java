package com.cudo.pixelviewer.operate.mapper;

import com.cudo.pixelviewer.vo.PlaylistContentsVo;
import com.cudo.pixelviewer.vo.PlaylistVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlaylistMapper {

    List<PlaylistVo> getPlaylistList();

    PlaylistVo getPlaylist(String playlistId);

    int postPlaylistValid(Map<String, Object> param);
    int postPlaylist(Map<String, Object> param);

    int deletePlaylistValid(Map<String, Object> param);
    int deletePlaylist(Map<String, Object> param);

    int patchPlaylistNameValid(Map<String, Object> param);
    int patchPlaylistName(Map<String, Object> param);

    int putPlaylistValid(Map<String, Object> param);
    int putPlaylist(Map<String, Object> param);

    List<PlaylistContentsVo> getPlaylistContentsList();

    PlaylistContentsVo getPlaylistContents(String playlistId);

    int postPlaylistContentsValid(Map<String, Object> param);
    int postPlaylistContents(Map<String, Object> param);

    int deletePlaylistContentsValid(Map<String, Object> param);
    int deletePlaylistContents(Map<String, Object> param);

    int patchContentsNameValid(Map<String, Object> param);
    int patchContentsName(Map<String, Object> param);

    int patchContentsPlaytimeValid(Map<String, Object> param);
    int patchContentsPlaytime(Map<String, Object> param);

}