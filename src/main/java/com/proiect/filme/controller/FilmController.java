package com.proiect.filme.controller;

import com.proiect.filme.model.Film;
import com.proiect.filme.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** Clasa pentru gestionarea cererilor HTTP si controlul fluxului de date in aplicatia CineVault
 * @author Vasiliu Cristian
 * @version 12 Ianuarie 2026
 */
@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    // Gestioneaza afisarea paginii principale si functionalitatea de cautare
    @GetMapping("/")
    public String viewHomePage(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            // Logica pentru cautare si generare recomandari
            List<Film> results = filmService.searchFilms(keyword);
            model.addAttribute("searchResults", results);
            model.addAttribute("keyword", keyword);

            if (!results.isEmpty()) {
                String genre = results.get(0).getGen();

                // Cream o lista modificabila pentru recomandari
                List<Film> recommendations = new ArrayList<>(filmService.getFilmsByGen(genre));
                recommendations.removeAll(results);

                model.addAttribute("recommendations", recommendations);
                model.addAttribute("recGenre", genre);
            } else {
                model.addAttribute("recommendations", new ArrayList<>());
            }

            return "search_results";
        }

        // Incarcarea filmelor pe categorii pentru pagina de start
        model.addAttribute("actionMovies", filmService.getFilmsByGen("Action"));
        model.addAttribute("comedyMovies", filmService.getFilmsByGen("Comedy"));
        model.addAttribute("scifiMovies", filmService.getFilmsByGen("Sci-Fi"));
        model.addAttribute("dramaMovies", filmService.getFilmsByGen("Drama"));
        model.addAttribute("horrorMovies", filmService.getFilmsByGen("Horror"));
        model.addAttribute("docMovies", filmService.getFilmsByGen("Documentary"));
        return "index";
    }

    // Endpoint AJAX pentru adaugarea unui film in Wishlist fara reincarcarea paginii
    @PostMapping("/api/adauga-lista")
    @ResponseBody
    public String addToListAjax(@RequestParam("id") Long id) {
        Film film = filmService.getFilmById(id);
        if (film != null) {
            film.setStatus("Wishlist");
            filmService.saveFilm(film);
            return "Success";
        }
        return "Error";
    }

    // Afiseaza formularul pentru adaugarea unui film nou
    @GetMapping("/adauga")
    public String showNewFilmForm(Model model) {
        model.addAttribute("film", new Film());
        return "film_nou";
    }

    // Salveaza un film nou sau actualizarile aduse unuia existent
    @PostMapping("/salveaza")
    public String saveFilm(@ModelAttribute("film") Film film) {
        filmService.saveFilm(film);
        return "redirect:/";
    }

    // Pregateste formularul pentru editarea unui film existent
    @GetMapping("/editeaza/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Film film = filmService.getFilmById(id);
        model.addAttribute("film", film);
        return "film_nou";
    }

    // Sterge definitiv un film din baza de date
    @GetMapping("/stergeDefinitiv/{id}")
    public String deleteFilmForever(@PathVariable(value = "id") Long id) {
        filmService.deleteFilmForever(id);
        return "redirect:/";
    }

    // Actualizeaza ratingul utilizatorului si marcheaza filmul ca vizionat
    @PostMapping("/actualizeazaRating")
    public String updateRatingAndStatus(@RequestParam("id") Long id, @RequestParam("rating") Double rating) {
        Film film = filmService.getFilmById(id);
        film.setStatus("Vazut");
        film.setRating(rating);
        filmService.saveFilm(film);
        return "redirect:/vazute";
    }

    // Afiseaza lista de filme marcate ca Wishlist
    @GetMapping("/wishlist")
    public String viewWishlist(Model model) {
        model.addAttribute("wishlistFilms", filmService.getFilmsByStatus("Wishlist"));
        return "wishlist";
    }

    // Gestioneaza pagina de istoric (filme vazute), incluzand filtrare, sortare si date pentru grafice
    @GetMapping("/vazute")
    public String viewWatched(Model model,
                              @RequestParam(value = "gen", required = false, defaultValue = "Toate") String gen,
                              @RequestParam(value = "sort", required = false, defaultValue = "Default") String sort) {

        List<Film> allWatched = filmService.getFilmsByStatus("Vazut");

        // Filtrare dupa gen
        List<Film> filtered = allWatched.stream()
                .filter(f -> gen.equals("Toate") || f.getGen().equalsIgnoreCase(gen))
                .collect(Collectors.toList());

        // Sortare dupa rating
        if (sort.equals("ASC")) {
            filtered.sort(Comparator.comparing(Film::getRating, Comparator.nullsFirst(Comparator.naturalOrder())));
        } else if (sort.equals("DESC")) {
            filtered.sort(Comparator.comparing(Film::getRating, Comparator.nullsFirst(Comparator.reverseOrder())));
        }

        model.addAttribute("watchedFilms", filtered);
        model.addAttribute("selectedGen", gen);
        model.addAttribute("selectedSort", sort);

        // Pregatirea datelor matematice pentru graficele Chart.js
        List<String> genres = List.of("Action", "Comedy", "Drama", "Sci-Fi", "Horror", "Documentary");
        List<Long> countData = new ArrayList<>();
        List<Double> avgData = new ArrayList<>();

        for (String g : genres) {
            long count = allWatched.stream().filter(f -> f.getGen().equalsIgnoreCase(g)).count();
            countData.add(count);

            double avg = allWatched.stream()
                    .filter(f -> f.getGen().equalsIgnoreCase(g) && f.getRating() != null)
                    .mapToDouble(Film::getRating)
                    .average()
                    .orElse(0.0);
            avgData.add(Math.round(avg * 10.0) / 10.0);
        }

        model.addAttribute("chartLabels", genres);
        model.addAttribute("chartCount", countData);
        model.addAttribute("chartAvg", avgData);

        return "vazute";
    }

    // Reseteaza statusul unui film (il elimina din liste fara a-l sterge din baza de date)
    @GetMapping("/reseteazaStatus/{id}")
    public String resetStatus(@PathVariable(value = "id") Long id) {
        filmService.resetFilmStatus(id);
        return "redirect:/vazute";
    }

    // Elimina un film din Wishlist
    @GetMapping("/sterge/{id}")
    public String deleteFromList(@PathVariable(value = "id") Long id) {
        filmService.resetFilmStatus(id);
        return "redirect:/wishlist";
    }
}