# Cine Vault - Gestionare Colecție Filme

Cine Vault este o soluție software completă pentru gestionarea unei colecții personale de filme, oferind o interfață modernă și funcționalități avansate de procesare a datelor. Aplicația este construită folosind Java și respectă arhitectura Model-View-Controller (MVC) specifică ecosistemului Spring Boot.

## Arhitectura Sistemului

Aplicația este structurată pe straturi, asigurând o separare clară a responsabilităților:

* **Model:** Entitatea `Film` mapează structura bazei de date și definește atributele (titlu, gen, an apariție, rating personal, rating IMDb, status etc.).
* **Repository:** `FilmRepository` extinde `JpaRepository` pentru a asigura persistența datelor și definește interogări personalizate (Custom Queries) pentru căutare și filtrare.
* **Service:** Conține logica de business. 
  * `FilmService` utilizează concepte avansate de Java (Streams, Lambda) pentru filtrarea, sortarea și procesarea datelor.
  * `TmdbService` gestionează comunicarea cu exteriorul prin cereri HTTP.
* **Controller:** `FilmController` gestionează cererile HTTP venite din browser și rutele aplicației (`/`, `/wishlist`, `/vazute`, `/cauta`).

## Funcționalități Implementate

### Funcționalități de Bază (CRUD)
* **Adăugare (Create):** Introducerea de filme noi specificând titlul, genul, anul și descrierea.
* **Vizualizare (Read):** Listarea filmelor sub formă de carduri interactive, grupate pe categorii.
* **Actualizare (Update):** Editarea detaliilor sau modificarea statusului (ex: din "To Watch" în "Watched").
* **Ștergere (Delete):** Eliminarea filmelor sau logica de "Soft Delete" pentru resetarea istoricului.
* **Persistența Datelor:** Stocarea se face într-o bază de date relațională H2 (embedded) salvată pe disc.

### Funcționalități Avansate
* **Integrare API Extern (TMDB):** Aplicația consumă serviciile REST oferite de The Movie Database pentru a descărca automat posterul oficial al filmului.
  * Se folosește `RestTemplate` pentru cererile GET și `ObjectMapper` (din librăria Jackson) pentru parsarea răspunsurilor JSON complexe.
  * Sistemul include un mecanism de Fallback: dacă API-ul extern nu răspunde, aplicația gestionează eroarea grațios și folosește o imagine de rezervă.
* **Procesare Java Avansată:** Implementarea filtrelor pentru gen/status folosind Java Streams și a claselor de tip `Comparator` personalizat pentru ordonarea listelor după rating. Sistemul calculează automat agregări pentru statistici.
* **Interfață UI/UX Modernă:** Front-end-ul utilizează o temă "Dark Mode", elemente interactive (carduri cu efect zoom), notificări de tip Toast și ferestre modale. 
* **Tablou de bord cu Statistici:** Generarea de grafice vizuale (Doughnut Chart și Bar Chart) cu ajutorul librăriei Chart.js pentru a ilustra distribuția filmelor și mediile notelor.

## Tehnologii și Mediu de Dezvoltare

* **Back-end:** Java, Spring Boot, Spring Data JPA
* **Bază de date:** H2 Database
* **Integrare externă:** TMDB API (Jackson, RestTemplate)
* **Front-end:** Thymeleaf, Bootstrap 4, JavaScript personalizat, Chart.js

## Instalare și Rulare

Acest proiect folosește Maven pentru managementul dependențelor și procesul de build. 

Pentru a rula aplicația local, deschide un terminal în folderul rădăcină al proiectului (unde se află fișierul `pom.xml`) și execută următoarea comandă:

```bash
mvn spring-boot:run
