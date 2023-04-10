package com.study;

import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. request param
		
		//2. business logic
		HttpSession session = request.getSession();
		Object o = session.getAttribute("db");
		
		if(o == null) {
			o = new ArrayList<String>();
			session.setAttribute("db", o);
		}
		//의미있게 안봐도 된다
		
		//3. add attribute
//		request.setAttribute("list", o);
		
		//잘 동작하는지 보기위한 코드
		request.setAttribute("list", List.of("태웅", "백호", "대만", "태섭"));
		
		//4. forward / redirect
		String view = "/WEB-INF/views/list.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
