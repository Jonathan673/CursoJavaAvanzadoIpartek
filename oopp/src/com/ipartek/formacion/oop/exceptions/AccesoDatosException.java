package com.ipartek.formacion.oop.exceptions;
//source -> generate exception from superclass
public class AccesoDatosException extends RuntimeException {
	//lo suyo es cambiar el numero cuando se edita esta clase
	private static final long serialVersionUID = -6706460605765983905L;

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
