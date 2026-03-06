package com.proiect.filme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/** Clasa pentru definirea entitatii Film si maparea acesteia in baza de date
 * @author Vasiliu Cristian
 * @version 12 Ianuarie 2026
 */
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titlul este obligatoriu")
    private String titlu;

    @NotBlank(message = "Genul este obligatoriu")
    private String gen;

    // Validare an conform istoriei cinematografiei
    @Min(value = 1888, message = "Filmul nu poate fi mai vechi de 1888")
    @Max(value = 2026, message = "Anul nu poate depasi 2026")
    private int anAparitie;

    // Rating personal acordat de utilizator
    @Min(value = 0, message = "Nota minima este 0")
    @Max(value = 10, message = "Nota maxima este 10")
    private Double rating;

    // Rating preluat din surse externe (ex. TMDB)
    private Double imdbRating;

    @Column(length = 1000)
    private String imageUrl;

    @Column(length = 2000)
    private String descriere;

    // Status curent: Nevazut, Wishlist, Vazut
    private String status;

    public Film() {}

    public Film(String titlu, String gen, int anAparitie, Double rating, Double imdbRating, String imageUrl, String descriere, String status) {
        this.titlu = titlu;
        this.gen = gen;
        this.anAparitie = anAparitie;
        this.rating = rating;
        this.imdbRating = imdbRating;
        this.imageUrl = imageUrl;
        this.descriere = descriere;
        this.status = status;
    }

    // Verifica daca filmul are o imagine valida setata
    public boolean hasImage() {
        return imageUrl != null && !imageUrl.isEmpty();
    }

    // Returneaza ratingul formatat pentru afisare in interfata
    public String getStarsDisplay() {
        if (rating == null || rating == 0) return "";
        return "⭐ " + rating + "/10";
    }

    // Metode de acces (Getters si Setters)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitlu() { return titlu; }
    public void setTitlu(String titlu) { this.titlu = titlu; }

    public String getGen() { return gen; }
    public void setGen(String gen) { this.gen = gen; }

    public int getAnAparitie() { return anAparitie; }
    public void setAnAparitie(int anAparitie) { this.anAparitie = anAparitie; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public Double getImdbRating() { return imdbRating; }
    public void setImdbRating(Double imdbRating) { this.imdbRating = imdbRating; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}