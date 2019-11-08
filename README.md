# TexoIT Recruitment Process of Java WEB developer (Worst Movie Category) in Joinville
Será necessário o desenvolvimento de uma API RESTful para possibilitar a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards, como parte da seleção de desenvolvedor java na TexoIT Joinville.

# Requisito do Sistema:
1. Ler o arquivo CSV dos filmes e inserir os dados em uma base de dados ao inciar a aplicação;
# Requisito da API:
1. Obter o produtor com maior intervalo entre dois prêmios, e o que obteve dois prêmios mais rápido;
# Requisitos Não Funcionais 
1. O web service RESTful deve ser implementado com base no nível 2 de maturidade de Richardson; 
2. Devem ser implementados somente testes de integração;

# Ferramentas Usadas para desenvolver a API e Testar:

- IntelliJ 2019.1.3
- Java 8
- Maven
- Spring Boot 2.1.0
- Apache Tomcat 8.0
- Postman

# Formato da API:
<h3>
<a id="user-content-listagem-de-todos-os-amigos" class="anchor" href="#listagem-de-todos-os-amigos" aria-hidden="true"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>/producers</h3>
<p>Obter o produtor com maior intervalo entre dois prêmios, e o que obteve dois prêmios mais rápido.</p>
<p><strong> End-Point URL</strong></p>
<p><code>GET http://localhost:8090/producers</code></p>
<p><strong>Parâmetros</strong></p>
<ul>
<li>Nenhum</li>
</ul>
<p><strong>Exemplo de Requisição</strong></p>
<p><code>http://localhost:8090/producers</code></p>
<p><strong>Leiaute da Resposta</strong></p>
<pre><code>{
    "min": [
        {
            "producer": "Producer Name",
            "interval": 9,
            "previousWin": 2018,
            "followingWin": 2019
        }
    ],
    "max": [
        {
            "producer": "Producer Name",
            "interval": 99,
            "previousWin": 1900,
            "followingWin": 1999
        }
    ]
}</code></pre>
<h3>


Os testes de itegração implementados para a API encontram-se na classe MovieControllerIntegrationTests, com dados Mockados para utilizar os diversos cenários de seu funcionamento.

Para simular os casos basta alterar as informações ali presentes e executar a classe que irá inicializar apenas os recursos necessários ao final da execução será apresentado o resultado para cada um dos testes, no caso de falha será indicado a causa.


