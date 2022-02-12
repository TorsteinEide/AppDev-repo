package no.ntnu.Connectionjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionJdbcApplication {

	public static void main(String[] args) {
		JdbcConnection connection = JdbcConnection.getInstance();
		try{
			connection.connect();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		String status = connection.isConnected() ? "established" :"failed";
		System.out.println("Connection " + status);
		SpringApplication.run(ConnectionJdbcApplication.class, args);

	}

}
