package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import opeartions.service.PartService;

class PartServiceTest {

//	@Test
//	void testgetAllParts() {
//		PartService.getAllParts();
//	}
	
	@Test
	void testgetSpecificPart() {
		PartService.getSpecificPartByName("axles");
	}
	
//	@Test
//	void testremovePart() {
//		PartService.removePart();
//	}
//	
//	@Test
//	void testupdatePart() {
//		PartService.updatePart();
//	}
//	
//	@Test
//	void testaddPart() {
//		PartService.addPart();
//	}
//	
//	

}
