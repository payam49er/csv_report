package edu.mit.star.csv_report;
import au.com.bytecode.opencsv.CSVReader;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
//import java.util.*;

//import com.sun.tools.javac.util.List;

//import sun.tools.tree.ThrowStatement;
public class GenerateReport {

	public GenerateReport() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	
	public static String Parsecsv(String data)
	{
		
	   try
	   {
		//CSVReader reader = new CSVReader(new FileReader(filename));
	    StringReader str = new StringReader(data);
	    CSVReader reader = new CSVReader(str);
		java.util.List<String[]> content = reader.readAll();
		HashMap<String,Group> groups = new HashMap<String,Group>();
		for(String[] row:content)
		{
			String Name = row[0];
			String Events = row[1];
			//System.out.printf("%S has attended %S events %n",Name, Events);
			
			if(groups.containsKey(Name)){
				groups.get(Name).Add(Double.valueOf(Events));
			}else
			{
				Group g = new Group();
				g.Add(Double.valueOf(Events));
				groups.put(Name, g);
			}
			
		}
		reader.close();
		StringBuilder result = new StringBuilder();
		for(String name:groups.keySet())
		{
			//System.out.printf("%S has attended %S events with average of %S %n",name,groups.get(name).Gettotal(),groups.get(name).GetAverage());
		     String val = String.format("%S has attended %S events with average of %S %n",name,groups.get(name).Gettotal(),groups.get(name).GetAverage());
		     result.append(val);
		}
		
		return result.toString();
		
	   }
	   catch(Exception e)
	   {
		   return e.toString();
	   }
	}
		
	static class Group{
		private ArrayList<Double> events;
		
		public Group()
		{
			events = new ArrayList<Double>();
		}
		
		public Double Gettotal(){
			double sum = 0;
			for(Double event:events)
			{
			   	sum += event;
			}
			return sum;
		}
		
		public Double GetAverage(){
			return Gettotal()/events.size();
		}
		
		public void Add(Double m){
			events.add(m);
		}
	}
	
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
          String filename = "/Users/mothership/www/csv_report/data/test.csv";
          Parsecsv(filename);
	}
*/
}