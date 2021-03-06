package fr.demos.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rda = request.getRequestDispatcher("/Login.jsp");
		rda.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		String unBoutonAction = request.getParameter("boutonAction");

		if (unBoutonAction != null && unBoutonAction.equals("Login")) {

			String leNom = request.getParameter("Nom");

			leNom = leNom.trim(); // pour eviter les espaces

			if (leNom != null && !leNom.equals("")) {
				session.setAttribute("votrenom", leNom);
				rd = request.getRequestDispatcher("/ClimController");
			}

			else {

				request.setAttribute("erreur", "nom obligatoire");

			}

		}

		rd.forward(request, response);

	}

}
