package gr.publicsoft.springbootcrud.api;

//import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;


@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/api/supplier")			// mind that '/api/suppliers' is also available from the REST API
public class SupplierController {

	@Autowired
	SupplierRepository supplierRepository;
	

	@GetMapping
	public List<Supplier> getSuppliers(){
		return supplierRepository.findAll();
	}
	
	
	@GetMapping(path = "/page", params = {"page", "size"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Supplier> getSuppliersPaginated(@RequestParam("page") int page, @RequestParam("size") int size){
		Pageable pageAndSize = PageRequest.of(page,  size);
		return supplierRepository.findAll(pageAndSize);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getSupplierById(@PathVariable("id") Long id) {
		return ResponseEntity.of( supplierRepository.findById(id));
	}
	
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Supplier create(@RequestBody @Valid Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Supplier update(@RequestBody @Valid Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	
	@PatchMapping(path="/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> partialUpdate(@PathVariable("id") Long id, @RequestBody @Valid Supplier patchSupplier) {
		Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
		
		if ( !optionalSupplier.isPresent() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Supplier supplier =optionalSupplier.get();
		
		/* normally these checks and updates should be done dynamically for any class entity, we need sth more generic */
		if (patchSupplier.getAddress()				!= null) supplier.setAddress(				patchSupplier.getAddress()					);
		if (patchSupplier.getCity()        				!= null) supplier.setCity(						patchSupplier.getCity()						);
		if (patchSupplier.getCompanyName()	!= null) supplier.setCompanyName(	patchSupplier.getCompanyName()	);
		if (patchSupplier.getCountry()				!= null) supplier.setCountry(				patchSupplier.getCountry()				);
		if (patchSupplier.getFirstName()			!= null) supplier.setFirstName(			patchSupplier.getFirstName()				);
		if (patchSupplier.getIrsOffice()				!= null) supplier.setIrsOffice(				patchSupplier.getIrsOffice()				);
		if (patchSupplier.getLastName()			!= null) supplier.setLastName(      		patchSupplier.getLastName() 			);
		if (patchSupplier.getVatNumber()			!= null) supplier.setVatNumber(      	patchSupplier.getVatNumber() 			);
		if (patchSupplier.getZipCode()				!= null) supplier.setZipCode(      		patchSupplier.getZipCode()				);
		
		supplierRepository.save(supplier);
		
		return ResponseEntity.ok(supplier);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSupplier(@PathVariable("id") Long id) {
		try {
			supplierRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			
		}
	}
	
	
	@GetMapping("/companyname/{companyname}")
	public List<Supplier> getSuppliersByCompanyName1(@PathVariable("companyname") String companyName) {		
		return supplierRepository.findAllByCompanyName(companyName);
	}
	
	
	/*
	@GetMapping("/companyname/{companyname}")
	public Supplier getSupplierByCompanyName(@PathVariable("companyname") String companyName) {		
		return supplierRepository.findByCompanyName(companyName);
	}
	*/
	
	
	@GetMapping("/vat/{vat}")
	public ResponseEntity<?> getSupplierByVAT(@PathVariable("vat") String vat) {
		return ResponseEntity.of(supplierRepository.findByVatNumber(vat));
	}
}
