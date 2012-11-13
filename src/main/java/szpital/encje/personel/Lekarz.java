//DIAGRAM ENCJI http://i.imgur.com/ZwLAW.png

package szpital.encje.personel;

public abstract class Lekarz {
	private long id;
	private String imie;
	private String nazwisko;
	
	void lecz(){
		przyjeciePacjeta();
		zbadaniePacjeta();
		postawienieDiagnozy();
		wypisanieSwiadczenia();		
	}

	void przyjeciePacjeta(){
		System.out.println("Przyjecie pacjeta przez lekarza");
	}
	
	void zbadaniePacjeta(){
		System.out.println("Zbadanie pacjenta przez lekarza");
	}
	
	abstract void postawienieDiagnozy();
	
	abstract void wypisanieSwiadczenia();
	
}
