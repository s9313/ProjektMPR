package Projekt;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import szpital.encje.pacjenci.Pacjent;
import szpital.encje.wizyty.Wizyta;
import szpital.management.ManagerInterface;
import szpital.management.PacjentManager;
import szpital.management.WizytaManager;

public class WizytaManagerTest {

	private WizytaManager mgr;

	WizytaManager wizytaManager = new WizytaManager();
	
	private final static String DATA_1 = "27-12-2013";
	private final static String GODZINA_1 = "14:00";
	private final static int ID_PACJENTA_1 = 1;
	private final static int ID_LEKARZA_1 = 2;
	
	
	@Test
	public void checkConnection(){
		assertNotNull(wizytaManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Wizyta wizyta = new Wizyta(DATA_1, GODZINA_1, ID_PACJENTA_1, ID_LEKARZA_1);
		
		wizytaManager.save(wizyta);
		
		List<Wizyta> wizyty = wizytaManager.getAll();
		Wizyta personRetrieved = wizyty.get(wizyty.size()-1);
		
		assertEquals(DATA_1, personRetrieved.getData_zabiegu());
		assertEquals(GODZINA_1, personRetrieved.getGodzina());
		assertEquals(ID_PACJENTA_1, personRetrieved.getId_pacjenta());
		assertEquals(ID_LEKARZA_1, personRetrieved.getId_lekarza());
	}
	
	@Test
	public void checkDeleting(){
		WizytaManager wizyta = new WizytaManager();
		Wizyta wiz1 = new Wizyta(1);
		boolean deleted = wizyta.delete(wiz1);		
		
		assertFalse("nie skasowano",deleted);
	}
	
	@Test
	public void testGetAll() {
		WizytaManager wizyta = new WizytaManager();
		List<Wizyta> results = wizyta.getAll();
		
		assertNotNull("Lista jest nullem", results);
	}
	
	@Test
	public void testGet() {
		ManagerInterface<Wizyta> wizyta = new WizytaManager();
		Wizyta result = wizyta.get(3);

		assertNotNull("brak wyników",result);
		
	}
}
