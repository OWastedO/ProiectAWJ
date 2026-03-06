package com.proiect.filme;

import com.proiect.filme.model.Film;
import com.proiect.filme.service.FilmService;
import com.proiect.filme.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** Clasa responsabila pentru initializarea si popularea bazei de date la pornirea aplicatiei
 * @author Vasiliu Cristian
 * @version 12 Ianuarie 2026
 */
@Component
public class DataInit implements CommandLineRunner {

    @Autowired
    private FilmService filmService;

    @Autowired
    private TmdbService tmdbService;

    @Override
    public void run(String... args) throws Exception {
        // Rulam popularea doar daca baza de date este goala
        if (filmService.getAllFilms().isEmpty()) {
            System.out.println("--- CINEVAULT: Se initializeaza datele (TMDB API + Fallback) ---");
            System.out.println("--- Acest proces poate dura cateva secunde ---");

            // --- ACTION ---
            add("Mad Max: Fury Road", "Action", 2015, 8.1, "https://image.tmdb.org/t/p/w500/8tZYtuWezpScKdJvypVqIDA5x0T.jpg", "O cursa post-apocaliptica pentru supravietuire in desert.");
            add("The Dark Knight", "Action", 2008, 9.0, "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg", "Batman se confrunta cu haosul provocat de Joker.");
            add("John Wick", "Action", 2014, 7.4, "https://image.tmdb.org/t/p/w500/fZPSd91yGE9fCcCe6OoQr6E3Bev.jpg", "Un asasin retras cauta razbunare pentru cainele sau.");
            add("Die Hard", "Action", 1988, 8.2, "https://image.tmdb.org/t/p/w500/aJCpjDH720dqbbdjY9v0nKPjyUu.jpg", "Un politist lupta singur impotriva teroristilor intr-un zgarie-nori.");
            add("Gladiator", "Action", 2000, 8.5, "https://image.tmdb.org/t/p/w500/ty8TGRuvJLPUmAR1H1nRIsgwvim.jpg", "Un general roman tradat devine gladiator pentru razbunare.");
            add("Terminator 2: Judgment Day", "Action", 1991, 8.6, "https://image.tmdb.org/t/p/w500/5M0j0B18abtBI5gi2RhfjjurTqb.jpg", "Un cyborg protejeaza viitorul lider al rezistentei umane.");
            add("The Matrix", "Action", 1999, 8.7, "https://image.tmdb.org/t/p/w500/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg", "Un hacker descopera ca realitatea este o simulare.");
            add("Avengers: Endgame", "Action", 2019, 8.4, "https://image.tmdb.org/t/p/w500/or06FN3Dka5tukK1e9sl16pB3iy.jpg", "Eroii incearca sa anuleze distrugerea provocata de Thanos.");
            add("Mission: Impossible - Fallout", "Action", 2018, 7.9, "https://image.tmdb.org/t/p/w500/AkJQpZp9WoNdj7pLYSj1L0RcMMN.jpg", "Ethan Hunt trebuie sa opreasca un dezastru nuclear global.");
            add("Logan", "Action", 2017, 8.1, "https://image.tmdb.org/t/p/w500/fnbjc3lwFKA579hk55pQ28jP34T.jpg", "Un Wolverine batran protejeaza o tanara mutanta.");
            add("Top Gun: Maverick", "Action", 2022, 8.3, "https://image.tmdb.org/t/p/w500/62HCnUTziyWcpDaBO2i1DX17ljH.jpg", "Maverick se intoarce sa antreneze o noua generatie.");
            add("Raiders of the Lost Ark", "Action", 1981, 8.4, "https://image.tmdb.org/t/p/w500/ceG9VzoRAVGwivFU403Wc3AHRys.jpg", "Indiana Jones cauta Chivotul Legamantului inaintea nazistilor.");
            add("Kill Bill: Vol. 1", "Action", 2003, 8.2, "https://image.tmdb.org/t/p/w500/v7TaX8kXMXs5yGGxuzM6ONVaZuy.jpg", "O asasina tradata incepe o campanie sangeroasa de razbunare.");
            add("Léon: The Professional", "Action", 1994, 8.5, "https://image.tmdb.org/t/p/w500/wHqGb8J6tXBVwjqwo7mOLxpHX6Z.jpg", "Un asasin profesionist protejeaza o fetita de 12 ani.");
            add("Speed", "Action", 1994, 7.3, "https://image.tmdb.org/t/p/w500/oMk2hK4Y9cZk7p8T8CqJ9qL8G.jpg", "Un autobuz explodeaza daca scade sub 50 mph.");
            add("The Bourne Identity", "Action", 2002, 7.9, "https://image.tmdb.org/t/p/w500/aPHP29h4h8tqj4q1q2q3q4q5.jpg", "Un amnezic descopera ca este un asasin de elita.");
            add("Casino Royale", "Action", 2006, 8.0, "https://image.tmdb.org/t/p/w500/6hmW3ZJ8q3j4q2q4q5.jpg", "Prima misiune a lui James Bond ca agent 007.");
            add("Taken", "Action", 2008, 7.8, "https://image.tmdb.org/t/p/w500/aPHP29h4h8tqj4q1q2q3q4q5.jpg", "Un fost spion isi salveaza fiica rapita in Paris.");
            add("300", "Action", 2006, 7.6, "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg", "Regele Leonidas si 300 de spartani lupta impotriva persilor.");
            add("Heat", "Action", 1995, 8.3, "https://image.tmdb.org/t/p/w500/rrInDHqqJ3M3X3j4q2q4q5.jpg", "Un detectiv vaneaza o echipa de hoti profesionisti.");
            add("Skyfall", "Action", 2012, 7.8, "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg", "Bond trebuie sa protejeze MI6 de o amenintare interna.");
            add("Black Panther", "Action", 2018, 7.3, "https://image.tmdb.org/t/p/w500/uxzzxijgPIY7slzFvMotPv8wjKA.jpg", "Regele T'Challa lupta pentru viitorul regatului Wakanda.");
            add("Spider-Man: No Way Home", "Action", 2021, 8.0, "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg", "Identitatea lui Spider-Man este dezvaluita, declansand haosul multiversal.");
            add("Predator", "Action", 1987, 7.8, "https://image.tmdb.org/t/p/w500/k3oSSOE05jcixb3W8o5Y.jpg", "Comando vs extraterestru in jungla din America Centrala.");
            add("Rambo: First Blood", "Action", 1982, 7.7, "https://image.tmdb.org/t/p/w500/aPHP29h4h8tqj4q1q2q3q4q5.jpg", "Un veteran vietnamez este vanat de politia locala.");
            add("Lethal Weapon", "Action", 1987, 7.6, "https://image.tmdb.org/t/p/w500/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg", "Doi politisti diferiti fac echipa pentru a rezolva crime.");
            add("RoboCop", "Action", 1987, 7.6, "https://image.tmdb.org/t/p/w500/5M0j0B18abtBI5gi2RhfjjurTqb.jpg", "Un politist ucis revine ca un cyborg justitiar.");
            add("Crouching Tiger, Hidden Dragon", "Action", 2000, 7.9, "https://image.tmdb.org/t/p/w500/ceG9VzoRAVGwivFU403Wc3AHRys.jpg", "Razboinici chinezi lupta pentru o sabie legendara.");
            add("Ip Man", "Action", 2008, 8.0, "https://image.tmdb.org/t/p/w500/v7TaX8kXMXs5yGGxuzM6ONVaZuy.jpg", "Povestea maestrului de Kung Fu care l-a antrenat pe Bruce Lee.");
            add("The Raid", "Action", 2011, 7.6, "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg", "O echipa SWAT asediaza un bloc plin de criminali.");
            add("Braveheart", "Action", 1995, 8.4, "https://image.tmdb.org/t/p/w500/or06FN3Dka5tukK1e9sl16pB3iy.jpg", "William Wallace conduce revolta scotienilor impotriva Angliei.");
            add("Saving Private Ryan", "Action", 1998, 8.6, "https://image.tmdb.org/t/p/w500/k3oSSOE05jcixb3W8o5Y.jpg", "Soldatii americani cauta un parasutist in spatele liniilor inamice.");
            add("Dunkirk", "Action", 2017, 7.8, "https://image.tmdb.org/t/p/w500/8tZYtuWezpScKdJvypVqIDA5x0T.jpg", "Evacuarea disperata a trupelor aliate din Franta.");
            add("1917", "Action", 2019, 8.3, "https://image.tmdb.org/t/p/w500/iZf0KyrE25z1sage4syFLCCrMi9.jpg", "Doi soldati trebuie sa livreze un mesaj vital in WWI.");
            add("Fury", "Action", 2014, 7.6, "https://image.tmdb.org/t/p/w500/pfte7wdMobMF4CVHuOaM1xqXY.jpg", "Echipajul unui tanc lupta in Germania nazista.");
            add("Inglourious Basterds", "Action", 2009, 8.3, "https://image.tmdb.org/t/p/w500/7sfbEnaAR80QoJyTlkRfagy.jpg", "Evrei americani vaneaza nazisti in Franta ocupata.");
            add("Oldboy", "Action", 2003, 8.4, "https://image.tmdb.org/t/p/w500/pWDtjs548ucueBNSMDApXtn.jpg", "Un barbat sechestrat 15 ani cauta razbunare.");
            add("Face/Off", "Action", 1997, 7.3, "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg", "Un agent FBI face schimb de fete cu un terorist.");
            add("The Rock", "Action", 1996, 7.4, "https://image.tmdb.org/t/p/w500/5M0j0B18abtBI5gi2RhfjjurTqb.jpg", "Un chimist si un detinut sparg inchisoarea Alcatraz.");
            add("Con Air", "Action", 1997, 6.9, "https://image.tmdb.org/t/p/w500/aPHP29h4h8tqj4q1q2q3q4q5.jpg", "Detinuti periculosi preiau controlul unui avion.");
            add("Independence Day", "Action", 1996, 7.0, "https://image.tmdb.org/t/p/w500/ceG9VzoRAVGwivFU403Wc3AHRys.jpg", "Omenirea lupta impotriva unei invazii extraterestre masive.");
            add("Men in Black", "Action", 1997, 7.3, "https://image.tmdb.org/t/p/w500/uLOmOF5UI35u6.jpg", "Agenti secreti monitorizeaza activitatea extraterestra pe Pamant.");
            add("Bad Boys", "Action", 1995, 6.8, "https://image.tmdb.org/t/p/w500/x1y.jpg", "Doi politisti din Miami protejeaza un martor la crima.");
            add("Rush Hour", "Action", 1998, 7.0, "https://image.tmdb.org/t/p/w500/5M0j0B18abtBI5gi2RhfjjurTqb.jpg", "Doi politisti incompatibili fac echipa pentru a salva o fata.");
            add("Fast & Furious 5", "Action", 2011, 7.3, "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg", "Echipa lui Dom planuieste un jaf major in Rio.");
            add("The Equalizer", "Action", 2014, 7.2, "https://image.tmdb.org/t/p/w500/9uGHEgsiXBs.jpg", "Un barbat misterios face dreptate pentru cei neajutorati.");
            add("Nobody", "Action", 2021, 7.4, "https://image.tmdb.org/t/p/w500/oBgK5ndb.jpg", "Un tata subestimat isi dezvaluie trecutul violent.");
            add("Edge of Tomorrow", "Action", 2014, 7.9, "https://image.tmdb.org/t/p/w500/xjw5trH7.jpg", "Un soldat retraieste aceeasi zi de lupta mereu.");
            add("District 9", "Action", 2009, 7.9, "https://image.tmdb.org/t/p/w500/tuO.jpg", "Extraterestrii refugiati sunt segregati in Africa de Sud.");
            add("Baby Driver", "Action", 2017, 7.4, "https://image.tmdb.org/t/p/w500/rmnQ9jC.jpg", "Un sofer talentat incearca sa scape de viata criminala.");

            // --- COMEDY ---
            add("Superbad", "Comedy", 2007, 7.6, "https://image.tmdb.org/t/p/w500/ek8e8txUyUwd2Bnqj6lFEerJupq.jpg", "Trei liceeni incearca sa cumpere alcool pentru o petrecere.");
            add("The Hangover", "Comedy", 2009, 7.7, "https://image.tmdb.org/t/p/w500/ulNgX8kEl183mZqaKYiZ.jpg", "O petrecere a burlacilor in Vegas se termina dezastruos.");
            add("Dumb and Dumber", "Comedy", 1994, 7.3, "https://image.tmdb.org/t/p/w500/4LdpB6.jpg", "Doi prieteni prosti traverseaza tara pentru a returna o servieta.");
            add("Monty Python and the Holy Grail", "Comedy", 1975, 8.2, "https://image.tmdb.org/t/p/w500/bKPtXn9n4M4s8.jpg", "O parodie absurda a legendei Regelui Arthur.");
            add("Life of Brian", "Comedy", 1979, 8.0, "https://image.tmdb.org/t/p/w500/l.jpg", "Un barbat nascut in grajdul de langa Iisus este confundat.");
            add("Airplane!", "Comedy", 1980, 7.7, "https://image.tmdb.org/t/p/w500/z.jpg", "Pasagerii si echipajul unui avion sufera de toxiinfectie alimentara.");
            add("The Naked Gun", "Comedy", 1988, 7.6, "https://image.tmdb.org/t/p/w500/y.jpg", "Un politist incompetent incearca sa opreasca un asasinat.");
            add("Ace Ventura: Pet Detective", "Comedy", 1994, 6.9, "https://image.tmdb.org/t/p/w500/q.jpg", "Un detectiv de animale cauta mascota echipei Dolphins.");
            add("The Mask", "Comedy", 1994, 6.9, "https://image.tmdb.org/t/p/w500/x.jpg", "Un functionar devine un erou nebun datorita unei masti.");
            add("Liar Liar", "Comedy", 1997, 6.9, "https://image.tmdb.org/t/p/w500/v.jpg", "Un avocat nu poate minti timp de 24 de ore.");
            add("Mrs. Doubtfire", "Comedy", 1993, 7.1, "https://image.tmdb.org/t/p/w500/m.jpg", "Un tata se deghizeaza in bona pentru a-si vedea copiii.");
            add("Groundhog Day", "Comedy", 1993, 8.0, "https://image.tmdb.org/t/p/w500/g.jpg", "Un meteorolog traieste aceeasi zi la infinit.");
            add("Ghostbusters", "Comedy", 1984, 7.8, "https://image.tmdb.org/t/p/w500/7.jpg", "Trei parapsihologi deschid o afacere de prins fantome.");
            add("The Big Lebowski", "Comedy", 1998, 8.1, "https://image.tmdb.org/t/p/w500/9.jpg", "Un pierde-vara este confundat cu un milionar cu acelasi nume.");
            add("Office Space", "Comedy", 1999, 7.7, "https://image.tmdb.org/t/p/w500/o.jpg", "Trei angajati se revolta impotriva joburilor lor corporatiste.");
            add("Napoleon Dynamite", "Comedy", 2004, 6.9, "https://image.tmdb.org/t/p/w500/n.jpg", "Un adolescent ciudat ajuta un prieten sa castige alegerile.");
            add("Shaun of the Dead", "Comedy", 2004, 7.9, "https://image.tmdb.org/t/p/w500/s.jpg", "Un barbat incearca sa-si recupereze iubita in timpul apocalipsei zombie.");
            add("Hot Fuzz", "Comedy", 2007, 7.8, "https://image.tmdb.org/t/p/w500/h.jpg", "Un politist de top este transferat intr-un sat aparent linistit.");
            add("Tropic Thunder", "Comedy", 2008, 7.0, "https://image.tmdb.org/t/p/w500/t.jpg", "Actori de razboi ajung intr-un conflict real in jungla.");
            add("Zoolander", "Comedy", 2001, 6.5, "https://image.tmdb.org/t/p/w500/zoo.jpg", "Un manechin masculin este spalat pe creier sa ucida.");
            add("Meet the Parents", "Comedy", 2000, 7.0, "https://image.tmdb.org/t/p/w500/meet.jpg", "Un asistent medical isi cunoaste viitorul socru, fost agent CIA.");
            add("Borat", "Comedy", 2006, 7.3, "https://image.tmdb.org/t/p/w500/borat.jpg", "Un reporter kazah exploreaza cultura americana.");
            add("The 40-Year-Old Virgin", "Comedy", 2005, 7.1, "https://image.tmdb.org/t/p/w500/40.jpg", "Prietenii unui barbat incearca sa-l ajute sa-si piarda virginitatea.");
            add("Knocked Up", "Comedy", 2007, 7.0, "https://image.tmdb.org/t/p/w500/knock.jpg", "O aventura de o noapte duce la o sarcina neasteptata.");
            add("Mean Girls", "Comedy", 2004, 7.1, "https://image.tmdb.org/t/p/w500/mean.jpg", "O eleva noua intra in grupul fetelor populare din liceu.");
            add("Clueless", "Comedy", 1995, 6.9, "https://image.tmdb.org/t/p/w500/clue.jpg", "O fata bogata si populara face pe petitoarea in liceu.");
            add("Legally Blonde", "Comedy", 2001, 6.4, "https://image.tmdb.org/t/p/w500/leg.jpg", "O blonda se inscrie la Drept la Harvard pentru iubit.");
            add("21 Jump Street", "Comedy", 2012, 7.2, "https://image.tmdb.org/t/p/w500/21.jpg", "Doi politisti se infiltreaza sub acoperire intr-un liceu.");
            add("Neighbors", "Comedy", 2014, 6.3, "https://image.tmdb.org/t/p/w500/nei.jpg", "Un cuplu cu un bebelus intra in conflict cu fratia vecina.");
            add("Ted", "Comedy", 2012, 6.9, "https://image.tmdb.org/t/p/w500/ted.jpg", "Un ursulet de plus vorbitor ii strica viata proprietarului sau.");
            add("Horrible Bosses", "Comedy", 2011, 6.9, "https://image.tmdb.org/t/p/w500/boss.jpg", "Trei prieteni conspira sa-si ucida sefii abuzivi.");
            add("We're the Millers", "Comedy", 2013, 7.0, "https://image.tmdb.org/t/p/w500/mill.jpg", "O familie falsa face contrabanda cu droguri din Mexic.");
            add("Game Night", "Comedy", 2018, 6.8, "https://image.tmdb.org/t/p/w500/game.jpg", "O seara de jocuri devine un mister real cu rapiri.");
            add("Palm Springs", "Comedy", 2020, 7.3, "https://image.tmdb.org/t/p/w500/palm.jpg", "Doi invitati la nunta raman blocati intr-o bucla temporala.");
            add("Jojo Rabbit", "Comedy", 2019, 8.0, "https://image.tmdb.org/t/p/w500/jojo.jpg", "Un baiat din tineretul hitlerist descopera o evreica in pod.");
            add("The Grand Budapest Hotel", "Comedy", 2014, 8.1, "https://image.tmdb.org/t/p/w500/grand.jpg", "Aventurile unui concierge legendar la un hotel celebru.");
            add("School of Rock", "Comedy", 2003, 7.2, "https://image.tmdb.org/t/p/w500/school.jpg", "Un muzician ratat devine profesor suplinitor si formeaza o trupa.");
            add("Elf", "Comedy", 2003, 7.0, "https://image.tmdb.org/t/p/w500/elf.jpg", "Un om crescut de elfi cauta familia sa in New York.");
            add("Home Alone", "Comedy", 1990, 7.6, "https://image.tmdb.org/t/p/w500/home.jpg", "Un copil uitat acasa isi apara casa de hoti.");
            add("Ferris Bueller's Day Off", "Comedy", 1986, 7.8, "https://image.tmdb.org/t/p/w500/ferr.jpg", "Un licean chiuleste o zi pentru o aventura in Chicago.");
            add("Coming to America", "Comedy", 1988, 7.1, "https://image.tmdb.org/t/p/w500/com.jpg", "Un print african vine in Queens sa-si gaseasca sotie.");
            add("Crazy, Stupid, Love", "Comedy", 2011, 7.4, "https://image.tmdb.org/t/p/w500/craz.jpg", "Un barbat divortat reinvata sa agate femei.");
            add("Step Brothers", "Comedy", 2008, 6.9, "https://image.tmdb.org/t/p/w500/step.jpg", "Doi barbati maturi devin frati vitregi si rivali.");
            add("Anchorman", "Comedy", 2004, 7.1, "https://image.tmdb.org/t/p/w500/anch.jpg", "Un prezentator TV din anii '70 se simte amenintat de o femeie.");
            add("Bridesmaids", "Comedy", 2011, 6.8, "https://image.tmdb.org/t/p/w500/brid.jpg", "Competitia dintre domnisoarele de onoare distruge planurile de nunta.");
            add("Midnight in Paris", "Comedy", 2011, 7.7, "https://image.tmdb.org/t/p/w500/mid.jpg", "Un scriitor calatoreste in timp in Parisul anilor '20.");
            add("Paddington 2", "Comedy", 2017, 7.8, "https://image.tmdb.org/t/p/w500/padd.jpg", "Ursuletul Paddington este acuzat pe nedrept de furt.");
            add("Some Like It Hot", "Comedy", 1959, 8.2, "https://image.tmdb.org/t/p/w500/hot.jpg", "Doi muzicieni se deghizeaza in femei pentru a scapa de mafie.");
            add("Dr. Strangelove", "Comedy", 1964, 8.4, "https://image.tmdb.org/t/p/w500/dr.jpg", "O satira despre paranoia Razboiului Rece si razboiul nuclear.");
            add("Annie Hall", "Comedy", 1977, 8.0, "https://image.tmdb.org/t/p/w500/ann.jpg", "Povestea complicata a relatiei dintre un comedian si o cantareata.");

            // --- SCI-FI ---
            add("Star Wars: A New Hope", "Sci-Fi", 1977, 8.6, "https://image.tmdb.org/t/p/w500/6FfCtAuVAW42zPH3EdHs0OBukow.jpg", "Luke Skywalker se alatura luptei impotriva Imperiului Galactic.");
            add("Inception", "Sci-Fi", 2010, 8.8, "https://image.tmdb.org/t/p/w500/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg", "Hoti de vise intra in subconstientul unei tinte corporatiste.");
            add("Interstellar", "Sci-Fi", 2014, 8.6, "https://image.tmdb.org/t/p/w500/gEU2QniL6C8z1dY4uvReqETvDn.jpg", "Exploratori cauta o noua planeta pentru omenire prin gauri de vierme.");
            add("Blade Runner 2049", "Sci-Fi", 2017, 8.0, "https://image.tmdb.org/t/p/w500/gajva2L0rPYkEWjzgFlBXCAVBE5.jpg", "Un replicant descopera un secret care poate distruge societatea.");
            add("Alien", "Sci-Fi", 1979, 8.5, "https://image.tmdb.org/t/p/w500/vfrQk5IPloGg1v9Rzbh2Eg3VGyM.jpg", "Echipajul unei nave este vanat de o creatura extraterestra.");
            add("2001: A Space Odyssey", "Sci-Fi", 1968, 8.3, "https://image.tmdb.org/t/p/w500/zR6cO933lEUGk9A8M8gK1c1.jpg", "O misiune spatiala este sabotata de inteligenta artificiala HAL 9000.");
            add("Dune: Part One", "Sci-Fi", 2021, 8.2, "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg", "Paul Atreides trebuie sa salveze viitorul planetei desertice Arrakis.");
            add("Arrival", "Sci-Fi", 2016, 7.9, "https://image.tmdb.org/t/p/w500/pEFRzXtLmxYNjGd0XqJDHpGxv.jpg", "O lingvista incearca sa comunice cu extraterestrii care au aterizat.");
            add("Ex Machina", "Sci-Fi", 2014, 7.7, "https://image.tmdb.org/t/p/w500/dmdxpD8gJz.jpg", "Un programator testeaza constiinta unui robot umanoid seducator.");
            add("Back to the Future", "Sci-Fi", 1985, 8.5, "https://image.tmdb.org/t/p/w500/7lyBcpYB0t.jpg", "Un adolescent calatoreste accidental in 1955 intr-un DeLorean.");
            add("Avatar", "Sci-Fi", 2009, 7.5, "https://image.tmdb.org/t/p/w500/6EiRUJzFC.jpg", "Un marin paraplegic se infiltreaza in populatia nativa de pe Pandora.");
            add("The Martian", "Sci-Fi", 2015, 8.0, "https://image.tmdb.org/t/p/w500/5BHuvQ6p9.jpg", "Un astronaut abandonat pe Marte lupta sa supravietuiasca.");
            add("Gravity", "Sci-Fi", 2013, 7.2, "https://image.tmdb.org/t/p/w500/4p.jpg", "Doi astronauti plutesc in spatiu dupa distrugerea navetei.");
            add("Eternal Sunshine of the Spotless Mind", "Sci-Fi", 2004, 8.3, "https://image.tmdb.org/t/p/w500/5M.jpg", "Un cuplu isi sterge amintirile dureroase despre relatia lor.");
            add("Her", "Sci-Fi", 2013, 8.0, "https://image.tmdb.org/t/p/w500/e7.jpg", "Un scriitor singuratic se indragosteste de un sistem de operare.");
            add("Jurassic Park", "Sci-Fi", 1993, 8.2, "https://image.tmdb.org/t/p/w500/9i.jpg", "Dinozauri clonati scapa de sub control intr-un parc tematic.");
            add("E.T. the Extra-Terrestrial", "Sci-Fi", 1982, 7.9, "https://image.tmdb.org/t/p/w500/cB.jpg", "Un copil ajuta un extraterestru prietenos sa ajunga acasa.");
            add("The Fifth Element", "Sci-Fi", 1997, 7.7, "https://image.tmdb.org/t/p/w500/fP.jpg", "Un taximetrist si o fiinta suprema salveaza Pamantul.");
            add("12 Monkeys", "Sci-Fi", 1995, 8.0, "https://image.tmdb.org/t/p/w500/6.jpg", "Un condamnat este trimis in trecut sa opreasca un virus.");
            add("Minority Report", "Sci-Fi", 2002, 7.6, "https://image.tmdb.org/t/p/w500/cc.jpg", "Politia aresteaza criminalii inainte ca fapta sa fie comisa.");
            add("Gattaca", "Sci-Fi", 1997, 7.8, "https://image.tmdb.org/t/p/w500/ga.jpg", "Un barbat inferior genetic isi asuma identitatea altuia pentru a zbura.");
            add("Total Recall", "Sci-Fi", 1990, 7.5, "https://image.tmdb.org/t/p/w500/tr.jpg", "Un muncitor descopera ca amintirile sale sunt implantate.");
            add("Starship Troopers", "Sci-Fi", 1997, 7.3, "https://image.tmdb.org/t/p/w500/st.jpg", "Soldatii lupta impotriva unor insecte gigantice in spatiu.");
            add("The Thing", "Sci-Fi", 1982, 8.2, "https://image.tmdb.org/t/p/w500/tt.jpg", "Cercetatori in Antarctica sunt vanati de un extraterestru care isi schimba forma.");
            add("Donnie Darko", "Sci-Fi", 2001, 8.0, "https://image.tmdb.org/t/p/w500/dd.jpg", "Un adolescent are viziuni despre sfarsitul lumii.");
            add("A Clockwork Orange", "Sci-Fi", 1971, 8.3, "https://image.tmdb.org/t/p/w500/aco.jpg", "Un delincvent tanar este supus unui tratament experimental de reabilitare.");
            add("Planet of the Apes", "Sci-Fi", 1968, 8.0, "https://image.tmdb.org/t/p/w500/poa.jpg", "Un astronaut aterizeaza pe o planeta condusa de maimute inteligente.");
            add("Wall-E", "Sci-Fi", 2008, 8.4, "https://image.tmdb.org/t/p/w500/wal.jpg", "Un robot de salubritate se indragosteste si salveaza omenirea.");
            add("Akira", "Sci-Fi", 1988, 8.0, "https://image.tmdb.org/t/p/w500/ak.jpg", "Un motociclist capata puteri telekinetice in Neo-Tokyo.");
            add("Ghost in the Shell", "Sci-Fi", 1995, 8.0, "https://image.tmdb.org/t/p/w500/gis.jpg", "Un cyborg politist vaneaza un hacker periculos.");
            add("Looper", "Sci-Fi", 2012, 7.4, "https://image.tmdb.org/t/p/w500/lop.jpg", "Un asasin trebuie sa-si ucida propria versiune din viitor.");
            add("Source Code", "Sci-Fi", 2011, 7.5, "https://image.tmdb.org/t/p/w500/sc.jpg", "Un soldat retraieste ultimele 8 minute ale unui tren.");
            add("Moon", "Sci-Fi", 2009, 7.8, "https://image.tmdb.org/t/p/w500/mo.jpg", "Un astronaut singuratic pe Luna descopera un secret tulburator.");
            add("Sunshine", "Sci-Fi", 2007, 7.2, "https://image.tmdb.org/t/p/w500/sun.jpg", "O echipa incearca sa reaprinda soarele care moare.");
            add("Children of Men", "Sci-Fi", 2006, 7.9, "https://image.tmdb.org/t/p/w500/com.jpg", "Intr-o lume sterila, un barbat protejeaza singura femeie insarcinata.");
            add("Predestination", "Sci-Fi", 2014, 7.4, "https://image.tmdb.org/t/p/w500/pre.jpg", "Un agent temporal urmareste un criminal prin timp.");
            add("Contact", "Sci-Fi", 1997, 7.5, "https://image.tmdb.org/t/p/w500/con.jpg", "O cercetatoare primeste primul mesaj radio extraterestru.");
            add("War of the Worlds", "Sci-Fi", 2005, 6.5, "https://image.tmdb.org/t/p/w500/wow.jpg", "Un tata isi protejeaza copiii in timpul invaziei extraterestre.");
            add("Prometheus", "Sci-Fi", 2012, 7.0, "https://image.tmdb.org/t/p/w500/pro.jpg", "Cercetatori descopera originile omenirii, dar si o amenintare letala.");
            add("Oblivion", "Sci-Fi", 2013, 7.0, "https://image.tmdb.org/t/p/w500/obl.jpg", "Un reparator de drone descopera adevarul despre razboiul trecut.");
            add("Pacific Rim", "Sci-Fi", 2013, 6.9, "https://image.tmdb.org/t/p/w500/pac.jpg", "Roboti giganti pilotati de oameni lupta cu monstri marini.");
            add("Ready Player One", "Sci-Fi", 2018, 7.5, "https://image.tmdb.org/t/p/w500/rpo.jpg", "O vanatoare de comori intr-un univers de realitate virtuala.");
            add("Alita: Battle Angel", "Sci-Fi", 2019, 7.2, "https://image.tmdb.org/t/p/w500/alita.jpg", "Un cyborg reactivat isi redescopera trecutul de razboinic.");
            add("Tenet", "Sci-Fi", 2020, 7.3, "https://image.tmdb.org/t/p/w500/tenet.jpg", "Un agent manipuleaza curgerea timpului pentru a preveni razboiul.");
            add("Ad Astra", "Sci-Fi", 2019, 6.0, "https://image.tmdb.org/t/p/w500/ada.jpg", "Un astronaut calatoreste la marginea sistemului solar dupa tatal sau.");
            add("Annihilation", "Sci-Fi", 2018, 6.8, "https://image.tmdb.org/t/p/w500/ann.jpg", "Biologi exploreaza o zona misterioasa unde legile naturii nu se aplica.");
            add("Snowpiercer", "Sci-Fi", 2013, 7.1, "https://image.tmdb.org/t/p/w500/snow.jpg", "Supravietuitorii unei ere glaciare traiesc intr-un tren segregat.");
            add("Brazil", "Sci-Fi", 1985, 7.9, "https://image.tmdb.org/t/p/w500/bra.jpg", "Un birocrat viseaza sa evadeze dintr-o lume distopica absurda.");
            add("Metropolis", "Sci-Fi", 1927, 8.3, "https://image.tmdb.org/t/p/w500/met.jpg", "O distopie futurista despre diviziunea dintre muncitori si elita.");
            add("Stalker", "Sci-Fi", 1979, 8.1, "https://image.tmdb.org/t/p/w500/sta.jpg", "O calauza duce doi oameni intr-o zona misterioasa a dorintelor.");

            // --- DRAMA ---
            add("The Shawshank Redemption", "Drama", 1994, 9.3, "https://image.tmdb.org/t/p/w500/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg", "Doi detinuti leaga o prietenie profunda pe parcursul a 20 de ani.");
            add("The Godfather", "Drama", 1972, 9.2, "https://image.tmdb.org/t/p/w500/3bhkrj58Vtu7enYsRolD1fZdja1.jpg", "Ascensiunea unui fiu in imperiul mafiot al familiei sale.");
            add("Schindler's List", "Drama", 1993, 9.0, "https://image.tmdb.org/t/p/w500/sF1U4EUQS8YHUYjNl3pTXMYC5xg.jpg", "Un industrias german salveaza evrei in timpul Holocaustului.");
            add("Pulp Fiction", "Drama", 1994, 8.9, "https://image.tmdb.org/t/p/w500/d5iIlFn5s0ImszYzBPb8JPIfbXD.jpg", "Povestile intersectate ale unor criminali din Los Angeles.");
            add("Forrest Gump", "Drama", 1994, 8.8, "https://image.tmdb.org/t/p/w500/arw2vcBveWOVZr6pxd9XTd1TdQa.jpg", "Un barbat simplu influenteaza istoria moderna a Americii.");
            add("Fight Club", "Drama", 1999, 8.8, "https://image.tmdb.org/t/p/w500/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg", "Un insomniac si un vanzator de sapun fac un club subteran.");
            add("Parasite", "Drama", 2019, 8.5, "https://image.tmdb.org/t/p/w500/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg", "O familie saraca se infiltreaza in viata unei familii bogate.");
            add("Goodfellas", "Drama", 1990, 8.7, "https://image.tmdb.org/t/p/w500/aKuFiU82s5ISJpGZp7YkIr3kCUd.jpg", "Povestea ascensiunii si caderii unui asociat al mafiei.");
            add("One Flew Over the Cuckoo's Nest", "Drama", 1975, 8.7, "https://image.tmdb.org/t/p/w500/3jcbDmRFiQ83drXNOvRDeKHxS0C.jpg", "Un criminal simuleaza nebunia si se revolta in ospiciu.");
            add("12 Angry Men", "Drama", 1957, 9.0, "https://image.tmdb.org/t/p/w500/ppd84D2i9W8jXmsyInGyiU4zZT.jpg", "Un jurat incearca sa-i convinga pe ceilalti ca acuzatul e nevinovat.");
            add("City of God", "Drama", 2002, 8.6, "https://image.tmdb.org/t/p/w500/k7eYdW/+iY5Zt.jpg", "Viata violenta a tinerilor din favelele din Rio de Janeiro.");
            add("Life Is Beautiful", "Drama", 1997, 8.6, "https://image.tmdb.org/t/p/w500/mfnkSeeVOBVQRSQzPaWryqTwTw.jpg", "Un tata isi foloseste imaginatia pentru a proteja fiul in lagar.");
            add("The Green Mile", "Drama", 1999, 8.6, "https://image.tmdb.org/t/p/w500/velWPhVMQeQKcxggNEU8YmIo52R.jpg", "Paznicii inchisorii descopera un detinut cu puteri miraculoase.");
            add("The Pianist", "Drama", 2002, 8.5, "https://image.tmdb.org/t/p/w500/2hFvxCCWrTmCYwfy7uyDBT1CTR.jpg", "Supravietuirea unui pianist evreu in Varsovia ocupata.");
            add("Whiplash", "Drama", 2014, 8.5, "https://image.tmdb.org/t/p/w500/oIx56Ez1l.jpg", "Un baterist ambitios este impins la limita de un profesor abuziv.");
            add("The Prestige", "Drama", 2006, 8.5, "https://image.tmdb.org/t/p/w500/tC.jpg", "Doi magicieni rivali se lupta pentru suprematie si secrete.");
            add("Joker", "Drama", 2019, 8.1, "https://image.tmdb.org/t/p/w500/udDclJoHjfjb8EkGsdr7FD72CDE.jpg", "Un comediant ratat aluneca in nebunie si revolta.");
            add("Casablanca", "Drama", 1942, 8.5, "https://image.tmdb.org/t/p/w500/5K7cFA3ymlAiD1a.jpg", "Un proprietar de club reintalneste o veche iubire in razboi.");
            add("Citizen Kane", "Drama", 1941, 8.3, "https://image.tmdb.org/t/p/w500/sav0jxhQiH0bPr2IpCQf8u.jpg", "Moartea unui magnat de presa dezvaluie un mister.");
            add("American Beauty", "Drama", 1999, 8.3, "https://image.tmdb.org/t/p/w500/wby9315QzVKdW9BonAefg8jGTTj.jpg", "Un tata suburban in criza se indragosteste de prietena fiicei.");
            add("American History X", "Drama", 1998, 8.5, "https://image.tmdb.org/t/p/w500/c2gsmSQ2Cqv8zosqKOCwRS0GFBS.jpg", "Un fost neo-nazist incearca sa-si salveze fratele de ura.");
            add("The Intouchables", "Drama", 2011, 8.5, "https://image.tmdb.org/t/p/w500/1h.jpg", "Un aristocrat tetraplegic angajeaza un asistent din cartier.");
            add("Cinema Paradiso", "Drama", 1988, 8.5, "https://image.tmdb.org/t/p/w500/cp.jpg", "Un regizor isi aminteste copilaria si dragostea pentru filme.");
            add("The Lives of Others", "Drama", 2006, 8.4, "https://image.tmdb.org/t/p/w500/tlo.jpg", "Un agent Stasi spioneaza un cuplu de artisti in Berlinul de Est.");
            add("Requiem for a Dream", "Drama", 2000, 8.0, "https://image.tmdb.org/t/p/w500/req.jpg", "Patru vieti sunt distruse de dependenta de droguri.");
            add("A Beautiful Mind", "Drama", 2001, 8.2, "https://image.tmdb.org/t/p/w500/abm.jpg", "Un matematician genial se lupta cu schizofrenia.");
            add("Titanic", "Drama", 1997, 7.9, "https://image.tmdb.org/t/p/w500/9xjZS2rlVxm8SFx8kPC3aIGCOYQ.jpg", "O poveste de dragoste pe nava condamnata la scufundare.");
            add("The Notebook", "Drama", 2004, 7.9, "https://image.tmdb.org/t/p/w500/not.jpg", "Povestea de dragoste a unui cuplu, citita dintr-un jurnal.");
            add("La La Land", "Drama", 2016, 8.0, "https://image.tmdb.org/t/p/w500/uDO8zWDhfWz7xHVP96WDomkCpl.jpg", "Un muzician si o actrita se indragostesc in Los Angeles.");
            add("The Social Network", "Drama", 2010, 7.8, "https://image.tmdb.org/t/p/w500/n0yBibhJtQ5icDqTp8eA4.jpg", "Povestea fondarii Facebook si a proceselor care au urmat.");
            add("The Wolf of Wall Street", "Drama", 2013, 8.2, "https://image.tmdb.org/t/p/w500/pWHf4khOloNVfCxScsXSEj3I6.jpg", "Viata extravaganta a unui broker de bursa fraudulos.");
            add("The Irishman", "Drama", 2019, 7.8, "https://image.tmdb.org/t/p/w500/mbm8k3GFhXS0ROd9AD1gq.jpg", "Confesiunile unui asasin platit care a lucrat pentru Jimmy Hoffa.");
            add("Marriage Story", "Drama", 2019, 7.9, "https://image.tmdb.org/t/p/w500/pZekG6xabTj.jpg", "O privire dureroasa asupra unui divort si a custodiei copilului.");
            add("Room", "Drama", 2015, 8.1, "https://image.tmdb.org/t/p/w500/room.jpg", "O femeie si fiul ei scapa dupa ani de captivitate.");
            add("Spotlight", "Drama", 2015, 8.1, "https://image.tmdb.org/t/p/w500/spo.jpg", "Jurnalisti investigheaza abuzurile din Biserica Catolica.");
            add("Moonlight", "Drama", 2016, 7.4, "https://image.tmdb.org/t/p/w500/moon.jpg", "Maturizarea unui tanar de culoare in Miami.");
            add("12 Years a Slave", "Drama", 2013, 7.9, "https://image.tmdb.org/t/p/w500/12y.jpg", "Un om liber este rapit si vandut ca sclav in Sud.");
            add("Slumdog Millionaire", "Drama", 2008, 8.0, "https://image.tmdb.org/t/p/w500/slum.jpg", "Un orfan din Mumbai castiga la 'Vrei sa fii milionar?'.");
            add("Gran Torino", "Drama", 2008, 8.1, "https://image.tmdb.org/t/p/w500/gran.jpg", "Un veteran morocanos se imprieteneste cu vecinii sai imigranti.");
            add("No Country for Old Men", "Drama", 2007, 8.2, "https://image.tmdb.org/t/p/w500/bj1v6YC3.jpg", "Un vanator gaseste banii unui drog, fiind urmarit de un asasin.");
            add("There Will Be Blood", "Drama", 2007, 8.2, "https://image.tmdb.org/t/p/w500/twbb.jpg", "Ambitia unui petrolist il costa familia si sanatatea mintala.");
            add("Her", "Drama", 2013, 8.0, "https://image.tmdb.org/t/p/w500/her2.jpg", "Un scriitor dezvolta o relatie cu un sistem de operare.");
            add("Dallas Buyers Club", "Drama", 2013, 8.0, "https://image.tmdb.org/t/p/w500/dal.jpg", "Un pacient cu SIDA face contrabanda cu medicamente neaprobate.");
            add("Manchester by the Sea", "Drama", 2016, 7.8, "https://image.tmdb.org/t/p/w500/man.jpg", "Un unchi reticent trebuie sa aiba grija de nepotul sau.");
            add("Three Billboards Outside Ebbing, Missouri", "Drama", 2017, 8.1, "https://image.tmdb.org/t/p/w500/3bb.jpg", "O mama provoaca politia sa rezolve crima fiicei sale.");
            add("Green Book", "Drama", 2018, 8.2, "https://image.tmdb.org/t/p/w500/gb.jpg", "Un bodyguard italian conduce un pianist afro-american in turneu.");
            add("Bohemian Rhapsody", "Drama", 2018, 8.0, "https://image.tmdb.org/t/p/w500/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg", "Povestea trupei Queen si a solistului Freddie Mercury.");
            add("A Star Is Born", "Drama", 2018, 7.5, "https://image.tmdb.org/t/p/w500/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg", "Un muzician consacrat ajuta o tanara cantareata sa devina celebra.");
            add("Jojo Rabbit", "Drama", 2019, 8.0, "https://image.tmdb.org/t/p/w500/7GsM4mtM0worCtIVeiQt28HieeN.jpg", "O satira despre fanatism si razboi vazuta prin ochii unui copil.");
            add("Ford v Ferrari", "Drama", 2019, 8.0, "https://image.tmdb.org/t/p/w500/6ApDtO7xaWAfPqfi65vzX63enJj.jpg", "Ford construieste o masina pentru a invinge Ferrari la Le Mans.");

            // --- HORROR ---
            add("The Exorcist", "Horror", 1973, 8.0, "https://image.tmdb.org/t/p/w500/4ucLGcXVVSVnsfkGtbJ4xaVGSsw.jpg", "O fata de 12 ani este posedata de o entitate misterioasa.");
            add("The Shining", "Horror", 1980, 8.4, "https://image.tmdb.org/t/p/w500/b4gY5LI4BZFt2b6lra8tvj5xSix.jpg", "O familie se muta intr-un hotel izolat pentru iarna.");
            add("Psycho", "Horror", 1960, 8.5, "https://image.tmdb.org/t/p/w500/81d8oyEFgj7Z5QKiBhevYkfzOG.jpg", "O secretara fura bani si se cazeaza la un motel dubios.");
            add("Alien", "Horror", 1979, 8.4, "https://image.tmdb.org/t/p/w500/vfrQk5IPloGg1v9Rzbh2Eg3VGyM.jpg", "Echipajul unei nave spatiale este vanat de o creatura.");
            add("Get Out", "Horror", 2017, 7.7, "https://image.tmdb.org/t/p/w500/tFXcEccSQMf3lfhfXKSU9iRBpa3.jpg", "Un tanar afro-american viziteaza familia iubitei sale albe.");
            add("Hereditary", "Horror", 2018, 7.2, "https://image.tmdb.org/t/p/w500/p9fopC3k12aKling2Jue4yIuytp.jpg", "O familie este bantuita dupa moartea bunicii.");
            add("A Nightmare on Elm Street", "Horror", 1984, 7.3, "https://image.tmdb.org/t/p/w500/wETzI0X786pL5w7dM3x4YxQhE6c.jpg", "Freddy Krueger vaneaza adolescenti in visele lor.");
            add("Halloween", "Horror", 1978, 7.7, "https://image.tmdb.org/t/p/w500/ha6K8U5v5K6Iq3u5g5v5w5v5.jpg", "Michael Myers evadeaza si se intoarce in Haddonfield.");
            add("The Conjuring", "Horror", 2013, 7.5, "https://image.tmdb.org/t/p/w500/wVYREutTvI2tmxr6tuqCYHqJFHL.jpg", "Investigatori paranormali ajuta o familie terorizata.");
            add("It", "Horror", 2017, 7.3, "https://image.tmdb.org/t/p/w500/9E2y5Q7WlCVNEhP5GiVTJhEhx1o.jpg", "Un grup de copii se lupta cu un clovn demonic.");
            add("The Silence of the Lambs", "Horror", 1991, 8.6, "https://image.tmdb.org/t/p/w500/uS9m8OBk1A8eM9I042bx8XVr1VC.jpg", "Un agent FBI cere ajutorul unui canibal incarcerat.");
            add("Saw", "Horror", 2004, 7.4, "https://image.tmdb.org/t/p/w500/dH8lF88swG4c1W8p0e2a2.jpg", "Doi barbati se trezesc intr-un joc mortal.");
            add("Scream", "Horror", 1996, 7.3, "https://image.tmdb.org/t/p/w500/p1W0dK1X1.jpg", "Un criminal mascat terorizeaza un grup de liceeni.");
            add("Poltergeist", "Horror", 1982, 7.3, "https://image.tmdb.org/t/p/w500/z6D9.jpg", "O familie este bantuita de fantome in noua lor casa.");
            add("The Thing", "Horror", 1982, 8.2, "https://image.tmdb.org/t/p/w500/tzGY49kseSE9QAKkAd1u2.jpg", "Cercetatori in Antarctica descopera o forma de viata extraterestra.");
            add("Midsommar", "Horror", 2019, 7.1, "https://image.tmdb.org/t/p/w500/7LEI8ulZzO5gy9Ww2NjoUbW4Vfa.jpg", "Un cuplu participa la un festival suedez bizar.");
            add("Us", "Horror", 2019, 7.0, "https://image.tmdb.org/t/p/w500/ux2dU1jQ2ACIMShzB3yP93F96pM.jpg", "O familie este atacata de doppelgangerii lor.");
            add("A Quiet Place", "Horror", 2018, 7.4, "https://image.tmdb.org/t/p/w500/nJDqeD.jpg", "O familie trebuie sa traiasca in liniste absoluta.");
            add("The Ring", "Horror", 2002, 7.1, "https://image.tmdb.org/t/p/w500/z1dM.jpg", "O caseta video blestemata ucide privitorul in 7 zile.");
            add("Insidious", "Horror", 2010, 6.8, "https://image.tmdb.org/t/p/w500/9h1e.jpg", "O familie incearca sa previna spiritele rele sa le ia copilul.");
            add("The Texas Chain Saw Massacre", "Horror", 1974, 7.4, "https://image.tmdb.org/t/p/w500/sF.jpg", "Cinci prieteni sunt vanati de o familie de canibali.");
            add("Rosemary's Baby", "Horror", 1968, 8.0, "https://image.tmdb.org/t/p/w500/b.jpg", "O femeie suspecteaza ca vecinii ei au planuri sinistre.");
            add("Carrie", "Horror", 1976, 7.2, "https://image.tmdb.org/t/p/w500/9.jpg", "O fata timida cu puteri telekinetice se razbuna.");
            add("It Follows", "Horror", 2014, 6.8, "https://image.tmdb.org/t/p/w500/4.jpg", "O entitate supranaturala urmareste victima.");
            add("The Babadook", "Horror", 2014, 6.9, "https://image.tmdb.org/t/p/w500/k.jpg", "O mama si fiul ei sunt bantuiti de un monstru din carti.");
            add("Sinister", "Horror", 2012, 6.8, "https://image.tmdb.org/t/p/w500/8.jpg", "Un scriitor descopera filme snuff in noua sa casa.");
            add("28 Days Later", "Horror", 2002, 7.2, "https://image.tmdb.org/t/p/w500/w.jpg", "Un virus transforma oamenii in ucigasi furiosi.");
            add("The Witch", "Horror", 2015, 6.9, "https://image.tmdb.org/t/p/w500/7.jpg", "O familie din 1630 este sfasiata de vrajitorie.");
            add("Train to Busan", "Horror", 2016, 7.8, "https://image.tmdb.org/t/p/w500/3.jpg", "Pasagerii unui tren lupta sa supravietuiasca unei epidemii zombie.");
            add("Paranormal Activity", "Horror", 2007, 6.3, "https://image.tmdb.org/t/p/w500/j.jpg", "Un cuplu instaleaza camere pentru a surprinde fenomene.");
            add("The Blair Witch Project", "Horror", 1999, 6.4, "https://image.tmdb.org/t/p/w500/2.jpg", "Trei studenti dispar intr-o padure bantuita.");
            add("Dracula", "Horror", 1931, 7.5, "https://image.tmdb.org/t/p/w500/5.jpg", "Contele Dracula ajunge la Londra.");
            add("Frankenstein", "Horror", 1931, 7.8, "https://image.tmdb.org/t/p/w500/1.jpg", "Un om de stiinta creeaza un monstru din cadavre.");
            add("The Birds", "Horror", 1963, 7.6, "https://image.tmdb.org/t/p/w500/l.jpg", "Pasarile dintr-un oras mic incep sa atace oamenii.");
            add("Misery", "Horror", 1990, 7.8, "https://image.tmdb.org/t/p/w500/2.jpg", "Un scriitor este tinut captiv de fana lui numarul unu.");
            add("Jaws", "Horror", 1975, 8.0, "https://image.tmdb.org/t/p/w500/s.jpg", "Un rechin urias terorizeaza o plaja.");
            add("The Omen", "Horror", 1976, 7.5, "https://image.tmdb.org/t/p/w500/t.jpg", "Un ambasador realizeaza ca fiul sau ar putea fi Antihristul.");
            add("Suspiria", "Horror", 1977, 7.3, "https://image.tmdb.org/t/p/w500/5.jpg", "O balerina descopera secretele unei scoli de dans.");
            add("Dawn of the Dead", "Horror", 1978, 7.9, "https://image.tmdb.org/t/p/w500/r.jpg", "Supravietuitorii unei apocalipse zombie se ascund intr-un mall.");
            add("Evil Dead II", "Horror", 1987, 7.7, "https://image.tmdb.org/t/p/w500/1.jpg", "Ash Williams se lupta cu demonii intr-o cabana.");
            add("Candyman", "Horror", 1992, 6.7, "https://image.tmdb.org/t/p/w500/n.jpg", "Un spirit ucigas apare daca ii spui numele de 5 ori.");
            add("Hellraiser", "Horror", 1987, 6.9, "https://image.tmdb.org/t/p/w500/3.jpg", "O cutie puzzle deschide o poarta catre iad.");
            add("Child's Play", "Horror", 1988, 6.7, "https://image.tmdb.org/t/p/w500/2.jpg", "O papusa este posedata de sufletul unui criminal.");
            add("The Cabin in the Woods", "Horror", 2011, 7.0, "https://image.tmdb.org/t/p/w500/d.jpg", "Cinci prieteni merg la o cabana izolata.");
            add("Don't Breathe", "Horror", 2016, 7.5, "https://image.tmdb.org/t/p/w500/2.jpg", "Hoti intra in casa unui orb bogat.");
            add("Rec", "Horror", 2007, 7.4, "https://image.tmdb.org/t/p/w500/l.jpg", "Un reporter este blocat intr-o cladire cu un virus.");
            add("Annabelle", "Horror", 2014, 5.7, "https://image.tmdb.org/t/p/w500/y.jpg", "O papusa posedata terorizeaza un cuplu.");
            add("The Nun", "Horror", 2018, 5.9, "https://image.tmdb.org/t/p/w500/s.jpg", "Un preot investigheaza sinuciderea unei maicute.");
            add("Smile", "Horror", 2022, 6.8, "https://image.tmdb.org/t/p/w500/a.jpg", "O doctorita este urmarita de o entitate zambitoare.");
            add("Barbarian", "Horror", 2022, 6.9, "https://image.tmdb.org/t/p/w500/k.jpg", "O femeie descopera secretele casei inchiriate.");

            // --- DOCUMENTARY ---
            add("Planet Earth II", "Documentary", 2016, 9.5, "https://image.tmdb.org/t/p/w500/7f53X211i85t0n40r3N0r5.jpg", "David Attenborough nareaza minunile naturale ale Pamantului.");
            add("The Last Dance", "Documentary", 2020, 9.0, "https://image.tmdb.org/t/p/w500/oMq33j1231.jpg", "Ascensiunea lui Michael Jordan si a echipei Chicago Bulls.");
            add("Cosmos: A Spacetime Odyssey", "Documentary", 2014, 9.3, "https://image.tmdb.org/t/p/w500/4W1.jpg", "Neil deGrasse Tyson exploreaza universul.");
            add("13th", "Documentary", 2016, 8.2, "https://image.tmdb.org/t/p/w500/tcN.jpg", "Analiza a sistemului de inchisori din SUA.");
            add("My Octopus Teacher", "Documentary", 2020, 8.1, "https://image.tmdb.org/t/p/w500/u6.jpg", "Un cineast leaga o prietenie neobisnuita cu o caracatita.");
            add("Free Solo", "Documentary", 2018, 8.0, "https://image.tmdb.org/t/p/w500/v4.jpg", "Alex Honnold escaladeaza El Capitan fara franghii.");
            add("Senna", "Documentary", 2010, 8.4, "https://image.tmdb.org/t/p/w500/1.jpg", "Povestea legendei Formula 1, Ayrton Senna.");
            add("Amy", "Documentary", 2015, 7.9, "https://image.tmdb.org/t/p/w500/2.jpg", "Viata si moartea cantaretei Amy Winehouse.");
            add("Won't You Be My Neighbor?", "Documentary", 2018, 8.2, "https://image.tmdb.org/t/p/w500/a.jpg", "Portretul lui Fred Rogers, gazda iubita de copii.");
            add("Blackfish", "Documentary", 2013, 8.0, "https://image.tmdb.org/t/p/w500/d.jpg", "Controversa balenelor ucigase in captivitate.");
            add("March of the Penguins", "Documentary", 2005, 7.5, "https://image.tmdb.org/t/p/w500/q.jpg", "Pinguinii imperiali in calatoria lor anuala.");
            add("Super Size Me", "Documentary", 2004, 7.2, "https://image.tmdb.org/t/p/w500/2.jpg", "Un experiment de a manca doar McDonald's o luna.");
            add("Bowling for Columbine", "Documentary", 2002, 7.9, "https://image.tmdb.org/t/p/w500/4.jpg", "Michael Moore investigheaza violenta armata.");
            add("Fahrenheit 9/11", "Documentary", 2004, 7.3, "https://image.tmdb.org/t/p/w500/g.jpg", "Viziunea critica asupra presedintiei lui George W. Bush.");
            add("An Inconvenient Truth", "Documentary", 2006, 7.3, "https://image.tmdb.org/t/p/w500/i.jpg", "Al Gore despre incalzirea globala.");
            add("Inside Job", "Documentary", 2010, 8.2, "https://image.tmdb.org/t/p/w500/7.jpg", "Analiza crizei financiara din 2008.");
            add("Man on Wire", "Documentary", 2008, 7.7, "https://image.tmdb.org/t/p/w500/y.jpg", "Mersul pe sarma intre Turnurile Gemene.");
            add("Grizzly Man", "Documentary", 2005, 7.8, "https://image.tmdb.org/t/p/w500/3.jpg", "Viata si moartea activistului Timothy Treadwell.");
            add("The Social Dilemma", "Documentary", 2020, 7.5, "https://image.tmdb.org/t/p/w500/j.jpg", "Impactul periculos al retelelor sociale.");
            add("Icarus", "Documentary", 2017, 7.9, "https://image.tmdb.org/t/p/w500/e.jpg", "Scandalul dopajului in sportul rusesc.");
            add("Searching for Sugar Man", "Documentary", 2012, 8.2, "https://image.tmdb.org/t/p/w500/x.jpg", "Doi fani cauta un muzician disparut.");
            add("Apollo 11", "Documentary", 2019, 8.1, "https://image.tmdb.org/t/p/w500/1.jpg", "Misiunea istorica de aselenizare din 1969.");
            add("They Shall Not Grow Old", "Documentary", 2018, 8.2, "https://image.tmdb.org/t/p/w500/z.jpg", "Imagini restaurate din Primul Razboi Mondial.");
            add("Jiro Dreams of Sushi", "Documentary", 2011, 7.8, "https://image.tmdb.org/t/p/w500/p.jpg", "Un maestru bucatar de sushi de 85 de ani.");
            add("O.J.: Made in America", "Documentary", 2016, 8.9, "https://image.tmdb.org/t/p/w500/l.jpg", "Ascensiunea si decaderea lui O.J. Simpson.");
            add("Shoah", "Documentary", 1985, 8.7, "https://image.tmdb.org/t/p/w500/w.jpg", "Marturii despre Holocaust.");
            add("Night and Fog", "Documentary", 1956, 8.6, "https://image.tmdb.org/t/p/w500/q.jpg", "Documentary scurt despre lagarele de concentrare.");
            add("The Act of Killing", "Documentary", 2012, 8.1, "https://image.tmdb.org/t/p/w500/2.jpg", "Liderii indonezieni isi recreeaza crimele.");
            add("Exit Through the Gift Shop", "Documentary", 2010, 7.9, "https://image.tmdb.org/t/p/w500/d.jpg", "Lumea artei stradale si Banksy.");
            add("Hoop Dreams", "Documentary", 1994, 8.1, "https://image.tmdb.org/t/p/w500/s.jpg", "Doi tineri viseaza sa ajunga in NBA.");
            add("Dear Zachary", "Documentary", 2008, 8.5, "https://image.tmdb.org/t/p/w500/3.jpg", "O scrisoare catre un fiu despre tatal sau ucis.");
            add("Citizenfour", "Documentary", 2014, 8.0, "https://image.tmdb.org/t/p/w500/2.jpg", "Edward Snowden si spionajul NSA.");
            add("Food, Inc.", "Documentary", 2008, 7.7, "https://image.tmdb.org/t/p/w500/l.jpg", "Adevarul despre industria alimentara americana.");
            add("Before the Flood", "Documentary", 2016, 7.6, "https://image.tmdb.org/t/p/w500/y.jpg", "Leonardo DiCaprio despre schimbarile climatice.");
            add("The Imposter", "Documentary", 2012, 7.5, "https://image.tmdb.org/t/p/w500/1.jpg", "Un tanar pretinde ca este un copil disparut.");
            add("Three Identical Strangers", "Documentary", 2018, 7.6, "https://image.tmdb.org/t/p/w500/5.jpg", "Tripleti separati la nastere se regasesc.");
            add("Fyre", "Documentary", 2019, 7.2, "https://image.tmdb.org/t/p/w500/g.jpg", "Cel mai mare esec de festival muzical.");
            add("The Tinder Swindler", "Documentary", 2022, 7.1, "https://image.tmdb.org/t/p/w500/i.jpg", "Un escroc seduce femei pe Tinder.");
            add("Seaspiracy", "Documentary", 2021, 8.1, "https://image.tmdb.org/t/p/w500/p.jpg", "Impactul pescuitului industrial asupra oceanelor.");
            add("Cowspiracy", "Documentary", 2014, 8.1, "https://image.tmdb.org/t/p/w500/4.jpg", "Impactul agriculturii animale asupra mediului.");
            add("American Factory", "Documentary", 2019, 7.4, "https://image.tmdb.org/t/p/w500/9.jpg", "Conflict cultural intr-o fabrica din Ohio.");
            add("Making a Murderer", "Documentary", 2015, 8.5, "https://image.tmdb.org/t/p/w500/j.jpg", "Povestea lui Steven Avery.");
            add("Wild Wild Country", "Documentary", 2018, 8.1, "https://image.tmdb.org/t/p/w500/h.jpg", "Un guru indian construieste un oras in Oregon.");
            add("Tiger King", "Documentary", 2020, 7.5, "https://image.tmdb.org/t/p/w500/k.jpg", "Lumea bizara a crescatorilor de feline mari.");
            add("Don't F**k with Cats", "Documentary", 2019, 8.0, "https://image.tmdb.org/t/p/w500/2.jpg", "Internetul vaneaza un ucigas de animale.");
            add("The Great Hack", "Documentary", 2019, 7.0, "https://image.tmdb.org/t/p/w500/l.jpg", "Scandalul Cambridge Analytica.");
            add("Virunga", "Documentary", 2014, 8.2, "https://image.tmdb.org/t/p/w500/4.jpg", "Protejarea gorilelor de munte din Congo.");
            add("Honeyland", "Documentary", 2019, 8.0, "https://image.tmdb.org/t/p/w500/t.jpg", "Ultima femeie apicultor salbatic din Europa.");
            add("Fire of Love", "Documentary", 2022, 7.6, "https://image.tmdb.org/t/p/w500/z.jpg", "Doi vulcanologi care s-au iubit si au murit impreuna.");
            add("Navalny", "Documentary", 2022, 7.7, "https://image.tmdb.org/t/p/w500/u.jpg", "Investigatia otravirii liderului opozitiei ruse.");

            System.out.println("--- POPULARE COMPLETA ---");
        }
    }

    // Metoda de adaugare care incearca sa gaseasca posterul oficial prin TMDB,
    // iar daca esueaza, foloseste link-ul de rezerva (fallback) furnizat manual.
    private void add(String titlu, String gen, int an, Double imdbRating, String oldUrl, String desc) {

        // 1. Incercam sa gasim URL-ul real pe TMDB
        String realPosterUrl = tmdbService.getPosterUrl(titlu);

        // 2. Daca TMDB nu gaseste (sau da eroare), folosim url-ul vechi ca rezerva
        if (realPosterUrl == null) {
            System.out.println("Nu am gasit poster pentru: " + titlu + ". Folosesc imaginea de rezerva.");
            realPosterUrl = oldUrl;
        }

        // 3. Salvam filmul in baza de date
        Film f = new Film(titlu, gen, an, null, imdbRating, realPosterUrl, desc, "Nevazut");
        filmService.saveFilm(f);

        // 4. Mica pauza pentru a nu suprasolicita API-ul extern (Rate Limiting)
        try { Thread.sleep(100); } catch (InterruptedException e) {}
    }
}