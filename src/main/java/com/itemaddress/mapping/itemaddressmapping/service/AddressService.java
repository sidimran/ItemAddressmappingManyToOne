package com.itemaddress.mapping.itemaddressmapping.service;

import com.itemaddress.mapping.itemaddressmapping.dto.AddressDTO;
import com.itemaddress.mapping.itemaddressmapping.dto.ResultDTO;
import com.itemaddress.mapping.itemaddressmapping.exception.AddressNotFoundException;

public interface AddressService {
	
	public ResultDTO saveAddressdata(AddressDTO addressDTO);
	
	public ResultDTO getByAddressName(String addressName);

}
