package fr.demos.Data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.demos.formation.today.Climatisation;

public class FileClimatisationDAO implements ClimatisationDAO {

	@Override
	public void sauve(Climatisation cl) throws Exception {
		
		//ArrayList<Climatisation> liste = new ArrayList<Climatisation>(); 
		List<Climatisation> liste=null;
		try {
			liste =this.recherchetout();
			
		}
		catch (Exception e){
			// si la recherche plante ce n'est pas forcement un pb : le fichier n'existe pas encore
			System.out.println(e.getMessage());
			liste=new ArrayList<>();
		}
		
		
		// lecture
		// fichier
		// avant
		// ecriture,
		// on
		// recupere
		// la
		// liste
		// des
		// clims
		// (si
		// elle
		// existe)

	
		
		liste.add(cl);
	
		//try (ObjectInputStream ois = new ObjectInputStream(
			//	new BufferedInputStream(new FileInputStream("climatisations")))) {
			//liste = (ArrayList<Climatisation>) ois.readObject();
		//} catch (IOException exc) {

			//exc.printStackTrace();

		//} catch (ClassNotFoundException exc) {
			//exc.printStackTrace();

		//}
		// on Complete la liste retrouvé avec le nouvel element

		
		// on ecrit la nouvelle list
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("climatisations")))) {

			oos.writeObject(liste);
			oos.flush();
		}

	}

	@Override
	public List<Climatisation> recherchetout() throws Exception {
		
		ArrayList<Climatisation> maListeclim = new ArrayList<Climatisation>();
		try 
			(ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("climatisations")));){
			maListeclim = (ArrayList<Climatisation>) ois.readObject();

		//} catch (IOException exc) {

			//exc.printStackTrace();

		//} catch (ClassNotFoundException exc) {
			//exc.printStackTrace();
		//}
		
		return maListeclim;
		}
	}


	
	
	@Override
	public List<Climatisation> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombre(String Critere){
		
		List<Climatisation> liste=null;
		
		int nb=0;
		try {
			liste =this.recherchetout();
			nb=liste.size();
			
		}
		catch (Exception e){
			// si la recherche plante ce n'est pas forcement un pb : le fichier n'existe pas encore
			System.out.println(e.getMessage());
			
		}
		return nb;
	}

}
