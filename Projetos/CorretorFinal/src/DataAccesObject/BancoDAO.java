/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import Models.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author berna
 */
public class BancoDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Scanner ler = new Scanner(System.in);
    Banco b = new Banco();
    int contBanco = 1;
    int resposta;

    public void cadBanco(Banco b) {
        try {
            ps = DataSource.conexao().prepareStatement("INSERT INTO banco (razaoSocial, cnpj, endereco, numero, bairro, cidade, estado, telefone) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, b.getRazaoSocial());
            ps.setString(2, b.getCnpj());
            ps.setString(3, b.getEndereco());
            ps.setInt(4, b.getNumero());
            ps.setString(5, b.getBairro());
            ps.setString(6, b.getCidade());
            ps.setString(7, b.getEstado());
            ps.setString(8, b.getTelefone());
            ps.executeUpdate();
                   } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:" + ex);
        }
    }

    public void alterarBanco(Banco b, int cod){
        try {
            ps = DataSource.conexao().prepareStatement("UPDATE banco SET razaoSocial = ?, cnpj = ?, endereco = ? ,numero = ?, bairro = ?, cidade = ?, estado = ?, telefone = ? WHERE codigo = " + cod);
            ps.setString(1, b.getRazaoSocial());
            ps.setString(2, b.getCnpj());
            ps.setString(3, b.getEndereco());
            ps.setInt(4, b.getNumero());
            ps.setString(5, b.getBairro());
            ps.setString(6, b.getCidade());
            ps.setString(7, b.getEstado());
            ps.setString(8, b.getTelefone());

            ps.executeUpdate();
            //contBanco++;
            //System.out.println("CADASTROU");
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }

    public ArrayList<Banco> listarBancoTodos() throws Exception {
        try {
            ArrayList<Banco> bancos = new ArrayList<Banco>();
            String sql = "SELECT * FROM banco";
            sql += " ORDER BY codigo";
            // pega a conexão e o Statement
            ps = DataSource.conexao().prepareStatement(sql);
            // executa um select
            ResultSet rs = ps.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                Banco banco = new Banco();
                banco.setCodigo(rs.getInt("codigo"));
                banco.setRazaoSocial(rs.getString("razaoSocial"));
                banco.setCnpj(rs.getString("cnpj"));
                banco.setEndereco(rs.getString("endereco"));
                banco.setNumero(rs.getInt("numero"));
                banco.setBairro(rs.getString("bairro"));
                banco.setCidade(rs.getString("cidade"));
                banco.setEstado(rs.getString("estado"));
                banco.setTelefone(rs.getString("telefone"));
                // adicionando o objeto à lista
                bancos.add(banco);

            }
            return bancos;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }
    }

    public ArrayList<Banco> listarBanco(String razao) throws Exception {
        try {
            String query = "SELECT * FROM banco WHERE LOWER(razaoSocial) LIKE ?";
            ps = DataSource.conexao().prepareStatement(query);
            ps.setString(1, '%' + razao + '%');

            ResultSet rs = ps.executeQuery();
            ArrayList<Banco> bancos = new ArrayList<Banco>();
            // itera no ResultSet
            while (rs.next()) {
                Banco banco = new Banco();
                banco.setCodigo(rs.getInt("codigo"));
                banco.setRazaoSocial(rs.getString("razaoSocial"));
                banco.setCnpj(rs.getString("cnpj"));
                banco.setEndereco(rs.getString("endereco"));
                banco.setNumero(rs.getInt("numero"));
                banco.setBairro(rs.getString("bairro"));
                banco.setCidade(rs.getString("cidade"));
                banco.setEstado(rs.getString("estado"));
                banco.setTelefone(rs.getString("telefone"));
                // adicionando o objeto à lista
                bancos.add(banco);

            }
            return bancos;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }
    }

    public Banco bancoBuscarBanco(int codigo) {
        Banco b = new Banco();
        try {

            ps = DataSource.conexao().prepareStatement("SELECT * FROM banco WHERE codigo = " + codigo);
            rs = ps.executeQuery();

            while (rs.next()) {//aqui será exibido o resultado da busca
                b.setCodigo(rs.getInt("codigo"));
                b.setRazaoSocial(rs.getString("razaoSocial"));
                b.setCnpj(rs.getString("cnpj"));
                b.setEndereco(rs.getString("endereco"));
                b.setNumero(rs.getInt("numero"));
                b.setBairro(rs.getString("bairro"));
                b.setCidade(rs.getString("cidade"));
                b.setEstado(rs.getString("estado"));
                b.setTelefone(rs.getString("telefone"));
            }
        } catch (Exception erro) {
            System.err.println("Não foi possível executar o comando SQL" + erro);
        }
        return b;
    }

    public void excluirBanco(int codigo) {
        try {
            ps = DataSource.conexao().prepareStatement("SELECT * FROM banco WHERE codigo = " + codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                ps = DataSource.conexao().prepareStatement("DELETE FROM banco WHERE codigo = " + codigo);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);;
        }
    }

    public int numeroLinhas() {
        int num = 0;
        try {
            ps = DataSource.conexao().prepareStatement("SELECT COUNT(*) FROM banco");
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
