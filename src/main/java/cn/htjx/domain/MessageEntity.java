package cn.htjx.domain;

import java.io.Serializable;

public class MessageEntity implements Serializable {

	private static final long serialVersionUID = -1248243433913752200L;
	
	private int state;
	private String msg;
	private String data;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
