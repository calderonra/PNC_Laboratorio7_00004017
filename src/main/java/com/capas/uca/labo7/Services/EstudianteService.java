package com.capas.uca.labo7.Services;

import java.util.List;

import com.capas.uca.labo7.Domain.Estudiante;
import org.springframework.dao.DataAccessException;




public interface EstudianteService {

    public List<Estudiante> findAll() throws DataAccessException;

    public Estudiante findOne(Integer code) throws DataAccessException;

    public void save(Estudiante estudiante) throws DataAccessException;

    public void edit(Estudiante estudiante) throws DataAccessException;

    public void delete(Integer codigoEstudiante) throws DataAccessException;

    public List<Estudiante> filterByNombre(String cadena) throws DataAccessException;

    public List<Estudiante> startWith(String cadena) throws DataAccessException;

}
