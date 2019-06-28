package builder;

import java.util.ArrayList;
import java.util.Hashtable;

import composite.*;

public class ConcreteBuilder implements Builder{
	private final HWSystem root;
	private Hashtable<String, ArrayList<Integer>> coordinates;
	
	public ConcreteBuilder() {
		root = new SubSystem("PC");
		this.coordinates = new Hashtable<String, ArrayList<Integer>>();
		this.coordinates.put(root.getName(), new ArrayList<>());
	}
	
	@Override
	public HWSystem builtSubSystem(String name) throws Exception{
		return new SubSystem(name);
	}
	
	@Override
	public HWSystem builtSwitch(String name) throws Exception{
		/*boolean admin;
		double dice = Math.random();
		if (dice > 0.5)
			admin = true;
		else admin = false;
		Component newComp = new SecurityProxy(admin);*/
		return new Switch(name);
	}
	@Override
	public void builtHierachy(HWSystem parent, HWSystem child) throws Exception{
		ArrayList<Integer> newCoordinate;
		int next;
		if(parent == null) {
			newCoordinate = new ArrayList<>(coordinates.get(root.getName())); //recupera le coordinate del padre
			next = root.addComponent(child);
		}
		else {
			newCoordinate = new ArrayList<>(coordinates.get(parent.getName()));
			next = parent.addComponent(child);
		}
		newCoordinate.add(next);
		this.coordinates.put(child.getName(), newCoordinate);
	}	
	
	@Override
	public HWSystem getRoot() {
		return this.root;
	}
	
	@Override
	public Hashtable<String, ArrayList<Integer>> getCoordinates(){
		return new Hashtable<String, ArrayList<Integer>>(coordinates);
	}
	
	/*public Component builtPart(boolean terminator, Component parent) throws Exception {
		Component newComp;
		if (terminator) {
			boolean admin;
			double dice = Math.random();
			if (dice > 0.5)
				admin = true;
			else admin = false;
			newComp = new SecurityProxy(admin);
		} else newComp = new Group();
		if(parent == null)
			root.addComponent(newComp);
		else parent.addComponent(newComp);
		return newComp;
	}*/
}