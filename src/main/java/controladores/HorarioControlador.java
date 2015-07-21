/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Horario;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class HorarioControlador extends Controlador<Horario>{

    public HorarioControlador() {
        super(Horario.class);
    }
    
    public List<Horario> buscarXEmpleado(String empleado, Date fechaInicio, Date fechaFin){
        String jpql = "SELECT h FROM Horario h WHERE "
                + "EXISTS(SELECT a FROM AsignacionHorario a WHERE "
                + "a.horario = h AND "
                + "(a.fechaInicio BETWEEN :fechaInicio AND :fechaFin OR :fechaInicio BETWEEN a.fechaInicio AND a.fechaFin)"
                + "AND (a.empleado = :empleado OR "
                + "EXISTS(SELECT d FROM DetalleGrupoHorario d WHERE d.empleado = :empleado AND d.grupoHorario = a.grupoHorario))"
                + ")";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("empleado", empleado);
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        return this.getDao().buscar(jpql, mapa);
    }
    
}
