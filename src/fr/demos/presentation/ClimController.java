package fr.demos.presentation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.Data.ClimatisationDAO;
import fr.demos.Data.FileClimatisationDAO;
import fr.demos.Data.SQLClimatisationDAO;
import fr.demos.formation.today.Climatisation;

/**
 * Servlet implementation class ClimController
 */
@WebServlet("/ClimController")
public class ClimController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClimController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/SaisieClimatisation.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/SaisieClimatisation.jsp");

		boolean erreurs = false;

		String unBoutonAction = request.getParameter("boutonAction");
		if (unBoutonAction != null && unBoutonAction.equals("enregistrer")) {
			String leNomAppareil = request.getParameter("NomAppareil");
			String laTemperature = request.getParameter("Temperature");
			String leTauxHumidité = request.getParameter("TauxHumidité");
			String laPression = request.getParameter("Pression");
			double tempval = 0;
			double pressionval = 0;
			double humiditeval = 0;
			request.setAttribute("nom", leNomAppareil);
			request.setAttribute("temp", laTemperature);
			request.setAttribute("txh", leTauxHumidité);
			request.setAttribute("press", laPression);
			// conversion

			try {

				tempval = Double.parseDouble(laTemperature);

			} catch (NumberFormatException exp) {
				erreurs = true;
				request.setAttribute("TempErreur", "nombre incorrect");

			}
			try {

				pressionval = Double.parseDouble(laPression);
				request.setAttribute("pressionfinal", pressionval);

			} catch (NumberFormatException exps) {
				erreurs = true;
				request.setAttribute("pressionErreur", "nombre incorrect");
			}
			try {

				humiditeval = Double.parseDouble(leTauxHumidité);

			} catch (NumberFormatException expss) {
				erreurs = true;
				request.setAttribute("humiditéErreur", "incorrect");
			}

			// validation
			// if(humiditeval>100);{
			// erreurs=true;

			// request.setAttribute("humiditéErreur", "valeur trop grande");
			// }

			if (!erreurs) {
				Climatisation clim = new Climatisation(leNomAppareil, tempval, pressionval, humiditeval);

		
				//ClimatisationDAO dao = new FileClimatisationDAO();
				
				List<Climatisation>ListClim=null;
				try {
					ClimatisationDAO dao3=new SQLClimatisationDAO();
					dao3.sauve(clim);
				

					//dao.sauve(clim);
					

				} catch (IOException exc) {

					exc.printStackTrace();
					request.setAttribute("RechercheDataErreur", exc.getMessage()); //le but c'est que l'utilisateur puisse voir le message d'erreur et pour ca il faut enlever les catch pour propager l'exception dans FileClimatisationDAO
				} catch (Exception e) {// il sert a rien ce catch mais j'arrive pas a l'enlever la

					e.printStackTrace();
				}
				
				

				rd = request.getRequestDispatcher("/succesClim.jsp");
				
			}

			else {

				rd = request.getRequestDispatcher("/SaisieClimatisation.jsp");

			}

			
		}
		rd.forward(request, response);

	}
}