# Java - API jdbc #

**Objetivo geral:**
 Conhecer os principais recursos do JDBC na teoria e prática
 Elaborar a estrutura básica de um projeto com JDBC
 Implementar o padrão DAO manualmente com JDBC

**Visão geral do JDBC**

![esquemaAPIJava1](https://github.com/leila-bwt/DesafioII_API_REST_Cubos_Academi/assets/108028195/9d5c90f0-e375-4bb6-9291-8ba2bcd32f55)


 JDBC (Java Database Connectivity): API padrão do Java para acesso a dados
 Páginas oficiais: 
o https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/
o https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html
 Pacotes: java.sql e javax.sql (API suplementar para servidores)

*Instalação das ferramentas:*
 Instalar o MySQL Server e o MySQL Workbench

## Preparação do primeiro projeto

*Checklist:*
* Usando o MySQL Workbench, crie uma base de dados chamada "coursejdbc"
* Baixar o MySQL Java Connector
* Caso ainda não exista, criar uma User Library contendo o arquivo .jar do driver do MySQL
      o Window -> Preferences -> Java -> Build path -> User Libraries
      o Dê o nome da User Library de MySQLConnector
      o Add external JARs -> (localize o arquivo jar)
* Criar um novo Java Project
      o Acrescentar a User Library MySQLConnector ao projeto
* Na pasta raiz do projeto, criar um arquivo "db.properties" contendo os dados de conexão:
user=usuario
password=senha
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false
* No pacote "db", criar uma exceção personalizada DbException
* No pacote "db", criar uma classe DB com métodos estáticos auxiliares
      o Obter e fechar uma conexão com o banco