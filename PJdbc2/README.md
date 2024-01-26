## Demo: recuperar dados

*API:*
* Statement - Para montar um comando SQL e ser executado/ recuperar dados do BD.
* ResultSet: - Representa um objeto contendo o resutado da consulta em forma de tabela

         • first [move para posição 1, se houver]
         • beforeFirst [move para posição 0]
         • next [move para o próximo, retorna false se já estiver no último]
         • absolute(int) [move para a posição dada, lembrando que dados reais começam em 1]

*Checklist:*
* Usar o script SQL para criar a base de dados "coursejdbc"
* Fazer um pequeno programa para recuperar os departamentos
* Na classe DB, criar métodos auxiliares estáticos para fechar ResultSet e Statement.

Atenção: o objeto ResultSet contém os 
dados armazenados na forma de tabela:
          ![APIJavaMySQLTabela1](https://github.com/leila-bwt/DesafioII_API_REST_Cubos_Academi/assets/108028195/df0cc74e-22c1-441f-a4a4-aa6e29f26e28)

