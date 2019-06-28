package adapter;

import java.util.ArrayList;
import java.util.Hashtable;

import builder.Builder;
import composite.HWSystem;

public class Translator implements VirtualCopy {
	private Hashtable<String, ArrayList<Integer>> coordinates;
	private HWSystem root;
	
	public Translator(Builder cb) {
		this.coordinates = cb.getCoordinates();
		this.root = cb.getRoot();
	}
	
	@Override
	public void printComponents() {
		System.out.println(this.coordinates.keySet());
	}

	@Override
	public boolean accendi(String system) throws Exception {
		ArrayList <Integer> order = this.coordinates.get(system);
		//System.out.println(order);
		return this.root.accendi(new ArrayList<Integer>(order));
	}

	@Override
	public boolean spegni(String system) throws Exception {
		return this.root.spegni(new ArrayList<Integer>(this.coordinates.get(system)));
	}
}

