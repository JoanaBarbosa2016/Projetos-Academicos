/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
        return Model.Matricula.listaCodigoAluno.get(Model.Matricula.listaCodigoAluno.size()-1);
    }

    public String getNome() 
    {
        return Model.Matricula.listaAluno.get(Model.Matricula.listaAluno.size()-1);
        
    }

    public String getCpf() 
    {
        
        return Model.Matricula.listaCpf.get(Model.Matricula.listaCpf.size()-1);
    }

    public void setCpf(String cpf) 
    {
         Model.Matricula.listaCpf.add(cpf);
    }

    public void setNome(String nome) 
    {
       Model.Matricula.listaAluno.add(nome);
    }

    public void setCodigo(String codigo) 
    {
        Model.Matricula.listaCodigoAluno.add(codigo);
    }
    
    
}
