# Joinville TexoIT Recruitment Process of Java WEB developer (Worst Movie Category)
Será necessário o desenvolvimento de uma API RESTful para possibilitar a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards, como parte da seleção de desenvolvedor java na TexoIT Joinville.

# Requisito do Sistema:
1. Ler o arquivo CSV dos filmes e inserir os dados em uma base de dados ao inciar a aplicação;
# Requisito da API:
1. Obter o produtor com maior intervalo entre dois prêmios, e o que obteve dois prêmios mais rápido;

# Ferramentas Usadas para desenvolver a API e Testar:

- IDE de Desenvolvimento: [IntelliJ 2019.1.3 com Java EE 8]
- Gerenciador de Dependências: [Maven]
- Framework para desenvolvimento da API: [Spring Boot 2.1.0-RELEASE]
- Servidor de Aplicação: [Apache Tomcat 8.0]
- Testes da API RESTful: [Postman]

# Formato da API:
<h3>
<a id="user-content-listagem-de-todos-os-amigos" class="anchor" href="#listagem-de-todos-os-amigos" aria-hidden="true"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Producers</h3>
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

# Teste Unitario

<strong>As seguintes validações devem ser consideradas:</strong>

- Validar os dados que retorna.
- Validar os headers da resposta
- Validar se a resposta está de acordo.
- Validar se o content-type alterado, o comportamento continua o mesmo.
- Validar se a estrutura do JSON ou XML está correta.
- Validar se quando der erro o status está de acordo com os códigos de erro.
- Validar se uma requisição com informações incompleta, qual será o comportamento da requisição.
- Testar o tempo de resposta de uma requisição

Os testes implementados para a API encontram-se na classe [MovieControllerTest.java] e uma vez que estes são testes voltados para testar o correto funcionadmento dos recurso da API, utilizamos de informação ficticias que nos permite simular os possiveis cenários.

Para simular os casos basta alterar as informações ali presentes e executar a classe que irá inicializar apenas os recursos necessários ao final da execução será apresentado o resultado para cada um dos testes, no caso de falha será indicado a causa.


