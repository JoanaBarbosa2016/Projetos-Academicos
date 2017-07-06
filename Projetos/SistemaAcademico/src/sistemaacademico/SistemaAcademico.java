/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaAcademico;

import Model.Matricula;
import View.JFrameBuscarAluno;
import View.JFrameBuscarCurso;
import View.JFrameCadastroAluno;
import View.JFrameCadastroCurso;
import java.util.Scanner;

/**
 *
 * @author Joana
 */
public class SistemaAcademico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner scanner = new Scanner(System.in); 
        int opcao;
        do {
            System.out.println(
                    
            "------------------------------------------------\n"+
                    "1- Controller\n"+
            "------------------------------------------------\n"+
                    "ACESSAR BANCO DE DADOS PELO jFRAME\n"+
                    "2-Vew para cadastrar aluno\n"+
                    "3-Vew para cadastrar curso\n"+
                    "4-Vew para exibir dados de alunos\n"+
                    "5-Vew para exibir dados de cursos\n"+
                    "0-Sair\n"+
           "------------------------------------------------\n"
            );
             opcao = scanner.nextInt();  
            switch(opcao){
                case 1:
                    Matricula matricula = new Matricula();
                    matricula.dataBase();
                break;
                case 2: 
                    JFrameCadastroAluno cadastro1 = new JFrameCadastroAluno();
                    cadastro1.setVisible(true);
                break;
                case 3:
                     JFrameCadastroCurso cadastro = new JFrameCadastroCurso();
                     cadastro.setVisible(true);
                break;
                case 4:
                     JFrameBuscarAluno aluno = new JFrameBuscarAluno();
                     aluno.setVisible(true);
                 break;
                case 5:
                     JFrameBuscarCurso curso = new JFrameBuscarCurso();
                     curso.setVisible(true);
                 break;
                }
            }while(opcao != 0);

}
}
    