import org.ektorp.CouchDbConnector;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        StdHttpClient.Builder httpClientBuilder = new StdHttpClient.Builder().host("localhost").port(5984);
        httpClientBuilder = httpClientBuilder.username("admin").password("123456");

        StdCouchDbInstance couchDbInstance = new StdCouchDbInstance(httpClientBuilder.build());
        if (couchDbInstance.checkIfDbExists("LR4")) {
            couchDbInstance.deleteDatabase("LR4");
        }
        couchDbInstance.createDatabase("LR4");

        CouchDbConnector dbConnector = couchDbInstance.createConnector("LR4", true);

        Book book1 = new Book();
        String jsonContent = new String(Files.readAllBytes(Paths.get("C:\\DB\\lab4\\books.json")));
        book1.setInfo(jsonContent);
        dbConnector.create("JSON", book1);

        Book book2 = new Book();
        String xmlContent = new String(Files.readAllBytes(Paths.get("C:\\DB\\lab4\\books.xml")));
        book2.setInfo(xmlContent);
        dbConnector.create("XML", book2);

        Book book3 = new Book();
        String csvContent = new String(Files.readAllBytes(Paths.get("C:\\DB\\lab4\\books.csv")));
        book3.setInfo(csvContent);
        dbConnector.create("CSV", book3);

        System.out.println("JSON: ");
        System.out.println(dbConnector.get(Book.class, "JSON"));
        System.out.println("XML: ");
        System.out.println(dbConnector.get(Book.class, "XML"));
        System.out.println("CSV: ");
        System.out.println(dbConnector.get(Book.class, "CSV"));
    }
}
