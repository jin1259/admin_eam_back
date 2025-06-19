package com.sk.eadmin.biz.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerProblemRegistMapperOutputDTO {
  private String 	regId;
  private String 	custNm;
  private String 	custMbl;
  private String 	reqDesc;
  private String 	prbmCd;
  private String 	custPrbm;
  private int 	prbmDgr;
  private String 	prgsSts;
  private String 	prgsStsVal;
  private Date 	crteDttm;
  private String 	agntIcn;
}
