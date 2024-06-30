package com.employeeMannagement.mapper;

import com.employeeMannagement.entity.Address;
import com.employeeMannagement.dto.AddressDTO;

public class AddressMapper {
	
	public static AddressDTO mapToAddressDTO(Address address){
		return new AddressDTO(
				address.getId(),
				address.getStreetName(),
				address.getHouseNumber(),
				address.getZipCode()
		);
	}
	
	public static Address mapToAddress(AddressDTO addressDTO){
		return new Address(
				addressDTO.getId(),
				addressDTO.getStreetName(),
				addressDTO.getHouseNumber(),
				addressDTO.getZipCode()
		);
	}
}
