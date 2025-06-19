package com.sk.eadmin.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.eadmin.biz.dto.AddCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemMappingAgentMapperOutputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemRegistDetailInfoOutputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemRegistMapperInputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemRegistMapperOutputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemRegistOutputDTO;
import com.sk.eadmin.biz.dto.ModifyCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.mapper.CustomerProblemMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerProblemServiceImpl implements CustomerProblemService {
  private final CustomerProblemMapper customerProblemMapper;
  @Override
  public List<CustomerProblemRegistOutputDTO> getCustomerProblemRegistList(@NonNull CustomerProblemRegistInputDTO input) {
	log.debug(">>>>> {}.getCustomerProblemRegistList Start <<<<<", this.getClass().getName());
	log.debug("    Parameter 1 - input[{}]", input);
    final CustomerProblemRegistMapperInputDTO mapperInput = CustomerProblemRegistMapperInputDTO.builder()
    	.problemCode(input.getProblemCode())
    	.agentRegionCode(input.getAgentRegionCode())
    	.progressStatusCode(input.getProgressStatusCode())
    	.requestDesc(input.getRequestDesc())
        .build();
    log.debug("mapperInput - {}", mapperInput);
	final List<CustomerProblemRegistMapperOutputDTO> mapperResults = customerProblemMapper.getCustomerProblemRegistList(mapperInput);
    log.debug("mapperResults - {}", mapperResults);
	List<CustomerProblemRegistOutputDTO> retList = new ArrayList<CustomerProblemRegistOutputDTO>();
	for (CustomerProblemRegistMapperOutputDTO mapperResult: mapperResults) {
		final CustomerProblemRegistOutputDTO ret = CustomerProblemRegistOutputDTO.builder()
			.regId(mapperResult.getRegId()) 
		    .custNm(mapperResult.getCustNm())
			.crteDttm(mapperResult.getCrteDttm())
			.agntIcn(mapperResult.getAgntIcn())
			.prbmDgr(mapperResult.getPrbmDgr())
			.prgsSts(mapperResult.getPrgsSts()).build();
		retList.add(ret);
	}
    log.debug("retList - {}", retList);
	log.debug(">>>>> {}.getCustomerProblemRegistList Finish <<<<<", this.getClass().getName());
    log.debug("    return - [{}]", retList);
    return retList;
  }

  @Override
  public CustomerProblemRegistDetailInfoOutputDTO getCustomerProblemRegistDetail(Integer registID) {
	log.debug(">>>>> {}.getCustomerProblemRegistDetail Start <<<<<", this.getClass().getName());
	log.debug("    Parameter 1 - registID[{}]", registID);
	final CustomerProblemRegistMapperOutputDTO problemRegistMapperOutput = customerProblemMapper.getCustomerProblemRegistDetail(registID);
	log.debug("problemRegistMapperOutput - {}", problemRegistMapperOutput);
	final List<CustomerProblemMappingAgentMapperOutputDTO> customerProblemMappingAgents = customerProblemMapper.getCustomerProblemMappingAgentList(registID);
	log.debug("customerProblemMappingAgents - {}", customerProblemMappingAgents);
	final List<CustomerProblemRegistDetailInfoOutputDTO.Agent> agents = new ArrayList<CustomerProblemRegistDetailInfoOutputDTO.Agent>();
	for (CustomerProblemMappingAgentMapperOutputDTO customerProblemMappingAgent: customerProblemMappingAgents) {
	  final CustomerProblemRegistDetailInfoOutputDTO.Agent retAgent = CustomerProblemRegistDetailInfoOutputDTO.Agent.builder()
	    .agntNm(customerProblemMappingAgent.getAgntNm())
	    .agntRegnCd(customerProblemMappingAgent.getAgntRegnCd())
	    .agentRegnVal(customerProblemMappingAgent.getAgentRegnVal())
		.build();
	  log.debug("regAgent for {} - {}", customerProblemMappingAgent, retAgent);
	  agents.add(retAgent);
	}
    final CustomerProblemRegistDetailInfoOutputDTO ret = CustomerProblemRegistDetailInfoOutputDTO.builder()
	  .custNm(problemRegistMapperOutput.getCustNm())
	  .reqDesc(problemRegistMapperOutput.getReqDesc())
	  .custMbl(problemRegistMapperOutput.getCustMbl())
	  .prgsSts(problemRegistMapperOutput.getPrgsSts())
	  .prgsStsVal(problemRegistMapperOutput.getPrgsSts())
	  .crteDttm(problemRegistMapperOutput.getCrteDttm())
	  .prbmCd(problemRegistMapperOutput.getPrbmCd())
	  .custPrbm(problemRegistMapperOutput.getCustPrbm())
      .prbmDgr(problemRegistMapperOutput.getPrbmDgr())
      .agents(agents).build();
	log.debug(">>>>> {}.getCustomerProblemRegistDetail Finish <<<<<", this.getClass().getName());
    log.debug("    return - [{}]", ret);
    return ret;
  }
    
  @Override
  @Transactional
  public void addCustomerProblemRegist(AddCustomerProblemRegistInputDTO param) {
    log.debug(">>>>> {}.addCustomerProblemRegist Start <<<<<", this.getClass().getName());
    log.debug("    Parameter 1 - param[{}]", param);
    final int resultCount = customerProblemMapper.addCustomerProblemRegist(
      CustomerProblemRegistMapperInputDTO.builder()
  	    .reqestID(param.getReqestID())
  	    .customerName(param.getCustomerName())
  	    .customerMobile(param.getCustomerMobile())
  	    .requestDesc(param.getRequestDesc())
  	    .problemCode(param.getProblemCode())
  	    .problemDegree(param.getProblemDegree())
  	    .progressStatusCode(param.getProgressStatusCode()).build()
    );
    log.debug("insert result count of customerProblemMapper.addCustomerProblemRegist - {}", resultCount);
	log.debug(">>>>> {}.addCustomerProblemRegist Finish <<<<<", this.getClass().getName());
  }
	
  @Override
  @Transactional
  public void modifyCustomerProblemRegist(ModifyCustomerProblemRegistInputDTO param) {
	log.debug(">>>>> {}.modifyCustomerProblemRegist Start <<<<<", this.getClass().getName());
	log.debug("    Parameter 1 - param[{}]", param);
    final int resultCount = customerProblemMapper.modifyCustomerProblemRegist(
      CustomerProblemRegistMapperInputDTO.builder()
        .registID(param.getRegistID())
        .reqestID(param.getReqestID())
    	.customerName(param.getCustomerName())
    	.customerMobile(param.getCustomerMobile())
    	.requestDesc(param.getRequestDesc())
    	.problemCode(param.getProblemCode())
    	.problemDegree(param.getProblemDegree())
    	.progressStatusCode(param.getProgressStatusCode()).build()
    );
    log.debug("insert result count of customerProblemMapper.modifyCustomerProblemRegist - {}", resultCount);
	log.debug(">>>>> {}.modifyCustomerProblemRegist Finish <<<<<", this.getClass().getName());
  }
	
  @Override
  @Transactional
  public void deleteCustomerProblemRegist(Integer registID) {
    log.debug(">>>>> {}.deleteCustomerProblemRegist Start <<<<<", this.getClass().getName());
    log.debug("    Parameter 1 - registID[{}]", registID);
    final int resultCount = customerProblemMapper.deleteCustomerProblemRegist(registID);
    log.debug("insert result count of customerProblemMapper.deleteCustomerProblemRegist - {}", resultCount);
	log.debug(">>>>> {}.deleteCustomerProblemRegist Finish <<<<<", this.getClass().getName());
  }
}
