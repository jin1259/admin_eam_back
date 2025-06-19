package com.sk.eadmin.biz.dto;

import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerProblemRegistDetailInfoResDTO {
  @Schema(
	description = "고객불만응답",
	name = "customerProblemResistResDTO",
	type = "object"
  )
  private CustomerProblemResistResDTO customerProblemResistResDTO;
  @Schema(
	description = "고객불만매핑에이전트",
	name = "customerProblemMappingAgentResDTO",
	type = "array"
  )
  private List<CustomerProblemMappingAgentResDTO> customerProblemMappingAgentResDTO;
  
  @Builder
  @Data
  public static class CustomerProblemResistResDTO {
    @Schema(
	  description = "고객명",
	  name = "custNm",
	  type = "string",
	  example = "홍길동"
	)
    private String custNm;

    @Schema(
	  description = "요청설명",
	  name = "reqDesc",
	  type = "string",
	  example = "요청설명 샘플"
	)
    private String reqDesc;

    @Schema(
	  description = "고객휴대폰번호",
	  name = "custMbl",
	  type = "string",
	  example = "01098761234"
	)
    private String custMbl;

    @Schema(
	  description = "진행상태코드. 01 - 성공, 02 - 대기",
	  name = "prgsSts",
	  type = "string",
	  example = "01"
	)
    private String prgsSts;

    @Schema(
	  description = "생성일시",
	  name = "crteDttm",
	  type = "string",
	  example = "2024-03-27T01:01:04.132"
	)
    private Date crteDttm;
  }

  @Builder
  @Data
  public static class CustomerProblemMappingAgentResDTO {
    @Schema(
	  description = "담당자명",
	  name = "agntNm",
	  type = "string",
	  example = "홍길순"
	)
	private String agntNm;

    @Schema(
	  description = "담당지역코드. 01 - 서울, 02 - 경기, 03 - 인천",
	  name = "agntRegnCd",
	  type = "string",
	  example = "01"
	)
    private String agntRegnCd; 

    @Schema(
	  description = "담당지역명",
	  name = "agentRegnVal",
	  type = "string",
	  example = "서울"
	)
    private String agentRegnVal;
  }
}
