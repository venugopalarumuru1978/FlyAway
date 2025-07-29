package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MemberDAO;
import com.models.Members;

/**
 * Servlet implementation class AddMember
 */
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname = request.getParameter("txtCname");
		String phone = request.getParameter("txtPhone");
		String email = request.getParameter("txtEmail");
		String pwd = request.getParameter("txtPswd");
		String loc = request.getParameter("txtLoc");
		
		Members  member = new Members();
		member.setCusname(cname);
		member.setPhone(phone);
		member.setEmail(email);
		member.setPswd(pwd);
		member.setLocation(loc);
		
		MemberDAO mDao = new MemberDAO();
		mDao.AddMember(member);
		
		response.sendRedirect("Members.jsp");		
	}
}
