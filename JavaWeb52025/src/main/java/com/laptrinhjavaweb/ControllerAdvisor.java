package com.laptrinhjavaweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.laptrinhjavaweb.bean.ErrorResponseBean;
import com.laptrinhjavaweb.customexception.FieldRequiredException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ErrorResponseBean> handleCArithmeticException(ArithmeticException ex, WebRequest request) {

		ErrorResponseBean result = new ErrorResponseBean();
		result.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("Lỗi rồi ní ơi!");
		details.add("Sửa lại lẹ đi");
		result.setDetails(details);
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<ErrorResponseBean> handleFieldRequiredException(FieldRequiredException ex, WebRequest request) {

		ErrorResponseBean result = new ErrorResponseBean();
		result.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("Thiếu field rồi!");
		result.setDetails(details);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
