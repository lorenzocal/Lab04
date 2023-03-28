package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		for (Studente s : cdao.getStudentiIscrittiCorso(cdao.getTuttiICorsi().get(3))) {
			System.out.println(s.toString() + "\n");
		};
		
		
	}

}
