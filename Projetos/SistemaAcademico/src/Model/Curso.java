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
public class Curso {
    private String nomeCurso;
    private String codigoCurso;
    private String cargaHoraria;

    public String getNomeCurso()
    {
        return Model.Matricula.listaCurso.get(Model.Matricula.listaCurso.size()-1);
    }

    public String getCargaHoraria()
    {
        return Model.Matricula.listaCargaHoraria.get(Model.Matricula.listaCargaHoraria.size()-1);
    }

    public String getCodigoCurso()
    {
        return Model.Matricula.listaCodigoCurso.get(Model.Matricula.listaCodigoCurso.size()-1);
    }

    public void setNomeCurso(String nomeCurso)
    {
        Model.Matricula.listaCurso.add(nomeCurso); 
    }

    public void setCargaHoraria(String cargaHoraria)
    {
         Model.Matricula.listaCargaHoraria.add(cargaHoraria);
    }

    public void setCodigoCurso(String codigoCurso)
    {
        Model.Matricula.listaCodigoCurso.add(codigoCurso);
    }
    
    
}
