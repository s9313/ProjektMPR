package szpital.temp;

import java.util.ArrayList;
import java.util.List;

import szpital.encje.pacjenci.Pacjent;
import szpital.encje.personel.Lekarz;
import szpital.encje.wizyty.Wizyta;

public class DatabaseContext {

	private static List<Lekarz> lekarze = new ArrayList<Lekarz>();
	private static List<Pacjent> pacjenci = new ArrayList<Pacjent>();
	private static List<Wizyta> wizyty = new ArrayList<Wizyta>();
	
	public static List<Lekarz> getLekarze() {
		return lekarze;
	}
	public static List<Pacjent> getPacjenci() {
		return pacjenci;
	}
	public static List<Wizyta> getWizyty() {
		return wizyty;
	}
	
	
}
