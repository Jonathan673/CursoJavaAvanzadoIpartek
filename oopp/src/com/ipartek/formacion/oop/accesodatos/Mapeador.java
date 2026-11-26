package com.ipartek.formacion.oop.accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapeador <T>{
	T mapear(ResultSet rs) throws SQLException;
}
