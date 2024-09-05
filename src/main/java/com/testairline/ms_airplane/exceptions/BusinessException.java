/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.exceptions;

import com.testairline.ms_airplane.enums.ApplicationResponseEnum;

public class BusinessException extends Exception {

	private final ApplicationResponseEnum responseCode;

	public BusinessException(ApplicationResponseEnum responseCode) {
		this.responseCode = responseCode;
	}

	public BusinessException(ApplicationResponseEnum responseCode, Exception exception) {
		super(exception);
		this.responseCode = responseCode;
	}

	public ApplicationResponseEnum getResponseCode() {
		return responseCode;
	}
}
