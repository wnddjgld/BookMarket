package kr.ac.kopo.wnddjgld.bookmarket.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException {
    @ExceptionHandler(value = RuntimeException.class)
    private ModelAndView handleException(Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e.toString());
        mav.setViewName("errorCommon");
        return mav;
    }
}
