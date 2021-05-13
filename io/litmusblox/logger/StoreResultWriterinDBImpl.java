package io.litmusblox.logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Date;

import com.amazonaws.services.lambda.runtime.Context;

public class StoreResultWriterinDBImpl implements ResultWriterinDB{
	//@Override
	/*//public void storeValues(String input, String output, Context context) {

	public void storeValues(String string, String jsonString, Context context) {
		String envName= "";
		if(context.getFunctionName().equals("PredictorDev")){
			envName="PredictorDev";
		}
		else if(context.getFunctionName().equals("Testing_Mega-Predictor")){
			envName="Testing_Mega-Predictor";
		}
		else if(context.getFunctionName().equals("PredictorProd")){
			envName="PredictorProd";
		}
		else
		{
			envName="TestingForSubroles";
		}
		Date date= new Date();
        //getTime() returns current time in milliseconds
	    long time = date.getTime();
		this.storeResult(Long.toString(time), string, jsonString, Long.toString(time), envName, "Metadata");//this.
		
	}*/



	public void storeResult(String id,String input,String output,String timestamp, String intance,String metadata) {
		Connection connection = null;
		
		try {
			//System.out.println("================== :::::::::::::::::::===================");
			//System.out.println(resumeContent);
			// LOAD THE DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://jmdb-predictor-dev.cptvjl3vuwqy.ap-south-1.rds.amazonaws.com/role_predictor_dev",
					"jmlabsuser", "Testpass10");
            PreparedStatement stmt=connection.prepareStatement("INSERT INTO `MegaPredictor_logger`(ID,Input,Output,Time_Stamp,Instance,Meta_Data) VALUE (UNIX_TIMESTAMP(),?,?,CONVERT_TZ(NOW(),'UTC','Asia/Calcutta'),?,?)");//NOW()  
            
			//PreparedStatement stmt=connection.prepareStatement("INSERT INTO `Sales_Resume`(Resume_Title,Keyskills,Resume_Text) VALUE (?,?,?)");  
            //PreparedStatement stmt=connection.prepareStatement("INSERT INTO `ResumeParser`(Resume_Title,Keyskills,Resume_Text,Role_type) VALUE (?,?,?,?)");  

            //stmt.setString(1,id);
            stmt.setString(1,input);
			stmt.setString(2,output);
			//stmt.setString(4,timestamp);
			stmt.setString(3,intance);
			stmt.setString(4,metadata); 

              
            int i=stmt.executeUpdate(); 
            
			// iterate through the java resultset
			
			stmt.close();
            System.out.println("Database updated successfully ");

		} catch (Exception e) {
			System.out.println(e);
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
}
	@Override
	public void storeValues(String completeInput,String input,String output, Context context) {
		String envName= "";
		if(context.getFunctionName().equals("PredictorDev")){
			envName="PredictorDev";
		}
		else if(context.getFunctionName().equals("Testing_Mega-Predictor")){
			envName="Testing_Mega-Predictor";
		}
		else if(context.getFunctionName().equals("PredictorProd")){
			envName="PredictorProd";
		}
		else
		{
			envName="TestingForSubroles";
		}
		Date date= new Date();
        //getTime() returns current time in milliseconds
	    long time = date.getTime();
	    
		this.storeResult("", input, output,"",envName,completeInput);//this.

	}
	}


