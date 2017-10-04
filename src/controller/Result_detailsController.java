package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xmlReader.ParsingResults;
import xmlReader.Row;


@WebServlet("/Result_detailsController")
public class Result_detailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParsingResults parsingResults = new ParsingResults();
		List<Row> rowLists = parsingResults.returnRowList();
		int index = Integer.parseInt(request.getParameter("index"));
		Row result = rowLists.get(index);
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("result_details.jsp").forward(request, response);
	}

}
