package com.kbit.eem.models.service.Configurations.Receipt;

public class HeadAccountSO {
	private int id;
	private String accountNumber;
	private String accountName;
	private String userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return String.format(
				"{ID:%d, AccountName:%s, AccountNumber:%s, UserID:%s}", id,
				accountName, accountNumber, userId);
	}
}
