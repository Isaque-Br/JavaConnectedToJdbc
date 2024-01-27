package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {
    
    public static void main(String[]args){
        
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                "DELETE FROM department "
                + "WHERE "
                + "Id = ?");

                st.setInt(1, 2);

                int rowsAffected = st.executeUpdate();
                System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException e) { // CASO OCORA EXCEPTION...IMPRIMA STACK TRACE
            throw new DbIntegrityException(e.getMessage()); // ..CAPTURA EXCECAO DO JDBC COM SQLEXCEPTION E LANÇA UMA EXCECAO PERSONALIZADA NOSSA.
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
