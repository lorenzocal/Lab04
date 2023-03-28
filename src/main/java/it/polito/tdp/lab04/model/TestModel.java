package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		for (Studente s : model.getStudentiIscrittiCorso(model.getTuttiICorsi().get(2))) {
			System.out.println(s.toString() + "\n");
		};
	}

}
