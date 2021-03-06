package hu.me.iit.controller;

import hu.me.iit.exception.DtoConversionException;
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
    public Map<String, String> numberFormatExceptionHandler(NumberFormatException e) {
        Map<String, String> ret = new HashMap<>();
        ret.put("Description", e.getMessage());
        ret.put("Error", "Number conversion failed!");
        return ret;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentExceptionHandler(IllegalArgumentException e) {
        return e.getMessage();
    }

    @ExceptionHandler(DtoConversionException.class)
    public Map<String, String> dtoConversionExceptionHandler(DtoConversionException e){
        Map<String, String> ret = new HashMap<>();
        ret.put("Description", e.getMessage());
        ret.put("Error", "DTO Conversion failed");
        return ret;
    }

    //@ExceptionHandler(Exception.class)
    ///public String xd(Exception ex){
    //    return ex.getMessage();
    //}


}