package br.com.transfer.money.domains;

import java.math.BigDecimal;
/*
 * @author Luan Ricardo De Luna Vieira Venancio
 * 
 */

//THAT'S A GOOD EXAMPLE USING EXTENDS, GOOD WAY TO EXPLAIN INHERITANCE
public class Account extends Client {
	private String clientCurrency;
	private Integer newAccountNumber;
	private Integer newAgencyNumber;
	private BigDecimal newBalance;

	public Account(String clientName, String clientCpf, String clientRg, Integer clientAge, String clientCurrency,
			Integer newAccountNumber, Integer newAgencyNumber, BigDecimal newBalance, Boolean underEightteenYearsOld,
			Boolean parentsAuthorization) {
		super.setClientName(clientName);
		super.setClientCpf(clientCpf);
		super.setClientAge(clientAge);
		super.setClientRg(clientRg);
		super.setUnderEightteen(underEightteenYearsOld);
		super.setParentsAuthorization(parentsAuthorization);
		this.clientCurrency = clientCurrency;
		this.newAccountNumber = newAccountNumber;
		this.newAgencyNumber = newAgencyNumber;
		this.newBalance = newBalance;
	}
	
	public Account(String clientName, String clientCpf, String clientRg, Integer clientAge, String clientCurrency,
			Integer newAccountNumber, Integer newAgencyNumber, BigDecimal newBalance, Boolean underEightteenYearsOld) {
		super.setClientName(clientName);
		super.setClientCpf(clientCpf);
		super.setClientAge(clientAge);
		super.setClientRg(clientRg);
		super.setUnderEightteen(underEightteenYearsOld);
		this.clientCurrency = clientCurrency;
		this.newAccountNumber = newAccountNumber;
		this.newAgencyNumber = newAgencyNumber;
		this.newBalance = newBalance;
	}

	public Account() {
	}

	public String getClientCurrency() {
		return clientCurrency;
	}

	public void setClientCurrency(String clientCurrency) {
		this.clientCurrency = clientCurrency;
	}

	public Integer getNewAccountNumber() {
		return newAccountNumber;
	}

	public void setNewAccountNumber(Integer newAccountNumber) {
		this.newAccountNumber = newAccountNumber;
	}

	public Integer getNewAgencyNumber() {
		return newAgencyNumber;
	}

	public void setNewAgencyNumber(Integer newAgencyNumber) {
		this.newAgencyNumber = newAgencyNumber;
	}

	public BigDecimal getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(BigDecimal newBalance) {
		this.newBalance = newBalance;
	}

}
