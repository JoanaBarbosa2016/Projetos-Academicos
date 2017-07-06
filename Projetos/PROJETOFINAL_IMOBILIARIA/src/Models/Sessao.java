/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *Classe que gerencia os dados do usuário logado
 * @author aluno
 */
public class Sessao
{
    private String cpf;
    private String descricao;
    Boolean sessaoIniciada;
    
    /**
     * Método para iniciar uma sessão de usuário
     * @param cpfUsuario CPF do usuário
     * @param tipoUsuario Tipo de usuário
     * @return Retorna true para sessão iniciada, false para falha ao iniciar sessão
     */
    public Boolean iniciaSessao(String cpfUsuario, String tipoUsuario)
    {
        try
        {
            cpf = cpfUsuario;
            descricao = tipoUsuario;
            sessaoIniciada = true;
        }
        catch(Exception e)
        {
            System.err.println("Erro ao criar sessão:\n" + e);
        }
        
        return sessaoIniciada;
    }
    
    /**
     * Método para finalizar a sessão do usuário
     * @return Retorna true para sessão finalizada e false para falha ao finalizar sessão
     */
    public Boolean finalizaSessao()
    {
        Boolean sessaoFinalizada = false;
        try
        {
            this.cpf = "";
            this.descricao = "";
            sessaoFinalizada = true;
        }
        catch(Exception e)
        {
            System.err.println("Erro ao finalizar sessão:\n" + e);
        }
        
        return sessaoFinalizada;
    }
    
    /**
     * Método que informa o cpf e a descrição do tipo de usuário logado (Posição 0 cpf, posição 1 descrição do tipo de usuário)
     * @return Retorna uma string informando se a sessão é de administrador ou de corretor
     */
    public String getSessao()
    {
        String sessao = "";
                        
        System.err.println(descricao);
        try
        {       
            if(descricao.equals("1"))
            {
                sessao = "administrador";
            }
            else if(descricao.equals("2"))
            {
                sessao = "corretor";
            }
        }
        catch(Exception e)
        {
            System.err.println("Erro ao obter sessão:\n" + e);
        }
        
        return sessao;
        
    }
}
