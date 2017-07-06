/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademico;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class Persistencia {
    Scanner ler = new Scanner(System.in);
    Aluno aluno = new Aluno();
    Curso curso = new Curso();
    Matricula matricula = new Matricula();
    private static Connection conn = null; 
    ResultSet rs = null;
    PreparedStatement ps = null;
    
 public Persistencia()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //Obteendo uma conexão com o banco de dados
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/matricula", "root", "");
            System.out.println("Conexao Aberta!!...");
        }
        catch (ClassNotFoundException ex)
        {
         System.err.println("Nao foi possivel conectar ao banco de dados \n" + ex);
        }
        catch(SQLException e){
            System.out.println("Nao foi possivel encontrar o driver\n" +e);
        }
    }
    
    public static Connection conexao()
    {
        if (conn == null)
             new Persistencia();
        
        return conn;
    }
    
    private void insereDadosNoBanco(){
        
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
private void alteraDadosDoBanco()
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

 
    private void excluiDadosDoBanco()
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
    
    private void carregaDadosDoBanco() {
        try{
        
            ps =  Persistencia.conexao().prepareStatement("Select * from matricula" ); 
            rs = ps.executeQuery();
            
            DefaultTableModel dtm = new DefaultTableModel(new String[]{"dataMatricula","numeroMatricula"}, 0);
            System.out.println("Dados de matriculas:\n");
            
            while(rs.next())
            {
                String[] dados = {rs.getString("dataMatricula"), rs.getString("numeroMatricula")};          
                dtm.addRow(dados);
                System.out.println(Arrays.toString(dados));
            }
            
            System.out.println("\nDeseja excluir?\n <s/n>\n");
                    String opcao = ler.next();     
                    if("s".equals(opcao)){
                         System.out.println("\nO registro sera excluido...\n");  
                    excluiDadosDoBanco();
                     System.out.println("\n-------------------------------\n");
                         System.out.println("\nexcluído com sucesso\n");
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

public void dataBase(){
    Matricula matricula = new Matricula();
    Matricula paginaDeCadastro = new Matricula();
    try{
    int opcao = 10;
    while(opcao!=0){
         System.out.println("\nEscolha sua opção\n");
         System.out.println
            (
                  "1-Cadastrar alunos gravando em arquivo\n" + 
                  "2-Cadastrar curso gravando em arquivo\n" + 
                  "3-Matricular aluno em um curso gravando em arquivo\n" +
                  "4-Inserir dados de alunos e cursos no banco \n" + 
                  "5-Excluir dados de cursos do Banco\n" + 
                  "6-Carregar dados de matriculas do Banco\n" +   
                  "7-Imprime natricula do arquivo (txt)\n"+
                  "8-Carrega dados de alunos do banco para alterá-los\n"+
                  "9-Altera dados de alunos no banco\n"+
                  "0-sair\n"
            );
            opcao = ler.nextInt();
            switch(opcao){
                case 1:paginaDeCadastro.cadastrarAlunos();                    
                     break;
                case 2:paginaDeCadastro.cadastrarCursos();                
                     break;
                case 3:paginaDeCadastro.matricularAlunosEmCursos();               
                     break;
                case 4:insereDadosNoBanco();
                     break;
                case 5: excluiDadosDoBanco();
                     break; 
                case 6:carregaDadosDoBanco();
                     break;
                case 7:matricula.imprime_Em_Tela_AlunosECursos();
                     break;
                case 8:carregaDadosDoBanco_E_Altera();
                     break;
                case 9:alteraDadosDoBanco();
                     break;
                case 0:
            }
    }
}catch(Exception erro)
        {
            System.err.println("\nFinalizado devido a erro\n" + erro);
        }
    
     
}
    
}

