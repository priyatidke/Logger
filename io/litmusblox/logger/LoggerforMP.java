//package io.litmusblox.logger;

//import java.util.logging.Logger;

//import org.apache.http.HttpRequest;

//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.LogManager;
/*public class LoggerforMP implements ClientHttpRequestInterceptor {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	 
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }
 
    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        if (log.isDebugEnabled()) {
            log.debug("===========================request begin================================================");
            log.debug("URI         : {}", request.getURI());
            log.debug("Method      : {}", request.getMethod());
            log.debug("Headers     : {}", request.getHeaders());
            log.debug("Request body: {}", new String(body, "UTF-8"));
            log.debug("==========================request end================================================");
        }
    }
    private void logResponse(ClientHttpResponse response) throws IOException {
        if (log.isDebugEnabled()) {
            log.debug("============================response begin==========================================");
            log.debug("Status code  : {}", response.getStatusCode());
            log.debug("Status text  : {}", response.getStatusText());
            log.debug("Headers      : {}", response.getHeaders());
            log.debug("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
            log.debug("=======================response end=================================================");
        }
    }
}

	/*private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 

// Get the Logger from the log manager which corresponds  
// to the given name <Logger.GLOBAL_LOGGER_NAME here> 
// static so that it is linked to the class and not to 
// a particular log instance because Log Manage is universal 
public void makeSomeLog() 
{ 
    // add some code of your choice here 
    // Moving to the logging part now 
    LOGGER.log(Level.INFO, "My first Log Message"); 

    // A log of INFO level with the message "My First Log Message" 
} 


//public class GfG 
//{ 
public static void main(String[] args) 
{ 
	LoggerforMP obj = new LoggerforMP(); 
    obj.makeSomeLog(); 

    // Generating some log messages through the  
    // function defined above 
    LogManager lgmngr = LogManager.getLogManager(); 

    // lgmngr now contains a reference to the log manager. 
    Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME); 

    // Getting the global application level logger  
    // from the Java Log Manager 
    log.log(Level.INFO, "This is a log message"); 

    // Create a log message to be displayed 
    // The message has a level of Info 
} */

