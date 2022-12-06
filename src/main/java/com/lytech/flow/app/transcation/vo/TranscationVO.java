package com.lytech.flow.app.transcation.vo;

public class TranscationVO {

	private Long id;

	private Integer status;
	
	private String todoCompanyType ;

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
}
