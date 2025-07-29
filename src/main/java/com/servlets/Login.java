package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MemberDAO;
import com.models.Members;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String uname = request.getParameter("txtUsername");
			String pswd = request.getParameter("txtPswd");
			
			if(uname.equals("Administrator") && pswd.equals("admin@123"))
			{
				response.sendRedirect("Flights.jsp");
			}
			else
			{
				MemberDAO  mDaoObj = new MemberDAO();
				Members member = mDaoObj.UserCheck(uname, pswd);
				if(member!=null)
				{
					HttpSession session = request.getSession();
					session.setAttribute("cid", member.getCusid());
					System.out.println(member.getCusname());
					session.setAttribute("cname", member.getCusname());
					response.sendRedirect("MemberHome.jsp");
				}
				else
				{
					response.sendRedirect("Error.jsp");
				}
			}
	}

}
