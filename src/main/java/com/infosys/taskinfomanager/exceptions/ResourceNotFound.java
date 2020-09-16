package com.infosys.taskinfomanager.exceptions;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String message){
        super(message);
    }

    public ResourceNotFound(String message, Throwable throwable ){
        super(message, throwable);
    }

}
