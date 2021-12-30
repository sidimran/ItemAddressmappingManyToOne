package com.itemaddress.mapping.itemaddressmapping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemaddress.mapping.itemaddressmapping.converter.AddressConverter;
import com.itemaddress.mapping.itemaddressmapping.dataobject.Address;
import com.itemaddress.mapping.itemaddressmapping.dto.AddressDTO;
import com.itemaddress.mapping.itemaddressmapping.dto.ResultDTO;
import com.itemaddress.mapping.itemaddressmapping.exception.AddressNotFoundException;
import com.itemaddress.mapping.itemaddressmapping.repository.AddressRepository;
import com.itemaddress.mapping.itemaddressmapping.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	AddressConverter addressConverter;

	ResultDTO dto = new ResultDTO();

	@Override
	public ResultDTO saveAddressdata(@Valid AddressDTO addressDTO) {

		Address saveAddress = addressConverter.dtoToEntity(addressDTO);
		addressRepository.save(saveAddress);
		dto.setMessage("Saved Successfully");
		dto.setData(saveAddress);

		return dto;
	}

	@Override
	public ResultDTO getByAddressName(String addressName) {

		ResultDTO resultDTO = new ResultDTO<>();
		List<Address> listAddress = addressRepository.getByAddressName(addressName);

		List<AddressDTO> addressDTO = new ArrayList<>();

		for (Address address : listAddress) {
			addressDTO.add(addressConverter.entityToDto(address));

		}
		resultDTO.setMessage("Fetched Data");
		resultDTO.setListData(addressDTO);

		return resultDTO;
	}

}
