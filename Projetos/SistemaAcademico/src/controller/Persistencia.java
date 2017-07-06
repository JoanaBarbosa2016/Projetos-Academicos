/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
/**
 *
 * @author Joana
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Persistencia {
    private static Connection conn = null; 

    
 private Persistencia()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //Obteendo uma conexão com o banco de dados
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/matricula", "root", "");
            System.out.println("Conexao Aberta!!...");
        }
        catch (ClassNotFoundException ex)
        {
         System.err.println("Nao foi possivel conectar ao banco de dados \n" + ex);
        }
        catch(SQLException e){
            System.out.println("Nao foi possivel encontrar o driver\n" +e);
        }
    }
    
    public static Connection conexao()
    {
        if (conn == null)
             new Persistencia();
        
        return conn;
    }
    
    
    

    
}

