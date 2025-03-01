package SevenDaysOfcode.entity;

public class Production {

    private String title;
    private String year;
    private String imdbID;
    private String type;
    private String poster;

    public Production(String title, String year, String imdbID, String type, String poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }

    @Override
    public String toString() {
        return String.format("--- Produção Audiovisual ---" +
                "\nTítulo: %s" +
                "\nAno: %s" +
                "\nImdbID: %s" +
                "\nTipo: %s" +
                "\nConfira o poster aqui: %s" +
                "\n-------------------------------------------------------------------------------------------------------------------------------------",
                this.title, this.year, this.imdbID, this.type, this.poster);
    }
}
