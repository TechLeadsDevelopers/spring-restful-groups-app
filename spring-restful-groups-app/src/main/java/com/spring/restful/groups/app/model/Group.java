package com.spring.restful.groups.app.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String status;
	private String description;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SS", timezone = "IST")
	private Timestamp creatdate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SS", timezone = "IST")
	private Timestamp lstmodified;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreatdate() {
		return creatdate;
	}
	public void setCreatdate(Timestamp creatdate) {
		this.creatdate = creatdate;
	}
	public Timestamp getLstmodified() {
		return lstmodified;
	}
	public void setLstmodified(Timestamp lstmodified) {
		this.lstmodified = lstmodified;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", status=" + status + ", description=" + description
				+ ", creatdate=" + creatdate + ", lstmodified=" + lstmodified + "]";
	}
	
	
}
