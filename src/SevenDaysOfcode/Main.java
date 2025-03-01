package SevenDaysOfcode;

import SevenDaysOfcode.extractor.ProductionExtractor;
import SevenDaysOfcode.entity.Production;
import SevenDaysOfcode.generator.HTMLGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static SevenDaysOfcode.api.OmdbRequest.findMoviesOrSeries;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final ProductionExtractor productionExtractor = new ProductionExtractor();
    private static int escolha = -1;
    private static String titulo = "";
    private  static int op = -1;


    public static void main(String[] args) {

        while(op!=0){
            System.out.println("""
                    =====================================
                    | 1 - PESQUISAR POR FILMES E SÉRIES |
                    | 2 - GERAR HTML DE FILMES E SÉRIES |
                    | 0 - SAIR ........................ |
                    =====================================
                    """);

            op = inputIntNumber(op, 0 , 2, "-- ESCOLHA UMA DAS OPÇÕES ACIMA: ");
            switch (op){
                case 1:
                    mostrarResultados();
                    break;
                case 2:
                    gerarHTML();
                    break;
                case 0:
                    System.out.println("-- SAINDO...");
                    System.exit(0);
            }
        }
    }

    public  static void gerarHTML(){
        try (FileWriter fw = new FileWriter("html-gerado/productions.html", false);
             PrintWriter write  = new PrintWriter(fw)){

            HTMLGenerator htmlGenerator = new HTMLGenerator(write);
            htmlGenerator.generateHTMLPage(pesquisarPorProducoes());

            System.out.println("-- HTML GERADO COM SUCESSO - VERIFICAR NA PASTA 'html-gerado' \n");

        } catch (IOException e) {
            System.out.println("--ERRO AO CRIAR O ARQUIVO HTML: "+e.getMessage());
        }
    }

    public static void mostrarResultados(){
        pesquisarPorProducoes().forEach(System.out::println);
    }

    public static List<Production> pesquisarPorProducoes() {
        List<Production> resultsFound = new ArrayList<>();
        escolha = inputIntNumber(escolha, 1, 2, "-- DIGITE 1 PARA FILMES OU 2 PARA SÉRIES: ");
        sc.nextLine();
        titulo = inputTitulo();

        String moveOrSeries = (escolha==1) ? "movie" : "series" ;
        String moviesOrSeriesJson = findMoviesOrSeries(titulo, moveOrSeries);

        resultsFound = productionExtractor.getObjects(moviesOrSeriesJson);
        return resultsFound;
    }

    private static int inputIntNumber(int input, int menorOpc, int maiorOpc, String msgInput){
        while (true){
            System.out.print(msgInput);
            try{
                input = sc.nextInt();
                if(input < menorOpc || input > maiorOpc){
                    System.out.println("-- INSIRA UM VALOR VÁLIDO");
                } else {
                    return input;
                }

            }catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("-- INSIRA SOMENTE NÚMEROS INTEIROS");
            }
        }
    }

    private static String inputTitulo(){
        while (true){
            System.out.print("-- DIGITE O TITULO DA PRODUÇÃO QUE DESEJA ENCONTRAR: ");
            titulo = sc.nextLine();;
            if(titulo.trim().isEmpty()){
                System.out.println("-- O TÍTULO NÃO PODE SER VAZIO");
            } else{
                return titulo;
            }
        }
    }


}
