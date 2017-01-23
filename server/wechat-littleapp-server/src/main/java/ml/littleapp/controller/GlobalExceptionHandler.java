package ml.littleapp.controller;

import javax.servlet.http.HttpServletRequest;

import ml.littleapp.util.MyException;
import ml.littleapp.vo.ErrorInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req,
			MyException e) throws Exception {

		String reqUrl = req.getRequestURL().toString();
		logger.error(reqUrl, e);
		
		ErrorInfo<String> errorInfo = new ErrorInfo<String>();
		errorInfo.setMessage(e.getMessage());
		errorInfo.setCode(ErrorInfo.ERROR);
		errorInfo.setData("Some Data");
		errorInfo.setUrl(reqUrl);

		return errorInfo;
	}

}