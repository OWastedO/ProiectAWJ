package com.proiect.filme.service;

import com.proiect.filme.model.Film;
import com.proiect.filme.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/** Clasa ce implementeaza regulile functionale si procesarea datelor pentru entitatea Film
 * @author Vasiliu Cristian
 * @version 12 Ianuarie 2026
 */
@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    // Returneaza toate filmele din baza de date
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    // Salveaza sau actualizeaza un film
    public void saveFilm(Film film) {
        filmRepository.save(film);
    }

    // Cauta un film dupa ID sau arunca o exceptie daca nu exista
    public Film getFilmById(Long id) {
        Optional<Film> optional = filmRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Film nu a fost gasit pentru id :: " + id);
        }
    }

    // Sterge un film dupa ID
    public void deleteFilmById(Long id) {
        filmRepository.deleteById(id);
    }

    // Cauta filme care contin cuvantul cheie in titlu
    public List<Film> searchFilms(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return filmRepository.findByTitluContainingIgnoreCase(keyword);
        }
        return filmRepository.findAll();
    }

    // Returneaza filmele filtrate dupa status (ex: Wishlist, Vazut)
    public List<Film> getFilmsByStatus(String status) {
        return filmRepository.findByStatus(status);
    }

    // Returneaza numarul de filme vizionate dintr-un anumit gen
    public long countVazuteByGen(String gen) {
        return filmRepository.countByGenAndStatus(gen, "Vazut");
    }

    // Filtreaza filmele dupa gen folosind stream-uri Java
    public List<Film> getFilmsByGen(String gen) {
        return filmRepository.findAll().stream()
                .filter(f -> f.getGen().equalsIgnoreCase(gen))
                .collect(Collectors.toList());
    }

    // Reseteaza statusul si ratingul unui film fara a-l sterge din baza de date
    public void resetFilmStatus(Long id) {
        Film film = getFilmById(id);
        film.setStatus("Nevazut");
        film.setRating(null);
        saveFilm(film);
    }

    // Sterge definitiv filmul din baza de date
    public void deleteFilmForever(Long id) {
        filmRepository.deleteById(id);
    }

    // Metoda complexa pentru filtrarea si sortarea filmelor vizionate
    public List<Film> getFilteredWatchedFilms(String gen, String sortare) {
        List<Film> allWatched = filmRepository.findByStatus("Vazut");

        // Filtrare dupa gen
        if (gen != null && !gen.equals("Toate")) {
            allWatched = allWatched.stream()
                    .filter(f -> f.getGen().equalsIgnoreCase(gen))
                    .collect(Collectors.toList());
        }

        // Sortare dupa rating
        if (sortare != null) {
            switch (sortare) {
                case "DESC":
                    allWatched.sort(Comparator.comparing(Film::getRating).reversed());
                    break;
                case "ASC":
                    allWatched.sort(Comparator.comparing(Film::getRating));
                    break;
            }
        }

        return allWatched;
    }
}