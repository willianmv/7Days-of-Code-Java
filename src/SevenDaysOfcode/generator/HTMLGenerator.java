package SevenDaysOfcode.generator;

import SevenDaysOfcode.entity.Production;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

    private PrintWriter printWriter;

    public HTMLGenerator(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }


    public void generateHTMLPage(List<Production> productions){
        printWriter.write("<html lang=\"pt-br\">");
        printWriter.write(generateHTMLHead());
        printWriter.write(generateHTMLBodyStar());

        for(Production p : productions){
            writeMovieCard(p);
        }

        printWriter.write(generateHTMLBodyEnd());
        printWriter.write("</html>");
    }


    private String generateHTMLHead(){
        return """
            <head>
               <meta charset="utf-8">
               <title>Lista de Produções</title>
               <!-- Bootstrap CSS -->
               <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
               <style>
                   body {
                       background-color: #121212; /* Fundo escuro */
                       color: #E0E0E0; /* Texto claro */
                       font-family: 'Arial', sans-serif;
                   }
            
                   h1 {
                       color: #FFFFFF;
                       margin-bottom: 30px;
                   }

                   .card {
                       width: 18rem;
                       height: 30rem;
                       margin-bottom: 30px; /* Aumentando o espaço entre os cards */
                       display: flex;
                       flex-direction: column;
                       border: 1px solid #333333; /* Borda mais suave */
                       border-radius: 10px; /* Bordas arredondadas */
                       background-color: #1E1E1E; /* Fundo escuro para os cards */
                       box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3); /* Sombra suave */
                   }

                   .card-img-top {
                       width: 100%;
                       height: 200px;
                       object-fit: cover;
                       border-top-left-radius: 10px; /* Arredondando o topo da imagem */
                       border-top-right-radius: 10px;
                   }

                   .card-body {
                       flex-grow: 1;
                       padding: 20px;
                   }

                   .card-title {
                       color: #FFD700; /* Título dourado */
                       font-size: 1.25rem;
                   }

                   .card-text {
                       color: #B0B0B0; /* Texto de detalhes em um tom mais suave */
                   }

                   .btn-primary {
                       background-color: #6200EE; /* Cor de fundo para o botão */
                       border-color: #6200EE; /* Cor da borda do botão */
                   }

                   .btn-primary:hover {
                       background-color: #3700B3; /* Efeito hover no botão */
                       border-color: #3700B3;
                   }

                   .container {
                       padding-left: 15px;
                       padding-right: 15px;
                   }

                   .row {
                       display: flex;
                       flex-wrap: wrap;
                       gap: 30px; /* Espaço entre os cards */
                       justify-content: center; /* Alinhar os cards ao centro */
                   }
               </style>
            </head>
            """;
    }

    private String generateHTMLBodyStar(){
        return  """
                <body>
                  <div class="container mt-4">
                      <h1 class="text-center">Lista de Produções</h1>
                      <div class="row">
            """;
    }

    private void writeMovieCard(Production p){
            printWriter.println("<div class='col-md-4 mb-4'>");
            printWriter.println("<div class='card'>");
            printWriter.println("<img src='" + p.getPoster() + "' class='card-img-top' alt='" + p.getTitle() + " Poster'>");
            printWriter.println("<div class='card-body'>");
            printWriter.println("<h5 class='card-title'>" + p.getTitle() + "</h5>");
            printWriter.println("<p class='card-text'>Ano: " + p.getYear() + "</p>");
            printWriter.println("<p class='card-text'>Tipo: " + p.getType() + "</p>");
            printWriter.println("<a href='https://www.imdb.com/title/" + p.getImdbID() + "' class='btn btn-primary' target='_blank'>Ver no IMDb</a>");
            printWriter.println("</div>");
            printWriter.println("</div>");
            printWriter.println("</div>");
    }

    private String generateHTMLBodyEnd(){
        return """
                    </div>
                </div>
            </body>
            """;
    }
}
