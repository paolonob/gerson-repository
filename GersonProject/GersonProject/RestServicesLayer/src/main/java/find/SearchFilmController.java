package find;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pnm.dataLayer.entities.Film;
import com.pnm.dataLayer.repositories.FilmRepository;
import com.pnm.logicLayer.components.services.FilmManager;

@RestController
public class SearchFilmController {

	private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();
    
    private FilmManager filmManager;
    
    @Autowired
    public void setFilmManager(FilmManager filmManager) {
		this.filmManager = filmManager;
	}

	@RequestMapping("/searchFilm")
    public List<SearchFilm> searchFilm(@RequestParam(value="ricerca", defaultValue="World") String ricerca) {
    	
		List<SearchFilm> list = new ArrayList<SearchFilm>();
    	List<Film> listFilm = filmManager.searchByTitle(ricerca);
    	
    	for (int i = 0; i < listFilm.size(); i++) {
    		Film filmR = listFilm.get(i);
    		SearchFilm film = new SearchFilm(filmR.getId(), filmR.getTitle());
			list.add(film);
		}
    	
    	return list;
    	
//        return new SearchFilm(counter.incrementAndGet(), String.format(template, ricerca));
    	
    }
	
}
