package tester;

import adapter.*;
import composite.*;

public final class TestSpegnimento {
	
	public static final void testSpegnimento(VirtualCopy vc, HWSystem root) throws Exception{
		boolean response = true;
		HWSystem file = root.getChild(0).getChild(1).getChild(1).getChild(0);
		HWSystem cartella = root.getChild(0).getChild(1).getChild(1);
		HWSystem app = root.getChild(0).getChild(1).getChild(0);
		HWSystem finestra = root.getChild(0).getChild(1);
		HWSystem illuminazione = root.getChild(0).getChild(0);
		HWSystem grafica = root.getChild(0);
		
		vc.spegni("Cartella");
		if ((file.getState() && cartella.getState()) == false)
			response = response && true;
		else response = response && false;
		
		vc.spegni("Finestra");
		if ((file.getState() && cartella.getState() && app.getState() && finestra.getState()) == false)
			response = response && true;
		else response = response && false;
		
		vc.spegni("Grafica");
		if ((file.getState() && cartella.getState() && app.getState() && finestra.getState() && illuminazione.getState() && grafica.getState()) == false)
			response = response && true;
		else response = response && false;
		
		vc.spegni("PC");
		if ((file.getState() && cartella.getState() && app.getState() && finestra.getState() && illuminazione.getState() && grafica.getState() && root.getState()) == false)
			response = response && true;
		else response = response && false;
		
		if (response)
			System.out.println("Tutte le componenti si spengono correttamente.");
		else System.out.println("Alcune componenti NON si spengono correttamente.");
		
	}
}
