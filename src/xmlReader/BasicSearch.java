package xmlReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicSearch {
	public List<Row> basicsearch(String keyword,int IntfirstIndex,int IntlastIndex,String type) {		
		ParsingResults parsingResults = new ParsingResults();
		List<Row> rowList = parsingResults.returnRowList();
		List<Row> results = new ArrayList<>();

		if(type.equals("prev"))
		{
			for (int index = IntfirstIndex-1; index > -1; index--) {
				Row row = rowList.get(index);
				String agency = row.getAgency();
				String headline = row.getHeadline();
				String date = row.getDate();
				String city = row.getCity();
				String content = row.getContent();
	
				boolean bagency = false;
				boolean bheadline = false;
				boolean bdate = false;
				boolean bcity = false;
				boolean bcontent = false;
	
				if (agency != null) {
					bagency = agency.toLowerCase().contains(keyword.toLowerCase());
				}
				if (headline != null) {
					bheadline = headline.toLowerCase().contains(keyword.toLowerCase());
				}
				if (date != null) {
					bdate = date.toLowerCase().contains(keyword.toLowerCase());
				}
				if (city != null) {
					bcity = city.toLowerCase().contains(keyword.toLowerCase());
				}
				if (content != null) {
					bcontent = content.toLowerCase().contains(keyword.toLowerCase());
				}
	
				if (bagency || bheadline || bdate || bcity || bcontent) {
					results.add(row);
					if(results.size() == 10) {
						break;
					}
				}
			}
			Collections.reverse(results);
		}
		else {
			for (int index = IntlastIndex+1; index < rowList.size(); index++) {
				Row row = rowList.get(index);
				String agency = row.getAgency();
				String headline = row.getHeadline();
				String date = row.getDate();
				String city = row.getCity();
				String content = row.getContent();
	
				boolean bagency = false;
				boolean bheadline = false;
				boolean bdate = false;
				boolean bcity = false;
				boolean bcontent = false;
	
				if (agency != null) {
					bagency = agency.toLowerCase().contains(keyword.toLowerCase());
				}
				if (headline != null) {
					bheadline = headline.toLowerCase().contains(keyword.toLowerCase());
				}
				if (date != null) {
					bdate = date.toLowerCase().contains(keyword.toLowerCase());
				}
				if (city != null) {
					bcity = city.toLowerCase().contains(keyword.toLowerCase());
				}
				if (content != null) {
					bcontent = content.toLowerCase().contains(keyword.toLowerCase());
				}
	
				if (bagency || bheadline || bdate || bcity || bcontent) {
					results.add(row);
					if(results.size() == 10) {
						break;
					}
				}
			}
		}
		
		return results;
	}
}
