package SevenDaysOfcode.extractor;

import SevenDaysOfcode.entity.Production;

import java.util.ArrayList;
import java.util.List;

public class ProductionJsonExtractor {

    private Production production;
    private final List<Production> productions = new ArrayList<>();

    public List<Production> getObjects(String json){
        if(isErrorResponse(json)){
            String errorMessage = getErrorMessage(json);
            System.out.println("-- ERRO DA API: "+ errorMessage.toUpperCase()+"\n");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------\n");
            return new ArrayList<>();
        }

        String searchSection = getJsonSection(json, "\"Search\":", "]");
        String[]organizedJson = searchSection.split("\\},\\{");

        for(String s : organizedJson){
            String title = getValue(s, "\"Title\":");
            String year = getValue(s, "\"Year\":");
            String imdbID = getValue(s, "\"imdbID\":");
            String type = getValue(s, "\"Type\":");
            String poster = getValue(s, "\"Poster\":");

            productions.add(new Production(title, year, imdbID, type, poster));
        }
        return productions;
    }


    //Extrai o valor contido entre chaves
    private String getValue(String json, String key){
        int startIndex = json.indexOf(key) + key.length() + 1;
        int endIndex = json.indexOf("\"", startIndex);
        return json.substring(startIndex, endIndex);
    }

    //Extrai uma seção do JSON 'ESPECÍFICO' dessa response
    private String getJsonSection(String json, String startKey, String endKey){
        int startIndex = json.indexOf(startKey);
        if (startIndex == -1) return "";
        startIndex = json.indexOf("[", startIndex);
        int endIndex = json.indexOf(endKey, startIndex);
        return json.substring(startIndex+1, endIndex);
    }

    //Verifica se o JSON veio com erro, caso 'ESPECÍFICO'
    private boolean isErrorResponse(String json){
        return json.contains("\"Response\":\"False\"");
    }

    //Extrair mensagem de erro
    private String getErrorMessage(String json){
        return getValue(json, "\"Error\":");
    }

}
