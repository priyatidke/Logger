package io.litmusblox.logger;

import com.amazonaws.services.lambda.runtime.Context;

public interface ResultWriterinDB {
	
	void storeResult(String id,String input,String output,String timestamp, String intance,String metadata);

	void storeValues(String completeInput, String input, String response,Context context);
	//void storeValues(String input,String output,Context context);





}
