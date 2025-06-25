package com.barclays.categories.model;

public class CategoriesRequest {
	
	private String cardNum;
	private String clientId;
	private String channelId;
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
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
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
	@Override
	public String toString() {
		return "CategoriesRequest [cardNum=" + cardNum + ", clientId=" + clientId + ", channelId=" + channelId
				+ ", reqId=" + reqId + ", msgTs=" + msgTs + "]";
	}
	
	
	
	

}
