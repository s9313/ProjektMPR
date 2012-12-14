package szpital.encje.personel;

public class Chirurg extends Lekarz {

	public Chirurg(String imie, String nazwisko, String specjalizacja) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.specjalizacja = specjalizacja;
	}

	public Chirurg(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public Chirurg()
	{
		this("");
	}
	
	@Override
	void postawienieDiagnozy() {
		System.out.println("postawienie diagnozy przez lekarza Chirurga");
		
	}

	@Override
	void wypisanieSwiadczenia() {
		System.out.println("Wypisanie swiadczenia przez lekarza Chirurga");
		
	}



}
