package server;

import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Properties;

public interface AutoServer {
	public void buildWithProp(Properties prop);
	public ArrayList<String> getModels();
	public boolean sendChoosenModel(ObjectOutputStream out, String modelname);
}
