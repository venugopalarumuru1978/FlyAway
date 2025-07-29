package com.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookingsDAO;
import com.DAO.FlightsDAO;
import com.models.Flights;

/**
 * Servlet implementation class Bookings
 */
public class Bookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fid = request.getParameter("fid");
		HttpSession session = request.getSession();
		
		 LocalDate cDate = LocalDate.now(); // Create a date object
		 System.out.println(cDate); // Display the current date
		
		FlightsDAO  fDao = new FlightsDAO();
		Flights flight = fDao.SearchFlightsBasedOnID(fid);
		
		BookingsDAO  bDao = new BookingsDAO();
		com.models.Bookings bkinfo = new com.models.Bookings();
		bkinfo.setCid((int)session.getAttribute("cid"));
		bkinfo.setAirname(flight.getFname());
		bkinfo.setSource(flight.getSource());
		bkinfo.setDest(flight.getDestination());
		bkinfo.setAmt(flight.getTktprice());
		bkinfo.setBkDate(cDate.toString());
		
		bDao.AddBookings(bkinfo);
		
		response.sendRedirect("Bookings.jsp");
	}
}
