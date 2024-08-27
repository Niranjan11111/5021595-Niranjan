package com.example.BookstoreAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String address;
	public void setId(long l) {
		// TODO Auto-generated method stub
		
	}
	public void setName(String name2) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(String email2) {
		// TODO Auto-generated method stub
		
	}
	public void setAddress(String address2) {
		// TODO Auto-generated method stub
		
	}
}
