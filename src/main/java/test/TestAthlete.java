package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Athlete;
import main.java.Sport;

class TestAthlete {

    protected Sport sport1;
    protected Sport sport2;
    protected Sport sport3;
    protected Sport sport4;
    protected Sport sport5;

    protected Athlete athlete1;
    protected Athlete athlete2;
    protected Athlete athlete3;
    protected Athlete athlete4;
    protected Athlete athlete5;
    protected Athlete athlete6;
    protected Athlete athlete7;
    protected Athlete athlete8;


    public TestAthlete(){
    }

    
    @BeforeEach
    public void setUp(){
    	sport1 = new Sport("Musculation");
    	sport2 = new Sport("Danse");
    	sport3 = new Sport("Natation");
        athlete1 = new Athlete("Yanis", sport2);
        athlete2 = new Athlete("Moha", sport3);
        
    	sport4 = new Sport("Golf");
    	athlete3 = new Athlete("Charles", sport4);
    	athlete4 = new Athlete("Frank", sport4);
    	athlete5 = new Athlete("Elon", sport4);
    	athlete6 = new Athlete("Rayan", sport4);
    	
    	sport5 = new Sport("Yoga");
    	athlete7 = new Athlete("Frank", sport4);
    	
    }
    
    
    @Test
    public void testAthlete1(){
    	assertEquals(athlete1.getNameAthlete(), "Yanis");
    	assertEquals(athlete1.getSportPracticed().getNameSport(), "Danse");
    	athlete1.setSportPracticed(sport1);
    	assertEquals(athlete1.getSportPracticed().getNameSport(), "Musculation");
    	assertEquals(athlete2.getNameAthlete(), "Moha");
    	assertEquals(athlete2.getSportPracticed().getNameSport(), "Natation");
    }
    
    
    @Test
    public void testAthleteSport(){    	
    	assertEquals(sport4.getNbAthletes(), 4);
    	assertEquals(sport4.getListAthletes(), "Charles Frank Elon Rayan ");
    }
    
    
    @Test
    public void testAthlete2(){
    	assertEquals(sport4.getNbAthletes(), 4);    	
    }
    
    
    @Test
    public void testAthleteInOneSport(){
    	assertEquals(sport4.getNameSport(), "Golf");
    	assertEquals(sport4.getNbAthletes(), 4);
    	assertEquals(athlete2.getNameAthlete(), "Moha");
    	assertEquals(athlete2.getSportPracticed().getNameSport(), "Natation");
    	assertEquals(sport4.getListAthletes(), "Charles Frank Elon Rayan ");
    	sport4.addAthlete(athlete2);
    	assertNotEquals(sport4.getNbAthletes(), 5);
    	assertEquals(sport4.getNbAthletes(), 4);
    	assertNotEquals(sport4.getListAthletes(), "Charles Frank Elon Rayan Moha ");
    	assertEquals(sport4.getListAthletes(), "Charles Frank Elon Rayan ");
    }
    
    
    @Test
    public void testChangeSportOfAthlete(){
    	athlete8 = new Athlete("Mehdi", sport4);
    	assertEquals(athlete8.getSportPracticed().getNameSport(), "Golf");  
    	athlete8.unsubscribeSport();
    	assertEquals(athlete8.getSportPracticed(), null);
    	athlete8.subscribeSport(sport5);
    	assertEquals(athlete8.getSportPracticed().getNameSport(), "Yoga");  
    }
    
}
