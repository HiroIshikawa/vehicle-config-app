package scale;

public interface ScaleThread{
	public void updateOptionName(String modelName, String optionSetName, String optionName, String newName);	
	public void updateOptionPrice(String modelName, String optionSetName, String optionName, float price);
	/*public void run();
	public void stop();*/
}
