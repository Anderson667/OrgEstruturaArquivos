# Relatorio final do trabalho de Estrutura de Arquivos

## Objetivo
#####  O objetivo do trabalho foi realizar uma busca de Hash em dois dataset das edições do ENEM de 2014 e 2013, buscando verficiar o aumento de pontuação média de um municipio em relação ao ano anterior, e com estes dados realizar um previsão para o próximo ano.
  
## Processo de busca
 ##### O processo de busca funciona da seguinte forma:
  
 ##### 1.Usuario informa o nome do municipio no qual quer pesquisar.
 ##### 2.Usuario informa se quer filtrar dados relacionados a redação ou em relação as provas de conhecimentos gerais.
 ##### 3.Usario informa nota na qual quer buscar
 ##### 4.Programa devolve os dados dos dois anos e realiza a previsão do proximo ano com base nos dados gerados.

## Fases do Trabalho

  ### Primeira Fase
   ##### A planilha de dados do ENEM, consiste de aproximadamente 150 atributos, como nome,sexo,deficiencia,nota,gabarito de da prova, porém o objetivo do trabalho não é utilizar todos os campos para realizar a busca. Então a primeira fase consiste em filtrar os dados para facilitar o manuseamento deles posteriormente. A linguaguem para realizar a filtragem e organização dos dados em uma planilha foi o Java. No qual foi realizado todo o processo de leitura, filtragem e preenchimento dos dados em um novo arquivo.
   
   #### Dados Relacionados a primeira fase
   #### Dados filtrados
   ##### Inscrição | Codigo_Municipio | Nome_Municipio | Sigla_do_Estado | Local da Escola | Idade | Sexo | Conclusão Ensino medio | Cor_Raça | Presenca_CN | Presenca_CH | Presenca_LC | Presenca_MT | Cor_CN | Cor_CH | Cor_LC | Cor_MT | Nota_CN | Nota_CH | Nota_LC | Nota_MT | Tipo_lingua | Status_Redacao | Nota_Competencia1 | Nota_Competencia2 | Nota_Competencia3 | Nota_Competencia4 |Nota_Competencia5 | Nota_Redacao |
    
   #### Tempo Execução
   
   ##### Gerar CSV do estado do RJ = Aprox. 3.5 minutos
   ##### Gerar CSV do Brasil = Aprox 30.6 minutos
    
    
  ### Segunda Fase
   ##### A segunda fase consiste em criar o programa que realize carregue os dados dos arquivos criados e realizar a busca com base na entrada do usuario. Para isso foi usada a linguaguem Python.
    
 #### Tempo Execucao
 
 ##### Gerar CSV do Brasil(2014 e 2015) = Aprox 10 minutos(Após o carregamento dos dados é possivel realizar qualquer consulta)
 
 ## Arquivos
 
 ##### link: https://www.dropbox.com/sh/jhbpfnwy4g53fh8/AABa11NOl9oEhtqRZXJwJ41ea?dl=0
 ##### Conteudo:
 ##### ENEM 2014 original.
 ##### ENEM 2015 original.
 ##### ENEM 2014 filtrado.
 ##### ENEM 2015 filtrado.
