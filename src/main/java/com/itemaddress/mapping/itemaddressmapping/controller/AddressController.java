package com.itemaddress.mapping.itemaddressmapping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.itemaddress.mapping.itemaddressmapping.dto.AddressDTO;
import com.itemaddress.mapping.itemaddressmapping.dto.ResultDTO;
import com.itemaddress.mapping.itemaddressmapping.exception.AddressNotFoundException;
import com.itemaddress.mapping.itemaddressmapping.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins="*")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping
	public ResultDTO saveAddressData(@Valid @RequestBody AddressDTO addressDTO) throws AddressNotFoundException {
		return addressService.saveAddressdata(addressDTO);

	}

	@RequestMapping(value = "/getByAddressName", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResultDTO getByAddressName(@RequestParam(value = "address") String addressName) {
		return addressService.getByAddressName(addressName);
	}

}
