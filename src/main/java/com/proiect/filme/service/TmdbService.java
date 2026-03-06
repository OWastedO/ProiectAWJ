package com.proiect.filme.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/** Clasa pentru integrarea cu API-ul extern TMDB in vederea preluarii posterelor filmelor
 * @author Vasiliu Cristian
 * @version 12 Ianuarie 2026
 */
@Service
public class TmdbService {

    private final String API_KEY = "b5fd69102f789388b04eded1fe41afbd";
    private final String BASE_URL = "https://api.themoviedb.org/3/search/movie";
    private final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

    // Interogheaza API-ul TMDB pentru a gasi URL-ul posterului pe baza titlului filmului
    public String getPosterUrl(String movieTitle) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            // Constructia URL-ului pentru cerere incluzand cheia API si titlul cautat
            String url = BASE_URL + "?api_key=" + API_KEY + "&query=" + movieTitle;

            // Efectuarea cererii HTTP GET catre serviciul extern
            String response = restTemplate.getForObject(url, String.class);

            // Procesarea raspunsului JSON utilizand libraria Jackson
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            JsonNode results = root.path("results");

            // Verificam daca exista rezultate si extragem imaginea din primul rezultat relevant
            if (results.isArray() && results.size() > 0) {
                JsonNode firstMovie = results.get(0);
                String posterPath = firstMovie.path("poster_path").asText();

                // Validam calea imaginii inainte de a returna URL-ul complet
                if (posterPath != null && !posterPath.isEmpty() && !posterPath.equals("null")) {
                    return IMAGE_BASE_URL + posterPath;
                }
            }
        } catch (Exception e) {
            // In caz de eroare la conectare sau procesare, returnam null fara a intrerupe executia aplicatiei
            System.out.println("Avertisment TMDB pentru filmul: " + movieTitle + " -> " + e.getMessage());
        }

        // Returneaza null daca nu s-a gasit poster, urmand a se folosi imaginea de rezerva din HTML
        return null;
    }
}