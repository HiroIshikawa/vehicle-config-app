package server;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Properties;

import adapter.BuildAuto;

public class BuildCarModelOptions implements AutoServer{
	BuildAuto auto = null;
	public void buildWithProp(Properties prop) {
		if(auto == null) {
    		auto = new BuildAuto();
    		System.out.println("BulidCarModelOptions.buildWithProp auto = new BuildAuto()");
    	}
		auto.buildWithProp(prop);
		
		String modelName = "FordZTW";
		auto.printAuto(modelName);
	}
	@Override
	public ArrayList<String> getModels() {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		if(auto!=null) {
			list.addAll(auto.getModels());
		}
		return list;
	}
	
	public boolean sendChoosenModel(ObjectOutputStream out, String theModel) {
		if(auto.sendChoosenModel(out, theModel))
			return true;
		else
			return false;
	}
}