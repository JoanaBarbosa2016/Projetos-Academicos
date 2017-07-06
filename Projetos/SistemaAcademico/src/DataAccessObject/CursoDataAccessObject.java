/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Model.Curso;
import controller.Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joana
 */
public class CursoDataAccessObject {
    Scanner ler = new Scanner(System.in);
    PreparedStatement ps = null;
    ResultSet rs = null;
    Curso curso = new Curso();
    
    public void insereDadosNoBancoC(){   
        try{ 
            ps = Persistencia.conexao().prepareStatement("Insert Into curso(nomeCurso,codigoCurso,cargaHoraria) values (?,?,?)");    
            ps.setString(1,curso.getNomeCurso());
            ps.setString(2,curso.getCodigoCurso());
            ps.setString(3,curso.getCargaHoraria());
            ps.executeUpdate();
            
            System.out.println("\nOs dados foram inseridos no banco.....\n");
        }
        catch(SQLException e)
        {
            System.err.println("Nao foi possivel executar o comando sql " + e);
        }
    }
    public void excluiDadosDoBanco()
    {
        try
        {  
            
            ps = Persistencia.conexao().prepareStatement("Delete from curso where nomeCurso = ?");
            System.out.println("Digite o nome do curso a ser excluido \n");
            curso.setNomeCurso(ler.next());
            ps.setString(1,curso.getNomeCurso());
            System.out.println("\nexcluído com sucesso\n");
            System.out.println("\n-------------------------------------\n");
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("Não foi possível executar o comando SQL");

        }
        }
            
    
    public void carregaDadosDoBanco() {
        try{
        
            ps =  Persistencia.conexao().prepareStatement("Select * from curso" ); 
            rs = ps.executeQuery();
            
            DefaultTableModel dtm = new DefaultTableModel(new String[]{"nomeCurso","codigoCurso","codigoCurso"}, 0);
            System.out.println("Dados do curso:\n");
            
            while(rs.next())
            {
                String[] dados = {rs.getString("nomeCurso"), rs.getString("codigoCurso"), rs.getString("cargaHoraria")};          
                dtm.addRow(dados);
                System.out.println(Arrays.toString(dados));
            }
            
            System.out.println("\nDeseja excluir?\n <s/n>\n");
                    String opcao = ler.next();     
                    if("s".equals(opcao)){
                         System.out.println("\nO registro sera excluido...\n");  
                    excluiDadosDoBanco();
                    }
        }catch(SQLException e)
        {
            System.err.println("Não foi possível executar o comando SQL");
            
        }
       
    }



        public ArrayList<Curso> listarCursos(String pegarDados) throws Exception{
        try{
            ArrayList<Curso> cursos = new ArrayList<Curso>();
            String sql = "SELECT * FROM curso";
            if(pegarDados != ""){
                sql += " WHERE LOWER(nomeCurso) LIKE '%"+ pegarDados.toLowerCase() +"%'";
            }
            sql+=" ORDER BY codigoCurso";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                curso.setNomeCurso(rs.getString("nomeCurso"));
                curso.setCodigoCurso(rs.getString("codigoCurso"));
                curso.setCargaHoraria(rs.getString("cargaHoraria"));
                cursos.add(curso);
            }
            return cursos;
        }                       
        catch(SQLException e){
                throw new Exception("Não foi possível executar a busca.");
        } 
    }
}
    
