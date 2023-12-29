package application;

public class Film {

    private int filmId;
    private  String filmName;
    private  int filmYear;
    private String filmLang;
    private int filmRating;

    public Film() {
    }

    public Film(String filmName, int filmYear, String filmLang, int filmRating) {
        this.filmName = filmName;
        this.filmYear = filmYear;
        this.filmLang = filmLang;
        this.filmRating = filmRating;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(int filmYear) {
        this.filmYear = filmYear;
    }

    public String getFilmLang() {
        return filmLang;
    }

    public void setFilmLang(String filmLang) {
        this.filmLang = filmLang;
    }

    public int getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(int filmRating) {
        this.filmRating = filmRating;
    }
}
