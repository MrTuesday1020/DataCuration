package xmlReader;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import unsw.curation.api.extractnamedentity.ExtractEntitySentence;
import unsw.curation.api.tokenization.ExtractionKeywordImpl;

public class AdvancedSearch {
	public List<Row> advancedSearch(String ragency, String rheadline, String rdate, String rcity, String rcontent,
			String rselection, int IntfirstIndex, int IntlastIndex, String type) {
		ParsingResults parsingResults = new ParsingResults();
		List<Row> rowList = parsingResults.returnRowList();

		List<Row> results = new ArrayList<>();
		ExtractionKeywordImpl ek = new ExtractionKeywordImpl();
		ExtractEntitySentence ees = new ExtractEntitySentence();
		
		
		if (type.equals("prev")) {
			for (int index = IntfirstIndex - 1; index > -1; index--) {
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
				boolean bbcontent = false;

				if (agency != null) {
					bagency = agency.toLowerCase().contains(ragency.toLowerCase());
					if (!bagency)
						continue;
				}
				if (headline != null) {
					bheadline = headline.toLowerCase().contains(rheadline.toLowerCase());
					if (!bheadline)
						continue;
				}
				if (date != null) {
					bdate = date.toLowerCase().contains(rdate.toLowerCase());
					if (!bdate)
						continue;
				}
				if (city != null) {
					bcity = city.toLowerCase().contains(rcity.toLowerCase());
					if (!bcity)
						continue;
				}
				if (content == null) {
					if(rcontent != "")
						bcontent = false;
					else
						bcontent = true;
				}
				if (content != null) {
					bbcontent = content.toLowerCase().contains(rcity.toLowerCase());
					if (rcontent != "") {
						if (bbcontent)
							if (rselection.equals("keyword")) {
								System.out.println("Searching keyword " + rcontent);
								String keywords = null;
								try {
									keywords = ek.ExtractSentenceKeyword(content, new File(
											"/Users/mrtuesday/Documents/eclipse_workspace/dataDuration/WebContent/WEB-INF/stopwordlist.txt"));
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								if (keywords != "")
									bcontent = keywords.toLowerCase().contains(rcontent.toLowerCase());
							} else if (rselection.equals("people")) {
								System.out.println("Searching people " + rcontent);
								List<String> people = null;
								try {
									people = ees.ExtractPerson(content);
								} catch (URISyntaxException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								for (String s : people) {
									if (s != "")
										bcontent = s.toLowerCase().contains(rcontent.toLowerCase());
									if(bcontent)
										break;
								}
							} else if (rselection.equals("organization")) {
								System.out.println("Searching organization " + rcontent);
								List<String> organizations = null;
								try {
									organizations = ees.ExtractOrganization(content);
								} catch (URISyntaxException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								for (String s : organizations) {
									if (s != "")
										bcontent = s.toLowerCase().contains(rcontent.toLowerCase());
									if(bcontent)
										break;
								}
							} else if (rselection.equals("location")) {
								System.out.println("Searching location " + rcontent);
								List<String> locations = null;
								try {
									locations = ees.ExtractCity(content);
								} catch (URISyntaxException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								for (String s : locations) {
									if (s != "")
										bcontent = s.toLowerCase().contains(rcontent.toLowerCase());
									if(bcontent)
										break;
								}
							} else {
								bcontent = false;
							}
					} else {
						bcontent = true;
					}
				}

				if (bagency && bheadline && bdate && bcity && bcontent) {
					results.add(row);
					System.out.println((results.size()+1) + " results!");
					if(results.size() == 10) {
						break;
					}
				}
				Collections.reverse(results);
			}
		} else {
			for (int index = IntlastIndex + 1; index < rowList.size(); index++) {
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
				boolean bbcontent = false;

				if (agency != null) {
					bagency = agency.toLowerCase().contains(ragency.toLowerCase());
					if (!bagency)
						continue;
				}
				if (headline != null) {
					bheadline = headline.toLowerCase().contains(rheadline.toLowerCase());
					if(bheadline)
					if (!bheadline)
						continue;
				}
				if (date != null) {
					bdate = date.toLowerCase().contains(rdate.toLowerCase());
					if (!bdate)
						continue;
				}
				if (city != null) {
					bcity = city.toLowerCase().contains(rcity.toLowerCase());
					if (!bcity)
						continue;
				}
				if (content == null) {
					if(rcontent != "")
						bcontent = false;
					else
						bcontent = true;
				}
				if (content != null) {
					bbcontent = content.toLowerCase().contains(rcity.toLowerCase());
					if (rcontent != "") {
						if (bbcontent)
							if (rselection.equals("keyword")) {
								System.out.println("Searching keyword " + rcontent);
								String keywords = null;
								try {
									keywords = ek.ExtractSentenceKeyword(content, new File(
											"/Users/mrtuesday/Documents/eclipse_workspace/ass1/WebContent/WEB-INF/stopwordlist.txt"));
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								if (keywords != "")
									bcontent = keywords.toLowerCase().contains(rcontent.toLowerCase());
							} else if (rselection.equals("people")) {
								System.out.println("Searching people " + rcontent);
								List<String> people = null;
								try {
									people = ees.ExtractPerson(content);
								} catch (URISyntaxException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								for (String s : people) {
									if (s != "")
										bcontent = s.toLowerCase().contains(rcontent.toLowerCase());
									if(bcontent)
										break;
								}
							} else if (rselection.equals("organization")) {
								System.out.println("Searching organization " + rcontent);
								List<String> organizations = null;
								try {
									organizations = ees.ExtractOrganization(content);
								} catch (URISyntaxException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								for (String s : organizations) {
									if (s != "")
										bcontent = s.toLowerCase().contains(rcontent.toLowerCase());
									if(bcontent)
										break;
								}
							} else if (rselection.equals("location")) {
								System.out.println("Searching location " + rcontent);
								List<String> locations = null;
								try {
									locations = ees.ExtractLocation(content);
								} catch (URISyntaxException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								for (String s : locations) {
									if (s != "")
										bcontent = s.toLowerCase().contains(rcontent.toLowerCase());
									if(bcontent)
										break;
								}
							} else {
								bcontent = false;
							}
					} else {
						bcontent = true;
					}
				}

				if (bagency && bheadline && bdate && bcity && bcontent) {
					System.out.println((results.size()+1)+ " results!");
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
