package composite;

import java.util.ArrayList;

public class SubSystem extends HWSystem{
	private ArrayList <HWSystem> children;
	
	public SubSystem(String name) {
		super(false, name);
		this.children = new ArrayList <>();
	}
	
	@Override
	public int addComponent(HWSystem newComp){
		children.add(newComp);
		return children.indexOf(newComp);
	}
	
	/*@Override
	public void removeComponent(Component c) {
		children.remove(c);
		//cosa succede se c non è nell'array?
 	}*/
	
	@Override
	public HWSystem getChild(int num) {
		return children.get(num);
	}
	
	
	@Override
	public boolean spegni(ArrayList <Integer> order) throws Exception{
		if (order.isEmpty()) {
			boolean all = true;
			for (HWSystem c : children) {
				boolean response = c.spegni(order);
				all = all || response;
			}
			if (all == true) {				//solo se tutte solo spente allora si può considerare spento
				/*String whatHappened;
				if(this.getState() == false)
					whatHappened = " era già spento.";
				else whatHappened = " è stato spento.";*/
				this.setState(false);
				//System.out.println(this.getName()+whatHappened);
			}
			return all;
		} else {
			try {
				HWSystem newChild = getChild(order.get(0));
				ArrayList<Integer> newOrder = new ArrayList<>(order);
				newOrder.remove(0);
				return newChild.spegni(newOrder);
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
	}
	
	@Override
	public boolean accendi(ArrayList <Integer> order) throws Exception{
		if (order.isEmpty()) {
			boolean all = false;
			for (HWSystem c : children) {
				boolean response = c.accendi(order);
				all = all || response;
			}
			if (all == true) {				//solo se almeno uno è acceso allora si può considerare acceso
				/*String whatHappened;
				if(this.getState() == true)
					whatHappened = " era già acceso.";
				else whatHappened = " è stato acceso.";*/
				this.setState(true);
				//System.out.println(this.getName()+whatHappened);
			}
			return all;
		} else {
			try {
				HWSystem newChild = getChild(order.get(0));
				ArrayList<Integer> newOrder = new ArrayList<>(order);
				newOrder.remove(0);
				return newChild.accendi(newOrder);
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} 
	}
}
