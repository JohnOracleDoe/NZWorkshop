package example;

import java.util.Optional;
import static spark.Spark.get;
import static spark.Spark.port;

public class Hello {

	public static final Optional<String> PORT = Optional.ofNullable(System.getenv("PORT"));
	public static final Optional<String> GREETING = Optional.ofNullable(System.getenv("GREETING"));
	
	public static void main(String[] args) {
		Integer port = Integer.valueOf(PORT.orElse("8080"));
		port(port);

		get("/", (req, res) -> {
			return GREETING.orElse("Hello World!");
		});

	}

}
