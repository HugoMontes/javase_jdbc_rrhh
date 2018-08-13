package com.educomser.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hugo Montes
 */
public class Conexion {

    private String url = "jdbc:postgresql://localhost:5432/cursojse";
    private String username = "postgres";
    private String password = "123456";
    private String driver = "org.postgresql.Driver";

    private Connection connection;

    public Conexion() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            String message = "Error al cargar el driver de la BD";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, message, ex);
        } catch (SQLException ex) {
            String message = "Error en parametros de conexion";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, message, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            String message="Error al cerrar la conexion";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, message, ex);
        }
    }
}
