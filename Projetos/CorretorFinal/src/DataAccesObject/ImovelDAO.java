/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import Models.Imovel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author berna
 */
public class ImovelDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Scanner ler = new Scanner(System.in);

    //int contImovel = 1;
    int resposta;

    public void cadImovel(Imovel i) {
        try {
            ps = DataSource.conexao().prepareStatement("INSERT INTO imovel (codigo, tipo, descricao, endereco, numero,"
                    + "bairro, cidade, estado, complemento, valor, status) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, i.getCodigo());
            ps.setInt(2, i.getTipo());
            ps.setString(3, i.getDescricao());
            ps.setString(4, i.getEndereco());
            ps.setInt(5, i.getNumero());
            ps.setString(6, i.getBairro());
            ps.setString(7, i.getCidade());
            ps.setInt(8, i.getEstado());
            ps.setString(9, i.getComplemento());
            ps.setFloat(10, i.getValor());
            ps.setInt(11, i.getStatus());

            ps.executeUpdate();
            //contImovel++;
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }

    public void alterarImovel(Imovel i, int cod) {
        try {
            ps = DataSource.conexao().prepareStatement("UPDATE imovel SET tipo = ?, descricao = ?, endereco = ? ,numero = ?, bairro = ?, cidade = ?, estado = ?, complemento = ?, valor = ?, status = ? WHERE codigo = " + cod);

            ps.setInt(1, i.getTipo());
            ps.setString(2, i.getDescricao());
            ps.setString(3, i.getEndereco());
            ps.setInt(4, i.getNumero());
            ps.setString(5, i.getBairro());
            ps.setString(6, i.getCidade());
            ps.setInt(7, i.getEstado());
            ps.setString(8, i.getComplemento());
            ps.setFloat(9, i.getValor());
            ps.setInt(10, i.getStatus());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }

    public ArrayList<Imovel> listarImovelTodos() throws Exception {
        try {
            ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
            String sql = "SELECT * FROM imovel";
            sql += " ORDER BY codigo";
            // pega a conexão e o Statement
            ps = DataSource.conexao().prepareStatement(sql);
            // executa um select
            ResultSet rs = ps.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setCodigo(rs.getInt("codigo"));
                imovel.setTipo(rs.getInt("tipo"));
                imovel.setDescricao(rs.getString("descricao"));
                imovel.setEndereco(rs.getString("endereco"));
                imovel.setNumero(rs.getInt("numero"));
                imovel.setBairro(rs.getString("bairro"));
                imovel.setCidade(rs.getString("cidade"));
                imovel.setEstado(rs.getInt("estado"));
                imovel.setComplemento(rs.getString("complemento"));
                imovel.setValor(rs.getFloat("valor"));
                imovel.setStatus(rs.getInt("status"));
                // adicionando o objeto à lista
                imoveis.add(imovel);

            }
            return imoveis;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }
    }

    public ArrayList<Imovel> listarImovel(String descricao) throws Exception {
        try {
            String query = "SELECT * FROM imovel WHERE LOWER(descricao) LIKE ?";
            ps = DataSource.conexao().prepareStatement(query);
            ps.setString(1, '%' + descricao + '%');

            ResultSet rs = ps.executeQuery();
            ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
            // itera no ResultSet
            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setCodigo(rs.getInt("codigo"));
                imovel.setTipo(rs.getInt("tipo"));
                imovel.setDescricao(rs.getString("descricao"));
                imovel.setEndereco(rs.getString("endereco"));
                imovel.setNumero(rs.getInt("numero"));
                imovel.setBairro(rs.getString("bairro"));
                imovel.setCidade(rs.getString("cidade"));
                imovel.setEstado(rs.getInt("estado"));
                imovel.setComplemento(rs.getString("complemento"));
                imovel.setValor(rs.getFloat("valor"));
                imovel.setStatus(rs.getInt("status"));
                // adicionando o objeto à lista
                imoveis.add(imovel);

            }
            return imoveis;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }
    }

    public Imovel imovelBuscarImovel(int codigo) {
        Imovel i = new Imovel();
        try {

            ps = DataSource.conexao().prepareStatement("SELECT * FROM imovel WHERE codigo = " + codigo);
            rs = ps.executeQuery();

            while (rs.next()) {//aqui será exibido o resultado da busca
                i.setCodigo(rs.getInt("codigo"));
                i.setTipo(rs.getInt("tipo"));
                i.setDescricao(rs.getString("descricao"));
                i.setEndereco(rs.getString("endereco"));
                i.setNumero(rs.getInt("numero"));
                i.setBairro(rs.getString("bairro"));
                i.setCidade(rs.getString("cidade"));
                i.setEstado(rs.getInt("estado"));
                i.setComplemento(rs.getString("complemento"));
                i.setValor(rs.getFloat("valor"));
                i.setStatus(rs.getInt("status"));
            }
        } catch (Exception erro) {
            System.err.println("Não foi possível executar o comando SQL" + erro);
        }
        return i;
    }

    public void excluirImovel(int codigo) {
        try {
            ps = DataSource.conexao().prepareStatement("SELECT * FROM imovel WHERE codigo = " + codigo);
            rs = ps.executeQuery();
            while (rs.next()) {

                ps = DataSource.conexao().prepareStatement("DELETE FROM imovel WHERE codigo = " + codigo);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);;
        }
    }

    public void VendaImovel(int idImovel) {
        try {
            ps = DataSource.conexao().prepareStatement("SELECT FROM imovel WHERE codigo = " + idImovel);
            ps.executeUpdate();

            while (rs.next()) {
                if (rs.getString("status").equals("disponivel") || rs.getString("status").equals("reservado")) {
                    System.out.println("Deseja vender o imóvel " + rs.getString("descricao") + "localizado em "
                            + rs.getString("endereco") + "número" + rs.getString("numero") + "na cidade de "
                            + rs.getString("cidade"));
                } else {
                    System.out.println("");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql: " + ex);
        }
    }

    public int numeroLinhas() {
        int num = 0;
        try {
            ps = DataSource.conexao().prepareStatement("SELECT COUNT(*) FROM imovel");
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

    public void RelatorioVenda() throws Exception {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject("relatorios/relatorioImoveisVendidos.jasper");
            String sql = ("SELECT* From imovel Where status=" + 2);
            // pega a conexão e o Statement
            ps = DataSource.conexao().prepareStatement(sql);
            // executa um select
            rs = ps.executeQuery(sql);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            HashMap map = new HashMap();
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, map, jrRS);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            jv.setVisible(true);
            jv.toFront();

        } catch (SQLException e) { //vrata os erros SQL

            throw new Exception("Erro! " + e.getMessage());
        }

    }

    public void RelatorioReserva() throws Exception {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject("relatorios/relatorioImoveisReservados.jasper");
            String sql = ("SELECT* From imovel Where status=" + 1);
            // pega a conexão e o Statement
            ps = DataSource.conexao().prepareStatement(sql);
            // executa um select
            rs = ps.executeQuery(sql);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            HashMap map = new HashMap();
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, map, jrRS);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            jv.setVisible(true);
            jv.toFront();

        } catch (SQLException e) { //vrata os erros SQL

            throw new Exception("Não Há imoveis reservados! " + e.getMessage());
        }

    }

    public void RelatorioDisponivel() throws JRException, Exception {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject("relatorios/relatorioImoveisDisponiveis.jasper");
            String sql = ("SELECT* From imovel Where status=" + 0);
            // pega a conexão e o Statement
            ps = DataSource.conexao().prepareStatement(sql);
            // executa um select
            rs = ps.executeQuery(sql);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            HashMap map = new HashMap();
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, map, jrRS);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            jv.setVisible(true);
            jv.toFront();

        } catch (SQLException e) { //vrata os erros SQL

            throw new Exception("Erro! " + e.getMessage());
        }
    }

    public void RelatorioImoveis() throws JRException, Exception {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject("relatorios/relatorioImoveisTodos.jasper");
            String sql = "SELECT* From imovel";
            // pega a conexão e o Statement
            ps = DataSource.conexao().prepareStatement(sql);
            // executa um select
            rs = ps.executeQuery(sql);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            HashMap map = new HashMap();
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, map, jrRS);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            jv.setVisible(true);
            jv.toFront();

        } catch (SQLException e) { //vrata os erros SQL

            throw new Exception("Erro! " + e.getMessage());
        }
    }
}
