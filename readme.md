# Manual de utilização do Programa "mainLista.jar"

 O executável "mainLista.jar" do programa se encontra na raiz do diretório e para que um ficheiro seja lido é recomendável que ele se encontrar no mesmo diretório que o jar, a exemplo no diretório se encontram disponíveis para teste dois ficheiros ("registos.txt" e "registos.bin") e também estão no mesmo diretório o código fonte do programa ("listaDupla.java"), um programa para leitura de arquivos binários ("ReadBinRegFile.java") e dois subdiretórios de projeto sendo que um contém dentre outros arquivos o programa mainLista e suas dependências e o outro contém o package do qual o mainLista depende.


# Estrutura das classes e métodos 

Em razão da utilização de packages o mainLista apenas chama métodos da classe "listaDupla". 

A primeira classe no "listaDupla" é a "REG", que serve como uma estrutura para definir cada objeto na lista, o construtor do REG serve para definir os tipos que são aceitos e realizar a inicialização dos mesmos. 

A classe seguinte é a classe "listaDupla", a qual todos os métodos que serão descritos a seguir pertencem. O construtor da classe "listaDupla" define dois objetos do tipo REG, equivalentes aos nós direito e esquerdo na lista, e em seguida os inicializa com valor null.  

O método seguinte é o "preencherLista", que com base no nome do ficheiro de entrada detecta se a extensão do mesmo é text, csv ou binário e usa um int para marcar o tipo de ficheiro que foi recebido. Após isto é executada a leitura do ficheiro e os dados são postos na lista, utilizando inserção a direita para que a ordem dos dados se mantenha o mais próximo o possível a de entrada,  até que se chegue ao fim do ficheiro. Como a inserção de elementos na lista é realizada por meio da leitura do ficheiro para alterar os elementos da lista ou adicionar novos elementos se faz necessária a alteração do ficheiro que será lido e uma nova execução do programa (pois o método "preencherLista" só é chamado uma vez a cada execução).

O próximo  método é o "ColocaElementoEsqLista", que serve para realizar a inserção de elementos em um nó a esquerda na lista, que efetivamente não é utilizado no programa.

O próximo  método é o "ColocaElementoDirLista", que serve para realizar a inserção de elementos em um nó a direita na lista, que é utilizado como meio de inserção padrão do programa.

A seguir vem o método "Mostra", que percorre a lista da esquerda para direita, até o fim dela, e exibe os objetos nela contidos.

O método seguinte é o "GravaBin", que grava os objetos da lista em um ficheiro binário (denominado "Lista.bin"), caso o ficheiro utilizado na entrada tenhas sido deste tipo.

O método seguinte é o "Grava", que grava os objetos da lista em um ficheiro csv(denominado "Lista.csv"), caso o ficheiro utilizado na entrada tenhas sido do tipo csv ou txt. Fora o caso da gravação da lista em um ficheiro o método "Grava" também depende de um seletor para definir se está a gravar a lista base ou uma lista com um filtro de idade aplicado (maiores ou menos de 18 anos, o filtro é feito nos métodos "Maior18" e "Menor18" que serão descritos abaixo), o método "GravaBin" também contém um seletor semelhante a este.

O método "deltaData" compara a data de nascimento no registo com a data atual, e retorna um booleano (verdadeiro caso o resultado da comparação seja maior ou igual a dezoito e falso em caso contrário).

O método "Maior18" cria uma nova lista e em seguida faz, tendo como destino esta nova lista, a copia dos elementos presentes na lista que original que obedeçam a condição: idade maior ou igual a 18 anos, a condição é verificada por meio do retorno da função "deltaData".

O método "Menor18" funciona de forma semelhante ao anterior, só que com a condição : idade menor que 18 anos, a condição é verificada por meio do retorno da função "deltaData".

Todos os métodos e classes acima descritos estão contidos em um package no subdiretório de projeto (ou podem ser visualizadas no código fonte) e são chamadas pelo main na mesma ordem em que estão descritas nos parágrafos anteriores.



## Estrutura dos ficheiros que são aceitos pelo programa

Para ficheiros do tipo csv o programa compreende como separador padrão o ';' e sendo assim cada dado de entrada deve estar separado por ';' . Para este tipo de ficheiro a entrada dos dados tem a seguinte ordem(sendo que nome é um texto e o restante dos dados devem ser valores numéricos):
**nome;dia;mês;ano;telefone**

Para ficheiros do tipo bin o programa faz a leitura dos dados por linhas, o separador compreendido como padrão é a quebra de linha. Para este tipo de ficheiro a entrada dos dados tem a seguinte ordem:
**nome
dia/mês/ano
telefone**


## Ficheiros de saída do programa

O programa tem 3 ficheiros de saída de terminação .bin ou .csv(a depender do ficheiro utilizado na entrada): "Lista", "Maiores_que_18" e "Menores_que_18". Todos os ficheiros de saída tem estrutura similar ao ficheiro de entrada do seu tipo correspondente.


*Iago Gomes*
