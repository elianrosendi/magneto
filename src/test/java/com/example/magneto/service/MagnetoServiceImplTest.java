package com.example.magneto.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.magneto.domain.InvalidDNAException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MagnetoServiceImplTest {

	MagnetoService service = new MagnetoServiceImpl();

	@Test
	public void testIsMutant() throws InvalidDNAException {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		Assert.assertTrue(service.isMutant(dna));
	}

	@Test
	public void testIsNotMutant() throws InvalidDNAException {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" };
		Assert.assertFalse(service.isMutant(dna));
	}

	@Test(expected = InvalidDNAException.class)
	public void testIsMutantInvalidDNA() throws InvalidDNAException {
		String[] dna = { "ATACGA", "TTACGA", "ATCCTT", "TTACGT", "ATACGA", "ATACGX" };
		service.isMutant(dna);
	}

}
