package szpital.glowny;

import szpital.baza.ManagerInterface;
import szpital.encje.personel.Lekarz;
import szpital.management.*;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ManagerInterface<Lekarz> mgr = new PostgresPersonManager();

	}

}
