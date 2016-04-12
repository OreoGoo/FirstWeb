package fr.demos.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.Data.ClimatisationDAO;
import fr.demos.Data.FileClimatisationDAO;
import fr.demos.Data.SQLClimatisationDAO;

/**
 * Servlet implementation class ClimatisationajaxController
 */
@WebServlet("/ClimatisationajaxController")
public class ClimatisationajaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClimatisationajaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		ClimatisationDAO dao;
		try {
			
		 dao= new SQLClimatisationDAO();
		
		int nb= dao.nombre("");
	
		
		
		out.println("il ya "+nb+"Climatisation");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
