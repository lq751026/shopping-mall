package com.lq.gulimall.product.exception;

import com.lq.exception.BizCodeEnume;
import io.renren.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
//自定义异常的处理
@Slf4j
@RestControllerAdvice(basePackages = "com.lq.gulimall.product.controller")
/*@ControllerAdvice(basePackages = "com.lq.gulimall.product.controller")*/
public class GulimallExceControllerAdrivce {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R HandLeVaileException(MethodArgumentNotValidException e){
      log.error("数据校验出现问题，异常类型{}",e.getMessage(),e.getCause());
        BindingResult result = e.getBindingResult();
        Map<String,String>errMap=new HashMap<>();
        result.getFieldErrors().forEach((fieldError -> {
            errMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        }));
        return  R.error(BizCodeEnume.VATLD_EXCPTION.getCode(),BizCodeEnume.VATLD_EXCPTION.getMsg()).put("data",errMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        log.info(throwable.getLocalizedMessage());
         return R.error(BizCodeEnume.UNKNOW_EXCPPTION.getCode(),BizCodeEnume.UNKNOW_EXCPPTION.getMsg());
    }
}
