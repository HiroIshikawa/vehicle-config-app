package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class OptionSet implements Serializable {

	private static final long serialVersionUID = 1L;
	public ArrayList<Option> opt = new ArrayList<Option>();
	private String name; // either Color, Transmission, Brakes/Traction Control, Side Impact Air Bag, Power Moonroof
	private Option choice = new Option();
 	
	// Constructor
	protected OptionSet(){}
 	protected OptionSet(String n){ this.name = n; }
	protected OptionSet(int optlength) { this.opt = new ArrayList<Option>(optlength); }
	protected OptionSet(String n, int optlength)
	{
		this.name = n;
		this.opt = new ArrayList<Option>(optlength);
	}
	protected OptionSet(String n, int optlength, String[] optNam)
	{
		this.name = n;
		this.opt = new ArrayList<Option>(optlength);
		for (int i = 0; i < optlength; i++)
			opt.get(i).setName(optNam[i]);
	}
	protected OptionSet(String n, int optlength, float[] optP)
	{
		this.name = n;
		this.opt = new ArrayList<Option>(optlength);
		for (int i = 0; i < optlength; i++)
			opt.get(i).setPrice(optP[i]);
	}
	protected OptionSet(String n, int optlength, String[] optNam, float[] optP)
	{
		this.name = n;
		this.opt = new ArrayList<Option>(optlength);
		for (int i = 0; i < optlength; i++)
		{
			opt.get(i).setName(optNam[i]);
			opt.get(i).setPrice(optP[i]);
		}
	}

	// Getter
	protected ArrayList<Option> getOpts(){ return opt;}
	protected String getName(){ return name;}
	
	protected Option getOptionChoice(){ return choice; }
	//protected String getChoice(){ return choice.getName(); }
	
	protected Option getOpt(int i){ return this.opt.get(i);}
	protected Option getOpt(String name)
	{ 
		Iterator<Option> optItr = opt.iterator();
		int tracker = 0;
		while(optItr.hasNext()){
			if (optItr.next().getName() == name)
				opt.get(tracker);
			tracker += 1;
		}
		return null;
	}
	protected Option getOpt(float price)
	{ 
		for (int i = 0; i < opt.size(); i++)
			if (this.opt.get(i).getPrice() == price)
				return this.opt.get(i);
		return null;
	}
	protected String getOptName(int i){ return opt.get(i).getName(); }
	protected String getOptName(float price)
	{ 
		for (int i = 0; i < opt.size(); i++)
			if (this.opt.get(i).getPrice() == price)
				return this.getOpt(i).getName();
		return null;
	}
	protected float getOptPrice(int i){ return opt.get(i).getPrice(); }
	protected float getOptPrice(String n){
		for (int i = 0; i < opt.size(); i++)
			if (this.findOpt(n) > -1)
				return opt.get(i).getPrice();
		return 0;
	}
	protected String[] getOptNames(){ 
		String[] names = new String[opt.size()];
		for (int i = 0; i < opt.size(); i++)
			names[i] = opt.get(i).getName();
		return names;
	}
	
	
	
	protected float[] getOptPrices(){ 
		float[] names = new float[opt.size()];
		for (int i = 0; i < opt.size(); i++)
			names[i] = opt.get(i).getPrice();
		return names;
	}
	
	protected int getOptSize(){ return opt.size(); }
	
	protected int findOpt(String n){
		for (int i = 0; i < this.opt.size(); i++)
		{
			if (this.opt.get(i).getName().equals(n))
				return i;
		}
		return -1;
	}	
	protected int findOpt(int p){
		for (int i = 0; i < this.opt.size(); i++)
			if (this.opt.get(i).getPrice() == p)
				return i;
		return -1;
	}

	// Setter
	protected void setName(String n) { this.name = n; }
	
	// protected void setOptionChoice(Option nChoice){ this.choice = nChoice; }
	protected void setOptionChoice(String optName)
	{
		if (this.findOpt(optName) > -1)
			this.choice = this.getOpt(this.findOpt(optName));
	}
	
	protected void setOpts(ArrayList<Option> newOpts) { this.opt = newOpts; }
	protected void setOpt(int size) { 
		for (int i = 0; i < size; i++) {
			Option option = new Option();
			this.opt.add(option);
		}
	}
	protected void setOpt(Option newOpt, int index) { opt.set(index,newOpt); }

	protected void setOptName(int i, String n){ opt.get(i).setName(n); }
	protected void setOptPrice(int i, float p) { opt.get(i).setPrice(p); }
	protected void setOptNamePrice(int i, String n, int p)
	{
		opt.get(i).setName(n);
		opt.get(i).setPrice(p);
	}

	// Update
	protected void updateOptPrice(String n, float newP)
	{
		if(this.findOpt(n) > -1)
		{
			this.opt.get(findOpt(n)).setPrice(newP);
		}
	}
	protected void updateOptName(String p, String newN)
	{
		if(this.findOpt(p) > -1)
			this.opt.get(findOpt(p)).setName(newN);
	}

	// Delete
	protected void deleteOpts()
	{
		for (int i = 0; i < opt.size(); i++)
			this.opt.set(i, null);
	}
	protected void deleteOpt(String n)
	{
		for (int i = 0; i < this.opt.size(); i++)
		{
			if (this.findOpt(n) > -1)
				this.opt.set(i,null);
		}
	}
	protected void deleteOpt(int i)
	{
		this.opt.set(i,null);
	}

	protected void printOpset() 
	{
		System.out.print("The optionset name: ");
		System.out.println(name);
		for (int i = 0; i < opt.size(); i++) 
		{
			opt.get(i).printOpt();
		}
	}
	
	protected void printChoice()
	{
		System.out.println(name);
		this.choice.printOpt();
	}
	

	// Option Inner Class
	protected class Option implements Serializable{

		private static final long serialVersionUID = 1L;
		private String name;
		private float price;

		protected Option(){}
		protected Option(String n){ this.name = n; }
		protected Option(int p){ this.price = p; }
		protected Option(String n, int p)
		{
			this.name = n;
			this.price = p;
		}

		protected String getName(){ return name; }
		protected float getPrice(){ return price; }

		protected void setName(String n) { this.name = n; }
		protected void setPrice(float p) { this.price = p; }


		private void printOpt() {
			System.out.print("The option name is: ");
			System.out.println(name);
			System.out.print("The option price is: ");
			System.out.println(price);
		}
	}
}