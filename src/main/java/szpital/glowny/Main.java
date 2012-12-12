package szpital.glowny;

import java.util.List;

import szpital.baza.ManagerInterface;
import szpital.encje.personel.Lekarz;
import szpital.management.*;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ManagerInterface<Lekarz> lekarz = new PostgresPersonManager();
		List<Lekarz> lekarze = lekarz.getAll();
		

	}

}
