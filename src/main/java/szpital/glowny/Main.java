package szpital.glowny;

import java.util.List;

import szpital.encje.pacjenci.Pacjent;
import szpital.encje.personel.Chirurg;
import szpital.encje.personel.Kardiolog;
import szpital.encje.personel.Lekarz;
import szpital.encje.personel.Neurolog;
import szpital.encje.wizyty.Wizyta;
import szpital.management.*;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ManagerInterface<Lekarz> lekarz = new LekarzManager();
		ManagerInterface<Pacjent> pacjent = new PacjentManager();
		ManagerInterface<Wizyta> wizyta = new WizytaManager();
	
		
//		wizyta.save(new Wizyta("27-12-2013", "15:00", 1, 2));
		
//		Wizyta wiz1 = new Wizyta(2);
//		wizyta.delete(wiz1);
		
//		System.out.println("Wizyta o id 4: " + wizyta.get(1).getData_zabiegu());
		
//		for(Wizyta w: wizyta.getAll()){
//			System.out.println(w.getId());
//		}
		
		
			
//		pacjent.save(new Pacjent("Michal", "Popowicz", "dsfjksdjf", "564245353"));
//		pacjent.save(new Pacjent("Krzysiek", "Ibisz", "Warszawa", "343435435"));
//		
//		Pacjent pac1 = new Pacjent("Popowicz");
//		pacjent.delete(pac1);
		
//		System.out.println("Pacjent o id 1:"+pacjent.get(2).getImie());
		
//		for(Pacjent p: pacjent.getAll()){
//			System.out.println(p.getImie());
//		}	
		
		
		
//		lekarz.save(new Kardiolog("Adam","Nowak","Kardiolog"));
//		lekarz.save(new Kardiolog("Kim","Dzong Il","Kardiolog"));		
//     	lekarz.save(new Neurolog("Janusz", "Juras", "Neurolog"));		
//		lekarz.save(new Chirurg("Kamil", "siema", "Chirurg"));
		
//		Lekarz lek =new Kardiolog("Nowak");
//		lekarz.delete(lek);
		
//		Lekarz lekk =new Kardiolog("Dzong Il");
//		lekarz.delete(lekk);
		
//		Lekarz lek1 = new Neurolog("Juras");
//		lekarz.delete(lek1);

//		Lekarz lek2 = new Chirurg("siema");
//		lekarz.delete(lek2);
		
//		System.out.println("Osoba o id 1:"+lekarz.get(1).getImie());
	
//		for(Lekarz l: lekarz.getAll()){
//			System.out.println(l.getImie());
//		}
		
	}

}
