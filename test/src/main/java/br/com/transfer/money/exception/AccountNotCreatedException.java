package br.com.transfer.money.exception;



public class AccountNotCreatedException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String campo;

	private final Integer code;

	public AccountNotCreatedException(String msg, String campo, Integer code) {
		super(msg);
		this.campo = campo;
		this.code = code;
	}

	public AccountNotCreatedException(String msg, String campo, Integer codigo, Throwable cause) {
		super(msg, cause);
		this.campo = campo;
		this.code = codigo;
	}

	public String getCampo() {
		return campo;
	}

	public Integer getCodigo() {
		return code;
	}

}
