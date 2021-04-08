UNIVERSIDADE FEDERAL RURAL DO SEMI-ÁRIDO 
CURSO DE CIÊNCIA DA COMPUTAÇÃO 
COMPILADORES 
LABORATÓRIO  01 
AMBIENTE  DE  TRABALHO 
 
(LINUX) 
1.  Usando o terminal do Linux, execute as seguintes tarefas, em ordem: 
 
a)  Crie uma pasta chamada “Compiladores”
 
b)  Mude para esta pasta 
c)  Baixe o Material de Apoio 1 (Lab01.tar.gz) para a pasta recém-criada 
d)  Descomprima o arquivo Lab01.tar.gz 
e)  Mude para o diretório Lab01 
f)  Liste o conteúdo desse diretório 
 
2.  Crie uma pasta chamada Terminal e use o redirecionamento da saída (>) para criar 
um arquivo chamado listagem.txt dentro da pasta Terminal. O arquivo deve conter 
o nome de todos os arquivos e pastas presentes em /etc. 
 
3.  Exiba o conteúdo do arquivo listagem.txt usando os comandos cat, more e less. 
 
4.  Utilize o pipe (|) para exibir o conteúdo da pasta /etc, filtrando o resultado de 
forma que sejam exibidos apenas pastas e arquivos que contenham as letras “rc” 
em seu nome. A ferramenta grep deve ser usada para fazer a filtragem. 
 
5.  Utilize o comando sort para ordenar a saída obtida na questão anterior. 

UNIVERSIDADE FEDERAL RURAL DO SEMI-ÁRIDO 
CURSO DE CIÊNCIA DA COMPUTAÇÃO 
COMPILADORES 
LABORATÓRIO  02 
AMBIENTE  DE  TRABALHO 
 
(VISUAL  STUDIO  CODE) 
1.  Rode o programa “Olá Mundo!” no Visual Studio Code.  
 
 
#include <iostream> 
using namespace std; 
 
int main() 
{ 
    cout << "Olá Mundo!\n"; 
} 
 
 
Para isso siga os passos abaixo: 
 
a)  No terminal, crie uma pasta chamada Hello. O Visual Studio Code só 
permite a criação de tarefas de compilação e depuração para arquivos de 
código armazenados dentro de pastas. 
 
b)  Entre na pasta e crie um arquivo vazio chamado hello.cpp 
 
c)  Entre no VS Code e abra a pasta Hello. 
 
d)  O arquivo hello.cpp vai aparecer no explorador do VS Code. Edite o arquivo 
e insira o código do “Olá Mundo!” mostrado acima. 
 
e)  Crie uma tarefa de compilação para o arquivo hello.cpp usando: 
i.  Compilação direta com g++ 
ii.  Compilação através de um Makefile 
 
f)  Crie uma tarefa de depuração de código 
 
g)  Adicione uma tarefa para gerar o Makefile usando o CMake. 

UNIVERSIDADE FEDERAL RURAL DO SEMI-ÁRIDO 
CURSO DE CIÊNCIA DA COMPUTAÇÃO 
COMPILADORES 
LABORATÓRIO  03 
TRADUÇÃO  DIRIGIDA  POR  SINTAXE 
1.  A notação polonesa (ou notação pré-fixada) e a notação polonesa reversa (ou 
notação pós-fixada) são notações para expressões aritméticas que não possuem 
ambiguidade quanto à sua ordem de avaliação. Na notação pré-fixada os 
operadores devem preceder os valores numéricos associados e na notação pós-
fixada os operadores devem suceder os seus operandos. Estas notações foram 
criadas pelo matemático polonês Jan Lukasiewicz em 1920 e, embora não seja 
muito utilizada na matemática convencional, é muito usada na Ciência da 
Computação. 
 
Exemplos: 
 
Notação Pré-fixada  Notação Infixada  Notação Pós-fixada 
*+abc  (a+b)*c  ab+c* 
*c+ab  c*(a+b)  cab+* 
-a+b-cd  a-(b+(c-d))  abcd-+-
 
