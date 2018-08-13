package com.educomser.persistence.dao;

import com.educomser.domain.Departamento;
import java.util.List;

/**
 *
 * @author Hugo Montes
 */
public interface DepartamentoDao {

    public void save(Departamento departamento);

    public void delete(long id);

    public void update(Departamento departamento);

    public List<Departamento> getAllList();

    public Departamento findById(long id);
}
