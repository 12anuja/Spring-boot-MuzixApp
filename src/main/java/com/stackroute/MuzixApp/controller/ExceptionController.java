package com.stackroute.MuzixApp.controller;

import com.mysql.cj.x.protobuf.MysqlxExpr;
import com.stackroute.MuzixApp.error.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.error.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController
{
    @ExceptionHandler(value = TrackAlreadyExistsException.class)
    public ResponseEntity<Object> exception1()
    {
        return new ResponseEntity<>("Track already present", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = TrackNotFoundException.class)
    public ResponseEntity<Object> exception2()
    {
        return new ResponseEntity<>("Track not exists", HttpStatus.NOT_FOUND);


    }

}
