package com.cheyitou.common.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class MyAccount {

	   
	private Integer id;
	private String numOrderOver;//已完成订单数
	private BigDecimal accountAmount;//账号余额
	private BigDecimal getAmount;//提现金额
	private String paymentFlow;//支付流水
	private Integer userId;//冗余字段
	private String fundingSource;//资金来源
	private String orderNum;//订单编号
	private Date getCreate;//创建时间
	private Date getModified;//修改时间
	private Date getTime;//提现时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumOrderOver() {
		return numOrderOver;
	}
	public void setNumOrderOver(String numOrderOver) {
		this.numOrderOver = numOrderOver;
	}
	public BigDecimal getAccountAmount() {
		return accountAmount;
	}
	public void setAccountAmount(BigDecimal accountAmount) {
		this.accountAmount = accountAmount;
	}
	public BigDecimal getGetAmount() {
		return getAmount;
	}
	public void setGetAmount(BigDecimal getAmount) {
		this.getAmount = getAmount;
	}
	public String getPaymentFlow() {
		return paymentFlow;
	}
	public void setPaymentFlow(String paymentFlow) {
		this.paymentFlow = paymentFlow;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFundingSource() {
		return fundingSource;
	}
	public void setFundingSource(String fundingSource) {
		this.fundingSource = fundingSource;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
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
	public Date getGetTime() {
		return getTime;
	}
	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}
	
	
	
}