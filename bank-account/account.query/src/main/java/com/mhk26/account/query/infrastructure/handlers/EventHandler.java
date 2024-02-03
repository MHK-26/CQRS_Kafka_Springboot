package com.mhk26.account.query.infrastructure.handlers;

import com.mhk26.account.common.events.AccountOpenedEvent;
import com.mhk26.account.common.events.AccountClosedEvent;
import com.mhk26.account.common.events.FundsDepositedEvent;
import com.mhk26.account.common.events.FundsWithdrawnEvent;
public interface EventHandler {
    void on(AccountOpenedEvent event);
    void on(FundsDepositedEvent event);
    void on(FundsWithdrawnEvent event);
    void on(AccountClosedEvent event);

}
