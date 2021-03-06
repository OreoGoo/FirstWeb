package fr.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.formation.today.Climatisation;

/**
 * Servlet implementation class MaDate
 */
@WebServlet("/MaDateController")
public class MaDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MaDateController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// d represente le model
		Date d = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat ("EEE, MMM d, ''yyy' et il est' k 'heure' m 'minute'");
		
		String laDate=sdf.format(d);
		Climatisation clim1= new Climatisation ("t3", 12, 10, 1100);
		
		// transfert du model
		
		request.setAttribute("dateduJour", laDate);
		
		request.setAttribute("clim1", clim1);
	
		
		//appeler la vue
		RequestDispatcher rd=request.getRequestDispatcher("/madateView.jsp");
		rd.forward(request, response);
		
	
		
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
