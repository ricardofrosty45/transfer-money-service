package br.com.transfer.money.service.enumeration;

public enum ErrorsEnum {

	SAME_CPF("Client has the same CPF", "clientCpf", 100), 
	SAME_RG("Client has the same RG", "clientRg", 101),
	MINOR_DOESNT_HAVE_AUTHORIZATION("You don't have permition to create a bank account", "parentsAuthorization", 102),
	INSUFFICIENT_BANK_BALANCE("You don't have enough money!","balance",103),
	NO_REGISTRED_ACCOUNTS("Any accounts were registred","accounts",104);

	private String msg;

	private String campo;

	private final Integer code;

	private ErrorsEnum(String msg, String campo, Integer code) {
		this.setMsg(msg);
		this.setCampo(campo);
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public Integer getCode() {
		return code;
	}

}
