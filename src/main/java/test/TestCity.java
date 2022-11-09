package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.City;
import main.java.Sport;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class TestCity {
    protected Sport sport1;
    protected City city1;


    public TestCity(){
    }

    @BeforeEach
    public void setUp(){ // throws java.lang.Exception
        sport1 = new Sport("Musculation");
        city1 = new City("Paris", sport1);
    }
    
    
    @Test
    public void testSportCity(){
        assertEquals(sport1.getNameSport(), "Musculation");
        assertEquals(city1.getName(), "Paris");
        assertEquals(city1.getSport().getNameSport(), "Musculation");
        sport1.setNameSport("MMA");
        assertNotEquals(city1.getSport().getNameSport(), "Musculation");
        assertEquals(city1.getSport().getNameSport(), "MMA");
    }
    
    
 
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {

    }
}