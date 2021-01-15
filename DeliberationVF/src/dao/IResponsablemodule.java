package dao;

import beans.responsablemodule;

public interface IResponsablemodule {
	public responsablemodule getresponsableModule(String emailRM, String mdpRM);	
	public boolean login(String emailRM, String mdpRM);


}
