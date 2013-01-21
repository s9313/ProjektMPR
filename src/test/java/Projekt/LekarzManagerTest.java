package Projekt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


import szpital.encje.pacjenci.Pacjent;
import szpital.encje.personel.Kardiolog;
import szpital.encje.personel.Lekarz;
import szpital.encje.wizyty.Wizyta;
import szpital.management.LekarzManager;
import szpital.management.ManagerInterface;
import szpital.management.PacjentManager;
import szpital.management.WizytaManager;

public class LekarzManagerTest {
	
	private LekarzManager kk;

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
		
		lekarzManager.save(kardiolog);
		
		List<Lekarz> lekarze = lekarzManager.getAll();
		Lekarz personRetrieved = lekarze.get(lekarze.size()-1);
		
		assertEquals(IMIE_1, personRetrieved.getImie());
		assertEquals(NAZWISKO_1, personRetrieved.getNazwisko());
		assertEquals(SPECJALIZACJA_1, personRetrieved.getSpecjalizacja());		
	}
	
	@Test
	public void checkDeleting(){
		ManagerInterface<Lekarz> lekarz = new LekarzManager();
		Lekarz del = new Kardiolog("Jerzy");
//		boolean deleted = lekarz.delete(del);
//			
//		assertFalse("nie skasowano",deleted);
	}
	
	@Test
	public void testGetAll() {
		LekarzManager lekarz2 = new LekarzManager();
		List<Lekarz> results = lekarz2.getAll();
		
		assertNotNull("Lista jest nullem", results);
	}
	
	@Test
	public void testGet() {
		ManagerInterface<Lekarz> lekarz = new LekarzManager();
		Lekarz result = lekarz.get(1);

		assertNotNull("brak wyników",result);
		
	}

}
