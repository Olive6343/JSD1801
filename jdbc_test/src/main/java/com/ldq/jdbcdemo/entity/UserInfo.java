package com.ldq.jdbcdemo.entity;

public class UserInfo {

	private Long uId;
	private String username;
	private String password;
	private String idCard;
	private Integer status;
	public UserInfo(){}
	public UserInfo(Long uId, String username, String password, String idCard, Integer status) {
		super();
		this.uId = uId;
		this.username = username;
		this.password = password;
		this.idCard = idCard;
		this.status = status;
	}

	public Long getuId() {
		return uId;
	}
	
	@Override
	public String toString() {
		return "UserInfo [uId=" + uId + ", username=" + username + ", password=" + password + ", idCard=" + idCard
				+ ", status=" + status + "]";
	}
	public void setuId(Long uId) {
		this.uId = uId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
