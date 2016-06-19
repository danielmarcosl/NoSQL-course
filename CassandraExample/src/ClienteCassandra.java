import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class ClienteCassandra {

	public static void main(String[] args) {
		Cluster cluster;
		Session session;

		// Connection to the db
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("demodb");

		// Inserts to persona table
		//session.execute("INSERT INTO persona (DNI, first_name, last_name, sex, nacionality, civil_state, birth_date) VALUES (122, 'Juan', 'Cordoba', 'Masculino', 'Espanola', 'Soltero', 1424109603234)");
		//session.execute("INSERT INTO persona (DNI, first_name, last_name, sex, nacionality, civil_state, birth_date) VALUES (123, 'Marta', 'Ariza', 'Femenino', 'Catalana', 'Casada', 1424109603234)");

		// Select * from persona
		ResultSet results = session.execute("SELECT * FROM persona");
		for (Row row : results) {
			System.out.println("Last name: " + row.getString("last_name"));
		}
		
		// Update civil_state
		//session.execute("UPDATE persona SET civil_state = 'Viudo' WHERE DNI = 122");
		
		// Select for view the change
		//ResultSet results2 = session.execute("SELECT * FROM persona WHERE DNI = 122");
		//for (Row row : results2) {
		//	System.out.println("DNI: " + row.getInt("DNI") + "\nCivil state: " + row.getString("civil_state"));
		//}
		
		session.close();
		cluster.close();
	}
}
