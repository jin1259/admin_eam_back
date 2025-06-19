package com.sk.eadmin.biz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sk.eadmin.biz.dto.CustomerProblemMappingAgentMapperOutputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemRegistMapperInputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemRegistMapperOutputDTO;

@Mapper
public interface CustomerProblemMapper {
	List<CustomerProblemRegistMapperOutputDTO> getCustomerProblemRegistList(CustomerProblemRegistMapperInputDTO param);
	CustomerProblemRegistMapperOutputDTO getCustomerProblemRegistDetail(int registID);
	List<CustomerProblemMappingAgentMapperOutputDTO> getCustomerProblemMappingAgentList(int registID);
	int addCustomerProblemRegist(CustomerProblemRegistMapperInputDTO param);
	int modifyCustomerProblemRegist(CustomerProblemRegistMapperInputDTO param);
	int deleteCustomerProblemRegist(int registID);
}
