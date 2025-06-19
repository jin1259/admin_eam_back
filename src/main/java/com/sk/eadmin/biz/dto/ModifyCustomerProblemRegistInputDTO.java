package com.sk.eadmin.biz.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ModifyCustomerProblemRegistInputDTO {
  private Integer registID;
  private String customerName;
  private String customerMobile;
  private String requestDesc;
  private String problemCode;
  private Integer problemDegree;
  private String progressStatusCode;
  private String reqestID;
}
