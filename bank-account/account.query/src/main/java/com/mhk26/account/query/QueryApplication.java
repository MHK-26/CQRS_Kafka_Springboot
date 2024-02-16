package com.mhk26.account.query;

import com.mhk26.account.query.api.queries.*;
import com.mhk26.cqrs.core.infrastructure.QueryDispatcher;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QueryApplication {
	@Autowired
	private QueryDispatcher queryDispatcher;

	@Autowired
	private QueryHandler queryHandler;

	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);
	}

	@PostConstruct
	public  void registerHandlers(){
		queryDispatcher.registerHandler(FindAllAccountsQuery.class,queryHandler::handler);
		queryDispatcher.registerHandler(FindAccountByIdQuery.class,queryHandler::handler);
		queryDispatcher.registerHandler(FindAccountByHolderQuery.class,queryHandler::handler);
		queryDispatcher.registerHandler(FindAccountWithBalanceQuery.class,queryHandler::handler);
	}

}
