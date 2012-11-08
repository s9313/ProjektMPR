package szpital.encje.wizyty;

import java.util.Date;

import szpital.encje.pacjenci.Pacjent;
import szpital.encje.personel.Lekarz;

public class Wizyta {
	
	private Date dataWizyty;
	private Pacjent pacjent;
	private Lekarz lekarz;

	public Date getDataWizyty() {
		return dataWizyty;
	}

	public void setDataWizyty(Date dataWizyty) {
		this.dataWizyty = dataWizyty;
	}
	
	
}
