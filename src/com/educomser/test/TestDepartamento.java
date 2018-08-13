package com.educomser.test;

import com.educomser.domain.Departamento;
import com.educomser.persistence.dao.DepartamentoDao;
import com.educomser.persistence.dao.impl.DepartamentoDaoImpl;
import java.util.Scanner;

/**
 *
 * @author Hugo Montes
 */
public class TestDepartamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 1. Definir objetod de acceso a datos
        DepartamentoDao depDao = new DepartamentoDaoImpl();
        // 2. Adicionar un registro
        Departamento departamento = new Departamento("1E", "COMERCIAL");
        depDao.save(departamento);
        // 3. Listar registros
        System.out.println("--- LISTA DE DEPARTAMENTOS ---");
        for (Departamento dep : depDao.getAllList()) {
            System.out.println(dep);
        }
        // 4. Busqueda de registros
        System.out.println("Ingrese el id de un registro a modificar: ");
        long id = in.nextLong();
        Departamento depBuscado=depDao.findById(id);
        System.out.println("--- DEPARTAMENTO ENCONTRADO ---");
        System.out.println(depBuscado);
        
    }

}
