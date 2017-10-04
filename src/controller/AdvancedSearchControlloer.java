package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xmlReader.AdvancedSearch;
import xmlReader.Row;

/**
 * Servlet implementation class AdvancedSearchControlloer
 */
@WebServlet("/AdvancedSearchControlloer")
public class AdvancedSearchControlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agency = request.getParameter("agency");
		String headline = request.getParameter("headline");
		String date = request.getParameter("date");
		String city = request.getParameter("city");
		String content = request.getParameter("content");
		String selection = request.getParameter("selection");
		
		if(agency == null)
			agency = "";
		if(headline == null)
			headline = "";
		if(date == null)
			date = "";
		if(city == null)
			city = "";
		if(content == null)
			content = "";
		
		String firstIndex = request.getParameter("firstIndex");
		String lastIndex = request.getParameter("lastIndex");
		String type = request.getParameter("type");
		
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
		
		
		AdvancedSearch advancedSearch = new AdvancedSearch();
		List<Row> rows = advancedSearch.advancedSearch(agency, headline, date, city, content, selection,IntfirstIndex,IntlastIndex,type);
		
		
		if(agency.equals(""))
			agency = null;
		if(headline.equals(""))
			headline = null;
		if(date.equals(""))
			date = null;
		if(city.equals(""))
			city = null;
		if(content.equals(""))
			content = null;
		
		request.setAttribute("agency", agency);
		request.setAttribute("headline", headline);
		request.setAttribute("date", date);
		request.setAttribute("city", city);
		request.setAttribute("content", content);
		request.setAttribute("selection", selection);
		if(rows.size()!=0) {
			request.setAttribute("firstIndex", rows.get(0).getIndex());
			request.setAttribute("lastIndex", rows.get(rows.size()-1).getIndex());
		}
		else {
			request.setAttribute("firstIndex", 0);
			request.setAttribute("lastIndex", 0);
		}
		request.setAttribute("results", rows);
		request.getRequestDispatcher("advresults.jsp").forward(request, response);
	}

}
