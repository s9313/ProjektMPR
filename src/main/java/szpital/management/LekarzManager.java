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
import szpital.encje.personel.Lekarz;
import szpital.encje.personel.Neurolog;

public class LekarzManager implements ManagerInterface<Lekarz> {

	private Connection conn;
	
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String password = "postgres";
	private String login = "postgres";

	String createTable =
			"CREATE TABLE Lekarz(" +
			"id serial not null," +
			"imie varchar(32) not null, " +
			"nazwisko varchar(64) not null," +
			"specjalizacja varchar(64) not null," +
			"CONSTRAINT lekarz_pk PRIMARY KEY(id))";
 
	Statement statement;
	PreparedStatement addLekarzStatement;
	PreparedStatement deleteLekarzStatement;
	PreparedStatement getAllLekarzsStatement;
	PreparedStatement getLekarzByIdStatement;
	
	public LekarzManager() {
		try {
			conn = DriverManager.getConnection(url, login, password);
			statement = conn.createStatement();

			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);
			
			boolean tableExists = false;
			
			while (rs.next()) {
				if ("Lekarz".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if(!tableExists)
				statement.executeUpdate(createTable);

			addLekarzStatement = conn
					.prepareStatement(
							"INSERT INTO Lekarz (imie, nazwisko, specjalizacja) " +
							"VALUES (?, ?, ?)");
			deleteLekarzStatement=conn
					.prepareStatement("DELETE From Lekarz where true");
			getAllLekarzsStatement = conn
					.prepareStatement("SELECT * FROM Lekarz");
			getLekarzByIdStatement=conn
					.prepareStatement("SELECT * FROM Lekarz WHERE id=?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}
	
	public void clearPersons() {
		try {
			deleteLekarzStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Lekarz get(long id) {
		try {
			getLekarzByIdStatement.setLong(1, id);
			ResultSet rs = getLekarzByIdStatement.executeQuery();
			
			String spec = "";
			String imie = "";
			String nazwisko = "";
			String specjalizacja = "";
	
			Lekarz wynik = null;
			
			while(rs.next())
			{
				spec = rs.getString("specjalizacja");
				imie = rs.getString("imie");
				nazwisko = rs.getString("nazwisko");
			}
			
//			if(spec.equalsIgnoreCase("chirurg"))
//			{
//				wynik = new Chirurg();
//				wynik.setImie(imie);
//				wynik.setNazwisko(nazwisko);
//				
//			}
			
			if(spec.equalsIgnoreCase("neurolog"))
				wynik = new Neurolog(imie, nazwisko, specjalizacja);

			if(spec.equalsIgnoreCase("chirurg"))
				wynik = new Chirurg(imie, nazwisko, specjalizacja);
			
			if(spec.equalsIgnoreCase("kardiolog"))
				wynik = new Kardiolog(imie, nazwisko, specjalizacja);

			
			return wynik;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Lekarz> getAll() {
		List<Lekarz> result= new ArrayList<Lekarz>();

		try {
			ResultSet rs= getAllLekarzsStatement.executeQuery();
			while(rs.next())
			{
				Lekarz p=null;
				String spec=rs.getString("specjalizacja");
				String imie=rs.getString("imie");
				String nazwisko=rs.getString("nazwisko");
				String specjalizacja=rs.getString("specjalizacja");
				if(spec.equalsIgnoreCase("chirurg"))
				{
					p = new Chirurg();
					p.setImie(imie);
					p.setNazwisko(nazwisko);
					p.setSpecjalizacja(specjalizacja);
					
				}
				if(spec.equalsIgnoreCase("kardiolog"))
				{
					p=new Kardiolog(imie,nazwisko,specjalizacja);
					
				}
				result.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean save(Lekarz obj) {
		try {
			addLekarzStatement.setString(1, obj.getImie());
			addLekarzStatement.setString(2, obj.getNazwisko());
			addLekarzStatement.setString(3, obj.getSpecjalizacja());
			return addLekarzStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Lekarz obj) {

		try {
			deleteLekarzStatement.setString(1, obj.getNazwisko());
			deleteLekarzStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
