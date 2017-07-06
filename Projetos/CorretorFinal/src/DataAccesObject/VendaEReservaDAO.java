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

/**
 *
 * @author berna
 */
public class VendaEReservaDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public void reserva(int codImovel, int codComprador) {
        try {
            ps = DataSource.conexao().prepareStatement("INSERT INTO vendaereserva (codImovel, codComprador, status) VALUES (?,?, ?)");
            ps.setInt(1, codImovel);
            ps.setInt(2, codComprador);
            ps.setInt(3, 1);
            ps.executeUpdate();

            ps = DataSource.conexao().prepareStatement("UPDATE imovel SET status = ? WHERE codigo = " + codImovel);
            ps.setInt(1, 1);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }

    public void cancelarReserva(int codImovel) {
        try {
            ps = DataSource.conexao().prepareStatement("SELECT * FROM vendaereserva WHERE codImovel = " + codImovel);
            rs = ps.executeQuery();
            while (rs.next()) {

                ps = DataSource.conexao().prepareStatement("DELETE FROM vendaereserva WHERE codImovel = " + codImovel);
                ps.executeUpdate();
            }

            ps = DataSource.conexao().prepareStatement("UPDATE imovel SET status = ? WHERE codigo = " + codImovel);
            ps.setInt(1, 0);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);;
        }
    }

    public void cancelarVenda(int codImovel) {
        try {
            ps = DataSource.conexao().prepareStatement("SELECT * FROM vendaereserva WHERE codImovel = " + codImovel);
            rs = ps.executeQuery();
            while (rs.next()) {

                ps = DataSource.conexao().prepareStatement("DELETE FROM vendaereserva WHERE codImovel = " + codImovel);
                ps.executeUpdate();
            }

            ps = DataSource.conexao().prepareStatement("UPDATE imovel SET status = ? WHERE codigo = " + codImovel);
            ps.setInt(1, 0);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);;
        }
    }
    
    public int vendaComReserva(int codigoImovel){
        Comprador c = new Comprador();
        CompradorDAO comprador = new CompradorDAO();
        int codComprador;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = DataSource.conexao().prepareStatement("SELECT * FROM vendaereserva WHERE codImovel = " + codigoImovel);
            rs = ps.executeQuery();
            
            while(rs.next()){
                c.setCodigo(rs.getInt("codComprador"));
                codComprador = c.getCodigo();
            }
        }
        catch(SQLException ex){
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
        System.out.println(codComprador = c.getCodigo());
        return (codComprador = c.getCodigo());
    }

    public void vendaSemBanco(int codImovel, int codComprador) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DataSource.conexao().prepareStatement("INSERT INTO vendaereserva (codImovel, codComprador, status) VALUES (?,?, ?)");
            ps.setInt(1, codImovel);
            ps.setInt(2, codComprador);
            ps.setInt(3, 2);
            ps.executeUpdate();

            ps = DataSource.conexao().prepareStatement("UPDATE imovel SET status = ? WHERE codigo = " + codImovel);
            ps.setInt(1, 2);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }

    public void vendaComBanco(int codImovel, int codComprador, int codBanco, int codFiador) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DataSource.conexao().prepareStatement("INSERT INTO vendaereserva (codImovel, codComprador, codBanco, codFiador, status) VALUES (?,?,?,?,?)");
            ps.setInt(1, codImovel);
            ps.setInt(2, codComprador);
            ps.setInt(3, codBanco);
            ps.setInt(4, codFiador);
            ps.setInt(5, 2);
            ps.executeUpdate();

            ps = DataSource.conexao().prepareStatement("UPDATE imovel SET status = ? WHERE codigo = " + codImovel);
            ps.setInt(1, 2);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }
    
    public void vendaReservaSemBanco(int codImovel, int codComprador) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DataSource.conexao().prepareStatement("UPDATE vendaereserva SET codImovel = ?, codComprador = ?, status = ?");
            ps.setInt(1, codImovel);
            ps.setInt(2, codComprador);
            ps.setInt(3, 2);
            ps.executeUpdate();

            ps = DataSource.conexao().prepareStatement("UPDATE imovel SET status = ? WHERE codigo = " + codImovel);
            ps.setInt(1, 2);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }

    public void vendaReservaComBanco(int codImovel, int codComprador, int codBanco, int codFiador) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DataSource.conexao().prepareStatement("UPDATE vendaereserva SET codImovel = ?, codComprador = ?, codBanco = ?, codFiador = ?, status = ?");
            ps.setInt(1, codImovel);
            ps.setInt(2, codComprador);
            ps.setInt(3, codBanco);
            ps.setInt(4, codFiador);
            ps.setInt(5, 2);
            ps.executeUpdate();

            ps = DataSource.conexao().prepareStatement("UPDATE imovel SET status = ? WHERE codigo = " + codImovel);
            ps.setInt(1, 2);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Não foi possível executar o comando sql:  1" + ex);
        }
    }

}
