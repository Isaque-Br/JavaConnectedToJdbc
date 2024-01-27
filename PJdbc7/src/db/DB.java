package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {    //CLASS PARA CARREGAR AS PROPRIEDADES DE db.properties
    
    private static Connection conn = null; // OBJTO DE CONNECTION COM BD DO JDBC

    public static Connection getConnection() { // metodo para conectar banco de dados usando conn
        if (conn == null) {
            try {
                Properties props = loadProperties(); // get nas propriedades de conexåo recebendo o metodo de load
                String url = props.getProperty("dburl");// PEGANDO URL 
                conn = DriverManager.getConnection(url, props);// CONECTANDO COM BD COM DriverManager(class do jdbc) passando as propiedades de conexao..e atribui a variavel conn
        }
        catch (SQLException e) {
            throw new db.DbException(e.getMessage());
        }
    }
        return conn;
}

public static void closeConnection() {
    if (conn != null) {
        try{
            conn.close();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}    

  private static Properties loadProperties() {
// METODO AUXILIAR PARA CARREGAR OS DADOS DE db.properties e guardar dentro de um objeto especifico
     try (FileInputStream fs = new FileInputStream("db.properties")) { // ABRINDO ARQUIVO NA RAIZ DO PROJETO
            Properties props = new Properties(); // STANCIA OBJETO TIPO PROPETIES E
            props.load(fs); //...LE O IMPUT APONTADO PELO fs E GUARDA OS DADOS DENTRO DO OBJETO props
             return props;
     }
     catch (IOException e) { // TRATANDO DUAS EXCECOES FILENOTFOUNDEXCEPTION AND IOEXCPETION
       throw new DbException(e.getMessage());
       }
   }

   public static void closeStatement(Statement st) {
    if (st != null) {
        try {
            st.close();
        }catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
   }

   public static void closeResultSet(ResultSet rs) {
    if (rs != null) {
        try {
            rs.close();
        }catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
   }
 }

