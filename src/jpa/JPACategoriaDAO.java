package jpa;

import Entidades.Categoria;
import dao.CategoriaDAO;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> implements CategoriaDAO{

	public JPACategoriaDAO() {
		super(Categoria.class);
	}

}
