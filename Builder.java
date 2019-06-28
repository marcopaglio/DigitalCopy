package builder;

import java.util.ArrayList;
import java.util.Hashtable;

import composite.HWSystem;

public interface Builder {
	public HWSystem builtSubSystem(String name) throws Exception;
	public HWSystem builtSwitch(String name) throws Exception;
	public void builtHierachy(HWSystem parent, HWSystem child) throws Exception;
	public HWSystem getRoot();
	public Hashtable<String, ArrayList<Integer>> getCoordinates();
}