package com.example.magneto.service;

import org.springframework.stereotype.Service;

import com.example.magneto.domain.InvalidDNAException;

/**
 * Implementacion del servicio MagnetoService.
 * 
 * @author Elian
 *
 */
@Service
public class MagnetoServiceImpl implements MagnetoService {

	/**
	 * @see MagnetoService.
	 */
	@Override
	public boolean isMutant(String[] dna) throws InvalidDNAException {
		validateDNA(dna);
		return checkForMutant(dna);
	}

	/**
	 * Valida la matriz de ADN para determinar si sus caracteres son validos.
	 * Caracters validos: (A, T, C, G)
	 * 
	 * @param dna
	 * @throws InvalidDNAException
	 */
	private void validateDNA(String[] dna) throws InvalidDNAException {
		for (String sequence : dna) {
			char[] sequenceCharacters = sequence.toCharArray();
			for (char character : sequenceCharacters) {
				if (character != 'A' && character != 'T' && character != 'C' && character != 'G') {
					throw new InvalidDNAException(dna);
				}
			}
		}
	}

	/**
	 * Analiza una matriz de ADN para ver si es mutante.
	 * 
	 * @param dna
	 * @return true si es mutante
	 */
	private boolean checkForMutant(String[] dna) {
		return checkForMutantHorizontal(dna) || checkForMutantVertical(dna) || checkForMutantObliquely(dna);
	}

	/**
	 * Analiza una matriz de ADN para ver si es mutante de forma oblicua.
	 * 
	 * @param dna
	 * @return
	 */
	private boolean checkForMutantObliquely(String[] dna) {
		int size = dna.length;
		int count = 0;
		for (int fila = 0; fila < size - 1; fila++) {
			for (int columna = 0; columna < size - 1; columna++) {
				char letter = dna[fila].charAt(columna);
				char nextLetter = dna[fila + 1].charAt(columna + 1);
				if (letter == nextLetter) {
					for (int i = 0; fila == columna && letter == nextLetter && fila + i < size; i++) {
						nextLetter = dna[fila + i].charAt(columna + i);
						if (letter == nextLetter) {
							count++;
						}
					}
					if (count == 4) {
						return true;
					}
					count = 0; // Resets counter
				}
			}

		}
		return false;
	}

	/**
	 * Analiza una matriz de ADN para ver si es mutante de forma Vertical.
	 * 
	 * @param dna
	 * @return
	 */
	private boolean checkForMutantVertical(String[] dna) {
		int size = dna.length;
		int count = 0;
		for (int fila = 0; fila < size - 1; fila++) {
			for (int columna = 0; columna < size; columna++) {
				char letter = dna[fila].charAt(columna);
				char nextLetter = dna[fila + 1].charAt(columna);
				if (letter == nextLetter) {
					for (int i = fila; letter == nextLetter && i < size; i++) {
						nextLetter = dna[i].charAt(columna);
						if (letter == nextLetter) {
							count++;
						}
					}
					if (count == 4) {
						return true;
					}
					count = 0; // Resets counter
				}
			}

		}
		return false;
	}

	/**
	 * Analiza una matriz de ADN para ver si es mutante de forma Horizontal.
	 * 
	 * @param dna
	 * @return
	 */
	private boolean checkForMutantHorizontal(String[] dna) {
		int size = dna.length;
		int count = 0;
		for (int fila = 0; fila < size; fila++) {
			for (int columna = 0; columna < size - 1; columna++) {
				char letter = dna[fila].charAt(columna);
				char nextLetter = dna[fila].charAt(columna + 1);
				if (letter == nextLetter) {
					for (int i = columna; letter == nextLetter && i < size; i++) {
						nextLetter = dna[fila].charAt(i);
						if (letter == nextLetter) {
							count++;
						}
					}
					if (count == 4) {
						return true;
					}
					count = 0; // Resets counter
				}
			}

		}
		return false;
	}
}
