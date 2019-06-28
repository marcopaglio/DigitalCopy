package tester;

//import java.util.Scanner;

import adapter.*;
import builder.*;

public class Tester {
	public static void main(String[] args) throws Exception{
		Builder studente = new ConcreteBuilder();
		Director professore = new Director(studente);
		
		professore.construct();

		TestComposite.testComposite(studente.getRoot());
		
		VirtualCopy app = new Translator(studente);
		
		TestAccensione.testAccensione(app, studente.getRoot());
		TestSpegnimento.testSpegnimento(app, studente.getRoot());


		/*
		VirtualCopy app = new Translator(studente);
		Scanner s = new Scanner(System.in);
		boolean again = true;
		while(again) {
			app.printComponents();
			//System.out.println(pieraccini.getSystems());
			System.out.println("Quale componente vuoi modificare?");
			String componente = s.nextLine();
			System.out.println("Quale azione vuoi intraprendere?");
			boolean wrong = true;
			while(wrong) {
				String azione = s.nextLine();
				if(azione.equals("accendere")) {
					app.accendi(componente);
					wrong = false;
				}
				else if (azione.equals("spegnere")) {
						app.spegni(componente);
						wrong = false;
				}else System.out.println("Devi scegliere tra 'accendere' o 'spegnere'. Riprova.");
			}
			System.out.println("Vuoi continuare? Y or N");
			String continua = s.nextLine();
			if (continua.equals("N")) {
				again = false;
				s.close();
			}
		}
		*/
	}	
}
