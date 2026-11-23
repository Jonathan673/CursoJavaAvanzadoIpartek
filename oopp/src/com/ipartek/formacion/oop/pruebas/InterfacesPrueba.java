package com.ipartek.formacion.oop.pruebas;

import java.util.ArrayList;
import java.util.Collection;

public class InterfacesPrueba {

	public static void main(String[] args) {
		Collection<Rodable> rodables = new ArrayList<>();
		rodables.add(new Balon());
		rodables.add(new Naranja());
		
		Iterable<Rodable> iterable = rodables;
		
		for(Rodable rodable:iterable) {
			if(rodable instanceof Comestible c) {
				c.comer();
			}
			rodable.rodar();
			if(rodable instanceof Comestible c) {
				c.comer();
			}
		}
	}

}

interface Rodable {
	void rodar();
}

interface Comestible {
	void comer();
}

class Fruto {
}

class ObjetoDeporte {
}

class Naranja extends Fruto implements Rodable, Comestible {
	private boolean porElSuelo = false;
	@Override
	public void comer() {
		if(porElSuelo) {
			System.out.println("Joder que asco dios mio esta llena de ...");			
		}else {
			System.out.println("Que rico, es la mejor naranja que he probado en la vida");
		}
	}

	@Override
	public void rodar() {
		System.out.println("Rodando");
		porElSuelo = true;
	}
}

class Balon extends ObjetoDeporte implements Rodable {

	@Override
	public void rodar() {
		System.out.println("Rodando");
	}
}