package com.uca.capas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDao;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;


@Controller
public class MainController {
	@Autowired
	private ContribuyenteDao contribuyenteDao;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia> importancias = null;
		try {
			importancias = contribuyenteDao.findAllImportance();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyente", contribuyente);
		mav.addObject("importancias", importancias);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/validacion")
	public ModelAndView validacion(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias = null;
		try {
			importancias = contribuyenteDao.findAllImportance();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(result.hasErrors()) 
		{
			mav.addObject("importancias", importancias);
			mav.setViewName("index");
		}else
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    Date date = new Date();
		    String datex=formatter.format(date);
		    Date date1;
			try {
				date1 = new SimpleDateFormat("dd/MM/yyyy").parse(datex);
				contribuyente.setFecha(date1);
				contribuyenteDao.create(contribuyente);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
			Contribuyente contribuyentenuevo = new Contribuyente();
			mav.addObject("contribuyente", contribuyentenuevo);
			mav.addObject("success", true);
			mav.addObject("importancias", importancias);
			mav.setViewName("index");

		}
		
		
		return mav;
	}
	
	
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		
		try {
			contribuyentes = contribuyenteDao.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("listado");
		
		return mav;
	}
	
	
	
}