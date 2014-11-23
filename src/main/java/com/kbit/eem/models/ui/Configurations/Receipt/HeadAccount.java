package com.kbit.eem.models.ui.Configurations.Receipt;

import com.kbit.eem.models.ui.BaseModel;

public class HeadAccount extends BaseModel {
	private int id;
	private String accountNumber;
	private String accountName;
	
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

	@Override
	public String toString() {
		return String.format(
				"{ID:%d, AccountName:%s, AccountNumber:%s}", id,
				accountName, accountNumber);
	}
}
