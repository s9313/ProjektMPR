package szpital.baza;

import java.util.List;

import szpital.encje.pacjenci.Pacjent;

public class PacjentManager implements ManagerInterface<Pacjent> {

	
	public Pacjent get(long id) {
		for (Pacjent pacjent : DatabaseContext.getPacjenci()) {
			if (pacjent.getId() == id) {
				return pacjent;
			}
		}
		return null;
	}

	public List<Pacjent> getAll() {
		return DatabaseContext.getPacjenci();
	}

	public boolean save(Pacjent obj) {
		return DatabaseContext.getPacjenci().add(obj);
	}

	public boolean delete(Pacjent obj) {
		for (Pacjent pacjent : DatabaseContext.getPacjenci()) {
			if (pacjent.equals(obj)) {
				DatabaseContext.getPacjenci().remove(obj);
				return true;
			}
		}
		return false;
	}

}
