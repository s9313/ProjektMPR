package szpital.encje.wizyty;

import java.util.Date;

import szpital.encje.pacjenci.Pacjent;
import szpital.encje.personel.Lekarz;

public class Wizyta {
	
	private long id;
	private String data_zabiegu;
	private String godzina;
	private int id_pacjenta;
	private int id_lekarza;
	
	public Wizyta(String data_zabiegu, String godzina, int id_pacjenta, int id_lekarza) {
		this.data_zabiegu = data_zabiegu;
		this.godzina = godzina;
		this.id_pacjenta = id_pacjenta;
		this.id_lekarza = id_lekarza;
	}
	
	public Wizyta(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getData_zabiegu() {
		return data_zabiegu;
	}
	public void setData_zabiegu(String data_zabiegu) {
		this.data_zabiegu = data_zabiegu;
	}
	public String getGodzina() {
		return godzina;
	}
	public void setGodzina(String godzina) {
		this.godzina = godzina;
	}
	public int getId_pacjenta() {
		return id_pacjenta;
	}
	public void setId_pacjenta(int id_pacjenta) {
		this.id_pacjenta = id_pacjenta;
	}
	public int getId_lekarza() {
		return id_lekarza;
	}
	public void setId_lekarza(int id_lekarza) {
		this.id_lekarza = id_lekarza;
	}
	
}
	
	