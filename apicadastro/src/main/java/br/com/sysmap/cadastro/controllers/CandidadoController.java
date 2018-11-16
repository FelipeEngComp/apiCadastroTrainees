package br.com.sysmap.cadastro.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sysmap.cadastro.daos.CandidatoDAO;
import br.com.sysmap.cadastro.models.Candidato;

@Controller
public class CandidadoController {
	
	@Autowired
	private CandidatoDAO candidatoDAO;
	
	@RequestMapping(value="/buscar")
	@ResponseBody
	public List<Candidato> buscarPor() {		
		List<Candidato> candidatos = candidatoDAO.listar();		
		return candidatos;		
	}
	
	
	
	
//	@RequestMapping("listar")
//	@ResponseBody
//	public List<Candidato> detalheJson(@PathVariable("id") Integer id) {
//		return candidatoDAO.listar();
//	}
	
	@RequestMapping("/{id}")
	@ResponseBody
	public Candidato detalheJson(@PathVariable("id") Integer id) {
		return candidatoDAO.find(id);
	}


}
