package com.curso.spring.mvc.controllers;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.curso.spring.mvc.dto.Genero;
import com.curso.spring.mvc.dto.validadores.PersonaNombreNotNullValidador;

/**
 * Permite que todos los controladores gestionados por RequestMappingHandlerMapping tengan esta configuraci�n
 * com�n dentro del paquete indicado.
 * 
 * @author dcela
 *
 */
@ControllerAdvice("com.curso.spring.mvc.controllers")
//@SessionAttributes("generos")
public class ConfiguracionControladores {
	
	// Obligatorio poner la clave con la que queremos acceder al objeto como atributode request
	@ModelAttribute("generos")
	public Genero[] generos() {
		// Invocamos la l�gica para recuperar los datos del G�nero.
		return new Genero[] {Genero.MASCULINO, Genero.FEMENINO};
	}
	
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.addValidators(new PersonaNombreNotNullValidador());
	}

}
