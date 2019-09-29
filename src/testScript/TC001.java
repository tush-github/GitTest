package testScript;

import java.util.ArrayList;
import java.util.HashMap;

import utilities.Excel;
import library.KeywordLibrary;

public class TC001 {

	public static void main(String[] args) throws Exception 
	{
		
		
		HashMap<Integer, ArrayList<String>> map = Excel.getAllData("TestCase");
		for (Integer key1 : map.keySet()) 
		{
			Thread.sleep(3000);
			ArrayList<String> list = map.get(key1);
			KeywordLibrary.controller(list.get(0), list.get(1), list.get(2), list.get(3));

		}

		}

}
