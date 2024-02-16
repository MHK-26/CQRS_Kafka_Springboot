package com.mhk26.account.cmd.api.controllers;


import com.mhk26.account.cmd.api.commands.RestoreReadDBCommand;
import com.mhk26.account.common.dto.BaseResponse;
import com.mhk26.cqrs.core.infrastructure.CommandDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api/v1/restoreReadDB")
public class RestoreReadDBController {


    private final Logger logger = Logger.getLogger(RestoreReadDBController.class.getName());


    @Autowired
    private CommandDispatcher commandDispatcher;

    @PostMapping
    public ResponseEntity<BaseResponse> restoreReadDB(){

        try {
            commandDispatcher.send(new RestoreReadDBCommand());
            return new ResponseEntity<>(new BaseResponse("Read database restore request completed successfully!"), HttpStatus.CREATED);
        }catch ( IllegalStateException e ){
            logger.log(Level.WARNING, MessageFormat.format("Client made a bad request - {0}.",e.toString()));
            return new ResponseEntity<>(new BaseResponse(e.toString()), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            var safeErrorMessage ="Error while processing request to restore read database.";
            logger.log(Level.SEVERE, safeErrorMessage,e);
            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}
