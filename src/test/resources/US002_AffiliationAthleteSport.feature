#Author: IBOUDA & OURAGHENE

@tag
Feature: USOO2 Affiliation d un athlète à un sport
  En tant qu utilisateur, je veux pouvoir associer un athlète à un sport 
  Afin de m assurer qu il pratique bien un seul et unique sport à la fois


  @tag1
  Scenario Outline: association à un sport d un athlète pratiquant déjà un autre sport
    Given Un sport <sport> composé d une liste d athlètes pratiquant ce sport
    When J associe un athlète <nom> à ce sport alors qu il pratique déjà un autre <sport1>
    Then Le système refuse d ajouter l athlète à la liste du sport avec le message <messageErreur>
    
    Examples: 
      |  sport	   |		  nom 		 |		sport1		|				ListAthletes	  	 |												messageErreur										|
      |	  MMA 	   |    Astérix    |		Karate		| 				Obélix					 |			Athlete already associated with another sport	!		|


  @tag2
  Scenario Outline: association à un sport d un athlète ne pratiquant actuellement aucun sport    
    Given Un sport <sport> composé d une liste d athlètes pratiquant ce sport
    When J associe l athlète <nom> au sport <sport> 
    Then L athlete s appelant <nom> fait dorénavent partis de la liste d athletes du sport <sport>

    Examples: 
      |	  sport 		 |		ListAthletes   |  		nom 		 |			ListAthletes	  	 |
      |  	Golf 		   |   		Charles			 |    Mohammed   | 		 Charles, Mohammed	 |
      |  Natation 	 |   		Firas 			 |    Ryflan	   | 	  	Firas, Ryflan		 	 |
