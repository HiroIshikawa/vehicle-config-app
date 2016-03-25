package util;

import java.io.*;

import java.util.*;

import model.Automobile;


import exception.AutoException;
import exception.MissingNameForAutomobileException;
import exception.MissingOpsetSizeException;
import exception.MissingOptNameException;
import exception.MissingOptPriceException;
import exception.MissingOptSetNameException;
import exception.MissingOptSizeException;
import exception.MissingPriceForAutomobileException;


public class AutoFileIO  {
	static public Automobile readFile(String filename) throws AutoException
	{
		Automobile automobile = new Automobile();
		try {
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);

			// opsets size
			String firstline = buff.readLine();
			try{
				if (firstline.equals("")){
					throw new MissingOpsetSizeException(1, "Missing OptionSet Size");}
			}
			catch(MissingOpsetSizeException ae1){
				firstline = ae1.fix();
				System.out.println(firstline);
			}
			System.out.println(firstline);
			int optsSize = Integer.parseInt(firstline); // 5
			automobile.setOpsets(optsSize);
			

			// opts sizes for each opset
			int[] size = new int[optsSize];
			for (int i = 0; i < optsSize; i++)
			{
				String line = buff.readLine();
				try{
					if (line == "")
						throw new MissingOptSizeException(2, "Missing Option Size");
				}
				catch (MissingOptSizeException a2){
					line = a2.fix();
				}
				size[i] = Integer.parseInt(line);
				automobile.setOpt(i, Integer.parseInt(line));
			}
			
			// name of auto
			String lineAutoNam = buff.readLine();
			try
			{
				if (lineAutoNam == "")
					throw new MissingNameForAutomobileException(3, "Missing Name for Auto");
			}
			catch(MissingNameForAutomobileException ae3)
			{
				lineAutoNam = ae3.fix();
			}
			automobile.setName(lineAutoNam);

			// baseprice of auto
			String lineAutoPrice = buff.readLine();
			try
			{
				if (lineAutoPrice.equals(""))
					throw new MissingPriceForAutomobileException(4, "Missing Base Price for Auto");
			}
			catch(MissingPriceForAutomobileException ae4)
			{
				lineAutoPrice = ae4.fix();
			}
			automobile.setBaseprice(Integer.parseInt(lineAutoPrice));	


			// name of the optionsets
			for (int i = 0; i < optsSize; i++)
			{
				String line = buff.readLine();
				try {
					if (line.equals(""))
						throw new MissingOptSetNameException(5, "Missing Option Set Name");
				}
				catch (MissingOptSetNameException ae5)
				{
					line = ae5.fix();
				}
				automobile.setOpsetName(i, line);			
			}

			// name of options
			for (int i = 0; i < optsSize; i++)
			{
				for (int j = 0; j < size[i]; j++) // size[0] == 10
 				{
					String line = buff.readLine();
					try {
						// automobile.getOpset(i).setOptName(line, j);
						if (line.equals(""))
							throw new MissingOptNameException(6, "Missing Option Name");
					}
					catch (MissingOptNameException ae6)
					{
						line = ae6.fix();
					}
					automobile.setOptName(i, j, line);
				}
			}

			// price of options
			for (int i = 0; i < optsSize; i++)
			{
				for (int j = 0; j < size[i]; j++) // size[0] == 10
 				{
					String line = buff.readLine();
					try {
						if (line.equals(""))
							throw new MissingOptPriceException(7, "Missing Option Price");
					}
					catch (MissingOptPriceException ae7)
					{
						line = ae7.fix();
					}
					int val = 0;
					try {
				        val=Integer.parseInt(line);		
					}
					catch (NumberFormatException e)
					{
				       System.out.println("not a number"); 
					}
					automobile.setOptPrice(i, j, val);
				}			
			}
			buff.close();
		} catch (IOException e) {
			System.out.println("No File Found Exception Found.");
			throw new exception.NoAutoFileFoundException();
		}
		return automobile;
	}
	
	static public Automobile readProperties(Properties props) throws IOException {
		Automobile automobile = new Automobile();
		automobile.setOpsets(5);
		String CarMake = props.getProperty("CarMake");
   
		if (CarMake!=null) {
			String CarBasePrice = props.getProperty("CarBasePrice");
			String CarModel = props.getProperty("CarModel");
			String Option1 = props.getProperty("Option1");
			String OptionValue1a = props.getProperty("OptionValue1a");
			String OptionValue1b = props.getProperty("OptionValue1b");
			String OptionValue1c = props.getProperty("OptionValue1c");
			String OptionValue1d = props.getProperty("OptionValue1d");
			String OptionValue1e = props.getProperty("OptionValue1e");
			String OptionValue1f = props.getProperty("OptionValue1f");
			String OptionValue1g = props.getProperty("OptionValue1g");
			String OptionValue1h = props.getProperty("OptionValue1h");
			String OptionValue1i = props.getProperty("OptionValue1i");
			String OptionValue1j = props.getProperty("OptionValue1j");
			String Option2 = props.getProperty("Option2");
			String OptionValue2a = props.getProperty("OptionValue2a");
			String OptionValue2b = props.getProperty("OptionValue2b");
			String Option3 = props.getProperty("Option3");
			String OptionValue3a = props.getProperty("OptionValue3a");
			String OptionValue3b = props.getProperty("OptionValue3b");
			String OptionValue3c = props.getProperty("OptionValue3c");
			String Option4 = props.getProperty("Option4");
			String OptionValue4a = props.getProperty("OptionValue4a");
			String OptionValue4b = props.getProperty("OptionValue4b");
			String Option5 = props.getProperty("Option5");
			String OptionValue5a = props.getProperty("OptionValue5a");
			String OptionValue5b = props.getProperty("OptionValue5b");
			
			String OptionPrice1a = props.getProperty("OptionPrice1a");
			String OptionPrice1b = props.getProperty("OptionPrice1b");
			String OptionPrice1c = props.getProperty("OptionPrice1c");
			String OptionPrice1d = props.getProperty("OptionPrice1d");
			String OptionPrice1e = props.getProperty("OptionPrice1e");
			String OptionPrice1f = props.getProperty("OptionPrice1f");
			String OptionPrice1g = props.getProperty("OptionPrice1g");
			String OptionPrice1h = props.getProperty("OptionPrice1h");
			String OptionPrice1i = props.getProperty("OptionPrice1i");
			String OptionPrice1j = props.getProperty("OptionPrice1j");
			String OptionPrice2a = props.getProperty("OptionPrice2a");
			String OptionPrice2b = props.getProperty("OptionPrice2b");
			String OptionPrice3a = props.getProperty("OptionPrice3a");
			String OptionPrice3b = props.getProperty("OptionPrice3b");
			String OptionPrice3c = props.getProperty("OptionPrice3c");
			String OptionPrice4a = props.getProperty("OptionPrice4a");
			String OptionPrice4b = props.getProperty("OptionPrice4b");
			String OptionPrice5a = props.getProperty("OptionPrice5a");
			String OptionPrice5b = props.getProperty("OptionPrice5b");
		
			automobile.setMake(CarMake);
			automobile.setBaseprice(Integer.parseInt(CarBasePrice));
			automobile.setModel(CarModel);
			automobile.setOpsetName(0, Option1);
			automobile.setOpsetName(1, Option2);
			automobile.setOpsetName(2, Option3);
			automobile.setOpsetName(3, Option4);
			automobile.setOpsetName(4, Option5);
			
			automobile.setOpts(automobile.opset.get(0), 10);
			automobile.setOptPrice(0, 0, Integer.parseInt(OptionPrice1a));
			automobile.setOptPrice(0, 1, Integer.parseInt(OptionPrice1b));
			automobile.setOptPrice(0, 2, Integer.parseInt(OptionPrice1c));
			automobile.setOptPrice(0, 3, Integer.parseInt(OptionPrice1d));
			automobile.setOptPrice(0, 4, Integer.parseInt(OptionPrice1e));
			automobile.setOptPrice(0, 5, Integer.parseInt(OptionPrice1f));
			automobile.setOptPrice(0, 6, Integer.parseInt(OptionPrice1g));
			automobile.setOptPrice(0, 7, Integer.parseInt(OptionPrice1h));
			automobile.setOptPrice(0, 8, Integer.parseInt(OptionPrice1i));
			automobile.setOptPrice(0, 9, Integer.parseInt(OptionPrice1j));
			
			automobile.setOptName(0, 0, OptionValue1a);
			automobile.setOptName(0, 1, OptionValue1b);
			automobile.setOptName(0, 2, OptionValue1c);
			automobile.setOptName(0, 3, OptionValue1d);
			automobile.setOptName(0, 4, OptionValue1e);
			automobile.setOptName(0, 5, OptionValue1f);
			automobile.setOptName(0, 6, OptionValue1g);
			automobile.setOptName(0, 7, OptionValue1h);
			automobile.setOptName(0, 8, OptionValue1i);
			automobile.setOptName(0, 9, OptionValue1j);
			
			automobile.setOpts(automobile.opset.get(1),2);
			automobile.setOptPrice(1, 0, Integer.parseInt(OptionPrice2a));
			automobile.setOptPrice(1, 1, Integer.parseInt(OptionPrice2b));
			automobile.setOptName(1, 0, OptionValue2a);
			automobile.setOptName(1, 1, OptionValue2b);
			
			automobile.setOpts(automobile.opset.get(2),3);
			automobile.setOptPrice(2, 0, Integer.parseInt(OptionPrice3a));
			automobile.setOptPrice(2, 1, Integer.parseInt(OptionPrice3b));
			automobile.setOptPrice(2, 2, Integer.parseInt(OptionPrice3c));
			automobile.setOptName(2, 0, OptionValue3a);
			automobile.setOptName(2, 1, OptionValue3b);
			automobile.setOptName(2, 2, OptionValue3c);
			
			automobile.setOpts(automobile.opset.get(3),2);
			automobile.setOptPrice(3, 0, Integer.parseInt(OptionPrice4a));
			automobile.setOptPrice(3, 1, Integer.parseInt(OptionPrice4b));
			automobile.setOptName(3, 0, OptionValue4a);
			automobile.setOptName(3, 1, OptionValue4b);
			
			automobile.setOpts(automobile.opset.get(4),2);
			automobile.setOptPrice(4, 0, Integer.parseInt(OptionPrice5a));
			automobile.setOptPrice(4, 1, Integer.parseInt(OptionPrice5b));
			automobile.setOptName(4, 0, OptionValue5a);
			automobile.setOptName(4, 1, OptionValue5b);
		}
		return automobile;
	}

	static public void serializeAuto(Automobile automobile) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("auto.ser"));
			out.writeObject(automobile);
			out.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			System.exit(1);
		}
	}

	static public Automobile deserializeAuto(String name) {
		try {
			Automobile automobile;
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					name));
			automobile = (Automobile) in.readObject();
			in.close();
			return automobile;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}