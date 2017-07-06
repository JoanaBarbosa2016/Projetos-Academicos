
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package DataAccessObject;

import Model.Aluno;
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

public class AlunoDataAccessObject {
    Scanner ler = new Scanner(System.in);
    PreparedStatement ps = null;
    ResultSet rs = null;
    Aluno aluno = new Aluno();


public void insereDadosNoBancoA(){
            
        try
        {
            //Por meio da conexão realizada, devemos obter uma instância de um objeto Statement,
            //PreparedStatement, para passar comandos SQL ao BD
            //Criar objetos para executar operações no BD (execute (String), executeQuery (String), ExecuteUpdate(String)
            ps = Persistencia.conexao().prepareStatement("Insert Into aluno (nome,cpf,codigo) values (?,?,?)");    
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getCodigo());
            ps.executeUpdate();
        System.out.println("\nOs dados foram inseridos no banco.....\n");
        }
        catch(SQLException e)
        {
            System.err.println("Nao foi possivel executar o comando sql " + e);
        }

}

public void alteraDadosDoBanco()
    {
        try
        {  
            ps = Persistencia.conexao().prepareStatement("update aluno set nome=?,codigo=?,cpf=?");
            System.out.println("Digite o novo nome do aluno \n");
            aluno.setNome(ler.next());
            System.out.println("Digite o novo codigo do aluno\n");
            aluno.setCodigo(ler.next()); 
            System.out.println("Digite o  novo cpf do aluno\n");
            aluno.setCpf(ler.next());   
            ps.setString(1,aluno.getNome());
            ps.setString(2,aluno.getCodigo());
            ps.setString(3,aluno.getCpf());
            System.out.println("\nAlterado com sucesso\n");
            System.out.println("\n-------------------------------------\n");
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("Não foi possível executar o comando SQL");

        }
    }
    
    public void carregaDadosDoBanco_E_Altera() {
        try{
          
            ps =  Persistencia.conexao().prepareStatement("Select * from aluno" ); 
            rs = ps.executeQuery();
            
            DefaultTableModel dtm = new DefaultTableModel(new String[]{"nome","codigo","cpf"}, 0);
            System.out.println("Dados de alunos:\n");
             // operações  que retornam resultados do BD (um objeto Resultset(rs) – conjunto de registros)
            while(rs.next())
            {
                String[] dados = {rs.getString("nome"), rs.getString("codigo"),rs.getString("cpf")};          
                dtm.addRow(dados);
                System.out.println(Arrays.toString(dados));
            }
            
            System.out.println("\nDeseja realmente alterar?\n <s/n>\n");
                    String opcao = ler.next();     
                    if("s".equals(opcao)){
                         System.out.println("\nO registro sera alterado...\n");  
                    alteraDadosDoBanco();
                         System.out.println("\nalterado com sucesso\n");
                    }
        }catch(SQLException e)
        {
            System.err.println("Não foi possível executar o comando SQL");
            
        }
       
    }


public ArrayList<Aluno> listarAlunos(String pegaDados) throws Exception{
        try{
            ArrayList<Aluno> alunos = new ArrayList<Aluno>();
            String sql = "SELECT * FROM aluno";
            if(pegaDados != ""){
                sql += " WHERE LOWER(nome) LIKE '%"+ pegaDados.toLowerCase() +"%'";
            }
            sql+=" ORDER BY codigo";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                aluno.setNome(rs.getString("nome"));
                aluno.setCodigo(rs.getString("codigo"));
                aluno.setCpf(rs.getString("cpf"));
                alunos.add(aluno);
            }
            return alunos;
        }                       
        catch(SQLException e){
                throw new Exception("Não foi possível executar a busca.");
        }    
    }


}



