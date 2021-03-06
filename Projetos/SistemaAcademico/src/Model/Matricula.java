/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataAccessObject.AlunoDataAccessObject;
import DataAccessObject.CursoDataAccessObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joana
 */
public class Matricula {
    private String dataMatricula;
    private String numeroMatricula;
    
    
    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }
    
    
   public static  ArrayList<String> listaAluno = new ArrayList<String>();
    public static ArrayList<String> listaCodigoAluno = new ArrayList<String>();
    public static ArrayList<String> listaCodigoCurso = new ArrayList<String>();
    public static ArrayList<String> listaCpf = new ArrayList<String>();
    public static ArrayList<String> listaCurso = new ArrayList<String>();
    public static ArrayList<String> listaCargaHoraria = new ArrayList<String>();
    
    Scanner ler = new Scanner(System.in);
    Curso curso = new Curso();
    Aluno aluno = new Aluno();
    
           
    
    public void imprime_Em_Tela_AlunosECursos() {
           try{
            FileReader arquivo = new FileReader("matricula.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            
            String[] matricula = new String[6];
            
            String linha = lerArquivo.readLine();
             matricula = linha.split("-"); 
            
            while(linha != null){  
              System.out.println("Dados da matricula:\n"); 
              System.out.println("-------------------------------------------");
              for(String lendo: matricula) {               
              System.out.println(lendo);
              
                }
               System.out.println("------------------------------------------");
               linha = lerArquivo.readLine();                  
                }
            lerArquivo.close();
            }
            catch(Exception erro)
                {
            System.err.println("Erro\n" + erro + "\n"); 
        }
    }
    
public void cadastrarAlunos(){                   
                    try{
                
            FileWriter arquivo = new FileWriter("aluno.txt");
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
                        System.out.println("Digite o nome do aluno\n");
                        aluno.setNome(ler.next());
                        System.out.println("Digite o codigo do aluno\n");
                        aluno.setCodigo(ler.next()); 
                        System.out.println("Digite o cpf do aluno\n");
                        aluno.setCpf(ler.next());    
                  for(int cont = 0; cont < listaAluno.size(); cont++)
                    {
                       gravarArquivo.write(listaAluno.get(cont) + "||" + listaCodigoAluno.get(cont) + "||" + listaCpf.get(cont) + "\n");
                       System.out.println("\nOs arquivos foram gravados com sucesso\n");
                    }
                   gravarArquivo.close();
                    } catch (Exception erro)
                    {
                        System.out.println("\nErro no cadastro do aluno\n");
                    }        
 }

public void cadastrarCursos(){ 
                    try
                    {
                            
            FileWriter arquivo = new FileWriter("curso.txt");
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
                        System.out.println("Digite o nome do curso\n");
                        curso.setNomeCurso(ler.next());
                        System.out.println("Digite o codigo do curso\n");
                        curso.setCodigoCurso(ler.next());
                        System.out.println("Digite a carga horária do curso\n");
                        curso.setCargaHoraria(ler.next());
                        for(int cont = 0; cont < listaCurso.size(); cont++){
                        gravarArquivo.write(listaCurso.get(cont) + "||" + listaCodigoCurso.get(cont) + "||" + listaCargaHoraria.get(cont) + "\n");
                        System.out.println("\nOs arquivos foram gravados com sucesso\n");
                          } 
                        gravarArquivo.close();
                    }catch(Exception erro)
                         {
                        System.err.println("\nErro " + erro);
                    }
}
public void matricularAlunosEmCursos() {
    String nomeProcurado;
                    try{                
            FileWriter arquivo = new FileWriter("matricula.txt");
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
                    System.out.println("Digite o Codigo do aluno");
                    String codProcurado = ler.next();

                    for(int cont = 0; cont< listaCodigoAluno.size(); cont++)
                    {
                        if(codProcurado.equals(listaCodigoAluno.get(cont)))
                        {
                            System.out.println("\n O nome do Aluno e: " + listaAluno.get(cont));      
                                        
                        }
                        else
                        {
                            System.out.println("Aluno nao Encontrado");  
                            break;
                        }
                    }
                        
                    System.out.println("\nDigite o codigo do curso a ser matriculado\n");
                    String codigocursoProcurado = ler.next();
                            
                    for(int cont1 = 0; cont1 < listaCodigoCurso.size(); cont1++)
                    {
                        if(codigocursoProcurado.equals(listaCodigoCurso.get(cont1)))
                        {
                             gravarArquivo.write("Nome:"+listaAluno.get(cont1) + "-" + "Codigo:"+listaCodigoAluno.get(cont1) +"-" +"Curso:"+ listaCurso.get(cont1));
                             System.out.println("\n--------------------------------------\n");
                             System.out.println("\nMatricula realizada com sucesso.......\n");
                        }
                        else
                        {
                        System.out.println("ERRO, ALUNO OU MATRÍCULA NÃO EXISTE");
                    }
                     gravarArquivo.close();
                }
                    }catch(Exception erro){
            System.err.println("\n" + erro);
        }
}
 
    
   

public void dataBase(){
    AlunoDataAccessObject alunno = new AlunoDataAccessObject();
    CursoDataAccessObject cursso = new CursoDataAccessObject();
    Matricula matricula = new Matricula();
    Matricula paginaDeCadastro = new Matricula();
    try{
    int opcao = 15;
    while(opcao!=0){
         System.out.println("\nEscolha sua opção\n");
         System.out.println
            (
                  "1-Cadastrar alunos gravando em arquivo\n" + 
                  "2-Cadastrar curso gravando em arquivo\n" + 
                  "3-Matricular aluno em um curso gravando em arquivo\n" +
                  "4-Inserir dados de alunos no banco \n" + 
                  "5-Inserir dados de cursos no banco \n" + 
                  "6-Excluir dados de cursos do Banco\n" + 
                  "7-Carregar dados de cursos do Banco\n" +   
                  "8-Imprime natricula do arquivo (txt)\n"+
                  "9-Carrega dados de alunos do banco para alterá-los\n"+
                  "10-Altera dados de alunos no banco\n"+
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
                case 4:alunno.insereDadosNoBancoA();
                     break;
                case 5:cursso.insereDadosNoBancoC();
                     break;                   
                case 6:cursso.excluiDadosDoBanco();
                     break; 
                case 7:cursso.carregaDadosDoBanco();
                     break;
                case 8:matricula.imprime_Em_Tela_AlunosECursos();
                     break;
                case 9:alunno.carregaDadosDoBanco_E_Altera();
                     break;
                case 10:alunno.alteraDadosDoBanco();
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
