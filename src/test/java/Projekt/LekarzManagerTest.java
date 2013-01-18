package Projekt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


import szpital.encje.personel.Kardiolog;
import szpital.encje.personel.Lekarz;
import szpital.management.LekarzManager;

public class LekarzManagerTest {

	LekarzManager lekarzManager = new LekarzManager();
	
	private final static String IMIE_1 = "Zenek";
	private final static String NAZWISKO_1 = "Owsiak";
	private final static String SPECJALIZACJA_1 = "Kardiolog";
	
	
	@Test
	public void checkConnection(){
		assertNotNull(lekarzManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Kardiolog kardiolog = new Kardiolog(IMIE_1, NAZWISKO_1, SPECJALIZACJA_1);
		
//		lekarzManager.clearPersons();
		lekarzManager.save(kardiolog);
		
		List<Lekarz> lekarze = lekarzManager.getAll();
		Lekarz personRetrieved = lekarze.get(lekarze.size()-1);
		
		assertEquals(IMIE_1, personRetrieved.getImie());
		assertEquals(NAZWISKO_1, personRetrieved.getNazwisko());
		assertEquals(SPECJALIZACJA_1, personRetrieved.getSpecjalizacja());		
	}

}
