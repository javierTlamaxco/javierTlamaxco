package com.sngular.omb.ombapi.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionFormat extends  Exception {

   // private  final Long timeStamp;

    private final int status;

    private final String codigoError;

    public  ExceptionFormat(/*final Long timeStamp,*/ final int status,final String message){
        super(message);
        //this.timeStamp = timeStamp;
        this.status = status;
        this.codigoError = null;
    }
}
