package com.entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note{
	@Id
	private int id;
	@Column(length=2000)
	private String title;
	
	@Column(length=3000)
	private String content;
	private Date addedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	public Note(String title, String content, Date addedDate) {
		super();
		this.id = new Random().nextInt(10000);
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
	}

	public Note() {
		super();

	}

}
