/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import Models.Corretor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author berna
 */
public class CorretorDAO {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Scanner ler = new Scanner(System.in);
    Corretor c = new Corretor();
    int contCorretor = 1;
    int resposta;
    
    //int codigo
    //String nome;
    //String cpf;
    //String usuario;
    //String senha;
    
    public void  cadCorretor(Corretor c){
        try {
            ps = DataSource.conexao().prepareStatement("INSERT INTO corretor (nome, cpf, usuario,"
                    + "senha,tipo_usuario) VALUES (?,?,?,?,?)");
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getUsuario());
            ps.setString(4, c.getSenha());
            ps.setInt(5, c.getTipo_usuario());
        
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1"+ex);
        }
    }
    
    public void alterarCorretor(Corretor c, int cod) {
        try {
            ps = DataSource.conexao().prepareStatement("UPDATE corretor SET nome = ?, cpf = ?, usuario = ? ,senha = ?,tipo_usuario = ? WHERE codigo = " + cod);

            //ps.setInt(1, b.getCodigo());
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getUsuario());
            ps.setString(4, c.getSenha());
            ps.setInt(5, c.getTipo_usuario());

            ps.executeUpdate();
            //contBanco++;
            //System.out.println("CADASTROU");
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }

    public ArrayList<Corretor> listarCorretorTodos() throws Exception {
        try {
            ArrayList<Corretor> corretores = new ArrayList<Corretor>();
            String sql = "SELECT * FROM corretor";
            sql += " ORDER BY codigo";
            // pega a conexão e o Statement
            ps = DataSource.conexao().prepareStatement(sql);
            // executa um select
            ResultSet rs = ps.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                Corretor corretor = new Corretor();
                corretor.setCodigo(rs.getInt("codigo"));
                corretor.setNome(rs.getString("nome"));
                corretor.setCpf(rs.getString("cpf"));
                corretor.setUsuario(rs.getString("usuario"));
                corretor.setSenha(rs.getString("senha"));
                corretor.setTipo_usuario(rs.getInt("tipo_usuario"));
                // adicionando o objeto à lista
                corretores.add(corretor);

            }
            return corretores;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }
    }

    public ArrayList<Corretor> listarCorretor(String nome) throws Exception {
        try {
            String query = "SELECT * FROM corretor WHERE LOWER(nome) LIKE ?";
            ps = DataSource.conexao().prepareStatement(query);
            ps.setString(1, '%' + nome + '%');

            ResultSet rs = ps.executeQuery();
            ArrayList<Corretor> corretores = new ArrayList<Corretor>();
            // itera no ResultSet
            while (rs.next()) {
                Corretor corretor = new Corretor();
                corretor.setCodigo(rs.getInt("codigo"));
                corretor.setNome(rs.getString("nome"));
                corretor.setCpf(rs.getString("cpf"));
                corretor.setUsuario(rs.getString("usuario"));
                corretor.setSenha(rs.getString("senha"));
                corretor.setTipo_usuario(rs.getInt("tipo_usuario"));
                // adicionando o objeto à lista
                corretores.add(corretor);

            }
            return corretores;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }
    }

    public Corretor corretorBuscarCorretor(int codigo) {
        Corretor c = new Corretor();
        try {

            ps = DataSource.conexao().prepareStatement("SELECT * FROM corretor WHERE codigo = " + codigo);
            rs = ps.executeQuery();

            while (rs.next()) {//aqui será exibido o resultado da busca
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setUsuario(rs.getString("usuario"));
                c.setSenha(rs.getString("senha"));
                c.setTipo_usuario(rs.getInt("tipo_usuario"));
            }
        } catch (Exception erro) {
            System.err.println("Não foi possível executar o comando SQL" + erro);
        }
        return c;
    }
    
    public void excluirCorretor(int codigo){
        try {
            ps = DataSource.conexao().prepareStatement("SELECT * FROM corretor WHERE codigo = " + codigo);
            rs = ps.executeQuery();
            while (rs.next()){
                    ps = DataSource.conexao().prepareStatement("DELETE FROM corretor WHERE codigo = " + codigo);    
                    ps.executeUpdate();
                }
            }
        catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);;
        }
    }
    
    public int numeroLinhas() {
        int num= 0;
        try {
            ps = DataSource.conexao().prepareStatement("SELECT COUNT(*) FROM corretor");
            rs = ps.executeQuery();
            //num = rs.getI;
            if(rs.next()){
                num = rs.getInt("COUNT(*)");
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);;
        }

        return num;
    }
    
}
