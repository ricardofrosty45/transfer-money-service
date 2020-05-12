package br.com.transfer.money.service.interfaces.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.transfer.money.service.entities.Account;
import br.com.transfer.money.service.enumeration.ErrorsEnum;
import br.com.transfer.money.service.exception.ClientNotFoundException;
import br.com.transfer.money.service.interfaces.IAccountRepository;

public class IAccountRepositoryImpl implements IAccountRepository {
	private static final Logger logger = LoggerFactory.getLogger(IAccountRepositoryImpl.class);

	@Override
	public List<Account> getAccountById(Integer firstAccountId, Integer secondAccountIdTarget)
			throws ClientNotFoundException {

		List<Account> clients = new ArrayList<Account>();
		HashMap<Integer, Account> clientMap = createAccountMap();
		logger.info(
				"## Fiz um HashMap, onde cada cliente tem seu id mapeado pelo map, assim eu passo o id dele pelo parametro e consigo achar eles");

		if (clientMap.get(firstAccountId) != null) {
			logger.info("Cliente Encontrado!");
			clients.add(clientMap.get(firstAccountId));

			logger.info("Adicionando na lista {...}");
		}

		if (clientMap.get(secondAccountIdTarget) != null) {
			logger.info("Cliente Encontrado");
			clients.add(clientMap.get(secondAccountIdTarget));
			logger.info("Adicionando na lista {...}");
		}

		if (clients.isEmpty()) {
			throw new ClientNotFoundException(ErrorsEnum.DIDNT_FIND_ACCOUNTS.getMsg(),
					ErrorsEnum.DIDNT_FIND_ACCOUNTS.getCampo(), ErrorsEnum.DIDNT_FIND_ACCOUNTS.getCode());
		}

		return clients;
	}

	private HashMap<Integer, Account> createAccountMap() {
		// Criando um hasmap para poder mapear os clientes com um Id;
		HashMap<Integer, Account> clientMap = new HashMap<Integer, Account>();

		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21,
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100));

		Account accountTwo = new Account("Ricardo De Luna", "12355423499", "1234567", 27, new Random().nextInt(12563),
				new Random().nextInt(4323), new BigDecimal(100));

		logger.info("Adicionando Clientes criados no HashMap");
		clientMap.put(1, accountOne);
		clientMap.put(2, accountTwo);

		return clientMap;
	}

}
