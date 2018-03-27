package com.example.magneto.service;

import com.example.magneto.domain.InvalidDNAException;

/**
 * Contrato del servicio definido por Magneto para detectar secuencias de ADN
 * mutantes.
 * 
 * @author Elian
 *
 */
public interface MagnetoService {

	/**
	 * Determina si una cadena de adn dada es mutante.
	 * 
	 * @param dna
	 *            Cadena de adn
	 * @return true si es mutante false si no lo es
	 * @throws InvalidDNAException
	 */
	boolean isMutant(String[] dna) throws InvalidDNAException;

}
