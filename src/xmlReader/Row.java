package xmlReader;

import java.util.List;

public class Row {
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	private int index;
	private String id;
    private String agency;
    private String date;
    private String headline;
    private String city;
    private String content;
    private String keyword;
    private List<String> people;
    private List<String> organization;
    public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<String> getPeople() {
		return people;
	}
	public void setPeople(List<String> people) {
		this.people = people;
	}
	public List<String> getOrganization() {
		return organization;
	}
	public void setOrganization(List<String> organization) {
		this.organization = organization;
	}
	public List<String> getLocation() {
		return location;
	}
	public void setLocation(List<String> location) {
		this.location = location;
	}
	private List<String> location;
}
