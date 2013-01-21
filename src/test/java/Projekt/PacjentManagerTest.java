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

public class PacjentManagerTest {

	PacjentManager pacjentManager = new PacjentManager();
	
	private final static String IMIE_1 = "Janek";
	private final static String NAZWISKO_1 = "Kozak";
	private final static String TELEFON_1 = "54645454654";
	private final static String ADRES_1 = "ciekawa33";
	
	
	@Test
	public void checkConnection(){
		assertNotNull(pacjentManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Pacjent pacjent = new Pacjent(IMIE_1, NAZWISKO_1, ADRES_1, TELEFON_1);
		
		pacjentManager.save(pacjent);
		
		List<Pacjent> pacjenci = pacjentManager.getAll();
		Pacjent personRetrieved = pacjenci.get(pacjenci.size()-1);
		
		assertEquals(IMIE_1, personRetrieved.getImie());
		assertEquals(NAZWISKO_1, personRetrieved.getNazwisko());
		assertEquals(TELEFON_1, personRetrieved.getTelefon());
		assertEquals(ADRES_1, personRetrieved.getAdres());
	}
	
	@Test
	public void checkDeleting(){
		PacjentManager pacjent = new PacjentManager();
		Pacjent pac1 = new Pacjent("Kozak");
		boolean deleted = pacjent.delete(pac1);		
		
		assertFalse("nie skasowano",deleted);
	}
	
	@Test
	public void testGetAll() {
		PacjentManager pacjent = new PacjentManager();
		List<Pacjent> results = pacjent.getAll();
		
		assertNotNull("Lista jest nullem", results);
	}
	
	@Test
	public void testGet() {
		ManagerInterface<Pacjent> pacjent = new PacjentManager();
		Pacjent result = pacjent.get(1);

		assertNotNull("brak wyników",result);
		
	}
	
	
}
