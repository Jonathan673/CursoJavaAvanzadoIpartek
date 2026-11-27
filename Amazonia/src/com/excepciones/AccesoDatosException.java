package com.excepciones;

//source -> generate exception from superclass
public class AccesoDatosException extends RuntimeException {
	// lo suyo es cambiar el numero cuando se edita esta clasex
	private static final long serialVersionUID = 5282905304870359492L;

	

	public AccesoDatosException() {
		super();
	}

	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccesoDatosException(String message) {
		super(message);
	}

	public AccesoDatosException(Throwable cause) {
		super(cause);
	}

}
