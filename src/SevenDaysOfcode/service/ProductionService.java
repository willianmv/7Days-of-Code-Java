package SevenDaysOfcode.service;

import SevenDaysOfcode.api.OmdbApiClient;
import SevenDaysOfcode.entity.Production;
import SevenDaysOfcode.extractor.ProductionJsonExtractor;
import SevenDaysOfcode.generator.HTMLGenerator;
import SevenDaysOfcode.utils.InputUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ProductionService {

    private final OmdbApiClient omdbApiClient = new OmdbApiClient("-> insira sua chave da omdb api nesse construtor <-");
    private final ProductionJsonExtractor productionJsonExtractor = new ProductionJsonExtractor();
    private final InputUtils inputUtils = new InputUtils();
    private final Scanner sc = new Scanner(System.in);
    private int escolha = -1;
    private String titulo;

    public void generateHtml(){
        try(FileWriter fw = new FileWriter("html-gerado/productions.html", false);
            PrintWriter writer = new PrintWriter(fw)){

            HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
            htmlGenerator.generateHTMLPage(searchProductions());

            System.out.println("-- PÁGINA GERADA COM SUCESSO: VERIFIQUE NA PASTA 'html-gerado'\n");


        }catch (IOException e){
            System.out.println("--ERRO AO CRIAR O ARQUIVO HTML: "+e.getMessage());
        }
    }

    public void showResults(){
        List<Production> productions = searchProductions();
        productions.forEach(System.out::println);
    }

    private List<Production> searchProductions(){
        escolha = inputUtils.inputIntegerNumber(escolha, 1, 2, "-- DIGITE 1 PARA FILMES OU 2 PARA SÉRIES: ");
        titulo = inputUtils.inputTitulo(titulo, "-- DIGITE O TITULO DA PRODUÇÃO QUE DESEJA ENCONTRAR: ");

        String movieOrSeries = (escolha==1) ? "movie" : "series" ;
        String moviesOrSeriesJson = omdbApiClient.findMoviesOrSeries(titulo, movieOrSeries);

        return productionJsonExtractor.getObjects(moviesOrSeriesJson);
    }



}
