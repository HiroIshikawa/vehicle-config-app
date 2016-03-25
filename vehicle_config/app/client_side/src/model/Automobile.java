package model;

import java.io.*;

import java.util.ArrayList;
// import java.util.LinkedHashMap;

import model.OptionSet.Option;

public class Automobile implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String model;
	private String make;
	private int basePrice;
	// private LinkedHashMap<String, OptionSet> optionSets = new LinkedHashMap<String, OptionSet>();
	public ArrayList<OptionSet> opset = new ArrayList<OptionSet>();
	// private Option choice;
	
	// Constructor
    public Automobile(){}
	public Automobile(String n){ this.name = n; }
	public Automobile(int bp){ this.basePrice = bp;}
	public Automobile(String n, int bp){ this.name = n; this.basePrice = bp;}
	public Automobile(String n, int optssize, int optsize)
	{
		this.name = n;
		this.opset = new ArrayList<OptionSet>(optssize); 
	}
	public Automobile(int bp, int optssize, int optsize)
	{
		this.basePrice = bp;
		this.opset = new ArrayList<OptionSet>(optssize);
	}
	public Automobile(String n, int bp, int optssize, int[] optsize)
	{
		this.name = n;
		this.basePrice = bp;
		this.opset = new ArrayList<OptionSet>(optssize);
	}
	public Automobile(String n, int bp, int optssize, String[] optsNams, int[] optsizes, String[] optNam, int[] optP)
	{
		this.name = n;
		this.basePrice = bp;
		this.opset = new ArrayList<OptionSet>(optssize);
	}


	// R
	synchronized public String getName(){ return name; }
	synchronized public String getModel() { return model; }
	synchronized public String getMake() { return make; }
	synchronized public int getBasePrice(){ return basePrice; }
	synchronized public int getOptionSetsize(){ return opset.size();}
	synchronized public int getOptionsize(int index){ return opset.get(index).getOptSize();}
	synchronized public ArrayList<OptionSet> getOpsets(){ return opset;}
	synchronized public OptionSet getOpset(int index){ return opset.get(index);}
	synchronized public OptionSet getOpset(String n){ 
		int index = 0;
		for (int i = 0; i < opset.size(); i++)
		{
			if (findOpset(n) > -1)
				getOpset(index);
			index++;
		}
		return null;
	}
	synchronized public String[] getOpsetNames(){
		String[] names = new String[opset.size()];
		for (int i = 0; i < opset.size(); i++)
			names[i] = opset.get(i).getName();
		return names;
	}
	synchronized public String getOptionSetName(int index){ return opset.get(index).getName(); }
	synchronized public ArrayList<Option> getOptions(String n){
		if (this.findOpset(n) > -1)
			opset.get(findOpset(n)).getOpts();
		return null;
	}
	synchronized public Option getOption(String n, int index){
		if (this.findOpset(n) > -1)
			opset.get(findOpset(n)).getOpt(index);
		return null;
	}
	synchronized public Option getOption(String n, String nn){
		if (this.findOpset(n) > -1)
			opset.get(findOpset(n)).getOpt(n);
		return null;
	}

	synchronized public Option getOption(String n, float p){
		if (this.findOpset(n) > -1)
			opset.get(findOpset(n)).getOpt(p);
		return null;
	}
	synchronized public String[] getOptionNames(int index){
		if (opset.get(index).getOptNames() != null)
			return opset.get(index).getOptNames();
		return null;
	}
	synchronized public float[] getOptionPrices(int index){
		if (opset.get(index).getOptPrices() != null)
			return opset.get(index).getOptPrices();
		return null;
	}
	synchronized public String[] getOptionNames(String n){
		if (this.findOpset(n) > -1)
		{
			opset.get(findOpset(n)).getOptNames();
				return opset.get(findOpset(n)).getOptNames();
		}
		return null;
	}
	synchronized public float[] getOptionPrices(String n){
		if (this.findOpset(n) > -1)
		{
			opset.get(findOpset(n)).getOptNames();
				return opset.get(findOpset(n)).getOptPrices();
		}
		return null;
	}
	synchronized public String getOptionName(String n, int p){
		for (int i = 0; i < opset.size(); i++)
		{
			System.out.println("Comaparing...");
			System.out.println("");
			System.out.println(n);
			System.out.println(opset.get(i).getName());
			if (opset.get(i).getName().equals(n))
			{
				System.out.println("There was a option name match. Fetching the contents..");
				return opset.get(i).getOptName(p);
			}
		}
		
		System.out.println("There were no matches... weired...");
		return null;
	}
	synchronized public float getOptionPrice(String n, String nn)
	{
		for (int i = 0; i < opset.size(); i++)
		{
			if (opset.get(i).getName().equals(n))
				return opset.get(i).getOptPrice(nn);
		}
		return -1;
	}
	
	synchronized public String getOptionChoice(String setName)
	{
		if (this.findOpset(setName)  > -1)
			return this.opset.get(findOpset(setName)).getOptionChoice().getName();
		//return ""; 
		return null;
	}
	synchronized public float getOptionChoicePrice(String setName)
	{
		if (this.findOpset(setName)  > -1)
			return this.opset.get(findOpset(setName)).getOptionChoice().getPrice();
		return -1;
		// return null;
	}
	synchronized public float getTotalPrice()
	{
		float totalPrice = 0;
		for (int i = 0; i < opset.size(); i++)
		{
			totalPrice += opset.get(i).getOptionChoice().getPrice();
		}
		return totalPrice;
	}
	
	synchronized public int findOpset(String name)
	{
		for (int i = 0; i < opset.size(); i++)
		{
			if (opset.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}
	
	// Setter of model
	synchronized public void setName(String n) { this.name = n;}
	synchronized public void setBaseprice(int bp) { this.basePrice = bp;}
	synchronized public void setModel(String n){ this.model = n; }
	synchronized public void setMake(String n){ this.make = n; } 

	synchronized public void setOpsets(ArrayList<OptionSet> nopsets) { this.opset = nopsets;}
	synchronized public void setOpsets(int opsSize) {
		//ArrayList<OptionSet> opset = new ArrayList<OptionSet>(opsSize);
		for (int i = 0; i < opsSize; i++) {
			OptionSet optionset = new OptionSet();
			opset.add(optionset);
		}
	}
	synchronized public void setOpset(OptionSet nopset, int i) { this.opset.set(i, nopset);}
	synchronized public void setOpts(ArrayList<Option> nopts, int i) { this.opset.get(i).setOpts(nopts);}
	synchronized public void setOpts(OptionSet opset, int num) 
	{ 
		opset.setOpt(num);
	}
	//public void setOpt(int opsetIndex, int optIndex) { this.opset.get(opsetIndex).setOpt(optIndex);}
	synchronized public void setOpt(int opsetIndex, int optIndex) { this.opset.get(opsetIndex).setOpt(optIndex);}
	
	synchronized public void setOptionChoice(String setName, String optionName)
	{
		if (findOpset(setName) > -1)
				opset.get(findOpset(setName)).setOptionChoice(optionName);
	}
	
	synchronized public void setOpt(Option nopt, int opsetIndex, int optIndex) { this.opset.get(opsetIndex).setOpt(nopt,optIndex);}
	synchronized public void setOpsetNames(String[] n, int size) 
	{
		for (int i = 0; i < opset.size(); i++)
			opset.get(i).setName(n[i]);
	}
	synchronized public void setOpsetName(int i, String n){ opset.get(i).setName(n); }
	synchronized public void setOptNames(String n, String[] nn){
		for (int i = 0; i < opset.size(); i++)
			if (opset.get(i).getName() == n)
			{
				for (int j = 0; j < opset.get(i).getOpts().size(); j++)
					opset.get(i).getOpt(j).setName(nn[i]);
			}
	}
	synchronized public void setOptPrices(String n, int[] p){
		for (int i = 0; i < opset.size(); i++)
			if (opset.get(i).getName() == n)
			{
				for (int j = 0; j < opset.get(i).getOpts().size(); j++)
					opset.get(i).getOpt(j).setPrice(p[i]);
			};
	}
	synchronized public void setOptName(int index1, int index2, String name){
			getOpset(index1).setOptName(index2, name);
	}
	synchronized public void setOptName(String n, String nn,int index){
		for (int i = 0; i < opset.size(); i++){
			if (opset.get(i).getName() == n)
				opset.get(i).getOpt(index).setName(nn);
			};
	}
	synchronized public void setOptPrice(int index1, int index2, float newPrice){
		getOpset(index1).setOptPrice(index2, newPrice);
	}
	synchronized public void setOptPrice(String osn, String on, int p){
		for (int i = 0; i < opset.size(); i++)
			if (opset.get(i).getName() == osn)
			{
				for (int j = 0; j < opset.get(i).getOpts().size(); j++)
				{
					if (opset.get(i).findOpt(on) > -1)
						opset.get(i).getOpt(j).setPrice(p);
				}
			};
	}

	// Update
	synchronized public void updateOpsetName(String OpsetName, String NewName)
	{
		if (findOpset(OpsetName) > -1)
			{
				opset.get(findOpset(OpsetName)).setName(NewName);
			};
	}
	
	synchronized public void updateOptPrice(String opSetName, String optionName, float newPrice)
	{
		if (findOpset(opSetName) > -1)
		{
			/*if (opset.get(findOpset(opSetName)).findOpt(optionName) > -1)
			{

				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println(newPrice);
				System.out.println("");
				System.out.println("");
			     setOptPrice(findOpset(opSetName), opset.get(findOpset(opSetName)).findOpt(optionName), newPrice);
			}*/
			this.opset.get(findOpset(opSetName)).updateOptPrice(optionName, newPrice);
		};
	}
	
	synchronized public void updateOptName(String opSetName, String optionName, String newName)
	{
		if (findOpset(opSetName) > -1)
		{
			
			this.opset.get(findOpset(opSetName)).updateOptName(optionName, newName);
		};
	}
	
	
	// Delete
	synchronized public void deleteopsets(){
		for (int i = 0; i < opset.size(); i++)
			opset.get(i).deleteOpts();
		for (int i = 0; i < opset.size(); i++)
			opset.set(i, null);
		opset = null;
	}
	synchronized public void deleteopset(int i){
		opset.get(i).deleteOpts();
		opset.set(i, null);
	}
	synchronized public void deleteOpts(int i){
		opset.get(i).deleteOpts();
	}
	synchronized public void deleteOpt(int i, int io){
		opset.get(i).deleteOpt(io);
	}
	
	// Print
	synchronized public void print() {
		System.out.print("The name of model: ");
		System.out.println(model);
		System.out.print("The base price of model: ");
		System.out.println(basePrice);
		for (int i = 0; i < opset.size(); i++) {
			opset.get(i).printOpset();
		}
	}
	
	synchronized public void printChoice()
	{
		for (int i = 0; i < opset.size(); i++) {
			opset.get(i).printChoice();
		}
	}
}



	
	
	