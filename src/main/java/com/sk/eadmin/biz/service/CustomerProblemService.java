package com.sk.eadmin.biz.service;

import java.util.List;

import com.sk.eadmin.biz.dto.AddCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemRegistDetailInfoOutputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.dto.CustomerProblemRegistOutputDTO;
import com.sk.eadmin.biz.dto.ModifyCustomerProblemRegistInputDTO;

public interface CustomerProblemService {
  public List<CustomerProblemRegistOutputDTO> getCustomerProblemRegistList(CustomerProblemRegistInputDTO param);
  public CustomerProblemRegistDetailInfoOutputDTO getCustomerProblemRegistDetail(Integer registID);
  public void addCustomerProblemRegist(AddCustomerProblemRegistInputDTO param);
  public void modifyCustomerProblemRegist(ModifyCustomerProblemRegistInputDTO param);
  public void deleteCustomerProblemRegist(Integer registID);
}
