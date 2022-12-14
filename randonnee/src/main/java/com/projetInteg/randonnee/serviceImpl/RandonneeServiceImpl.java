package com.projetInteg.randonnee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetInteg.randonnee.entities.Guide;
import com.projetInteg.randonnee.entities.Randonnee;
import com.projetInteg.randonnee.reops.GuideRespository;
import com.projetInteg.randonnee.reops.RandonneeRespository;
import com.projetInteg.randonnee.service.RandonneeService;

@Service
public class RandonneeServiceImpl implements RandonneeService {
	
	@Autowired
	RandonneeRespository randonneerepository;

	@Autowired
	GuideRespository guideRepository;
	@Override
	public Randonnee saveRandonnee(Randonnee r) {
		Guide guide= guideRepository.findById(r.getGuideId());
		r.setGuide(guide);
		Randonnee rando= randonneerepository.save(r);
		guide.getRandonnees().add(rando);
	return  rando;
	}

	@Override
	public Randonnee updateRandonnee(Randonnee r) {
		// TODO Auto-generated method stub
		return randonneerepository.save(r);
	}

	@Override
	public void deleteRandonnee(Randonnee r) {
		randonneerepository.delete(r);
		
	}

	@Override
	public void deleteRandonneeById(Long id) {
		
		randonneerepository.deleteById(id);
	}

	@Override
	public Randonnee getRandonnee(Long id) {
		// TODO Auto-generated method stub
		return randonneerepository.findById(id).get();
	}

	@Override
	public List<Randonnee> getAllRandonnees() {
		// TODO Auto-generated method stub
		return randonneerepository.findAll();
	}

	@Override
	public List<Randonnee> findByTitreRandonnee(String nom) {
		// TODO Auto-generated method stub
		return randonneerepository.findByTitreRandonnee(nom) ;
	}

	@Override
	public List<Randonnee> findByTitreRandonneeContains(String nom) {
		// TODO Auto-generated method stub
		return randonneerepository.findByTitreRandonneeContains(nom);
	}

}
