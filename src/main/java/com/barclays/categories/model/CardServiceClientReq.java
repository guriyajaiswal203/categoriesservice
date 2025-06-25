package com.barclays.categories.model;

public class CardServiceClientReq {
	
	private String cardNum;
	private String clientId;	
	private String reqId;
	private String msgTs;
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}	
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getMsgTs() {
		return msgTs;
	}
	public void setMsgTs(String msgTs) {
		this.msgTs = msgTs;
	}
	 
	

}
