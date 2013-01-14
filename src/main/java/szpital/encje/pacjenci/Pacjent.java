package szpital.encje.pacjenci;

public class Pacjent {
	private long id;
	private String imie;
	private String nazwisko;
	private String telefon;
	private String adres;
	
	public Pacjent(String imie, String nazwisko, String adres, String telefon) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adres = adres;
		this.telefon = telefon;
	}
	
	public Pacjent(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
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
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacjent other = (Pacjent) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