*+ab-cd  (a+b)*(c-d)  ab+cd-*
 
/-*ab*cd+ef  ((a*b)-(c*d))/(e+f)  ab*cd*-ef+/ 
 
a.  Considere as duas gramáticas sugeridas abaixo. Alguma delas consegue 
representar expressões aritméticas em notação pós-fixada? Descubra 
tentando encontrar uma derivação para alguns dos exemplos. 
 
expr  ->  expr term +    expr  ->  term expr +
 
  |  expr term -
      |  term expr -
 
    term        term 
             
term  ->  0    term  ->  0 
  |  1      |  1 
  |  …      |  … 
  |  9      |  9 
 
b.  Construa uma gramática para representar expressões aritméticas em 
notação pós-fixada. 
 
c.  Construa uma gramática para representar expressões aritméticas em 
notação pré-fixada. 
 
2.  Usando a gramática da questão anterior, construa um esquema de tradução 
dirigido por sintaxe que traduza expressões aritméticas da notação pré-fixada  
para a notação pós-fixada.  
 
3.  Construa árvores de derivação anotadas para as entradas em notação pré-fixada: 
a.  +9*52 
b.  +*952  

UNIVERSIDADE FEDERAL RURAL DO SEMI-ÁRIDO 
CURSO DE CIÊNCIA DA COMPUTAÇÃO 
COMPILADORES 
LABORATÓRIO  04 
ANÁLISE  SINTÁTICA 
1.  O método de análise sintática descendente cria uma árvore de derivação de cima 
para baixo (da raiz até as folhas). Explique por que a construção da árvore de 
derivação pode resultar em um processo de tentativa e erro. 
 
 
2.  Um analisador sintático preditivo não consegue trabalhar com gramáticas 
recursivas à esquerda, nem com gramáticas que não possuem produções com 
conjuntos FIRST disjuntos. Para as gramáticas abaixo, indique quais são recursivas 
à esquerda, quais não possuem conjuntos FIRST disjuntos e aquelas que poderiam 
ser usadas em um analisador preditivo sem nenhuma modificação. 
 
a.  S -> S +
 S  
   | S –
 S  
   | a 
 
b.  S -> +SS 
   | -SS 
   | a 
 
c.  S -> aSb 
   | a 
 
 
 
3.  Mostre as funções que implementariam um analisador sintático preditivo para 
cada uma das gramáticas abaixo:   
 
a.  S -> a(S)b 
   | c 
  
b.  S -> +SS 
   | -SS 
   | *SS 
   | /SS 
   | a 
   | b 
 
c.  S -> a S b 
   | ϵ 
 
 UNIVERSIDADE FEDERAL RURAL DO SEMI-ÁRIDO 
CURSO DE CIÊNCIA DA COMPUTAÇÃO 
COMPILADORES 
LABORATÓRIO  09 
EXERCÍCIOS  DE  REVISÃO 
1.  Descreva as fases do processo de compilação. 
 
2.  O que é tradução dirigida por sintaxe? 
 
3.  Como é formada uma gramática? 
 
4.  Escreva uma gramática para representar a definição de classe abaixo: 
 
 
 
5.  Mostre a derivação da cadeia ((5*2+6) -
 9/7) para a gramática abaixo 
 
 
 
6.  Dê exemplos de gramáticas associativas à esquerda e associativas à direita. 
 
7.  Mostre como representar a precedência entre operadores lógicos e relacionais. 
 
8.  O que é um esquema de tradução dirigido por sintaxe? 
 
9.  Construa um esquema de tradução para converter expressões aritméticas em 
notação infixada para a notação pré-fixada. 
 
10. Remova a recursão à esquerda na questão anterior para que o esquema de 
tradução possa ser implementado por um analisador sintático preditivo. class Ponto 
{ 
private: 
    int x; 
    int y; 
public: 
    Ponto(); 
} 
expr -> expr + term 
      | expr –
 term 
      | term 
 
term -> term * fact  
      | term / fact 
      | fact 
 
fact -> digi  
      | (expr) 
 
digi -> 0 | ... | 9 
 
