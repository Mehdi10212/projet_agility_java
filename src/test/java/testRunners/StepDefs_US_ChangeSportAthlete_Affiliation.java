package testRunners;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.Athlete;
import main.java.Sport;

public class StepDefs_US_ChangeSportAthlete_Affiliation {
	
	private Sport s1 = new Sport("Musculation");
	private Sport s2 = new Sport("MMA");
	private Sport s3 = new Sport("Karate");
	private Sport s4 = new Sport("Golf");
	private Sport s5 = new Sport("Natation");
	
	private Athlete a1 = new Athlete("Rafik", s1);
	private Athlete a2 = new Athlete("Aya", null);
	private Athlete a3 = new Athlete("Hugo", s2);
	private Athlete a4 = new Athlete("Louis", s2);
	private Athlete a5 = new Athlete("Astérix", s3);
	private Athlete a6 = new Athlete("Nino", s4);
	private Athlete a7 = new Athlete("Victor", s4);
	private Athlete a8 = new Athlete("Mohammed", null);
	private Athlete a9 = new Athlete("Charles", s5);
	private Athlete a10 = new Athlete("Malcolm", s5);
	private Athlete a11 = new Athlete("Christophe", s5);
	private Athlete a12 = new Athlete("Ryflan", null);

	
	@Given("Un athlète pratiquant un sport")
	public void un_athlète_pratiquant_un_sport() {
		Assert.assertTrue(a1 != null);
		Assert.assertTrue(a1.getSportPracticed() != null);
	}

	@When("Je supprime le sport actuel de l athlète")
	public void je_supprime_le_sport_actuel_de_l_athlète() {
		a1.unsubscribeSport();
		Assert.assertFalse(a1.isPraticeSport());
	}

	@Then("L athlète ne pratiquera plus de sport")
	public void l_athlète_ne_pratiquera_plus_de_sport() {
		Assert.assertTrue(a1.getSportPracticed() == null);
	}

	@Given("Un athlète <nom> ne pratiquant aucun null")
	public void un_athlète_nom_ne_pratiquant_aucun_null() {
		Assert.assertTrue(a2.getSportPracticed() == null);
	}

	@Then("Le système refuse avec le This athlete does not already play any sport !")
	public void le_système_refuse_avec_le_This_athlete_does_not_already_play_any_sport() {
	    String expectedMessage = "This athlete does not already play any sport !";
		
		try {
			a2.unsubscribeSport();
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains(expectedMessage));
		}		
	}

	@Given("Un sport MMA composé d une liste d athlètes pratiquant ce sport")
	public void un_sport_MMA_composé_d_une_liste_d_athlètes_pratiquant_ce_sport() {
		Assert.assertEquals(s2.getNameSport(), "MMA");
		Assert.assertEquals(s2.getNbAthletes(), 2);
	}

	@When("J associe un athlète Astérix à ce sport alors qu il pratique déjà un autre Karate")
	public void j_associe_un_athlète_Astérix_à_ce_sport_alors_qu_il_pratique_déjà_un_autre_Karate() {
		Assert.assertEquals(a5.getNameAthlete(), "Astérix");
		Assert.assertEquals(a5.getSportPracticed().getNameSport(), "Karate");
	}

	@Then("Le système refuse d ajouter l athlète à la liste du sport avec le message Athlete already associated with another sport	!")
	public void le_système_refuse_d_ajouter_l_athlète_à_la_liste_du_sport_avec_le_message_Athlete_already_associated_with_another_sport() {
	    String expectedMessage = "This athlete already play a sport !";
		
		try {
			a5.subscribeSport(s2);
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains(expectedMessage));
		}
	}

	@Given("Un sport Golf composé d une liste d athlètes pratiquant ce sport")
	public void un_sport_Golf_composé_d_une_liste_d_athlètes_pratiquant_ce_sport() {
		Assert.assertEquals(s4.getNameSport(), "Golf");
		Assert.assertEquals(s4.getNbAthletes(), 2);		
	}

	@When("J associe l athlète Mohammed au sport Golf")
	public void j_associe_l_athlète_Mohammed_au_sport_Golf() {
		Assert.assertTrue(a8.getSportPracticed() == null);
		a8.subscribeSport(s4);
		s4.addAthlete(a8);
		Assert.assertTrue(a8.isPraticeSport());
		Assert.assertEquals(a8.getSportPracticed().getNameSport(), "Golf");
	}

	@Then("L athlete s appelant Mohammed fait dorénavent partis de la liste d athletes du sport Golf")
	public void l_athlete_s_appelant_Mohammed_fait_dorénavent_partis_de_la_liste_d_athletes_du_sport_Golf() {
		Assert.assertTrue(s4.getListAthletes().contains(a8.getNameAthlete()));
	}


	@Given("Un sport Natation composé d une liste d athlètes pratiquant ce sport")
	public void un_sport_Natation_composé_d_une_liste_d_athlètes_pratiquant_ce_sport() {
		Assert.assertEquals(s5.getNameSport(), "Natation");
		Assert.assertEquals(s5.getNbAthletes(), 3);
	}

	@When("J associe l athlète Ryflan au sport Natation")
	public void j_associe_l_athlète_Ryflan_au_sport_Natation() {
		Assert.assertTrue(a12.getSportPracticed() == null);
		a12.subscribeSport(s5);
		s5.addAthlete(a12);
		Assert.assertTrue(a12.isPraticeSport());
		Assert.assertEquals(a12.getSportPracticed().getNameSport(), "Natation");
	}

	@Then("L athlete s appelant Ryflan fait dorénavent partis de la liste d athletes du sport Natation")
	public void l_athlete_s_appelant_Ryflan_fait_dorénavent_partis_de_la_liste_d_athletes_du_sport_Natation() {
		Assert.assertTrue(s5.getListAthletes().contains(a12.getNameAthlete()));
	}
	
}
