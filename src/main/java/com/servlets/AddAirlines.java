package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AirLinesDAO;
import com.models.Airlines;

/**
 * Servlet implementation class AddAirlines
 */
public class AddAirlines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAirlines() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String aname = request.getParameter("txtAirname");
		
		Airlines aobj = new Airlines();
		aobj.setAidId(0);
		aobj.setAirName(aname);
		AirLinesDAO aDaoObj = new AirLinesDAO();
		aDaoObj.AddAirLines(aobj);
		response.sendRedirect("AirLines.jsp");
	}
}
