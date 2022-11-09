#Author: IBOUDA & OURAGHENE

@tag
Feature: USOO1 Changement du sport d athlète
  En tant qu utilisateur, je veux supprimer le sport actuel auquel est associé un athlète
  Afin de pouvoir mettre à jour le sport pratiquer par l athlète

  @tag1
  Scenario: suppression du sport déjà affilié à un athlète
    Given Un athlète pratiquant un sport
    When Je supprime le sport actuel de l athlète
    Then L athlète ne pratiquera plus de sport


  @tag2
  Scenario Outline: suppression du sport à un athlète qui ne pratique déjà plus de sport
    Given Un athlète <nom> ne pratiquant aucun <sport>
    When Je supprime le sport actuel de l athlète
    Then Le système refuse avec le <messageErreur>
    
    Examples: 
      | name  | 		sport   |  sport  |										messageErreur										|
      | Yanis |    	null 		|   null  |		This athlete does not already play any sport !  |
