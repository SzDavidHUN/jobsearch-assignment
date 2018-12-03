package hu.me.iit.controller;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestController
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ConversionFailedException.class)
    public Map<String, String> conversionExceptionHandler(
            ConversionFailedException e
    ) {
        Map<String, String> ret = new HashMap<>();
        ret.put("Description", e.getMessage());
        ret.put("Value", e.getValue().toString());
        ret.put("Error", "Conversion failed!");
        return ret;
    }

    @ExceptionHandler(java.lang.NumberFormatException.class)
    public Map<String, String> asd2(NumberFormatException nfe) {
        Map<String, String> ret = new HashMap<>();
        ret.put("Description", nfe.getMessage());
        ret.put("Error", "Number conversion failed!");
        return ret;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String asd(IllegalArgumentException e) {
        return e.getMessage();
    }


    //@ExceptionHandler(Exception.class)
    ///public String xd(Exception ex){
    //    return ex.getMessage();
    //}


}