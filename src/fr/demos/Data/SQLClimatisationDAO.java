package fr.demos.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import fr.demos.formation.today.Climatisation;



public class SQLClimatisationDAO implements ClimatisationDAO {
	
	
	
	private DataSource ds=null;
	
	
	public SQLClimatisationDAO() throws Exception{ // on fait un construcuteur
		
		//les deux premieres ligne c'est la recherche dans l'annuaire du pool de connexion (utilisation de la libraire INDI)
		
				Context context= new InitialContext();
				
				ds= (DataSource)context.lookup("jdbc/appliclim");
				
	}
	

	@Override
	public void sauve(Climatisation cl) throws Exception {
		
				
				//on demande une connexion au pool
		
		Connection cx= ds.getConnection();
		
				
				//on va pouvoir preparer notre requete SQL
		
		PreparedStatement psmt=cx.prepareStatement("insert into climatisation values (?,?,?,?,?)");
		
		psmt.setString(1, cl.getNomSalle());
		psmt.setDouble(2, cl.getTemperature());
		psmt.setDouble(3,cl.getPression());
		psmt.setDouble(4, cl.getTauxHumidite());
		psmt.setLong(5,cl.getDatation());
		
		// on lance la commande dans la base
		psmt.executeUpdate();
		
		// on rend la connexion au pool
		cx.close();
		
		
	}

	@Override
	public List<Climatisation> recherchetout() throws Exception {
		Connection cx= ds.getConnection();
		PreparedStatement psmt=cx.prepareStatement("select * from climatisation");
		ResultSet rs= psmt.executeQuery();
		ArrayList<Climatisation>liste=new ArrayList<>();
		while (rs.next()){
		String nomSalle=rs.getString(1);
		double temperature=rs.getDouble(2);
		double pression=rs.getDouble(3);
		double tauxHumidite=rs.getDouble(4);
		long datation=rs.getLong(5);
		
	
		Climatisation cl= new Climatisation (nomSalle, pression, tauxHumidite, temperature);
		liste.add(cl);
		}
		
		return liste;
	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombre(String Critere) {
		
		int nb=0;
		try{
			List<Climatisation> liste=this.recherchetout();
			nb=liste.size();
		}
		
		catch(Exception e){}
		return nb;
	}

}
