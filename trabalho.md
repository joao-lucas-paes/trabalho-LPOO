# Trabalho de LPOO

## Descrição

- Desenvolver um projeto em Java no Eclipse que controle a tabela de jogos da Copa.
- O trabalho poderá ser feito individual ou em dupla.
- Fica opcional o uso de uma interface gráfica usando JavaFX para acessar as funcionalidades.
- No AVA tem uma aula sobre a utilização do Java FX.
- O sistema será composto pelas classes especificadas no Diagrama de Classes abaixo.
- O sistema deverá permitir inclusão de objetos das Classes descritas abaixo.
- Também deverá permitir alterar informações com o método set e ler as informações com o método get

## Saída do Projeto

- 1- Listar a tabela com o resultado dos jogos já efetuados de acordo com a classificação.
- 2- Listar os jogadores por time o nome e número da camisa.
- 3- Listar times por Grupo: Listar o nome dos times de cada grupo

<hr/>

## Descrição das Classes e Interfaces

- ## (a) Interface Verificável (Obrigatório)

  - ### • Método

    - a) boolean validar(String codigo)

        - Este método deverá validar o CPF para Pessoa, sempre que o CPF for cadastrado ou alterado. Se o valor retronado for false, então deverá chamar o método que solicita um novo valor a ser validado.

    - b) void solicitarNovo()

        - Este método deverá solicitar um novo CPF para Pessoa, sempre que o valor validado retorna false. Quando o novo valor for fornecido, deverá chamar o método validar, para que seja verificado novamente.

- ## (b) Classe Endereço (Obrigatório)

    - ### • Atributos

        - String rua int numero String bairro String cidade String cep

    - ### • 2 construtores

        - a) Para endereço completo

            - public Endereco(String rua, int numero, String bairro, String cidade, String cep)

        - b) Para endereço sem

            - cep public Endereco(String rua, int numero, String bairro, String cidade)

    - ### • Métodos

        - a) gets e sets

- ## (c) Classe Pessoa (Abstrata) (Obrigatório)

    - **• Implementa a classe Verificavel**
    
    - ### • Atributos privados

        - String nome 
        - String cpf 
        - Endereco endereco 
        - String celular 
        - String dataNascimento

    - ### • 1 Construtor

        - a) public Pessoa(String nome, String cpf, Endereco endereco, String celular). **obs: no construtor deve-se validar o CPF antes de atribuir o valor do cpf Então é preciso chamar o método para validar(String codigo) Se o CPF estiver correto, ele será atribuído, Caso contrário deverá solicitar um novo valor para o cpf**

    - ### • Métodos:
        
        - a) @Override public boolean validar(String CPF) este método terá que validar o CPF
        
        - b) @Override public void solicitarNovo() este método solicita um novo CPF, até que o valor do CPF informado esteja correto

- ## (d) Classe Jogador (Obrigatório)

    - **• Estende a classe Pessoa**

    - **• 1 construtor com os parâmetros de pessoa, o time e o numCamisa**

    - ### • Método:

        - a) @Override public String toString() retorna uma String com o nome e o numCamisa.

- ## (e) Classe Time (Obrigatório)

    - ### • Atributos privados

        - String nomeTime
        - String nomeSelecao
        - String grupo
        - List<"Jogador"> listJogadores (Utilizar ArrayList)

    - **• 1 construtor com os parâmetros de Time**

    - ### • Método:
        
        - a) int compareTo(Object obj) compara os produtos pelo nomeTime

        - b) public String toString() retorna uma String com o nomeTime, nomeSelecao, grupo e a lista de Jogadores

- ## (f) Classe Grupo (Obrigatório)

    - ### • Atributos privados:

        - String nomeDoGrupo, classificacao1, classificacao2, classificacao3, classificacao4 (os atributos podem mudar conforme a implementação do projeto em cada grupo de alunos)

    - **• 1 construtor com os parâmetros de Grupo**

    - ### • Método:
    
        - b) public String toString() retorna uma String com os atributos do grupo

- ## (g) Classe Jogos (Obrigatório)

    - ### • Atributos privados

        - String->Time1xTime2 
        
        - int golsTime1 
        
        - int golsTime2 (os atributos podem mudar conforme a implementação do projeto em cada grupo de alunos) 
        
        - listaGols -> Criar uma coleção com os jogadores que fizeram o gol.

    - **• 1 construtor com os parâmetros de Jogos**

    - ### • Método:

    - a) GerarResultados()

        - Se (golsTime1 == golsTime2) -> empate- > cada time ganha 1 ponto

        - Senão(golsTime1 > golsTime2) -> time1 ganha 3 pontos e time2 ganha 0 pontos
        
        - Senão (golsTime2 > golsTime1) -> time2 ganha 3 pontos e time1 ganha 0 pontos

    - b) public String toString() retorna uma String com os atributos dos jogos

- ## (h) Classe Sumula(gols) (Opcional)

- ### (i) Atributos privados: Jogador, gols, golsContra, Amarelos, Vermelhos

- ## (j) Classe Faltas (Opcional)

- ## (k) Classe Main

    - • Possui o método main

    - • Inserir pelo menos 6 Enderecos, 12 Jogadores, 3 Grupos, 6 Times, 4 Jogos

    - • Usar exceção para tratar entradas inválidas para os valores inteiros.

    - • Listar os Jogadores por Time, times por Grupo e a tabela com o resultado dos jogos já efetuados

    - • (Opcional) Listar a súmula dos jogos

    - • (Opcional) Listar as faltas cometidas

- ## (l) Informações adicionais

    - • O código deve ser comentado conforme necessidade de explicar certas funções e funcionalidades

    - • O projeto deve utilizar obrigatoriamente os conceitos de Herança, Abstração, Polimorfismo, Encapsulamento e Interfaces

    - • Usar coleções (ArrayList), para armazenar os Jogadores na classe Time.

    - • Os modificadores de acesso das classes e atributos devem ser corretamente atribuídos

    - • Entregar o projeto zipado com todos os códigos desenvolvidos e um arquivo txt cotendo o nome dos alunos. No caso de grupo, a nota vai ser a mesma para todos os alunos. Basta que apenas um do grupo faça a entrega no Moodle. A data de entrega será definida no Moodle.

    - • Entregar um vídeo do trabalho executando, onde deverá explicar as principais funcinalidades implementadas no código. (Enviar o link de onde o vídeo estará armazenado no mesmo arquivo txt que contém o nome dos alunos do grupo). O vídeo deverá ter no mínimo 7 minutos e no máximo 20 minutos.// TODOS os alunos do grupo devem apresentar o trabalho no vídeo.

    - • A avaliação do trabalho vai ser realizada de acordo com a implementação entregue. Em caso de plágio de outro colega ou da internet (ou de alguma maneira não foi você que fez), é zero para o trabalho (todo o grupo).

    - • Quaisquer dúvidas no desenvolvimento do trabalho devem ser enviadas para o e-mail:

# ~*ana.salina@ufms.br*~