package in.laxmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SbAsyncClientAppApplication {
   static String url="http://13.232.253.164:8080/ticket/{ticketNum}";
	public static void main(String[] args) {
		SpringApplication.run(SbAsyncClientAppApplication.class, args);
		System.out.println("request sending start");
		 WebClient webclient = WebClient.create();
		 String response = webclient.get()
		.uri(url, 6)
		.retrieve()
		.bodyToMono(String.class)
		.block();
		System.out.println("request sending end");

	}
	public static void handleResponse(String response) {
		System.out.println("response");
	}

}
