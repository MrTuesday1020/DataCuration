package xmlReader;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
	
    //List to hold Rows object
    private List<Row> rowList = null;
    private Row row = null;


    //getter method for Row list
    public List<Row> getRowList() {
        return rowList;
    }

	StringBuilder agency;
	StringBuilder headline;
	StringBuilder date;
	StringBuilder city;
	StringBuilder content;
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("row")) {
			String id = attributes.getValue("_id");
			row = new Row();
			row.setId(id);
			
			//initialize list
			if (rowList == null)
				rowList = new ArrayList<>();

		} else if (qName.equalsIgnoreCase("agency")) {
			agency = new StringBuilder();
		} else if (qName.equalsIgnoreCase("headline")) {
			headline = new StringBuilder();
		} else if (qName.equalsIgnoreCase("publish_date")) {
			date = new StringBuilder();
		} else if (qName.equalsIgnoreCase("city")) {
			city = new StringBuilder();
		} else if (qName.equalsIgnoreCase("content")) {
			content = new StringBuilder();
		}
	}
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (agency != null) {
			agency.append(new String(ch, start, length));
		} else if (headline != null) {
			headline.append(new String(ch, start, length));
		} else if (date != null) {
			date.append(new String(ch, start, length));
		} else if (city != null) {
			city.append(new String(ch, start, length));
		} else if (content != null) {
			content.append(new String(ch, start, length));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Row")) {
            //add row object to list
        		int index = rowList.size();
        		row.setIndex(index);
        		rowList.add(row);
        }
        if (qName.equalsIgnoreCase("agency")) {
        		row.setAgency(agency.toString());
            agency = null;
        }
        if (qName.equalsIgnoreCase("headline")) {
        		row.setHeadline(headline.toString());
            headline = null;
        }
        if (qName.equalsIgnoreCase("publish_date")) {
        		String[] parts = date.toString().split("T");
        		row.setDate(parts[0]);
            date = null;
        }
        if (qName.equalsIgnoreCase("city")) {
        		row.setCity(city.toString());
            city = null;
        }
        if (qName.equalsIgnoreCase("content")) {
        		row.setContent(content.toString());
            content = null;
        }
    }
}
