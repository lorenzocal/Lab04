package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.IscrizioneDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	private CorsoDAO corsoDAO = new CorsoDAO();
	private StudenteDAO studenteDAO = new StudenteDAO();
	private IscrizioneDAO iscrizioneDAO = new IscrizioneDAO();
	
	public List<Corso> getTuttiICorsi() {
		return this.corsoDAO.getTuttiICorsi();
	}
	
	public List<Studente> getStudentiIscrittiCorso(Corso corso){
		return this.corsoDAO.getStudentiIscrittiCorso(corso);
	}
	
	public Studente getStudente(int matricola) {
		return this.studenteDAO.getStudente(matricola);
	}
	
	public List<Corso> getCorsiStudente(int matricola){
		return this.corsoDAO.getCorsiStudente(matricola);
	}
	
	public boolean verificaIscrizioneCorso(Studente s, Corso c) {
		return this.iscrizioneDAO.verificaIscrizioneCorso(s, c);
	}
	
	
}
