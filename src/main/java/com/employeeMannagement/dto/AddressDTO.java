package com.employeeMannagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
	private Long id;
	private String streetName;
	private String houseNumber;
	private String zipCode;
	
}
