package com.interfaces;

import com.pojos.Genero;

public interface GeneroInterface extends DaoInterface<Genero>{

	Genero insertarGenero(Genero genero);
	
}
