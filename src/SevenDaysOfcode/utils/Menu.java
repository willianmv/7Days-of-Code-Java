package SevenDaysOfcode.utils;

import SevenDaysOfcode.service.ProductionService;

public class Menu {

    private final InputUtils inputUtils = new InputUtils();
    private final ProductionService productionService = new ProductionService();

    public void iniciar(){

        int op = -1;

        while(true){
            System.out.println("""
                    =====================================
                    | 1 - PESQUISAR POR FILMES E SÉRIES |
                    | 2 - GERAR HTML DE FILMES E SÉRIES |
                    | 0 - SAIR ........................ |
                    =====================================
                    """);

            op = inputUtils.inputIntegerNumber(op, 0 ,2, "-- ESCOLHA UMA DAS OPÇÕES ACIMA: ");

            switch (op){
                case 1:
                    productionService.showResults();
                    break;
                case 2:
                    productionService.generateHtml();
                    break;
                case 0:
                    System.out.println("-- SAINDO...");
                    System.exit(0);
            }
        }

    }
}
