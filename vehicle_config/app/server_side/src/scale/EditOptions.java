package scale;

import adapter.ProxyAutomobile;

import java.lang.Runnable;

import java.lang.Thread;
import scale.ScaleThread;

public class EditOptions extends ProxyAutomobile implements Runnable, ScaleThread{
	private ProxyAutomobile auto;
    private int ops;
    public EditOptions(int ops, ProxyAutomobile auto) {
        this.ops = ops; //create an instance of a1 for a given ops
        this.auto = auto;
        // this.a1 = new Thread();
        // this.auto = auto;
        // a1 = new Thread();
    }
    
	public void run() {
		synchronized(auto){
		System.out.println("**** inside run()****");
    	//while (running)
	    //{
    		System.out.println("**** inside run() ops****");
    		switch(ops)
	        {
	           case 0:  updateOptionName("FordZTW","Color","Gold Clearcoat Metalic", "blue"); break;
	           case 1:  updateOptionPrice("FordZTW","Color","Gold Clearcoat Metallic",500); break;
	           case 2:  updateOptionName("FordZTW","Color","Gold Clearcoat Metallic","red"); break;
	           case 3:  updateOptionPrice("FordZTW","Color","Gold Clearcoat Metallic",1000); break;
	           case 4:  System.out.println("");
	           			System.out.println("");
	           			System.out.println(getOptionName("FordZTW","Color", 0));
	           			System.out.println("");
	           			System.out.println("");
	           			break;
	           case 5:  System.out.println("");
		      			System.out.println("");
		      			System.out.println(getOptionPrice("FordZTW","Color", "Gold Clearcoat Metallic"));
		      			System.out.println("");
		      			System.out.println("");
		      			break;
	        }
	    //}
    	System.out.println("*****************************");
    	System.out.println("***** The current state *****");
    	System.out.println("*****************************");
    	auto.printAuto("FordZTW");
    	System.out.println("*****************************");
    	System.out.println("*****************************");
		}
    }
	
    public void start () {
    }

    public void stop () {	
    }
    
    void randomWait() {
        try {
        	System.out.println("");
        	System.out.println("random Waiting!!");
        	System.out.println("");
        	Thread.currentThread();
        	Thread.sleep((long)(3000*Math.random()));
        } catch(InterruptedException e) {
        	System.out.println("");
            System.out.println("Interrupted!");
            System.out.println("");
        }
    }  
    	
	synchronized public void updateOptionName(String modelName, String optionSetName, String optionName, String newName){
		System.out.println("");
		System.out.println("Option Name Updating to....");
		System.out.println(newName);
		System.out.println("");
		randomWait(); 
		auto.updateOptionName(modelName, optionSetName, optionName, newName);
		System.out.println("");
		System.out.println("Option Name Updated");
		System.out.println(newName);
		System.out.println("");
	};
	synchronized public void updateOptionPrice(String modelName, String optionSetName, String optionName, float price){
		System.out.println("");
		System.out.println("Option Price Updating to...");
		System.out.println(price);
		System.out.println("");
		randomWait();
		auto.updateOptionPrice(modelName, optionSetName, optionName, price);
		System.out.println("");
		System.out.println("Option Price Updated to");
		System.out.println(price);
		System.out.println("");
	};
	
	synchronized public String getOptionName(String modelName, String optionSetName, int index)
	{
		return auto.getOptionName(modelName, optionSetName, index);
	}
	
	synchronized public float getOptionPrice(String modelName, String optionSetName, String optionName)
	{
		return auto.getOptionPrice(modelName, optionSetName, optionName);
	}
	
	
}
