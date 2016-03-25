package client;

import java.util.ArrayList;
import java.util.Scanner;

import model.Automobile;

public class SelectCarOption {
	public void showModels(ArrayList<String> models){
		String name;
		System.out.println("from server autoModelList: ");
		for (int i = 0; i < models.size();i++)
		{
			name = models.get(i);
			System.out.println(name);
		}
	}
	
	public String selectModel()
	{
		String modelName = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the model name: ");
		modelName = scanner.nextLine();
		return modelName;
	}
	
	public void showOptions (Automobile theAuto)
	{
		System.out.println("This is the model info");
		theAuto.print();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter color you want to choose");
		String choice1 = scanner.nextLine();
		theAuto.setOptionChoice("Color", choice1);
		
		System.out.println("Enter transmisison you want to choose");
		String choice2 = scanner.nextLine();
		theAuto.setOptionChoice("Transmission", choice2);
		
		System.out.println("Enter brakes/traction control you want to choose");
		String choice3 = scanner.nextLine();
		theAuto.setOptionChoice("Brakes/Traction Control", choice3);
		
		System.out.println("Enter side impact airt bags present or not present");
		String choice4 = scanner.nextLine();
		theAuto.setOptionChoice("Side Impact Air Bags", choice4);
		
		System.out.println("Enter powerroof present or not present");
		String choice5 = scanner.nextLine();
		theAuto.setOptionChoice("Power Moonroof", choice5);
		
		System.out.println("Summary of your choice: ");
		theAuto.printChoice();
	}
}
