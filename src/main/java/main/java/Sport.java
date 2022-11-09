package main.java;
import java.util.List;
import java.util.ArrayList;

public class Sport { 
    private String nameSport;
    private City city;
    //private static List<String> sportsList = new ArrayList<String>(); //Liste des sports existants
    private List<Athlete> athletePracticingThisSport = new ArrayList<Athlete>();
    //private static Map<Athlete, Sport> athletePracticingThisSport = new LinkedHashMap<>();

     
    public Sport(String nameSport){
    	if(nameSport==null) throw new IllegalArgumentException("NameSport not valid !");
        this.nameSport = nameSport;
    }
    
    public Sport(String nameSport, String nameCity){
    	if(nameSport==null) throw new IllegalArgumentException("NameSport not valid !");
    	if(nameCity==null) throw new IllegalArgumentException("nameCity not valid !");
        this.nameSport = nameSport;
        this.setCity(new City(nameCity));
    }
    
    public Sport(String nameSport, City city){
    	if(nameSport==null) throw new IllegalArgumentException("NameSport not valid !");
    	if(city==null) throw new IllegalArgumentException("Object city not valid !");
        this.nameSport = nameSport;
        this.setCity(city);
    }
    
    public void addAthlete(Athlete athlete){
    	//if(!isAthleteAlreadyInSport(athlete.getNameAthlete()) && !athlete.isPraticeSport())
    	this.athletePracticingThisSport.add(athlete);
    	athlete.setPraticeSport(true);
    }
    
    public boolean isAthleteAlreadyInSport(String nameA){
    	for(Athlete a : athletePracticingThisSport){
    		if(a.getNameAthlete() == nameA)
    			return true;
    	}
		return false;    		    	
    }
    
    public String getListAthletes(){
        StringBuilder sp = new StringBuilder();
        extractedForListAthletes(sp);
        return sp.toString();
    }

	private void extractedForListAthletes(StringBuilder sp) {
		for (Athlete a : athletePracticingThisSport) {
        	if(athletePracticingThisSport.size() > 1)
        		sp.append(a.getNameAthlete() + " ");
        	else
        		sp.append(a.getNameAthlete());
        }
	}
    
    
    public int getNbAthletes(){
        return this.athletePracticingThisSport.size();
    }
    
    public String getNameSport(){
    	return this.nameSport;
    }
    
    public void setNameSport(String name){
    	 this.nameSport = name;
    }

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
    
}
