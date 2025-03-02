package SevenDaysOfcode.entity;

public record Production(String title, String year, String imdbID, String type, String poster) {

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
