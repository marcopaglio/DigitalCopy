package tester;

import adapter.*;
import composite.*;

public final class TestAccensione {
	
	public static final void testAccensione(VirtualCopy vc, HWSystem root) throws Exception{
		boolean response = true;
		HWSystem file = root.getChild(0).getChild(1).getChild(1).getChild(0);
		HWSystem cartella = root.getChild(0).getChild(1).getChild(1);
		HWSystem app = root.getChild(0).getChild(1).getChild(0);
		HWSystem finestra = root.getChild(0).getChild(1);
		HWSystem illuminazione = root.getChild(0).getChild(0);
		HWSystem grafica = root.getChild(0);
		
		vc.accendi("Cartella");
		if ((file.getState() && cartella.getState()) == true)
			response = response && true;
		else response = response && false;
		
		vc.accendi("Finestra");
		if ((file.getState() && cartella.getState() && app.getState() && finestra.getState()) == true)
			response = response && true;
		else response = response && false;
		
		vc.accendi("Grafica");
		if ((file.getState() && cartella.getState() && app.getState() && finestra.getState() && illuminazione.getState() && grafica.getState()) == true)
			response = response && true;
		else response = response && false;
		
		vc.accendi("PC");
		if ((file.getState() && cartella.getState() && app.getState() && finestra.getState() && illuminazione.getState() && grafica.getState() && root.getState()) == true)
			response = response && true;
		else response = response && false;
		
		if (response)
			System.out.println("Tutte le componenti si accendono correttamente.");
		else System.out.println("Alcune componenti NON si accendono correttamente.");
		
	}
}
