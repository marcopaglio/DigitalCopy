package tester;
import composite.*;

public final class TestComposite {
	public static final void testComposite(HWSystem root) throws Exception {
		boolean response = true;
		
		HWSystem grafica = root.getChild(0);
		if(grafica.getName() == "Grafica" && grafica.getState() == false)
			response = response && true;
		else response = response && false;
		
		HWSystem illuminazione = grafica.getChild(0);
		if(illuminazione.getName() == "Illuminazione" && illuminazione.getState() == false)
			response = response && true;
		else response = response && false;
		
		HWSystem finestra = grafica.getChild(1);
		if(finestra.getName() == "Finestra" && finestra.getState() == false)
			response = response && true;
		else response = response && false;

		HWSystem app = finestra.getChild(0);
		if(app.getName() == "App" && app.getState() == false)
			response = response && true;
		else response = response && false;
				
		HWSystem cartella = finestra.getChild(1);
		if(cartella.getName() == "Cartella" && cartella.getState() == false)
			response = response && true;
		else response = response && false;
		
		HWSystem file = cartella.getChild(0);
		if(file.getName() == "File" && file.getState() == false)
			response = response && true;
		else response = response && false;
		
		if (response)
			System.out.println("L'albero delle componenti è stato creato correttamente.");
		else System.out.println("L'albero delle componenti NON è stato creato correttamente.");
	}
}
