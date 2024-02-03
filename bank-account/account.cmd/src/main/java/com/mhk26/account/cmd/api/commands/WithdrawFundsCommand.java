package com.mhk26.account.cmd.api.commands;

import com.mhk26.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class WithdrawFundsCommand extends BaseCommand {
    private double amount;
}
