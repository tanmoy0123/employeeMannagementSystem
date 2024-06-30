package com.employeeMannagement.service.address;

import com.employeeMannagement.dto.AddressDTO;

import java.util.List;

public interface AddressServices {
	AddressDTO createAddress(AddressDTO addressDTO);
	AddressDTO getAddressById(Long addressId);
	List<AddressDTO> getAllAddress();
	
	AddressDTO updateAddress(Long addressId, AddressDTO updatedAddress);
	void deleteAddressById(Long addressId);
	
}
