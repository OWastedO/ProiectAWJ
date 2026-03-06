package com.proiect.filme.repository;

import com.proiect.filme.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Clasa pentru definirea operatiilor de acces la baza de date pentru entitatea Film
 * @author Vasiliu Cristian
 * @version 12 Ianuarie 2026
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    // Gaseste filmele care au un anumit status specificat
    List<Film> findByStatus(String status);

    // Gaseste filme dintr-un anumit gen excluzand un status specific si le ordoneaza descrescator dupa rating
    List<Film> findByGenAndStatusNotOrderByRatingDesc(String gen, String statusExclus);

    // Numara filmele dintr-un anumit gen care au un status specific
    long countByGenAndStatus(String gen, String status);

    // Cauta filme al caror titlu contine textul specificat indiferent de majuscule
    List<Film> findByTitluContainingIgnoreCase(String keyword);
}