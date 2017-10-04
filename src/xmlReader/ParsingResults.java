package xmlReader;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParsingResults {
	public List<Row> returnRowList() {
		List<Row> rowList = null;
		try {
		     SAXParserFactory factory = SAXParserFactory.newInstance();
		     SAXParser saxParser = factory.newSAXParser();
		     XMLHandler userhandler = new XMLHandler();
		     //saxParser.parse("./WebContent/WEB-INF/rows.xml", userhandler);
		     saxParser.parse("/Users/mrtuesday/Documents/eclipse_workspace/dataDuration/WebContent/WEB-INF/rows.xml", userhandler);
			 rowList = userhandler.getRowList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowList;
	}
}
