/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corretorimoveis;

import DataAccesObject.DataSource;
import Views.*;

/**
 *
 * @author berna
 */
public class CorretorImoveis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Criando conexão com o banco de dados
        System.out.println("Conectando ao banco de dados...\n");
        DataSource dataSource = new DataSource();
        
        

                        //BANCO - OK
        //JFrameCadastrarBanco cadBanco = new JFrameCadastrarBanco(); //Cadastrar Banco
        //cadBanco.show();
        
        //JFrameBuscarBanco buscBanco = new JFrameBuscarBanco(); //Tela de busca para Alterar e Excluir
        //buscBanco.show();
        
                        //COMPRADOR - OK
        //JFrameCadastrarComprador cadComprador = new JFrameCadastrarComprador(); //Cadastrar Comprador
        //cadComprador.show();
        
        //JFrameBuscarComprador buscComprador = new JFrameBuscarComprador(); //Tela de busca para Alterar e Excluir
        //buscComprador.show();
        
                        //CORRETOR - OK
        //JFrameCadastroCorretor cadCorretor = new JFrameCadastroCorretor(); //Cadastrar Corretor
        //cadCorretor.show();
        
        //JFrameBuscarCorretor buscCorretor = new JFrameBuscarCorretor(); //Tela de busca para Alterar e Excluir
        //buscCorretor.show();
        
        
                        //FIADOR
        //JFrameCadastrarFiador cadFiador = new JFrameCadastrarFiador();
        //cadFiador.show();
        
        //JFrameBuscarFiador buscFiador = new JFrameBuscarFiador();
        //buscFiador.show();
        
        JFrameLogin frameLogin= new JFrameLogin();
        frameLogin.show();
        
        
                        //IMOVEIS
        //JFrameCadastrarImovel cadImoveis = new JFrameCadastrarImovel();
        //cadImoveis.show();
        
        //JFrameBuscarImovel buscImovel = new JFrameBuscarImovel(); //Tela de busca para Alterar e Excluir
        //buscImovel.show();
    }
}


