package com.employeeMannagement.controller;


import com.employeeMannagement.dto.AddressDTO;
import com.employeeMannagement.service.address.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	private AddressServices addressServices;
	
	
	//Build ADD Address REST API
	@PostMapping
	public ResponseEntity<AddressDTO>  createAddress(
			@RequestBody AddressDTO addressDTO){
		AddressDTO savedAddress =  addressServices.createAddress(addressDTO);
		return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
	}
	
	//Build Get Address by id Rest api
	@GetMapping("{id}")
	public ResponseEntity<AddressDTO> getAddressById(
			@PathVariable("id") Long addressId){
		     AddressDTO addressDTO = addressServices.getAddressById(addressId);
			 return ResponseEntity.ok(addressDTO);
	}
	
	//Build Get All Address Rest api
	@GetMapping
	public ResponseEntity<List<AddressDTO>> getAllAddress(){
		List<AddressDTO> address = addressServices.getAllAddress();
		return ResponseEntity.ok(address);
	}
	
	//Build Update Address Rest Api
	@PutMapping("{id}")
	public ResponseEntity<AddressDTO> updatedAddress(
			@PathVariable("id") Long addressId,
			@RequestBody AddressDTO updatedAddress
	){
		AddressDTO addressDTO = addressServices
				.updateAddress(addressId, updatedAddress);
		return ResponseEntity.ok(addressDTO);
	}
	
	//Build Delete Address by id
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAddressById(
		@PathVariable("id")	Long addressId){
		addressServices.deleteAddressById(addressId);
		return ResponseEntity.ok("Address Deleted Successfully!.");
	}


}
