/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DAO;
import dao.DAOMINEDU;
import entidades.Empleado;



/**
 *
 * @author fesquivelc
 */
public class HiloPrueba extends Thread{
    EmpleadoControlador ec;

    public HiloPrueba() {
        ec = new EmpleadoControlador();
    }
    
    
    
    @Override
    public void run() {
        DAOMINEDU<Empleado> daom = new DAOMINEDU(Empleado.class);
        daom.getEntityManager();
        
        DAO dao = new DAO();
        dao.getEntityManager();
        System.out.println("TERMINADO LOS DAO");
    }
    
}
