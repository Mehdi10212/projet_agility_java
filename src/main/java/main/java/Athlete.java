package main.java;

public class Athlete {
	private String nameAthlete;
	private Sport sportPracticed;
	private boolean praticeSport = false;
	
	public Athlete(String nameAthlete, Sport sport){
    	//if(sport==null) throw new IllegalArgumentException("sport is null, that's not valid !");
		this.setNameAthlete(nameAthlete);
		if(sport != null) {
			this.sportPracticed = sport;
			this.sportPracticed.addAthlete(this);
		}
	}

	public void unsubscribeSport(){
		if(this.sportPracticed == null)
			throw new IllegalArgumentException("This athlete does not already play any sport !");
		this.setPraticeSport(false);
		setSportPracticed(null);
	}
	
	public void subscribeSport(Sport sport){
		if(this.isPraticeSport() == true)
			throw new IllegalArgumentException("This athlete already play a sport !");
		this.setPraticeSport(true);
		setSportPracticed(sport);
	}
	
	public String getNameAthlete() {
		return nameAthlete;
	}

	public void setNameAthlete(String nameAthlete) {
		this.nameAthlete = nameAthlete;
	}

	public Sport getSportPracticed() {
		return sportPracticed;
	}

	public void setSportPracticed(Sport sportPracticed) {
		this.sportPracticed = sportPracticed;
	}

	public boolean isPraticeSport() {
		return praticeSport;
	}

	public void setPraticeSport(boolean praticeSport) {
		this.praticeSport = praticeSport;
	}
	

}
