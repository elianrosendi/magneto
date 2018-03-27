package com.example.magneto.domain;

public class InvalidDNAException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Exception thrown when the dna sequence is invalid.
	 * @param dna
	 */
	public InvalidDNAException(String[] dna) {
		super("Invalid DNA sequence: " + dna.toString());
	}
}
