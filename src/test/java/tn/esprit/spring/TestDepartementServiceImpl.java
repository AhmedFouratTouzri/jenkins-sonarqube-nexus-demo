package tn.esprit.spring;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.DepartementServiceImpl;
import tn.esprit.spring.services.IDepartementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootTest

public class TestDepartementServiceImpl {
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);
	@Autowired
	IDepartementService depServive;

	//@Test
	public void testRetrieveAllDeps() {
		List<Departement> deps = depServive.retrieveAllDeps();
		assertEquals(6, deps.size());
	}

    @Test
    void testAddDep() throws ParseException {

		Departement d = new Departement((long) 1, "devops");
		Departement depAdded = depServive.addDep(d);
		assertEquals(d.getName(), depAdded.getName());
	}

	// @Test
	public void testUpdateDep() throws ParseException {

		Departement d = new Departement((long) 1, "informatique");
		Departement depUpdate = depServive.updateDep(d);
		assertEquals(d.getName(), depUpdate.getName());
	}

	// @Test
	public void testRetrieveDep() {
		Departement depRetrieved = depServive.retrieveDep("1");
		assertEquals(2L, depRetrieved.getId());
	}

	// @Test
	public void testDeleteUser() {
		depServive.deleteDep("1");
		assertNull(depServive.retrieveDep("1"));
	}

}
