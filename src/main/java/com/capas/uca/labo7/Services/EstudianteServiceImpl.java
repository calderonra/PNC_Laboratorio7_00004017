package com.capas.uca.labo7.Services;


import com.capas.uca.labo7.Domain.Estudiante;
import com.capas.uca.labo7.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    EstudianteRepository estudianteRepository;
    //EstudianteDAO estudianteDAO;

    @Override
    public List<Estudiante> findAll() throws DataAccessException {
        //return estudianteRepository.findAll();
        return estudianteRepository.mostrarTodos();
    }

    @Override
    public Estudiante findOne(Integer code) throws DataAccessException {
        return estudianteRepository.getOne(code);
    }

    @Override
    @Transactional
    public void save(Estudiante estudiante) throws DataAccessException {
        estudianteRepository.save(estudiante);
        /*
         * Para guardar y editar se usa este mismo
         * revisa si trae el id de la pk, si lo trae lo actualiza
         * sino, crea uno nuevo
         * */
    }
    @Override
    public void edit(Estudiante estudiante) throws DataAccessException {
        estudianteRepository.save(estudiante);

    }
    @Override
    @Transactional
    public void delete(Integer codigoEstudiante) throws DataAccessException {
        estudianteRepository.deleteById(codigoEstudiante);
    }

    @Override
    public List<Estudiante> filterByNombre(String cadena) throws DataAccessException {
        //return estudianteRepository.findByNombre(cadena);
        return estudianteRepository.mostrarPorNombre(cadena);
    }

    @Override
    public List<Estudiante> startWith(String cadena) throws DataAccessException {
        return estudianteRepository.findByApellidoStartingWith(cadena);
    }


}
