import java.util.ArrayList;
import java.util.Collections;


public class batcher {

	/*
	 * This class decides how to handle the data based on the dataType being submitted. 
	 * Usage is the same for all dataTypes.
	 */
	
	
	/*Handles batch of generic objects
	 * Class returns a copy of the list of objects when full, and resets the original list.
	 *Limit variable is calculated as the number of objects in the List. 
	 *the limit amount is user.
	 */
	int objLimit;
	int objIndex;
	ArrayList<Object> objBatch = new ArrayList<Object>();
	
	synchronized ArrayList<Object> submit(Object a) {
		
		objBatch.add(a);
		objIndex++;
		if (objIndex == objLimit) {
			ArrayList<Object> fullBatch = new ArrayList<Object>(objBatch);
			objIndex = 0;
			objBatch.clear();
			return fullBatch;
			//TODO, reset batcher
			}
		
		else return null;
	}
	
	/*Handles string batch	
	 * Class returns a copy of the list of strings when full, and resets the original list.
	 * Limit variable is calculated as the total characters in the List. 
	 * The limit amount is user specified. 
	 */
	int strLimit;
	int strIndex;
	ArrayList<String> strBatch = new ArrayList<String>();
	
	synchronized ArrayList<String> submit(String a) {
		strBatch.add(a);
		strIndex += a.length();
		if (strIndex >= strLimit) {
			ArrayList<String> fullBatch = new ArrayList<String>(strBatch);
			strBatch.clear();
			strIndex = 0;
			return fullBatch;
		}
		else return null;
	}
	
	//constructors
	
	public batcher(String a, int limit){
		this.strLimit = limit;
		this.strBatch.add(a);
		this.strIndex = a.length();
		
	}
	
	public batcher(Object a, int limit){
		this.objLimit = limit;
		this.objBatch.add(a);
		this.objIndex = 1;
	}



}
