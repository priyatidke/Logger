 package lambdaJavaPredictor;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import io.litmusblox.logger.LogConfiguration;
import io.litmusblox.logger.ResultWriterinDB;
import io.litmusblox.logger.StoreResultWriterinDBImpl;
public class LambdaPredictor implements RequestStreamHandler {
	
	JSONParser parser = new JSONParser();
	ResultWriterinDB storeResultWriterinDB= new StoreResultWriterinDBImpl();
	   
	   public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException
	   {

		   
		LogConfiguration.initialize();
		   
	    LambdaLogger logger = context.getLogger();
	    logger.log("Loading Java Lambda handler of ProxyWithStream");
	       String Active = null; 
	       String Company_Name = null;    //proxy
	       String Job_Description = null;  //param1
	       String Job_Title = null; 
	       String Responce=null;
	       String username = null;
	       String industry= null;
	       //String recruiterRoles= null;
	       demo predictor = new demo();
	       int err=0;
	       String password = null;//param2
	      // String choice1=null;
	       BufferedReader lambda_input = new BufferedReader(new InputStreamReader(inputStream));
	       JSONObject responseDetails = new JSONObject();
	       String responseCode = "200";
	       JSONObject input_JSON = null;
	       try {
	           input_JSON = (JSONObject)parser.parse(lambda_input);
	           logger.log("****"+input_JSON);
	           if (input_JSON.get("pathParameters") != null) {
	               JSONObject pathParameter = (JSONObject)input_JSON.get("pathParameters");
	               if ( pathParameter.get("proxy") != null) {
	                   Active = (String)pathParameter.get("proxy");
	               }
	           }
//  	           predictor.Global_Settings();
   //      predictor.addUser("abc","def");
	           if (input_JSON.get("queryStringParameters") != null)

	           {

	               JSONObject qps = (JSONObject)input_JSON.get("queryStringParameters");

	               if ( qps.get("username") != null)

	               {

	                   username = (String)qps.get("username");

	               }

	           }

	           if (input_JSON.get("queryStringParameters") != null)

	           {

	               JSONObject qps = (JSONObject)input_JSON.get("queryStringParameters");

	               if ( qps.get("password") != null)

	               {

	                   password = (String)qps.get("password");

	               }

	           }
//	           if (input_JSON.get("queryStringParameters") != null)
//
//	           {
//
//	               JSONObject qps = (JSONObject)input_JSON.get("queryStringParameters");
//
//	               if ( qps.get("choice1") != null)
//
//	               {
//
//	                   choice1=(String)qps.get("choice1");
//
//	               }
//
//	           }
	           
//	           for(Object obj:predictor.current_setting.Users) {
//	        	  JSONObject t1=new JSONObject();
//	        	  t1=(JSONObject)obj;
//	        	  err=0;
//	        	  if(username.toLowerCase().equals(t1.get("username").toString().toLowerCase())&&password.toLowerCase().equals(t1.get("password").toString().toLowerCase())){break;}
//	        	  if(!username.toLowerCase().equals(t1.get("username").toString().toLowerCase())||!password.toLowerCase().equals(t1.get("password").toString().toLowerCase())){err=3;}
//	        	  
//	           }
	           if(!username.equals("abc")||!password.equals("def")){err=3;}
	           if (input_JSON.get("body")!=null)
	        {
	        	JSONObject rP=(JSONObject)parser.parse(input_JSON.get("body").toString());
	        	if(rP.get("rolePrediction")!=null)
	        	{
	        		JSONObject rolePred=(JSONObject)parser.parse(rP.get("rolePrediction").toString());
	        		if(rolePred.get("jobTitle") != null)
	        		{
	        			Job_Title = (String)rolePred.get("jobTitle");
	        		}
	        		if(rolePred.get("jobDescription")!=null)
	        		{
	        			Job_Description = (String)rolePred.get("jobDescription");
	        		}
	        		if(rolePred.get("recruiterRoles")!=null) //|| rolePred.get("recruiterRoles")==null)
	        		{
	        			
	        			JSONArray abc = (JSONArray) rolePred.get("recruiterRoles");
	        			//if(abc.toString().contains("\\"))
	        			
	        			Responce = abc.toString().replace("\\", "");//replaceAll("[\\]{1,}", "\\");
	        			// (String)rolePred.get("recruiterRoles");
	        			/*else if(abc.toString().contains("\\\\"))
	        				Responce = abc.toString().replace("\\\\", "\\");
	        						//replaceAll("[\\]{1,}", "a")
	        			else if(abc.toString().contains("\n"))
	        				Responce = abc.toString().replace("\\", "n");
	        			else
	        				Responce = abc.toString();*/
	        			
	        			//Responce = null;
	        			//Responce = (String)rolePred.get("recruiterRoles");//.toString();
	        		}
	        		//else
	        		//{
	        			//JSONArray abc = (JSONArray) rolePred.get("recruiterRoles");
	        			//abc=null;
	        			//Responce = abc.toString();
	        			
	        			
	        		//}
	        		
	        		if(rolePred.get("industry")!=null)
	        		{
	        			industry = (String)rolePred.get("industry").toString();
	        		}
	        		else{
	        			industry = "";
	        		}
	        	}
	        }
		       
		       /*if (input_JSON.get("body") != null)
	           {
	               JSONObject bodyContents = (JSONObject)parser.parse(input_JSON.get("body").toString());
	               if ( bodyContents.get("jobTitle") != null)
	               {
	            	   Job_Title = (String)bodyContents.get("jobTitle");
	               }
	           }
	           if (input_JSON.get("body") != null)
	           {
	               JSONObject bodyContents = (JSONObject)parser.parse(input_JSON.get("body").toString());
	               if ( bodyContents.get("jobDescription") != null)
	               {
	            	   Job_Description = (String)bodyContents.get("jobDescription");
	               }
	           }
	           if (input_JSON.get("body") != null)
	           {
	               JSONObject bodyContents = (JSONObject)parser.parse(input_JSON.get("body").toString());
	               if ( bodyContents.get("company") != null)
	               {
	            	   Company_Name = (String)bodyContents.get("company");
	               }
	           }
	           if (input_JSON.get("body") != null)
	           {
	               JSONObject bodyContents = (JSONObject)parser.parse(input_JSON.get("body").toString());
	               if ( bodyContents.get("Response") != null)
	               {
	            	   Responce = (String)bodyContents.get("Response");
	               }
	           }*/
	           
	           }
	       catch(Exception e)
	       {
	        responseDetails.put("statusCode", "400");
	        responseDetails.put("exception", e);
	       }
	       
	     
	       
	       
	       
	       
	       ArrayList<String> topCapabilities=new ArrayList<String>();
	       ArrayList<String> topRoles=new ArrayList<String>();
	       if (Active.equals("True"))
	       {
	    	try {
	    		predictor.executor(Job_Description,Job_Title,Responce, industry);//vk
			} catch (Exception e) {
			
				e.printStackTrace();
			}
//	    	predictor.roleScoreCalculator(" "+Job_Description.replaceAll("\\s,|\\(|\\[|\\{|\\,"," "));
//	    	predictor.capabilityScoreCalculator();
//	    	predictor.storePrediction();
	    	
	       }
	       
	        JSONObject responseBody = new JSONObject();
	        if(err==3) {responseBody.put("Error ","Please check Username and Password");}
	        
	        else if(predictor.error==0||predictor.error==1||predictor.error==2||predictor.error==5||predictor.error==6||predictor.error==7) {
	        		responseBody.put("rolePrediction",predictor.rolePrediction);
	        		responseBody.put("towerGeneration",predictor.towerGeneration);
     }	
	   
	        	JSONObject headerJson = new JSONObject();
	           headerJson.put("x-custom-header", "my custom header value");
	           headerJson.put("Access-Control-Allow-Origin", "*");
	           responseDetails.put("isBase64Encoded", false);
	           responseDetails.put("statusCode", responseCode);
	           responseDetails.put("headers", headerJson);
	           responseDetails.put("body", responseBody.toString());  
	           OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
	           writer.write(responseDetails.toJSONString());  
	           writer.close();
	          storeResultWriterinDB.storeValues(input_JSON.toJSONString(),input_JSON.get("body").toString(),responseDetails.toJSONString(),context);
	           
	   }
	   
}

