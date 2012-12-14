package szpital.glowny;

import java.util.List;

import szpital.encje.personel.Chirurg;
import szpital.encje.personel.Kardiolog;
import szpital.encje.personel.Lekarz;
import szpital.encje.personel.Neurolog;
import szpital.management.*;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ManagerInterface<Lekarz> lekarz = new LekarzManager();
		
//		lekarz.save(new Kardiolog("Adam","Nowak","Kardiolog"));
//		lekarz.save(new Kardiolog("Kim","Dzong Il","Kardiolog"));		
//		lekarz.save(new Neurolog("Janusz", "Juras", "Neurolog"));		
//		lekarz.save(new Chirurg("Kamil", "siema", "Chrirug"));
		
//		Lekarz lek =new Kardiolog("Nowak");
//		lekarz.delete(lek);
		
//		Lekarz lek1 = new Neurolog("Juras");
//		lekarz.delete(lek1);

//		Lekarz lek2 = new Chirurg("siema");
//		lekarz.delete(lek2);
		
		System.out.println("Osoba o id 1:"+lekarz.get(1).getImie());
	
//		for(Lekarz l: lekarz.getAll()){
//			System.out.println(l.getImie());
//		}
		
	}

}
