/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.handler;

import com.testairline.ms_airplane.enums.ApplicationResponseEnum;
import com.testairline.ms_airplane.exceptions.BusinessException;
import com.testairline.ms_airplane.responses.ErrorResponse;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class BusinessExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleBusinessException(BusinessException ex) {
		if (!ObjectUtils.isEmpty(ex.getCause())) {
			log.error("Exception: {}", ex.getCause().getLocalizedMessage());
		}
		return new ErrorResponse(ex.getResponseCode().getCode(), ex.getResponseCode().getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ErrorResponse(ApplicationResponseEnum.AIRPLANE_VALIDATION_ERROR.getCode(),
				ApplicationResponseEnum.AIRPLANE_VALIDATION_ERROR.getMessage(), errors);
	}
}
