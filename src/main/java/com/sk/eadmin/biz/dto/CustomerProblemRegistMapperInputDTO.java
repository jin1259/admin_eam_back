package com.sk.eadmin.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CustomerProblemRegistMapperInputDTO {
	private String 	reqestID;
	private Integer registID;
	private String 	customerName;
	private String 	customerMobile;
	private String 	requestDesc;
	private String 	problemCode;
	private Integer problemDegree;
	private String 	progressStatusCode;
	private String 	agentRegionCode;
}
