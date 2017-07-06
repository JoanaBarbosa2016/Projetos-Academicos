/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author berna
 */
public class DataSource {
    private static Connection conn = null;
    private Connection conexao; 
    
    //Estabelece conexão com o BD
    public DataSource(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/corretor", "root","");
            System.out.println("Conectado ao banco de dados");           
        }
       
        catch(ClassNotFoundException ex){
            System.out.println("Não foi possível encontrar o Driver especificiado: " + ex);
        }
        
        catch (SQLException ex){
            System.out.println("Não foi possível conectar ao banco de dados: " + ex);
        }
        
    }
    
    //Retorna status da conexão
    public static Connection conexao() throws SQLException{
        if(conn == null)
            new DataSource();
        return conn;
    }
    
    //Encerra conexao
    public void closeDataSource(){
        try{
            conexao.close();
        }
        catch(Exception e){
            System.out.println("\nErro ao fechar conexão\n" + e);
        }
    }
    
}
