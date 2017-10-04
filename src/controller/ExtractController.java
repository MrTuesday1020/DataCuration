package controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unsw.curation.api.extractnamedentity.ExtractEntitySentence;
import unsw.curation.api.tokenization.ExtractionKeywordImpl;
import xmlReader.ParsingResults;
import xmlReader.Row;

@WebServlet("/ExtractController")
public class ExtractController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String index = request.getParameter("index");
		ParsingResults parsingResults = new ParsingResults();
		List<Row> rowList = parsingResults.returnRowList();

		ExtractionKeywordImpl ek = new ExtractionKeywordImpl();
		ExtractEntitySentence ees = new ExtractEntitySentence();
		String content = rowList.get(Integer.parseInt(index)).getContent();

		List<String> results = null;
		if (content != null) {
			if (type.equals("people")) {
				try {
					results = ees.ExtractPerson(content);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (type.equals("organization")) {
				try {
					results = ees.ExtractOrganization(content);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (type.equals("location")) {
				try {
					results = ees.ExtractLocation(content);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (type.equals("keyword")) {
				String kw = null;
				try {
					kw = ek.ExtractSentenceKeyword(content, new File(
							"/Users/mrtuesday/Documents/eclipse_workspace/dataDuration/WebContent/WEB-INF/stopwordlist.txt"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				results = Arrays.asList(kw.split(","));
			}
		}

		request.setAttribute("results", results);
		request.getRequestDispatcher("extract.jsp").forward(request, response);
	}

}
