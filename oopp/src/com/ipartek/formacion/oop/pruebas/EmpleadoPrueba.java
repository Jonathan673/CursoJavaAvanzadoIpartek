package com.ipartek.formacion.oop.pruebas;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ipartek.formacion.oop.pojos.Empleado;
import com.ipartek.formacion.oop.pojos.EmpleadoIndefinido;

public class EmpleadoPrueba {

	public static void main(String[] args) {
		ArrayList<Empleado> empleados = new ArrayList<>();

		empleados.add(new EmpleadoIndefinido(1L, "Paco", "898989g", "ljhlak", new BigDecimal("3456.2"), 15));
		empleados.add(new EmpleadoIndefinido(2L, "Paco", "898989g", "ljhlak", new BigDecimal("3456.2"), 15));
		empleados.add(new EmpleadoIndefinido(3L, "Paco", "898989g", "ljhlak", new BigDecimal("3456.2"), 15));
		
		for(Empleado empleado:empleados) {
			System.out.println(empleado.getSueldoMensual());
		}
	}

}
