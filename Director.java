package builder;

import composite.HWSystem;

public class Director { 
	private final Builder myBuilder;
	/*private final int numLevels;
	private int[] children;				//se riesci final*/
	
	public Director(Builder builder/*, int levels, int[] c*/) {
		this.myBuilder = builder;
		/*int levels = (int)(Math.random()*8)+1; //numero di livelli tra 1 e 9 compresi
		System.out.println("Il sistema contiene "+ levels+ " livelli.");*/
		/*this.numLevels = levels;
		this.children = new int[this.numLevels];
		for(int i= 0; i < levels; i++)
			children[i] = (int)(Math.random()*6)+1; //numero di prole tra 1 e 7
		System.arraycopy(this.children, 0, c, 0, c.length);*/
	}
	
	public void construct() throws Exception{
		
		HWSystem grafica = myBuilder.builtSubSystem("Grafica");
		myBuilder.builtHierachy(null, grafica);
		
		HWSystem illuminazione = myBuilder.builtSwitch("Illuminazione");
		myBuilder.builtHierachy(grafica, illuminazione);
		
		HWSystem finestra = myBuilder.builtSubSystem("Finestra");
		myBuilder.builtHierachy(grafica, finestra);
		
		HWSystem app = myBuilder.builtSwitch("App");
		myBuilder.builtHierachy(finestra, app);
		
		HWSystem cartella = myBuilder.builtSubSystem("Cartella");
		myBuilder.builtHierachy(finestra, cartella);
		
		HWSystem file = myBuilder.builtSwitch("File");
		myBuilder.builtHierachy(cartella, file);
		/*
		HWSystem audio = myBuilder.builtSubSystem("Audio");
		myBuilder.builtHierachy(null, audio);
		
		HWSystem ambiente = myBuilder.builtSubSystem("Ambiente");
		myBuilder.builtHierachy(audio, ambiente);
		
		HWSystem notifica = myBuilder.builtSwitch("Notifica");
		myBuilder.builtHierachy(audio, notifica);
		
		HWSystem applicazione = myBuilder.builtSubSystem("Applicazione");
		myBuilder.builtHierachy(ambiente, applicazione);
		
		HWSystem browser = myBuilder.builtSwitch("Browser");
		myBuilder.builtHierachy(applicazione, browser);
		
		HWSystem cassa = myBuilder.builtSwitch("Cassa");
		myBuilder.builtHierachy(applicazione, cassa);
		
		HWSystem game = myBuilder.builtSwitch("Game");
		myBuilder.builtHierachy(applicazione, game);
		
		HWSystem sistema = myBuilder.builtSubSystem("Sistema");
		myBuilder.builtHierachy(ambiente, sistema);
		
		HWSystem errore = myBuilder.builtSwitch("Errore");
		myBuilder.builtHierachy(sistema, errore);
		*/
	}
	
	
	/*public void construct() throws Exception {
		Component parent = null;
		Component child = null;
		String name = "System";
		Integer level = 0;
		Integer position = 0;
		ArrayList <Integer> local = new ArrayList<>();
		for(int i= 1; i < this.numLevels; i++) {
			level = i;
			local.add(i);												//uso integer a caso per creare una nuova posizione
			int nextParent = (int)(Math.random()*this.children[i-1]); //scelgo il propagatore
			for (int j = 0; j < this.children[i-1] & j != nextParent; j++) {
				position = j;
				local.set(i-1, position);
				child = myBuilder.builtInterruttore(name+level.toString()+position.toString());						//creo interruttori
				myBuilder.builtHierachy(parent, child);						//connetto alla gerarchia
				this.coordinates.put(name+level.toString()+position.toString(), new ArrayList<Integer>(local)); //registro posizione
			}
			position = nextParent;
			local.set(i-1, position);
			child = myBuilder.builtSubSystem(name+level.toString()+position.toString()); 				//creo gruppo
			myBuilder.builtHierachy(parent, child);
			this.coordinates.put(name+level.toString()+position.toString(), new ArrayList<Integer>(local)); //registro posizione
			
			parent = child;
		}
		level = this.numLevels;
		local.add(this.numLevels);
		for (int j = 0; j < this.children[this.numLevels-1]; j++) {
			position = j;
			local.set(this.numLevels-1, position);
			child = myBuilder.builtInterruttore(name+level.toString()+position.toString());						//creo interruttori ultimo livello
			myBuilder.builtHierachy(parent, child);
			this.coordinates.put(name+level.toString()+position.toString(), new ArrayList<Integer>(local)); //registro posizione
		}
	}*/
}