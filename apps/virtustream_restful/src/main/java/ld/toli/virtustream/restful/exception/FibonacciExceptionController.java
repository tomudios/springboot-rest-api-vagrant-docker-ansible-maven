package ld.toli.virtustream.restful.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FibonacciExceptionController {

	@ExceptionHandler(value = MinValueExceededException.class)
	public ResponseEntity<Object> exception(MinValueExceededException exception) {
		return new ResponseEntity<Object>("Value must be greater than 0", HttpStatus.PRECONDITION_FAILED);
	}
	
	@ExceptionHandler(value = MaxValueExceededException.class)
	public ResponseEntity<Object> exception(MaxValueExceededException exception) {
		return new ResponseEntity<Object>("Value must be less than or equal to 93", HttpStatus.PRECONDITION_FAILED);
	}
}
