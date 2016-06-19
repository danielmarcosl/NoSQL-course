package ejemplo;
import java.util.*;
import org.lightcouch.*;

public class CouchClient {

	public static void main(String[] args) {
		CouchDbClient dbClient = new CouchDbClient("couchdb.properties"); 
		DesignDocument designDocument;
		Response response;

		designDocument = dbClient.design().getFromDb("ejemplo");
		response = dbClient.design().synchronizeWithDb(designDocument);
		
		Scanner sc = new Scanner(System.in);

		System.out.print("First name: ");
		String firstName = sc.nextLine();

		System.out.print("Last name: ");
		String lastName = sc.nextLine();

		System.out.print("Nickname: ");
		String nickname = sc.nextLine();

		int docCount;
		String [] keys = {firstName, lastName};
		docCount = dbClient.view("ejemplo/por_nombre").key((Object[]) keys).query(Persona.class).size();
		
		if(docCount > 0) {
			System.out.println("Encontrado");
		} else {
			Persona persona = new Persona();
			
			persona.setFirst_name(firstName);
			persona.setLast_name(lastName);
			persona.setNickname(nickname);
			dbClient.save(persona);
			
			System.out.println("Nueva persona guardada");
		}
		
		List<Persona> personas = dbClient.view("ejemplo/por_todos").includeDocs(true).query(Persona.class);
		System.out.println("\n Lista de nombres: ");
		
		for(Persona todos : personas) {
			System.out.println(todos.first_name + " " + todos.last_name + " " + todos.nickname);
		}
		
		dbClient.shutdown();
	}

}
