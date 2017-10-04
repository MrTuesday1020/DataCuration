package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xmlReader.Row;
import xmlReader.BasicSearch;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/BasicSearchController")
public class BasicSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String firstIndex = request.getParameter("firstIndex");
		String lastIndex = request.getParameter("lastIndex");
		String type = request.getParameter("type");
		BasicSearch basicSearch = new BasicSearch();
		
		int IntfirstIndex = 0;
		int IntlastIndex = 0;
		if( lastIndex==null && firstIndex==null) {
			IntfirstIndex = 0;
			IntlastIndex = 0;
		}
		else {
			IntfirstIndex = Integer.parseInt(firstIndex);
			IntlastIndex = Integer.parseInt(lastIndex);
		}
		if(type == null)
			type = "next";
		
		if( type.equals("prev") && IntfirstIndex == 0 && IntlastIndex == 0) {
			type = "next";
		}
		
		List<Row> rows = basicSearch.basicsearch(keyword,IntfirstIndex,IntlastIndex,type);
		
		
		request.setAttribute("keyword", keyword);
		if(rows.size()!=0) {
			request.setAttribute("firstIndex", rows.get(0).getIndex());
			request.setAttribute("lastIndex", rows.get(rows.size()-1).getIndex());
		}
		else {
			request.setAttribute("firstIndex", 0);
			request.setAttribute("lastIndex", 0);
		}
		request.setAttribute("results", rows);
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
