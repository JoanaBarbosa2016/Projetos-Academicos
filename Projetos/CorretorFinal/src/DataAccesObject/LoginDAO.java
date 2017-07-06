/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Models.Sessao;

/**
 *
 * @author berna
 */
public class LoginDAO {

    PreparedStatement ps = null;
    ResultSet rs;
    private String cpfUsuarioLogado, tipoUsuarioLogado;

    
    public Boolean login(String usuario, String senha) 
    {
        
        Boolean logado = false;
        
        try 
        {
            ps = DataSource.conexao().prepareStatement("SELECT * FROM administrador WHERE usuario = '" + usuario + "'");
            rs = ps.executeQuery();
            
            //aqui será exibido o resultado da busca  
            while (rs.next()) 
            {              
                System.out.println("Executando procedimento de busca no banco de dados...");
                
                if (usuario.equals(rs.getString("usuario")) && senha.equals(rs.getString("senha")))
                {
                    Sessao sessao = new Sessao();
                    setUsuariologado(rs.getString("cpf"), rs.getString("tipo_usuario"));
                    System.out.println("LOGADO\nSessão iniciada para usuário " + usuario + "\nTipo de permissão:" + rs.getString("tipo_usuario"));
                    
                    logado = true;
                }
            }
            
            //Se ainda não estiver logado como administrador, tente como corretor
            if(!logado)
            {
                ps = DataSource.conexao().prepareStatement("SELECT * FROM corretor WHERE usuario = '" + usuario + "'");
                rs = ps.executeQuery();
                
                while (rs.next()) 
                {              
                    if (usuario.equals(rs.getString("usuario")) && senha.equals(rs.getString("senha")))
                    {
                        Sessao sessao = new Sessao();
                        setUsuariologado(rs.getString("cpf"), rs.getString("tipo_usuario"));
                        System.out.println("LOGADO\nSessão iniciada para usuário " + usuario + "\nTipo de permissão:" + rs.getString("tipo_usuario"));
                        logado = true;
                    }
                }
            }
        } 
        catch (Exception erro) 
        {
            System.err.println("Não foi possível executar o comando SQL" + erro);
        }
        
        return logado;
    }
    private void setUsuariologado(String cpf, String tipoUsuario)
    {
            cpfUsuarioLogado = cpf;
            tipoUsuarioLogado = tipoUsuario;
    }
    
    public String getCPFUsuarioLogado()
    {
        return cpfUsuarioLogado;
    }
        
    public String getTipoUsuarioLogado()
    {
        return tipoUsuarioLogado;
    }
}
