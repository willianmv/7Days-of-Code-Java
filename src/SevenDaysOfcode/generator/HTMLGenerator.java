package SevenDaysOfcode.generator;

import SevenDaysOfcode.entity.Production;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

    private final PrintWriter printWriter;

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
                       background-color: #121212;
                       color: #E0E0E0;
                       font-family: 'Arial', sans-serif;
                   }
            
                   h1 {
                       color: #FFFFFF;
                       margin-bottom: 30px;
                   }

                   .card {
                       width: 18rem;
                       height: 30rem;
                       margin-bottom: 30px;
                       display: flex;
                       flex-direction: column;
                       border: 1px solid #333333;
                       border-radius: 10px;
                       background-color: #1E1E1E;
                       box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
                   }

                   .card-img-top {
                       width: 100%;
                       height: 200px;
                       object-fit: cover;
                       border-top-left-radius: 10px;
                       border-top-right-radius: 10px;
                   }

                   .card-body {
                       flex-grow: 1;
                       padding: 20px;
                   }

                   .card-title {
                       color: #FFD700;
                       font-size: 1.25rem;
                   }

                   .card-text {
                       color: #B0B0B0;
                   }

                   .btn-primary {
                       background-color: #6200EE;
                       border-color: #6200EE;
                   }

                   .btn-primary:hover {
                       background-color: #3700B3;
                       border-color: #3700B3;
                   }

                   .container {
                       padding-left: 15px;
                       padding-right: 15px;
                   }

                   .row {
                       display: flex;
                       flex-wrap: wrap;
                       gap: 30px;
                       justify-content: center;
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
        printWriter.println("<img src='" + p.poster() + "' class='card-img-top' alt='" + p.title() + " Poster'>");
        printWriter.println("<div class='card-body'>");
        printWriter.println("<h5 class='card-title'>" + p.title() + "</h5>");
        printWriter.println("<p class='card-text'>Ano: " + p.year() + "</p>");
        printWriter.println("<p class='card-text'>Tipo: " + p.type() + "</p>");
        printWriter.println("<a href='https://www.imdb.com/title/" + p.imdbID() + "' class='btn btn-primary' target='_blank'>Ver no IMDb</a>");
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
