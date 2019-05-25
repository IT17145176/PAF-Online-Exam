package com.springBootREST.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootREST.dao.OderDao;
import com.springBootREST.model.Oder;

@RestController
@RequestMapping("/company")
public class OderController {
	
	@Autowired
	OderDao OderDao;
	
	/*to save an product*/
	@PostMapping("/Oder")
	public Oder createProduct(@Valid @RequestBody Oder pro) {
		return OderDao.save(pro);
	}
public ResponseEntity<Oder> CreateProduct(@PathVariable(value="id") Long proid,@Valid @RequestBody Oder pro){
				
		pro.setName(pro.getName());
		pro.setDescription(pro.getDescription());
		pro.setDate(pro.getDate());
		pro.setPrice(pro.getPrice());
		
		Oder CreateProduct=OderDao.save(pro);
		return ResponseEntity.ok().body(CreateProduct);
	}

	/*get all products*/
	@GetMapping("/Oder")
	public List<Oder> getAllProduct(){
		return OderDao.findAll();
	}
	
	/*get product by proid*/
	@GetMapping("/notes/{id}")
	public ResponseEntity<Oder> getProductById(@PathVariable(value="id") Long proid) {
		
		Oder pro=OderDao.findOne(proid);
		
		if(pro==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pro);
		}

	/*update an product by proid*/
	@PutMapping("/Oder/{id}")
	public ResponseEntity<Oder> updateProduct(@PathVariable(value="id") Long proid,@Valid @RequestBody Oder proDetails){
		
		Oder pro=OderDao.findOne(proid);
		if(pro==null) {
			return ResponseEntity.notFound().build();
		}
		pro.setName(proDetails.getName());
		pro.setDescription(proDetails.getDescription());
		pro.setDate(proDetails.getDate());
		pro.setPrice(proDetails.getPrice());
		
		Oder updateProduct=OderDao.save(pro);
		return ResponseEntity.ok().body(updateProduct);
	}
	
	/*Delete an product*/
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Oder> deleteProduct(@PathVariable(value="id") Long proid){
		
		Oder pro=OderDao.findOne(proid);
		if(pro==null) {
			return ResponseEntity.notFound().build();
		}
		OderDao.delete(pro);
		
		return ResponseEntity.ok().build();
	}
	
	
	
}


