import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CreateKeyspace {

	public static void main(String[] args) {
		Cluster cluster;
		Session session;
		
		String query = "CREATE KEYSPACE ejemplo WITH replication = "
				+ "{'class' : 'SimpleStrategy', 'replication_factor' : 1}";

		// Connection to the db
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect();

		// Executing the query
		session.execute(query);
		session.execute("USE ejemplo");

		// Message of success
		System.out.println("KeySpace created");

		// Close connection
		session.close();
		cluster.close();
	}

}
