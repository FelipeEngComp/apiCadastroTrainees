package br.com.sysmap.cadastro.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.sysmap.cadastro.models.Candidato;

@Repository
@Transactional
public class CandidatoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Candidato candidato) {

		manager.persist(candidato);

	}
	
	public Candidato find(Integer id) {
		Candidato candidato = manager.find(Candidato.class, id);
		return candidato;
	}

//	public Candidato find(Integer id) {
//
//		return manager.createQuery("Select * from Candidato c where Candidato.id = :id",
//				Candidato.class).setParameter("id", id).getSingleResult();
//	}

	public List<Candidato> listar() {
		return manager.createQuery("from Candidato", Candidato.class).getResultList();
	}

}
