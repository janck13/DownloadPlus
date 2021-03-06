import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class Logger {
	private static boolean log = false;
	private static boolean debug = false;
	/* enumerations for errors, check the map below for message strings */
	public enum Status{
		ERR_CONN, ERR_HTTP, ERR_REDIRECT, ERR_CLOCK,
		ERR_DUMP, ERR_READ, ERR_MERGE,
		ERR_PAUSE, ERR_RESUME, ERR_THREAD, ERR_FILE,
		ERR_DESTROY, ERR_LOAD, ERR_CLIPBOARD
	}
	private static final Map<Status, String> errorMap = new HashMap<Status,String>();
	static{
		errorMap.put(Status.ERR_CONN, "Error establishing connection.");
		errorMap.put(Status.ERR_HTTP, "Error response from HTTP.");
		errorMap.put(Status.ERR_REDIRECT, "Redirection cycle detected.");
		errorMap.put(Status.ERR_CLOCK, "Error operating with clock.");
		errorMap.put(Status.ERR_DUMP, "Error dumpting data.");
		errorMap.put(Status.ERR_READ, "Error reading data.");
		errorMap.put(Status.ERR_MERGE, "Error merging part files.");
		errorMap.put(Status.ERR_PAUSE, "Error pausing thread.");
		errorMap.put(Status.ERR_RESUME, "Error resuming thread.");
		errorMap.put(Status.ERR_THREAD, "Error in thread operation.");
		errorMap.put(Status.ERR_FILE, "Error in processing/creating file.");
		errorMap.put(Status.ERR_DESTROY, "Error in deleting file.");
		errorMap.put(Status.ERR_LOAD, "Error loading state.");
		errorMap.put(Status.ERR_CLIPBOARD, "Error accessing clipboard.");

	}
	
	public static void enableLog(){
		log = true;
	}
	
	public static void enableLog(boolean flag){
		log = flag;
	}

	public static void enableDebug(){
		debug = true;
	}
	
	public static void enableDebug(boolean flag){
		debug = flag;
	}
	
	public static void log(Status status){
		if(log){
			System.out.print("["+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"] ");
			System.out.println(status.toString()+ " -> "+errorMap.get(status));
		}
	}
	
	public static void log(Status status, String extra){
		if(log){
			System.out.print("["+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"] ");
			System.out.println(status.toString()+ " -> "+errorMap.get(status)+" "+extra);
		}
	}
	
	public static void debug(String msg){
		if(debug){
			System.out.println("["+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"] "+msg);
		}
	}
}
