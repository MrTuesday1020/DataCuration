package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xmlReader.ParsingResults;
import xmlReader.Row;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParsingResults parsingResults = new ParsingResults();
		List<Row> rowList = parsingResults.returnRowList();
		Collections.shuffle(rowList);
		List<Row> results = new ArrayList<>(); 
		
		String numberOfresults = request.getParameter("numberOfresults");
		
		int n;
		if( numberOfresults == null || numberOfresults.equals("")) {
			n = 10;
		}
		else {
			n = Integer.parseInt(numberOfresults);
		}
		
		//get random n elements
		for(int i=0;i<n;i++) {
			Row result = rowList.get(i);
			results.add(result);
		}
		
		request.setAttribute("results", results);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
}
