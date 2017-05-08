package find;

public class SearchFilm {
	
	private final long id;
    private final String title;
    
    public SearchFilm(long id, String title) {
        this.id = id;
        this.title = title;
    }
    
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}

}
