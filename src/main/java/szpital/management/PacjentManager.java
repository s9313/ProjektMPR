package szpital.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import szpital.encje.pacjenci.Pacjent;
import szpital.encje.personel.Chirurg;
import szpital.encje.personel.Kardiolog;
import szpital.encje.personel.Neurolog;
import szpital.temp.DatabaseContext;

public class PacjentManager implements ManagerInterface<Pacjent> {

	Connection conn;
	
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String password = "postgres";
	private String login = "postgres";

	String createTable =
			"CREATE TABLE Pacjent(" +
			"id serial not null," +
			"imie varchar(32) not null, " +
			"nazwisko varchar(64) not null," +
			"adres varchar(64) not null," +
			"telefon varchar(16) not null," +
			"CONSTRAINT Pacjent_pk PRIMARY KEY(id))";
 
	Statement statement;
	PreparedStatement addPacjentStatement;
	PreparedStatement deletePacjentStatement;
	PreparedStatement getAllPacjentsStatement;
	PreparedStatement getPacjentByIdStatement;
	
	public PacjentManager() {
		try {
			conn = DriverManager.getConnection(url, login, password);
			statement = conn.createStatement();

			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);
			
			boolean tableExists = false;
			
			while (rs.next()) {
				if ("Pacjent".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if(!tableExists)
				statement.executeUpdate(createTable);

			addPacjentStatement = conn
					.prepareStatement(
							"INSERT INTO Pacjent (imie, nazwisko, adres, telefon) " +
							"VALUES (?, ?, ?, ?)");
			deletePacjentStatement=conn
					.prepareStatement("DELETE From Pacjent WHERE nazwisko=?");
			getAllPacjentsStatement = conn
					.prepareStatement("SELECT * FROM Pacjent");
			getPacjentByIdStatement=conn
					.prepareStatement("SELECT * FROM Pacjent WHERE id=?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}

	@Override
	public Pacjent get(long id) {
	
	Pacjent result = null;
		
	try {
		getPacjentByIdStatement.setLong(1, id);
		ResultSet rs = getPacjentByIdStatement.executeQuery();
		while(rs.next()){
			result = new Pacjent(rs.getString("imie"),rs.getString("nazwisko"),rs.getString("adres"),rs.getString("telefon"));
			break;
		}
		return result;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}

	@Override
	public List<Pacjent> getAll() {
		List<Pacjent> result= new ArrayList<Pacjent>();
	
	try {
		ResultSet rs= getAllPacjentsStatement.executeQuery();
		while(rs.next())
			result.add(new Pacjent(rs.getString("imie"),rs.getString("nazwisko"),rs.getString("adres"),rs.getString("telefon")));
		
		return result;
		
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	
}

	@Override
	public boolean save(Pacjent obj) {
		try {
			addPacjentStatement.setString(1, obj.getImie());
			addPacjentStatement.setString(2, obj.getNazwisko());
			addPacjentStatement.setString(3, obj.getAdres());
			addPacjentStatement.setString(4, obj.getTelefon());			
			return addPacjentStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Pacjent obj) {

		try {
			deletePacjentStatement.setString(1, obj.getNazwisko());
			deletePacjentStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
