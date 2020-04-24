package br.com.transfer.money.exception;



public class TransferErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String campo;

	private final Integer codigo;

	public TransferErrorException(String msg, String campo, Integer codigo) {
		super(msg);
		this.campo = campo;
		this.codigo = codigo;
	}

	public TransferErrorException(String msg, String campo, Integer codigo, Throwable cause) {
		super(msg, cause);
		this.campo = campo;
		this.codigo = codigo;
	}

	public String getCampo() {
		return campo;
	}

	public Integer getCodigo() {
		return codigo;
	}

}
