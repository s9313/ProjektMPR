package szpital.management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import szpital.baza.ManagerInterface;
import szpital.encje.personel.Kardiolog;
import szpital.encje.personel.Lekarz;

public class PostgresPersonManager implements ManagerInterface<Lekarz> {
	
	Connection connection;
	
	private String url="jdbc:postgresql://localhost:5432/postgres";
	private String password="postgres";
	private String login="postgres";
	
	Statement stmt;
	PreparedStatement savePerson;
	PreparedStatement getAll;
	PreparedStatement deletePerson;
	PreparedStatement getPerson;
	
	public PostgresPersonManager(){
		try {
			connection = DriverManager.getConnection(url, login, password);
	
			getAll = connection.prepareStatement(" " + "SELECT * FROM Lekarz");
			deletePerson = connection.prepareStatement(" " + "DELETE FROM Lekarz WHERE name = ?");
			getPerson = connection.prepareStatement(" " + "SELECT * FROM Lekarz WHERE id= ?");
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public Lekarz get(long id) {
		Lekarz result = null;
		
		try {
			getPerson.setLong(1, id);
			ResultSet rs = getPerson.executeQuery();
				while(rs.next()){
					result = new Kardiolog(rs.getString("imie"), rs.getString("nazwisko"));
					break;
				}
			return result;
		}	
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	public List<Lekarz> getAll() {

		List<Lekarz> result = new ArrayList<Lekarz>();
		
		try {
			ResultSet rs = getAll.executeQuery();
			while(rs.next())
				result.add(new Kardiolog(rs.getString("Imie"), rs.getString("Nazwisko")));
			return result;
		}
		
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	public boolean save(Lekarz obj) {
		try {
			savePerson = connection.prepareStatement(" " + "INSERT INTO Lekarz(imie, nazwisko)" + "VALUES(?, ?)");
			savePerson.setString(1, obj.getImie());
			savePerson.setString(2, obj.getNazwisko());
			
			return savePerson.execute();
		}
		
		catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Lekarz obj) {
		try {
			deletePerson.setString(1, obj.getImie());
			deletePerson.executeUpdate();
			return true;
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	

}
