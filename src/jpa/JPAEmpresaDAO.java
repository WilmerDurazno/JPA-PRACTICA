package jpa;

import Entidades.Empresa;
import dao.EmpresaDAO;

public class JPAEmpresaDAO extends JPAGenericDAO<Empresa, Integer> implements EmpresaDAO{
	
	public JPAEmpresaDAO() {
		super(Empresa.class);
	}
}
