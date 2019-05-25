package com.springBootREST.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootREST.model.Oder;
import com.springBootREST.repository.OderRepository;

@Service
public class OderDao {
	
	@Autowired
	OderRepository oderRepository;
	
	public Oder save(Oder pro) {
		return oderRepository.save(pro);
	}
	
	public List<Oder> findAll(){
		return oderRepository.findAll();
	}
	
	public Oder findOne(Long proid) {
		return oderRepository.findOne(proid);
		
	}
	
	public void delete(Oder pro) {
		oderRepository.delete(pro);
	}

}
