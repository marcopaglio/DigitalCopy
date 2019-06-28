package composite;

import java.util.ArrayList;

public class Switch extends HWSystem {
	//private boolean admin;
	
	public Switch(String name/*,boolean admin*/) {
		super(false, name);
		//this.admin = admin;
	}
	
	/*public boolean getAdmin() {
		return this.admin;
	}*/
	
	@Override
	public boolean spegni(ArrayList <Integer> order) throws Exception{
		if (order.isEmpty()) {
			/*
			String whatHappened;
			if(this.getState() == false)
				whatHappened = " era gi� spento.";
			else whatHappened = " � stato spento.";
			*/
			this.setState(false);
			//System.out.println(this.getName()+whatHappened);
			return true;
		}
		else throw new Exception("L'indirizzo per "+ this.getName()+ " � sbagliato.");
	}
	
	@Override
	public boolean accendi(ArrayList <Integer> order) throws Exception{
		if (order.isEmpty()) {
			/*String whatHappened;
			if(this.getState() == true)
				whatHappened = " era gi� acceso.";
			else whatHappened = " � stato acceso.";*/
			this.setState(true);
			//System.out.println(this.getName()+whatHappened);
			return true;
		}
		else throw new Exception("L'indirizzo per "+ this.getName() + " � sbagliato.");
	}
}

/*public class SecurityProxy implements Component {
	private Interruttore myInt;
	
	public SecurityProxy(boolean admin) {
		myInt = new Interruttore(admin);
	}
	
	@Override
	public boolean getState() {
		return myInt.getState();
	}
	
	@Override
	public void setState(boolean s) {
		myInt.setState(s);
	}
	
	@Override
	public boolean spegni(ArrayList <Integer> order) throws Exception{
		if(myInt.getAdmin()) {
			if (this.security())
				return false;
		}
		return myInt.spegni(order);	
	}
	
	@Override
	public boolean accendi(ArrayList <Integer> order) throws Exception{
		if(myInt.getAdmin()) {
			if (this.security())
				return false;
		}
		return myInt.accendi(order);
	}
	
	private boolean security() {
		System.out.println("L'interruttore "+ this.myInt.toString() +" � protetto. Inserisci le credenziali di amministratore per continuare.");
		Scanner input = new Scanner(System.in);
		String response = input.nextLine();
		input.close();
		if (!(response.equals("marcopaglio")))
			return false;
		else return true;
	}
} */