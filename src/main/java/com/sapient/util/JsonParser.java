/**
 * 
 */
package com.sapient.util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;

/**
 * @author ssi248
 *
 */
public class JsonParser {
	
	public static Object recursiveSelect(String key,String jsonData)
	{
	
	JSONObject oTemp;
	JSONArray arrTemp;
	Object retVal=null;
	if(jsonData.startsWith("{")){
		oTemp = new JSONObject(jsonData);
		if(oTemp.has(key))
		{
			
			retVal =oTemp.get(key);	
			return retVal;
	
}
		else{
			for(String s:oTemp.keySet())
			{
				if((oTemp.get(s) instanceof JSONArray) || (oTemp.get(s) instanceof JSONObject))
				{
					retVal = recursiveSelect(key, oTemp.get(s).toString());
					if(retVal !=null)
					{
						return retVal;
					}
			}
			
		}
	
	}
}
	else if(jsonData.startsWith("["))
	{
		arrTemp = new JSONArray(jsonData);
		for(int i=0;i<arrTemp.length();i++)
		{
			retVal = recursiveSelect(key, arrTemp.get(i).toString());
			if(retVal !=null)
			{
				return retVal;
			}
		}
	}
	return retVal;
	}
	
	public static Object getValueFromArray(String key, String whereField, String whereValue,String feedData)
	{
		Object retValue=null;
		if(key.contains("."))
		{
			String[] keys=key.split("\\.");
			if(feedData.startsWith("{"))
			{
				JSONObject feedObject = new JSONObject(feedData);
				if(feedObject.has(keys[0]))
				{
					Object tempVal= feedObject.get(keys[0]);
					retValue= getValueFromArray(keys[1],whereField,whereValue,tempVal.toString());
				}
				else
				{
					Reporter.log(key +"is not present in the Json");
				}
			}
			
			else if (feedData.startsWith("["))
			{
				JSONArray feedArray = new JSONArray(feedData);
				for(int i=0;i<feedArray.length();i++)
				{
					if((feedArray.get(i) instanceof JSONArray) || feedArray.get(i) instanceof JSONObject)
{
	retValue= getValueFromArray(keys[1],whereField,whereValue,feedArray.get(i).toString());
}
				}
				
			}
		}
		else
		{
			retValue = recursiveSelect(key, feedData,whereField,whereValue);
		}
		
		return retValue;
	}

	/**
	 * @param key
	 * @param feedData
	 * @param whereField
	 * @param whereValue
	 * @return
	 */
	private static Object recursiveSelect(String key, String jsonData, String existingKey, String existingValue) {
		// TODO Auto-generated method stub
		JSONObject oTemp;
		JSONArray arrTemp;
		Object retVal=null;
		if(jsonData.startsWith("{")){
			oTemp = new JSONObject(jsonData);
			if(oTemp.has(key) && oTemp.has(existingKey)&& oTemp.getString(existingKey).equalsIgnoreCase(existingValue))
			{
				
				retVal =oTemp.get(key);	
				return retVal;
		
	}
			else{
				for(String s:oTemp.keySet())
				{
					if((oTemp.get(s) instanceof JSONArray) || (oTemp.get(s) instanceof JSONObject))
					{
						retVal = recursiveSelect(key, oTemp.get(s).toString(),existingKey,existingValue);
						if(retVal !=null)
						{
							return retVal;
						}
				}
				
			}
		
		}
	}
		else if(jsonData.startsWith("["))
		{
			arrTemp = new JSONArray(jsonData);
			for(int i=0;i<arrTemp.length();i++)
			{
				if((arrTemp.get(i) instanceof JSONArray) ||(arrTemp.get(i) instanceof JSONObject))
				{
					retVal = recursiveSelect(key,  arrTemp.get(i).toString(),  existingKey,  existingValue);
					if(retVal !=null)
					{
						return retVal;
					}
				}
			}
			
			}
		return retVal;
	}
}
