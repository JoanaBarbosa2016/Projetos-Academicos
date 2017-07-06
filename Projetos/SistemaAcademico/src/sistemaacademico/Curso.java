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
public class Curso {
     
    private String nomeCurso;
    private String codigoCurso;
    private String cargaHoraria;

    public String getNomeCurso()
    {
        return Matricula.listaCurso.get(Matricula.listaCurso.size()-1);
    }

    public String getCargaHoraria()
    {
        return Matricula.listaCargaHoraria.get(Matricula.listaCargaHoraria.size()-1);
    }

    public String getCodigoCurso()
    {
        return Matricula.listaCodigoCurso.get(Matricula.listaCodigoCurso.size()-1);
    }

    public void setNomeCurso(String nomeCurso)
    {
        Matricula.listaCurso.add(nomeCurso); 
    }

    public void setCargaHoraria(String cargaHoraria)
    {
         Matricula.listaCargaHoraria.add(cargaHoraria);
    }

    public void setCodigoCurso(String codigoCurso)
    {
        Matricula.listaCodigoCurso.add(codigoCurso);
    }
    
}
