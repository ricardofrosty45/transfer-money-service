package br.com.transfer.money.service.entities;

import java.math.BigDecimal;
/*
 * @author Luan Ricardo De Luna Vieira Venancio
 * 
 */

//CONTAS BANCARIAS USANDO NO EXTENDS O CLIENT, UM OTIMO EXEMPLO DE HERANCA
public class Account extends Client {
	private Integer newAccountNumber;
	private Integer newAgencyNumber;
	private BigDecimal newBalance;

	public Account(String clientName, String clientCpf, String clientRg, Integer clientAge,
			Integer newAccountNumber, Integer newAgencyNumber, BigDecimal newBalance) {
		super.setClientName(clientName);
		super.setClientCpf(clientCpf);
		super.setClientAge(clientAge);
		super.setClientRg(clientRg);
		this.newAccountNumber = newAccountNumber;
		this.newAgencyNumber = newAgencyNumber;
		this.newBalance = newBalance;
	}

	public Account() {
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
