package fr.demos.presentation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
 * Servlet implementation class ListClimatisationController
 */
@WebServlet("/ListClimatisationController")
public class ListClimatisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListClimatisationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ClimatisationDAO dao2= new FileClimatisationDAO();
		
		List<Climatisation> maListeclim = null;
		
		try{
			ClimatisationDAO dao4= new SQLClimatisationDAO();
			//maListeclim=dao2.recherchetout();
			maListeclim=dao4.recherchetout();
		} catch (IOException exc) {

			exc.printStackTrace();
			request.setAttribute("RechercheDataErreur", exc.getMessage());
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		RequestDispatcher rds = request.getRequestDispatcher("/ListClim.jsp");

		

		request.setAttribute("maliste", maListeclim);
		rds.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
