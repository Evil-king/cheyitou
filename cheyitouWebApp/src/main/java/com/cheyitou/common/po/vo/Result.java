package com.cheyitou.common.po.vo;

import java.io.Serializable;


public class Result implements Serializable {

	    private static final long serialVersionUID = 1953705349524707022L;

	    // 状态.0表示正常
	    private String code;
	    
	    // 处理失败时,返回消息,否则返回空
	    private String msg;
	    
	    // 处理正常时,返回结果,返回返回空
	    private Object data;
	    
	    //dataInfo
	    private Object dataInfo;
	    
	    public Result() {
	    }
	    
		public Result(String code){
	    	this.code = code;
	    }
	    
	    public Result(String code, String msg) {
	        this.code = code;
	        this.msg = msg;
	    }
	    
	    public Result(Object data) {
	        this.data = data;
	    }

	    
	    public Result(String code, String msg, Object data) {
			super();
			this.code = code;
			this.msg = msg;
			this.data = data;
		}
	    
		public Result(String code, String msg, Object data, Object dataInfo) {
			super();
			this.code = code;
			this.msg = msg;
			this.data = data;
			this.dataInfo = dataInfo;
		}

		public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String msg) {
	        this.msg = msg;
	    }

	    public Object getData() {
	        return data;
	    }

	    public void setData(Object data) {
	        this.data = data;
	    }

		public Object getDataInfo() {
			return dataInfo;
		}

		public void setDataInfo(Object dataInfo) {
			this.dataInfo = dataInfo;
		}
	    
	    
	}
