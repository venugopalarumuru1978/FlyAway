package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AirportsDAO;
import com.models.Airports;

/**
 * Servlet implementation class AddAirports
 */
public class AddAirports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAirports() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String apcode = request.getParameter("txtApCode");
		String apname = request.getParameter("txtApName");
		String apcity = request.getParameter("txtApCity");
		String apctry = request.getParameter("txtApCtry");
		
		Airports  apObj = new Airports();
		apObj.setAp_code(apcode);
		apObj.setAp_name(apname);
		apObj.setCity(apcity);
		apObj.setCountry(apctry);
		
		AirportsDAO  apDao = new AirportsDAO();
		apDao.AddAirports(apObj);
		
		response.sendRedirect("Airports.jsp");		
	}

}
