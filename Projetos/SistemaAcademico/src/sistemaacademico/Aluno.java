/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademico;

/**
 *
 * @author Joana
 */
public class Aluno {
     
    private String codigo;
    private String nome;
    private String cpf; 



    public String getCodigo() 
    {
        return Matricula.listaCodigoAluno.get(Matricula.listaCodigoAluno.size()-1);
    }

    public String getNome() 
    {
        return Matricula.listaAluno.get(Matricula.listaAluno.size()-1);
        
    }

    public String getCpf() 
    {
        
        return Matricula.listaCpf.get(Matricula.listaCpf.size()-1);
    }

    public void setCpf(String cpf) 
    {
         Matricula.listaCpf.add(cpf);
    }

    public void setNome(String nome) 
    {
       Matricula.listaAluno.add(nome);
    }

    public void setCodigo(String codigo) 
    {
        Matricula.listaCodigoAluno.add(codigo);
    }
    
    
}
