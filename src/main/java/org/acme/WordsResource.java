package org.acme;

import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import io.quarkus.logging.Log;

@Path("/words")
public class WordsResource {
    @ConfigProperty(name = "app.words")
    List<String> words;

    @GET
    public String getWords() {
        return words.stream().collect(Collectors.joining(" ")) + "\n";
    }
}
