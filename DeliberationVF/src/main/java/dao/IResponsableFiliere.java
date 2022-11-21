package dao;

import beans.responsableFiliere;

public interface IResponsableFiliere {
	public responsableFiliere getresponsablefiliere(String emailRF, String mdpRF);	
	public boolean login(String emailRF, String mdpRF);


}
