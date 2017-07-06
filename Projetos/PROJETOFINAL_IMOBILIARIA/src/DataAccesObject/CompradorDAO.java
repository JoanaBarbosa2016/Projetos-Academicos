/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import Models.Comprador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author berna
 */
public class CompradorDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Scanner ler = new Scanner(System.in);
    Comprador c = new Comprador();
    int contComprador = 1;
    int resposta;

    //int codigo;
    //String nome;
    //String endereco;
    //private int numero;
    //String bairro;
    //String cidade;
    //String estado;
    //String cpf;
    //String telefone;
    public void cadComprador(Comprador c) {
        try {
            ps = DataSource.conexao().prepareStatement("INSERT INTO comprador (nome, endereco, "
                    + "numero, bairro, cidade, estado, cpf, telefone) VALUES (?,?,?,?,?,?,?,?)");
            //ps.setInt(1, contComprador);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getEndereco());
            ps.setInt(3, c.getNumero());
            ps.setString(4, c.getBairro());
            ps.setString(5, c.getCidade());
            ps.setString(6, c.getEstado());
            ps.setString(7, c.getCpf());
            ps.setString(8, c.getTelefone());

            ps.executeUpdate();
            //contComprador ++;
            //System.out.println("CADASTROU!");
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }

    }

    public void alterarComprador(Comprador c, int cod) {
        try {
            ps = DataSource.conexao().prepareStatement("UPDATE comprador SET nome = ?, cpf = ?, endereco = ? ,numero = ?, bairro = ?, cidade = ?, estado = ?, telefone = ? WHERE codigo = " + cod);

            //ps.setInt(1, b.getCodigo());
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getEndereco());
            ps.setInt(4, c.getNumero());
            ps.setString(5, c.getBairro());
            ps.setString(6, c.getCidade());
            ps.setString(7, c.getEstado());
            ps.setString(8, c.getTelefone());

            ps.executeUpdate();
            //contBanco++;
            //System.out.println("CADASTROU");
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }

    public ArrayList<Comprador> listarCompradorTodos() throws Exception {
        try {
            ArrayList<Comprador> compradores = new ArrayList<Comprador>();
            String sql = "SELECT * FROM comprador";
            sql += " ORDER BY codigo";
            // pega a conexão e o Statement
            ps = DataSource.conexao().prepareStatement(sql);
            // executa um select
            ResultSet rs = ps.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                Comprador comprador = new Comprador();
                comprador.setCodigo(rs.getInt("codigo"));
                comprador.setNome(rs.getString("nome"));
                comprador.setEndereco(rs.getString("endereco"));
                comprador.setNumero(rs.getInt("numero"));
                comprador.setBairro(rs.getString("bairro"));
                comprador.setCidade(rs.getString("cidade"));
                comprador.setEstado(rs.getString("estado"));
                comprador.setCpf(rs.getString("cpf"));
                comprador.setTelefone(rs.getString("telefone"));
                // adicionando o objeto à lista
                compradores.add(comprador);

            }
            return compradores;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }
    }

    public ArrayList<Comprador> listarComprador(String nome) throws Exception {
        try {
            String query = "SELECT * FROM comprador WHERE LOWER(nome) LIKE ?";
            ps = DataSource.conexao().prepareStatement(query);
            ps.setString(1, '%' + nome + '%');

            ResultSet rs = ps.executeQuery();
            ArrayList<Comprador> compradores = new ArrayList<Comprador>();
            // itera no ResultSet
            while (rs.next()) {
                Comprador comprador = new Comprador();
                comprador.setCodigo(rs.getInt("codigo"));
                comprador.setNome(rs.getString("nome"));
                comprador.setEndereco(rs.getString("endereco"));
                comprador.setNumero(rs.getInt("numero"));
                comprador.setBairro(rs.getString("bairro"));
                comprador.setCidade(rs.getString("cidade"));
                comprador.setEstado(rs.getString("estado"));
                comprador.setCpf(rs.getString("cpf"));
                comprador.setTelefone(rs.getString("telefone"));
                // adicionando o objeto à lista
                compradores.add(comprador);

            }
            return compradores;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }
    }

    public Comprador compradorBuscarComprador(int codigo) {
        Comprador c = new Comprador();
        try {

            ps = DataSource.conexao().prepareStatement("SELECT * FROM comprador WHERE codigo = " + codigo);
            rs = ps.executeQuery();

            while (rs.next()) {//aqui será exibido o resultado da busca
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
            }
        } catch (Exception erro) {
            System.err.println("Não foi possível executar o comando SQL" + erro);
        }
        return c;
    }

    public void excluirComprador(int codigo) {
        try {
            ps = DataSource.conexao().prepareStatement("SELECT * FROM comprador WHERE codigo = " + codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                ps = DataSource.conexao().prepareStatement("DELETE FROM comprador WHERE codigo = " + codigo);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);;
        }
    }


    public int numeroLinhas() {
        int num = 0;
        try {
            ps = DataSource.conexao().prepareStatement("SELECT COUNT(*) FROM comprador");
            rs = ps.executeQuery();
            //num = rs.getI;
            if (rs.next()) {
                num = rs.getInt("COUNT(*)");
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);;
        }

        return num;
    }

}
