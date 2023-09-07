package com.gmission.doc.vo;

import lombok.Data;

@Data
public class FavoriteVO {
    private String userid;
    private int optionseq;
    private String optionname;
    private String exptypeid;
    private String expreasonid;
    private String expdatailreason;
    private String expinstname;
    private int ordernum;

    private FavoriteAddressVO favoriteAddressVO;
}
