package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class CarModelOptionsIO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Properties readData(String fname){
		Properties props= new Properties(); 
		FileInputStream in = null;
		try {
			in = new FileInputStream(fname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}
	
}
