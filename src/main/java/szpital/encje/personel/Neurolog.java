package szpital.encje.personel;

public class Neurolog extends Lekarz {
	
	public Neurolog(String imie, String nazwisko, String specjalizacja) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.specjalizacja = specjalizacja;
	}

	public Neurolog(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public Neurolog()
	{
		this("");
	}
	@Override
	void postawienieDiagnozy() {
		System.out.println("postawienie diagnozy przez lekarza Neurologa");
		
	}

	@Override
	void wypisanieSwiadczenia() {
		System.out.println("Wypisanie swiadczenia przez lekarza Neurologa");
		
	}

}
