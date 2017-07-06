/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

/**
 *
 * @author berna
 */
//String nome;
//String endereco;
//int numero;
//String bairro;
//String cidade;
//private String cep;
//String estado;
//String cpf;
//String telefone;
import Models.Fiador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FiadorDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Scanner ler = new Scanner(System.in);
    int contFiador = 1;
    int resposta;

    public void cadFiador(Fiador f) {
        try {
            ps = DataSource.conexao().prepareStatement("INSERT INTO fiador (nome, endereco, numero,"
                    + "bairro, cidade, estado, cpf, telefone) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, f.getNome());
            ps.setString(2, f.getEndereco());
            ps.setInt(3, f.getNumero());
            ps.setString(4, f.getBairro());
            ps.setString(5, f.getCidade());
            ps.setString(6, f.getEstado());
            ps.setString(7, f.getCpf());
            ps.setString(8, f.getTelefone());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }

    }

    public void alterarFiador(Fiador f, int cod) {
        try {
            ps = DataSource.conexao().prepareStatement("UPDATE fiador SET nome = ?, endereco = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, cpf = ?, telefone  = ? WHERE codigo = " + cod);

            //ps.setInt(1, b.getCodigo());
            ps.setString(1, f.getNome());
            ps.setString(2, f.getEndereco());
            ps.setInt(3, f.getNumero());
            ps.setString(4, f.getBairro());
            ps.setString(5, f.getCidade());
            ps.setString(6, f.getEstado());
            ps.setString(7, f.getCpf());
            ps.setString(8, f.getTelefone());

            ps.executeUpdate();
            //contBanco++;
            //System.out.println("CADASTROU");
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }

    public ArrayList<Fiador> listarFiadorTodos() throws Exception {
        try {
            ArrayList<Fiador> fiadores = new ArrayList<Fiador>();
            String sql = "SELECT * FROM fiador";
            sql += " ORDER BY codigo";
            // pega a conexão e o Statement
            ps = DataSource.conexao().prepareStatement(sql);
            // executa um select
            ResultSet rs = ps.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                Fiador fiador = new Fiador();
                fiador.setCodigo(rs.getInt("codigo"));
                fiador.setNome(rs.getString("nome"));
                fiador.setEndereco(rs.getString("endereco"));
                fiador.setNumero(rs.getInt("numero"));
                fiador.setBairro(rs.getString("bairro"));
                fiador.setCidade(rs.getString("cidade"));
                fiador.setEstado(rs.getString("estado"));
                fiador.setCpf(rs.getString("cpf"));
                fiador.setTelefone(rs.getString("telefone"));
                // adicionando o objeto à lista
                fiadores.add(fiador);

            }
            return fiadores;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }
    }

    public ArrayList<Fiador> listarFiador(String nome) throws Exception {
        try {
            String query = "SELECT * FROM fiador WHERE LOWER(nome) LIKE ?";
            ps = DataSource.conexao().prepareStatement(query);
            ps.setString(1, '%' + nome + '%');

            ResultSet rs = ps.executeQuery();
            ArrayList<Fiador> fiadores = new ArrayList<Fiador>();
            // itera no ResultSet
            while (rs.next()) {
                Fiador fiador = new Fiador();
                fiador.setCodigo(rs.getInt("codigo"));
                fiador.setNome(rs.getString("nome"));
                fiador.setEndereco(rs.getString("endereco"));
                fiador.setNumero(rs.getInt("numero"));
                fiador.setBairro(rs.getString("bairro"));
                fiador.setCidade(rs.getString("cidade"));
                fiador.setEstado(rs.getString("estado"));
                fiador.setCpf(rs.getString("cpf"));
                fiador.setTelefone(rs.getString("telefone"));
                // adicionando o objeto à lista
                fiadores.add(fiador);

            }
            return fiadores;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }
    }

    public Fiador fiadorBuscarFiador(int codigo) {
        Fiador f = new Fiador();
        try {

            ps = DataSource.conexao().prepareStatement("SELECT * FROM fiador WHERE codigo = " + codigo);
            rs = ps.executeQuery();

            while (rs.next()) {//aqui será exibido o resultado da busca
                f.setCodigo(rs.getInt("codigo"));
                f.setNome(rs.getString("nome"));
                f.setEndereco(rs.getString("endereco"));
                f.setNumero(rs.getInt("numero"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));
                f.setEstado(rs.getString("estado"));
                f.setCpf(rs.getString("cpf"));
                f.setTelefone(rs.getString("telefone"));
            }
        } catch (Exception erro) {
            System.err.println("Não foi possível executar o comando SQL" + erro);
        }
        return f;
    }

    public void excluirFiador(int codigo) {
        try {
            ps = DataSource.conexao().prepareStatement("SELECT * FROM fiador WHERE codigo = " + codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                ps = DataSource.conexao().prepareStatement("DELETE FROM fiador WHERE codigo = " + codigo);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);;
        }
    }
   

    public int numeroLinhas() {
        int num = 0;
        try {
            ps = DataSource.conexao().prepareStatement("SELECT COUNT(*) FROM fiador");
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
