package szpital.encje.personel;

public class Chirurg extends Lekarz {

	@Override
	void postawienieDiagnozy() {
		System.out.println("postawienie diagnozy przez lekarza Chirurga");
		
	}

	@Override
	void wypisanieSwiadczenia() {
		System.out.println("Wypisanie swiadczenia przez lekarza Chirurga");
		
	}



}
