import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;

public class InsertInto {

	public static void main(String[] args) {
		Cluster cluster;
		Session session;

		String query = "INSERT INTO employee(emp_id, name, city, salary, phone)"
				+ "VALUES(1, 'Juanito', 'Madrid', 1234, 987654321)";

		// Connection to the db
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("ejemplo");

		// Executing the query
		session.execute(query);

		// Executing the select and display result
		ResultSet result = session.execute("SELECT * FROM employee WHERE emp_id = 1");
		for (Row row : result) {
			System.out.println("Nombre: " + row.getString("name"));
		}

		// Close connection
		session.close();
		cluster.close();
	}

}
