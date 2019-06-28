package composite;

import java.util.ArrayList;

public abstract class HWSystem {
	private boolean state;
	private String name;
	
	public HWSystem(boolean state, String name) {
		this.state = state;
		this.name = name;
	}
	
	public int addComponent(HWSystem c) throws Exception{
		throw new Exception("Questa componente non può eseguire l'operazione richiesta.");
	}
	 /*
	public void removeComponent(Component c) throws Exception{
		throw new Exception("Questa componente non può eseguire l'operazione richiesta.");
	}
	*/
	
	public HWSystem getChild(int num) throws Exception{
		throw new Exception("Questa componente non può eseguire l'operazione richiesta.");
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getState() {
		return this.state;
	}
	
	public void setState(boolean s) {
		this.state = s;
	}
	
	public abstract boolean spegni(ArrayList <Integer> order) throws Exception; //order è una copia difensiva
	public abstract boolean accendi(ArrayList <Integer> order) throws Exception; //order è una copia difensiva
}
