package mashup.mashuprestservice;

import mashup.mashuprestservice.client.CoverArtArchiveClient;
import mashup.mashuprestservice.client.MashupClient;
import mashup.mashuprestservice.client.MusicBrainzClient;
import mashup.mashuprestservice.client.WikipediaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MashupRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MashupRestServiceApplication.class, args);
	}

}
