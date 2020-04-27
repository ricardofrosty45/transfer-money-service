package br.com.transfer.money.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.transfer.money.exception.AccountNotCreatedException;
import br.com.transfer.money.exception.TransferErrorException;
import br.com.transfer.money.handler.TransferMoneyHandler;

public class StartProject {

	private static final Logger logger = LoggerFactory.getLogger(StartProject.class);

	public static void main(String[] args) throws AccountNotCreatedException,TransferErrorException{
		TransferMoneyHandler handler = new TransferMoneyHandler();
		logger.info("## StartProject.main() - Initializing  Handler {. . .}");
		handler.handleRequest();
	}

}
