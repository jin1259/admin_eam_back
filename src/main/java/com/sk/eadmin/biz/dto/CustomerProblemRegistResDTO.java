package com.sk.eadmin.biz.dto;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CustomerProblemRegistResDTO {
  @Schema(
    description = "등록ID",
    name = "regId",
    type = "string",
    example = "1"
  )
  private String regId;

  @Schema(
	description = "고객명",
	name = "custNm",
	type = "string",
    example = "홍길동"
  )
  private String custNm;

  @Schema(
	description = "고객휴대폰번호",
	name = "custMbl",
	type = "string",
    example = "01098765432",
    nullable = true
  )
  private String custMbl;

  @Schema(
	description = "요청설명",
	name = "reqDesc",
	type = "string",
    example = "샘플요청설명입니다."
  )
  private String reqDesc;

  @Schema(
	description = "문의코드. 0001 - 사용요금관련, 0002 - 통화품질관련, 0003 - 대리점 서비스 관련, 0004 - 해외 로밍 관련",
	name = "prbmCd",
	type = "string",
    example = "0001"
  )
  private String prbmCd;

  @Schema(
	description = "담당지역코드. 01 - 서울, 02 - 경기, 03 - 인천",
	name = "prbmDgr",
	type = "string",
    example = "01"
  )
  private int prbmDgr;

  @Schema(
	description = "진행상태코드. 01 - 성공, 02 - 대기",
	name = "prgsSts",
	type = "string",
    example = "01"
  )
  private String prgsSts;

  @Schema(
	description = "진행상태값. Success or Hold",
	name = "prgsStsVal",
	type = "string",
    example = "Success"
  )
  private String prgsStsVal;

  @Schema(
	description = "생성일시",
	name = "crteDttm",
	type = "string",
    example = "2025-03-19T16:45:29"
  )
  private Date crteDttm;

  @Schema(
	description = "담당자아이콘",
	name = "agntIcn",
	type = "string",
    example = "1,2"
  )
  private String agntIcn;
}
