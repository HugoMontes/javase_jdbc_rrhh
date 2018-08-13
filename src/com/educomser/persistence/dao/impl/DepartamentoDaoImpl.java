package com.educomser.persistence.dao.impl;

import com.educomser.domain.Departamento;
import com.educomser.persistence.Conexion;
import com.educomser.persistence.dao.DepartamentoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hugo Montes
 */
public class DepartamentoDaoImpl implements DepartamentoDao {

    private Conexion conexion;
    private String tableName = "tbl_departamento";

    @Override
    public void save(Departamento departamento) {
        conexion = new Conexion();
        try {
            String sql = "INSERT INTO " + tableName + "(categoria, descripcion) VALUES(?, ?)";
            PreparedStatement query = conexion.getConnection().prepareStatement(sql);
            query.setString(1, departamento.getCategoria());
            query.setString(2, departamento.getDescripcion());
            query.executeUpdate();
        } catch (SQLException ex) {
            String message = "Error en la consulta insert into";
            Logger.getLogger(DepartamentoDaoImpl.class.getName()).log(Level.SEVERE, message, ex);
        } finally {
            conexion.closeConnection();
        }
    }

    @Override
    public void delete(long id) {
        conexion = new Conexion();
        try {
            String sql = "DELETE FROM " + tableName + " WHERE id=?";
            PreparedStatement query = conexion.getConnection().prepareStatement(sql);
            query.setLong(1, id);
            query.executeUpdate();
        } catch (SQLException ex) {
            String message = "Error en la consulta delete";
            Logger.getLogger(DepartamentoDaoImpl.class.getName()).log(Level.SEVERE, message, ex);
        } finally {
            conexion.closeConnection();
        }
    }

    @Override
    public void update(Departamento departamento) {
        conexion = new Conexion();
        try {
            String sql = "UPDATE " + tableName + " SET categoria=?, descripcion=? WHERE id=?";
            PreparedStatement query = conexion.getConnection().prepareStatement(sql);
            query.setString(1, departamento.getCategoria());
            query.setString(2, departamento.getDescripcion());
            query.setLong(3, departamento.getId());
            query.executeUpdate();
        } catch (SQLException ex) {
            String message = "Error en la consulta update";
            Logger.getLogger(DepartamentoDaoImpl.class.getName()).log(Level.SEVERE, message, ex);
        } finally {
            conexion.closeConnection();
        }
    }

    @Override
    public List<Departamento> getAllList() {
        conexion = new Conexion();
        List<Departamento> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + tableName + " ORDER BY id DESC";
            Statement query = conexion.getConnection().createStatement();
            ResultSet result = query.executeQuery(sql);
            while (result.next()) {
                Departamento dep = new Departamento();
                dep.setId(result.getLong("id"));
                dep.setCategoria(result.getString("categoria"));
                dep.setDescripcion(result.getString("descripcion"));
                list.add(dep);
            }
        } catch (SQLException ex) {
            String message = "Error en la consulta select";
            Logger.getLogger(DepartamentoDaoImpl.class.getName()).log(Level.SEVERE, message, ex);
        } finally {
            conexion.closeConnection();
        }
        return list;
    }

    @Override
    public Departamento findById(long id) {
        conexion = new Conexion();
        Departamento dep = null;
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE id=?";
            PreparedStatement query = conexion.getConnection().prepareStatement(sql);
            query.setLong(1, id);
            ResultSet result = query.executeQuery();
            while (result.next()) {
                dep = new Departamento();
                dep.setId(result.getLong("id"));
                dep.setCategoria(result.getString("categoria"));
                dep.setDescripcion(result.getString("descripcion"));
            }
        } catch (SQLException ex) {
            String message = "Error en la consulta select";
            Logger.getLogger(DepartamentoDaoImpl.class.getName()).log(Level.SEVERE, message, ex);
        } finally {
            conexion.closeConnection();
        }
        return dep;
    }

}
