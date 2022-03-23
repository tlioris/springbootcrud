package gr.publicsoft.springbootcrud.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import gr.publicsoft.springbootcrud.Application;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;

@ContextConfiguration(classes = Application.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql")})
public class SupplierRepositoryTests {

	@Autowired
	SupplierRepository supplierRepository;
	
	@Test
	public void ifNewSupplierSaved_thenPassTest() {
		Supplier newSupplier = new Supplier();
		
		newSupplier.setAddress("Nafpliou 128");
		newSupplier.setCity("Sparti");
		newSupplier.setCompanyName("Privo");
		newSupplier.setCountry("Greece");
		newSupplier.setFirstName("Dimitrios");
		newSupplier.setIrsOffice("DOY Spartis");
		newSupplier.setLastName("Dimitriou");
		newSupplier.setVatNumber("069601135");
		newSupplier.setZipCode("23100");
		
		//newSupplier
		
		supplierRepository.save(newSupplier);
		
		assertEquals(3, supplierRepository.findAll().size());
		
	}
	
}
