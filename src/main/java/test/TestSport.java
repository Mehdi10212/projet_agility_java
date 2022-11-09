package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.Sport;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class TestSport
{
    protected double fValeur1;
    protected double fValeur2;

    public TestSport(){
    }

    @BeforeEach
    public void setUp(){ // throws java.lang.Exception
        fValeur1= 2.0;
        fValeur2= 3.0;
    }


    @AfterEach
    public void tearDown(){ // throws java.lang.Exception
    }
    
    @Test
    public void testSport1(){
        Sport s = new Sport("Foot");
        assertEquals(s.getNameSport(), "Foot");
    }
    

}
