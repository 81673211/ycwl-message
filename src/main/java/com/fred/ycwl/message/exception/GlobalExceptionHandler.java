package com.fred.ycwl.message.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fred.ycwl.common.exception.BusinessException;
import com.fred.ycwl.common.web.Response;
import com.fred.ycwl.common.web.ResponseCode;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/23 11:18
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Response handle(Exception e) {
        Response response;
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            response = Response.getFailed(businessException.getResponseCode());
        } else {
            response = Response.getFailed(ResponseCode.ERROR_500);
        }
        return response;
    }
}
