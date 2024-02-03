package com.mhk26.account.cmd.api.commands;

import com.mhk26.cqrs.core.commands.BaseCommand;

public class CloseAccountCommand extends BaseCommand {
    public CloseAccountCommand(String id){
        super(id);
    }

}
