//DIAGRAM ENCJI http://i.imgur.com/ZwLAW.png

package szpital.encje.personel;

public abstract class Lekarz {
	protected long id;
	protected String imie;
	protected String nazwisko;
	
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
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
}
