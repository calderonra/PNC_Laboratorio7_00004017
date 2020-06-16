package com.capas.uca.labo7.Controller;

import com.capas.uca.labo7.Domain.Estudiante;
import com.capas.uca.labo7.Services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EstudianteService estudianteService;

    @RequestMapping("/listado")
    public ModelAndView initMain() {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudiantes = estudianteService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("listado");
        return mav;
    }

    @GetMapping("/index")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("estudiante", new Estudiante());
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/form")
    public ModelAndView form(@Valid @ModelAttribute Estudiante estudiante, BindingResult result){
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()){
            mav.setViewName("index");
            return mav;
        }else{
            try {
                if(estudiante.getCarne().isEmpty()){
                    estudianteService.edit(estudiante);
                }else {
                    estudianteService.save(estudiante);
                }
                Estudiante es= new Estudiante();
                mav.addObject("estudiante", es);
                mav.setViewName("index");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mav;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST, params = "action=Borrar")
    public ModelAndView delete(@RequestParam(value = "codigo") int id) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudianteService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, params = "action=Editar")
    public ModelAndView edit(@RequestParam(value = "codigo") int id) {
        ModelAndView mav = new ModelAndView();
        Estudiante estudiante = null;
        try {
            estudiante = estudianteService.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("estudiante", estudiante);
        mav.setViewName("index");
        return mav;
    }

    public ModelAndView auxVerLista(){
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try{
            estudiantes = estudianteService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }

        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("listado");
        return mav;
    }

}