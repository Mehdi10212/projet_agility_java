package main.java;

public class City {
    private String nameCity;
	private Sport sport;

    
    public City(String nameCity){
    	if(nameCity==null) throw new IllegalArgumentException("Name not valid !");
    	this.setName(nameCity);
    }
    
    public City(String nameCity, Sport sport){
        this.setName(nameCity);
        this.setSport(sport);
    }

	public String getName() {
		return nameCity;
	}

	public void setName(String name) {
		this.nameCity = name;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}    
    
}
