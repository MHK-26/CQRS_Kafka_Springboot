package com.mhk26.account.cmd.api.controllers;

import  com.mhk26.cqrs.core.infrastructure.CommandDispatcher;
import com.mhk26.account.cmd.api.commands.OpenAccountCommand;
import com.mhk26.account.cmd.api.dto.OpenAccountResponse;
import com.mhk26.account.common.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





import java.text.MessageFormat;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api/v1/openBankAccount")
public class OpenAccountController {
    private final Logger logger = Logger.getLogger(OpenAccountController.class.getName());


    @Autowired
    private CommandDispatcher commandDispatcher;

    @PostMapping
    public  ResponseEntity<BaseResponse> openAccount(@RequestBody OpenAccountCommand command){
        var id = UUID.randomUUID().toString();
        command.setId(id);
        try {
            commandDispatcher.send(command);
            return new ResponseEntity<>(new OpenAccountResponse("Bank account creation request completed successfully!", id), HttpStatus.CREATED);
        }catch ( IllegalStateException e ){
            logger.log(Level.WARNING, MessageFormat.format("Cliebt made a bad request - {0}.",e.toString()));
            return new ResponseEntity<>(new BaseResponse(e.toString()), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            var safeErrorMessage = MessageFormat.format("Error while processing request to open a anew bank account for id - {0}.", id);
            logger.log(Level.SEVERE, safeErrorMessage,e);
            return new ResponseEntity<>(new OpenAccountResponse(safeErrorMessage, id), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
