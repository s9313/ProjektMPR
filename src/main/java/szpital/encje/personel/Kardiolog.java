package szpital.encje.personel;

public class Kardiolog extends Lekarz {
	
	public Kardiolog(String imie, String nazwisko) {
		this.imie = imie;
		this.nazwisko = nazwisko;
	}

	@Override
	void postawienieDiagnozy() {
		System.out.println("postawienie diagnozy przez lekarza Kardiologa");
		
	}

	@Override
	void wypisanieSwiadczenia() {
		System.out.println("Wypisanie swiadczenia przez lekarza Kardiologa");
		
	}

}
