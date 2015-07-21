/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Periodo;
import entidades.Vacacion;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class VacacionControlador extends Controlador<Vacacion> {

    public VacacionControlador() {
        super(Vacacion.class);
    }

    public List<Vacacion> buscarXEmpleadoXFecha(String dni, Date fechaInicio, Date fechaFin, int desde, int tamanio) {
        String jpql = "SELECT v FROM Vacacion v"
                + " WHERE v.empleado = :dni"
                + " AND v.fechaInicio BETWEEN :fechaInicio AND :fechaFin"
                + " ORDER BY v.empleado,v.fechaInicio DESC";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", dni);
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        return this.getDao().buscar(jpql, mapa, desde, tamanio);
    }

    public List<Vacacion> buscarXEmpleadoXFechaXDni(String dni,Date fechaInicio){
        String jpql = "SELECT v FROM Vacacion v WHERE v.empleado = :dni AND :fechaInicio BETWEEN v.fechaInicio AND v.fechaFin";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni",dni);
        mapa.put("fechaInicio",fechaInicio);
        return this.getDao().buscar(jpql, mapa);
    }
    public List<Vacacion> buscarXFecha(Date fechaInicio, Date fechaFin, int desde, int tamanio) {
        String jpql = "SELECT v FROM Vacacion v"
                + " WHERE v.fechaInicio BETWEEN :fechaInicio AND :fechaFin"
                + " ORDER BY v.fechaInicio DESC";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        return this.getDao().buscar(jpql, mapa, desde, tamanio);
    }

    public int contarXEmpleadoXFecha(String dni, Date fechaInicio, Date fechaFin) {
        String jpql = "SELECT COUNT(v.id) FROM Vacacion v"
                + " WHERE v.empleado = :dni"
                + " AND v.fechaInicio BETWEEN :fechaInicio AND :fechaFin";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", dni);
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        return this.getDao().contar(jpql, mapa);
    }

    public int contarXFecha(Date fechaInicio, Date fechaFin) {
        String jpql = "SELECT COUNT(v.id) FROM Vacacion v"
                + " WHERE v.fechaInicio BETWEEN :fechaInicio AND :fechaFin";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        return this.getDao().contar(jpql, mapa);
    }

//    public Vacacion buscarXDia(String dni, Date dia) {
//        String jpql = "SELECT v FROM Vacacion v"
//                + " WHERE v.empleado = :dni"
//                + " AND ("
//                + "(v.hayInterrupcion = FALSE AND :dia BETWEEN v.fechaInicio AND v.fechaFin) OR "
//                + "(v.hayInterrupcion = TRUE AND :dia BETWEEN v.fechaInicio AND v.fechaInterrupcion)"
//                + ")";
//        Map<String, Object> mapa = new HashMap<>();
//        mapa.put("dni", dni);
//        mapa.put("dia", dia);
//        List<Vacacion> vacacion = this.getDao().buscar(jpql, mapa, -1, 1);
//        if (vacacion.isEmpty()) {
//            return null;
//        } else {
//            return vacacion.get(0);
//        }
//    }
    
    public Vacacion buscarXDia(String empleado, Date dia) {
        String jpql = "SELECT v FROM Vacacion v"
                + " WHERE v.empleado = :dni "
                + " AND ( "
                + "(v.fechaInterrupcion IS NULL AND :dia BETWEEN v.fechaInicio AND v.fechaFin) OR "
                + "(v.fechaInterrupcion IS NOT NULL AND :dia >= v.fechaInicio AND :dia < v.fechaInterrupcion)"
                + ") AND ("
                + "v.interrupcionVacacion IS NULL OR (v.interrupcionVacacion IS NOT NULL AND "
                + "((:dia >= v.fechaInicio AND :dia < v.interrupcionVacacion.fechaInicio) OR (:dia > v.interrupcionVacacion.fechaFin AND :dia <= v.fechaFin))"
                + ")"
                + ")";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", empleado);
        mapa.put("dia", dia);
        List<Vacacion> vacacion = this.getDao().buscar(jpql, mapa, -1, 1);
        if (vacacion.isEmpty()) {
            return null;
        } else {
            return vacacion.get(0);
        }
    }

    public List<Vacacion> buscarXEmpleadoXPeriodo(String dni, Periodo periodo) {
        String jpql = "SELECT v FROM Vacacion v WHERE v.empleado = :dni AND v.periodo = :periodo";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", dni);
        mapa.put("periodo", periodo);
        List<Vacacion> vacacion = this.getDao().buscar(jpql, mapa);
        return vacacion;
    }
}
