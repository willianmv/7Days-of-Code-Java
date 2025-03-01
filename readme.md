# Projeto 7 Days of Code - Requisição de Filmes e Séries via OMDB API

## Descrição

Este projeto foi desenvolvido em Java SE puro, sem a utilização de bibliotecas externas, com o objetivo de realizar requisições para a **OMDB API** e buscar filmes e séries, retornando os resultados em formato JSON. O programa processa esses dados, converte-os para objetos Java e permite duas formas de apresentação desses resultados:

1. **Exibição no Console**: Um menu interativo para o usuário procurar filmes ou séries e visualizar os resultados diretamente no console.
2. **Geração de Página HTML**: O programa também permite gerar uma página HTML estilizada, utilizando o framework Bootstrap, para exibir os resultados de maneira visualmente atraente.

## Funcionalidades

### 1. Pesquisa de Filmes e Séries
O usuário pode pesquisar por filmes ou séries utilizando um título específico. O sistema solicita ao usuário se deseja pesquisar por filmes ou séries e, em seguida, faz a requisição à API da OMDB para retornar as informações.

- **Input do usuário**: O usuário escolhe entre filmes ou séries e digita o título da produção que deseja buscar.
- **Processamento dos dados**: A resposta da API, no formato JSON, é transformada em objetos Java específicos através da classe `ProductionExtractor`.

### 2. Geração de Página HTML
Após a pesquisa, o programa oferece a opção de gerar uma página HTML contendo os resultados formatados com cards interativos para cada produção. O layout da página é construído com o uso do Bootstrap, garantindo uma aparência responsiva e moderna.

- **HTML Gerado**: A página contém cards para cada filme ou série, exibindo o título, ano de lançamento, tipo (filme ou série), poster e um link para acessar mais informações no IMDb.

### 3. Validação de Entradas
O programa garante que as entradas do usuário sejam válidas, tratando exceções de entradas inválidas como números fora do intervalo permitido ou entradas não numéricas.

### 4. Requisição à API da OMDB
Utilizando a `HttpClient` do Java SE, o programa faz uma requisição GET à OMDB API, fornecendo o título e o tipo da produção (filme ou série), com a chave de API necessária para autenticação. A resposta da API é processada e convertida em objetos Java para fácil manipulação e apresentação.

## Estrutura do Projeto

- **`Main.java`**: Controla o fluxo principal do programa, apresenta o menu interativo e chama as funcionalidades para pesquisa e geração de HTML.
- **`OmdbRequest.java`**: Classe responsável por fazer a requisição à OMDB API e retornar os resultados no formato JSON.
- **`ProductionExtractor.java`**: Responsável por extrair e converter os dados JSON em objetos `Production` para facilitar a manipulação e apresentação dos dados.
- **`HTMLGenerator.java`**: Classe responsável por gerar o arquivo HTML a partir das produções encontradas, utilizando o Bootstrap para estilizar a página.
- **`Production.java`**: Representa o modelo de dados de uma produção (filme ou série), com atributos como título, ano, tipo, imdbID e poster.

## Como Usar

1. **Rodar o Programa**: Compile e execute a classe `Main.java`. O programa exibirá um menu interativo no console.
2. **API - Key**: É necessário se cadastrar e pegar sua chave gratuitamente na OMBD API e adiciona-lá ao código.
3. **Escolher a Opção de Pesquisa**: Escolha entre pesquisar filmes ou séries e forneça o título da produção desejada.
4. **Exibir Resultados**: Os resultados serão exibidos diretamente no console.
5. **Gerar HTML**: Se desejar gerar a página HTML, escolha a opção de gerar HTML e o arquivo será salvo na pasta `html-gerado`.

## Exemplo de Execução

```plaintext
=====================================
| 1 - PESQUISAR POR FILMES E SÉRIES |
| 2 - GERAR HTML DE FILMES E SÉRIES |
| 0 - SAIR ........................ |
=====================================
-- ESCOLHA UMA DAS OPÇÕES ACIMA: 1
-- DIGITE 1 PARA FILMES OU 2 PARA SÉRIES: 1
-- DIGITE O TITULO DA PRODUÇÃO QUE DESEJA ENCONTRAR: Inception
-- Resultados encontrados:
"Title: Inception, Year: 2010, Type: movie, Poster: link_to_poster"
````

## Requisitos

- **Java SE** (sem dependências externas além do padrão da JDK).
- **JDK 11 ou superior** para execução de código com `HttpClient`.

## Observações

- A OMDB API tem limites de requisições diárias para chaves gratuitas. Certifique-se de que sua chave de API está funcionando corretamente.
- O projeto foi desenvolvido sem o uso de bibliotecas externas como `Jackson` ou `Gson` para o processamento de JSON, utilizando apenas os recursos nativos do Java.
- Vale ressaltar que, embora o projeto tenha sido inspirado na proposta do "7 Days of Code", algumas adaptações foram feitas. A API utilizada não foi a mesma da proposta original, e a forma de apresentação e fluxo dos dados também foi modificada. No entanto, todas as funcionalidades foram baseadas na ideia do projeto "7 Days of Code".


## Conclusão

Este projeto foi uma excelente maneira de praticar o uso de **requisições HTTP**, **processamento de JSON** e **geração de páginas HTML** com Java SE, tudo sem depender de bibliotecas externas. Além disso, é uma aplicação prática que integra diversos conceitos de desenvolvimento de software.

