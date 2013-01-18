package szpital.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import szpital.encje.personel.Chirurg;
import szpital.encje.personel.Kardiolog;
import szpital.encje.personel.Neurolog;
import szpital.encje.wizyty.Wizyta;

public class WizytaManager implements ManagerInterface<Wizyta> {

private Connection conn;
	
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String password = "postgres";
	private String login = "postgres";

	String createTable =
			"CREATE TABLE Wizyta(" +
			"id serial not null," +
			"data_zabiegu varchar(32) not null, " +
			"godzina varchar(16) not null," +
			"id_pacjenta int not null," +
			"id_lekarza int not null, " +
			"CONSTRAINT Wizyta_pk PRIMARY KEY(id)," +
			"CONSTRAINT id_pacjenta_fk FOREIGN KEY(id_pacjenta) REFERENCES pacjent(id) ON UPDATE CASCADE ON DELETE SET NULL," +
			"CONSTRAINT id_lekarza_fk FOREIGN KEY(id_lekarza) REFERENCES lekarz(id) ON UPDATE CASCADE ON DELETE SET NULL)";
 
	Statement statement;
	PreparedStatement addWizytaStatement;
	PreparedStatement deleteWizytaStatement;
	PreparedStatement getAllWizytasStatement;
	PreparedStatement getWizytaByIdStatement;
	
	public WizytaManager() {
		try {
			conn = DriverManager.getConnection(url, login, password);
			statement = conn.createStatement();

			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);
			
			boolean tableExists = false;
			
			while (rs.next()) {
				if ("Wizyta".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if(!tableExists)
				statement.executeUpdate(createTable);

			addWizytaStatement = conn
					.prepareStatement(
							"INSERT INTO Wizyta (data_zabiegu, godzina, id_pacjenta, id_lekarza) " +
							"VALUES (?, ?, ?, ?)");
			deleteWizytaStatement=conn
					.prepareStatement("DELETE From Wizyta WHERE id=?");
			getAllWizytasStatement = conn
					.prepareStatement("SELECT * FROM Wizyta");
			getWizytaByIdStatement=conn
					.prepareStatement("SELECT * FROM Wizyta WHERE id=?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}

	@Override
	public Wizyta get(long id) {
	
	Wizyta result = null;
		
	try {
		getWizytaByIdStatement.setLong(1, id);
		ResultSet rs = getWizytaByIdStatement.executeQuery();
		while(rs.next()){
			result = new Wizyta(rs.getString("data_zabiegu"),rs.getString("godzina"),rs.getInt("id_pacjenta"),rs.getInt("id_lekarza"));
			break;
		}
		return result;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}

	@Override
	public List<Wizyta> getAll() {
		List<Wizyta> result= new ArrayList<Wizyta>();
	
	try {
		ResultSet rs= getAllWizytasStatement.executeQuery();
		while(rs.next())
			result.add(new Wizyta(rs.getString("data_zabiegu"),rs.getString("godzina"),rs.getInt("id_pacjenta"),rs.getInt("id_lekarza")));
		
		return result;
		
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	
}

	@Override
	public boolean save(Wizyta obj) {
		try {
			addWizytaStatement.setString(1, obj.getData_zabiegu());
			addWizytaStatement.setString(2, obj.getGodzina());
			addWizytaStatement.setInt(3, obj.getId_pacjenta());
			addWizytaStatement.setInt(4, obj.getId_lekarza());			
			return addWizytaStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Wizyta obj) {

		try {
			deleteWizytaStatement.setInt(1, (int) obj.getId());
			deleteWizytaStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
