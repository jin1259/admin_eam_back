package com.sk.eadmin.biz.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomerProblemRegistReqDTO {
  @Schema(
    description = "고객명",
	name = "customerName",
	type = "string",
	example = "홍길동"
  )
  private String customerName;

  @Schema(
	description = "고객휴대폰번호",
	name = "customerMobile",
	type = "string",
	example = "01098765432"
  )
  private String customerMobile;

  @Schema(
	description = "요청설명",
	name = "requestDesc",
	type = "string",
	example = "요청설명 샘플"
  )
  private String requestDesc;

  @Schema(
	description = "문의코드(문의코드. 0001 - 사용요금관련, 0002 - 통화품질관련, 0003 - 대리점 서비스 관련, 0004 - 해외 로밍 관련)",
	name = "problemCode",
	type = "string",
	example = "01"
  )
  private String problemCode;

  @Schema(
	description = "고객불만게이지(1~100)",
	name = "problemDegree",
	type = "number",
	example = "1"
  )
  private Integer problemDegree;

  @Schema(
	description = "처리상태코드",
	name = "progressStatusCode",
	type = "string",
	example = "01"
  )
  private String progressStatusCode;

  @Schema(
	description = "테스트ID",
	name = "testID",
	type = "string",
	example = "hongkildong"
  )
  private String testID;
}
