package com.mhk26.account.cmd.api.commands;

import com.mhk26.cqrs.core.commands.BaseCommand;
import com.mhk26.account.common.dto.AccountType;
import lombok.Data;

@Data
public class OpenAccountCommand extends BaseCommand{
    private String accountHolder;
    private AccountType accountType;
    private double openingBalance;
}
