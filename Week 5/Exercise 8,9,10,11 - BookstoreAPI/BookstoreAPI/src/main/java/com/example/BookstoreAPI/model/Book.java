package com.example.BookstoreAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    private String title;
    private String author;
    private Double price;
    private String isbn;
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setTitle(Object title2) {
		// TODO Auto-generated method stub
		
	}
	public Object getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getIsbn() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPrice(Object price2) {
		// TODO Auto-generated method stub
		
	}
	public void setAuthor(Object author2) {
		// TODO Auto-generated method stub
		
	}
	public void setIsbn(Object isbn2) {
		// TODO Auto-generated method stub
		
	}
}
