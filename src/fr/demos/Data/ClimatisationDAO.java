package fr.demos.Data;

import java.util.List;

import fr.demos.formation.today.Climatisation;

//DAO: Data Access Object : objet qui sert a l'acces aux données
public interface ClimatisationDAO {
	
	void sauve(Climatisation cl) throws Exception;
	
	List <Climatisation> recherchetout() throws Exception; // on veut etre plus general que la array list 
	
	List <Climatisation> recherche (String critere) throws Exception;
	
	int nombre(String Critere);
	

}
