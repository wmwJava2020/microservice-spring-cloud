
package com.usa.employee.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handlesEmployeeException(Exception ex, WebRequest request) {

		String errorMsgDescription = ex.getLocalizedMessage();

		if (errorMsgDescription == null) errorMsgDescription = ex.toString();

		CustomErrorMessage errorMsg = new CustomErrorMessage(new Date(), errorMsgDescription);

		return new ResponseEntity<Object>(errorMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	} 
	
	@ExceptionHandler(value = { NullPointerException.class,UserCustomException.class, ArithmeticException.class  })
	public ResponseEntity<Object> handlesGeneralException(Exception ex, WebRequest request) {

		String errorMsgDescription = ex.getLocalizedMessage();

		if (errorMsgDescription == null) errorMsgDescription = ex.toString();

		CustomErrorMessage errorMsg = new CustomErrorMessage(new Date(), errorMsgDescription);

		return new ResponseEntity<Object>(errorMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	} 
/**	
	@ExceptionHandler(value = {ArithmeticException.class  })
	public ResponseEntity<Object> handlesArithmeticException(ArithmeticException ex, WebRequest request) {

		String illegalArithmeticExc = ex.getLocalizedMessage();

		if (illegalArithmeticExc == null) illegalArithmeticExc = ex.toString();

		CustomErrorMessage errorMsg = new CustomErrorMessage(new Date(), illegalArithmeticExc);

		return new ResponseEntity<Object>(errorMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	} 
	
	@ExceptionHandler(value = { UserCustomException.class })
	public ResponseEntity<Object> handlesUserCustomException(UserCustomException ex, WebRequest request) {

		String userDefinedExc = ex.getLocalizedMessage();

		if (userDefinedExc == null) userDefinedExc = ex.toString();

		CustomErrorMessage errorMsg = new CustomErrorMessage(new Date(), userDefinedExc);

		return new ResponseEntity<Object>(errorMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	} 
**/
}
