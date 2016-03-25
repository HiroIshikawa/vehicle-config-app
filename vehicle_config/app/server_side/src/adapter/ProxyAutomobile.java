package adapter;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;

import java.util.LinkedHashMap;

import exception.*;

import util.AutoFileIO;
import model.Automobile;


public abstract class ProxyAutomobile{
	private static LinkedHashMap<String, Automobile> mobiles = new LinkedHashMap<String, Automobile>();
	private Automobile auto;
	private ArrayList<String> models;

	/*
	public void add(String model)
	{
		mobiles.put(model, new Automobile());
	}
	public void add(String model, AutomFOobile auto)
	{
		mobiles.put(model, auto);
	}*/

	public static LinkedHashMap<String, Automobile> getMobileHash(){ return mobiles; }

	public void buildAuto(String filename) throws AutoException 
	{
		Boolean isError;
		do
		{
			isError = false;
			try
			{
				auto = AutoFileIO.readFile(filename);
			}
			catch(NoAutoFileFoundException e)
			{
				filename = fixNoFile();
				isError = true;
			}
		}
		while(isError);
		mobiles.put(auto.getName(), auto);
	};
	/*
	public void buildWithProp(String filename){
		try {
			auto = AutoFileIO.readProperties(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mobiles.put(auto.getModel(), auto);
	}*/

	public void buildWithProp(Properties prop) {
		// TODO Auto-generated method stub
		Boolean isError;
		do
		{
			isError = false;
			try {
				System.out.println("ProxyMobile.bulidWithPrep - try {");
				System.out.println(prop);
				auto = AutoFileIO.readProperties(prop);
				System.out.println(auto.getModel());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(isError);
		System.out.println("ProxyAutomobile.buildWithProp - while(idError)");
		mobiles.put(auto.getModel(), auto);
		System.out.println(auto.getModel());
		System.out.println(mobiles.get(auto.getModel()));
	}

	public ArrayList<String> getModels() {
		models = new ArrayList<String>();
		final Iterator<String> cursor = mobiles.keySet().iterator();
		while (cursor.hasNext()) {
			final String key = cursor.next();
			models.add(key);
		}
		return models;
	}

	public boolean sendChoosenModel(ObjectOutputStream out, String modelname) {
		Automobile theModel = mobiles.get(modelname);
		if(theModel == null) {
			System.out.println("Choosen model not found");
			return false;
		}
		try {
			out.writeObject(theModel);
			out.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean findAuto(String searchTerm){
		if (mobiles.containsKey(searchTerm))
		{
			return true;
		}
		System.out.println("Not Found");
		return false;
	}

	public void printAuto(String modelName){
		if (findAuto(modelName))
		{
			auto = mobiles.get(modelName);
			auto.print();
		}
	};

	public void updateOptionSetName(String modelName, String OptionSetName, String NewName){
		if (this.findAuto(modelName))
			mobiles.get(modelName).updateOpsetName(OptionSetName, NewName);
	};

	synchronized public void updateOptionPrice(String modelName, String optionSetName, String optionName, float newPrice){
		if (this.findAuto(modelName))
			mobiles.get(modelName).updateOptPrice(optionSetName, optionName, newPrice);
	};

	synchronized public void updateOptionName(String modelName, String optionSetName, String optionName, String newName){
		if (this.findAuto(modelName))
			mobiles.get(modelName).updateOptName(optionSetName, optionName, newName);
	};

	synchronized public String getOptionName(String modelName, String optionSetName, int index)
	{
		if (this.findAuto(modelName))
		{
			System.out.println("");
			System.out.println("Fetching the name of the option");
			System.out.println(modelName);
			System.out.println(optionSetName);
			System.out.println(index);
			System.out.println("");
			return mobiles.get(modelName).getOptionName(optionSetName, index);
		}
		return null;
	}

	synchronized public float getOptionPrice(String modelName, String optionSetName, String optionName)
	{
		if (this.findAuto(modelName))
		{
			System.out.println("");
			System.out.println("Fetching the Price of the option");
			System.out.println(modelName);
			System.out.println(optionSetName);
			System.out.println(optionName);
			System.out.println("");
			return mobiles.get(modelName).getOptionPrice(optionSetName, optionName);
		}
		return 0;
	}

	public String fixNoFile() {
		System.out.println("File not found. Please enter the name of a file again.");
		Scanner s=new Scanner(System.in);
		return s.nextLine();
	}
}
