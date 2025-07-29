package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.FlightsDAO;
import com.models.Flights;

/**
 * Servlet implementation class AddFlight
 */
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fid = request.getParameter("txtFCode");
		String fname = request.getParameter("txtFName");
		int aircode = Integer.parseInt(request.getParameter("ddlAirlines"));
		String source = request.getParameter("ddlSource");
		String dest = request.getParameter("ddlDest");
		float price = Float.parseFloat(request.getParameter("txtPrice"));
		int seats = Integer.parseInt(request.getParameter("txtSeat"));
		
		Flights  fly = new Flights();
		fly.setFid(fid);
		fly.setFname(fname);
		fly.setAircode(aircode);
		fly.setSource(source);
		fly.setDestination(dest);
		fly.setTktprice(price);
		fly.setSeats(seats);
		
		FlightsDAO flyDao = new FlightsDAO();
		flyDao.AddFlights(fly);
		
		response.sendRedirect("Flights.jsp");
	}

}
