package training;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class exm {
	
	    
	    public static void main(String[] args) {
	        FileInputStream fis=null;
	        try {
	            fis=new FileInputStream("C:\\Users\\shabe\\Desktop\\ss.txt");
	            char c=(char)fis.read();
	            while(c!=-1) 
	    			System.out.print(c);
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        finally {
	            try {
	                fis.close();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        
	    
	        
	    }
	    
	}


