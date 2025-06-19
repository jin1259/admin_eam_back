package com.sk.eadmin.biz.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CustomerProblemRegistOutputDTO {
  private String regId;
  private String custNm;
  private String custMbl;
  private String reqDesc;
  private String prbmCd;
  private int prbmDgr;
  private String prgsSts;
  private String prgsStsVal;
  private Date crteDttm;
  private String agntIcn;
}
