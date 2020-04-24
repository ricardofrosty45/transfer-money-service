package br.com.transfer.money.domains;

public class Client {
	private String clientName;
	private String clientCpf;
	private String clientRg;
	private Integer clientAge;
	private Boolean underEightteenYearsOld;
	private Boolean parentsAuthorization;
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientCpf() {
		return clientCpf;
	}
	public void setClientCpf(String clientCpf) {
		this.clientCpf = clientCpf;
	}
	public String getClientRg() {
		return clientRg;
	}
	public void setClientRg(String clientRg) {
		this.clientRg = clientRg;
	}
	public Integer getClientAge() {
		return clientAge;
	}
	public void setClientAge(Integer clientAge) {
		this.clientAge = clientAge;
	}
	public Boolean isUnderEightteenYearsOld() {
		return underEightteenYearsOld;
	}
	public void setUnderEightteen(Boolean underEightteenYearsOld) {
		this.underEightteenYearsOld = underEightteenYearsOld;
	}
	public Boolean isParentsAuthorization() {
		return parentsAuthorization;
	}
	public void setParentsAuthorization(Boolean parentsAuthorization) {
		this.parentsAuthorization = parentsAuthorization;
	}
}
