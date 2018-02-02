package copy;

import java.io.*;
import java.util.Scanner;

public class praveencopyfile {
 
    public static void main(String args[])
    {	
        String srcfname, dstfname;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter Source File Name (with extension like source.txt) : ");
        srcfname = scan.nextLine();
        System.out.print("Enter Destination File Name (with extension like destination.txt) : ");
        dstfname = scan.nextLine();
        
    	InputStream inStream = null;
    	OutputStream outStream = null;
		
    	try
    	{
    	    File file1 =new File(srcfname);
    	    File file2 =new File(dstfname);
 
    	    inStream = new FileInputStream(file1);
    	    outStream = new FileOutputStream(file2);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    while ((length = inStream.read(buffer)) > 0)
    	    {
    	    	outStream.write(buffer, 0, length);
    	    }
 
    	    if (inStream != null)
    	       inStream.close();
    	    if (outStream != null)
    	       outStream.close();
 
    	    System.out.println("File Copied..");
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
}
