package com.cudo.pixelviewer.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DisplayVo implements Serializable {

    private static final long serialVersionUID = 6840738662192251226L;

    private Integer displayId;

    private Integer screenId;

    private String displayNm;

    private Integer posX;
    private Integer posY;

    private Integer width;
    private Integer height;

    private Integer promaryFl;

    private Integer patternFl;

    private Integer row;
    private Integer column;
}