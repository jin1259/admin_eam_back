package com.sk.eadmin.biz.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerProblemRegistDetailInfoOutputDTO {
  private String custNm;
  private String reqDesc;
  private String custMbl;
  private String prgsSts;
  private String prgsStsVal;
  private Date crteDttm;
  private String prbmCd;
  private String custPrbm;
  private int prbmDgr;
  private List<Agent> agents;
  
  @Builder
  @Data
  public static class Agent {
	private String agntNm;
    private String agntRegnCd; 
	private String agentRegnVal;

  }
}
