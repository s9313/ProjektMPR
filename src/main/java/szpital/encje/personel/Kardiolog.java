package szpital.encje.personel;

public class Kardiolog extends Lekarz {
	
	public Kardiolog(String imie, String nazwisko, String specjalizacja) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.specjalizacja = specjalizacja;
	}

	public Kardiolog(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public Kardiolog()
	{
		this("");
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
