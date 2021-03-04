package mashup.mashuprestservice;

import mashup.mashuprestservice.client.CoverArtArchiveClient;
import mashup.mashuprestservice.client.MashupClient;
import mashup.mashuprestservice.client.MusicBrainzClient;
import mashup.mashuprestservice.client.WikipediaClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MashupConfiguration {
    @Bean
    public MusicBrainzClient musicBrainzClient() {
        return new MusicBrainzClient();
    }

    @Bean
    public WikipediaClient wikipediaClient() {
        return new WikipediaClient();
    }

    @Bean
    public CoverArtArchiveClient coverArtArchiveClient() {
        return new CoverArtArchiveClient();
    }

    @Bean
    public MashupClient mashupClient(MusicBrainzClient musicBrainzClient, WikipediaClient wikipediaClient, CoverArtArchiveClient coverArtClient) {
        return new MashupClient(musicBrainzClient, wikipediaClient, coverArtClient);
    }
}
