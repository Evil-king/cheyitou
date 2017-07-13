package com.cheyitou.common.model.po;

import java.util.Date;

public class Sms {
    private Integer id;

    private String phone;

    private String content;

    private Date request_time;

    private String res_xml;

    private String post_data;
    
    private Date getCreate;//创建时间

    private Date getModified;//修改时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRequest_time() {
		return request_time;
	}

	public void setRequest_time(Date request_time) {
		this.request_time = request_time;
	}

	public String getRes_xml() {
		return res_xml;
	}

	public void setRes_xml(String res_xml) {
		this.res_xml = res_xml;
	}

	public String getPost_data() {
		return post_data;
	}

	public void setPost_data(String post_data) {
		this.post_data = post_data;
	}

	public Date getGetCreate() {
		return getCreate;
	}

	public void setGetCreate(Date getCreate) {
		this.getCreate = getCreate;
	}

	public Date getGetModified() {
		return getModified;
	}

	public void setGetModified(Date getModified) {
		this.getModified = getModified;
	}

}