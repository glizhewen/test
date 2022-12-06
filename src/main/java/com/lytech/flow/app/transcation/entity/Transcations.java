package com.lytech.flow.app.transcation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "transcations")
@NamedQuery(name = "Transcations.findAll", query = "SELECT a FROM Transcations a")
public class Transcations {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "todo_company_type")
	private String todoCompanyType ;
	
	@Column(name = "created_at")
	private Date createdAt ;

	@Column(name = "updated_at")
	private Date updatedAt ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTodoCompanyType() {
		return todoCompanyType;
	}

	public void setTodoCompanyType(String todoCompanyType) {
		this.todoCompanyType = todoCompanyType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
