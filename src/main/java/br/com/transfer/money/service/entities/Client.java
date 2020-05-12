package br.com.transfer.money.service.entities;

public class Client {
	private String clientName;
	private String clientCpf;
	private String clientRg;
	private Integer clientAge;
	
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
}
