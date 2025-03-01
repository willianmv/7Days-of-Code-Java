package SevenDaysOfcode.api;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class OmdbRequest {

    public static String findMoviesOrSeries(String pesquisa, String tipo){
        String apiKey = "<Insira aqui a sua chave da OMDB API>";
        String pesquisaCodificada = URLEncoder.encode(pesquisa, StandardCharsets.UTF_8);
        String url = "http://www.omdbapi.com/?s="+ pesquisaCodificada +"&type="+ tipo +"&apikey=" + apiKey +"&page=1";

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("-- STATUS CODE DA REQUISIÇÃO: "+response.statusCode()+"\n");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------\n");

            if(response.statusCode() == 200){
                return response.body();
            }

        } catch (Exception e) {
            System.out.println("-- ERRO: "+e.getMessage());
        }
        return "";
    }







}
