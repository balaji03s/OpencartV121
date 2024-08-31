package Day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class readingPropertiesFiles {

	public static void main(String[] args) throws IOException {
				
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\cofig.properties");
		
		Properties abcobj=new Properties();

		abcobj.load(file);
		
		//Reading the data
		String url=abcobj.getProperty("appurl");
		String email=abcobj.getProperty("email");
		String pwd=abcobj.getProperty("password");
		String oid=abcobj.getProperty("orderid");
		String cid=abcobj.getProperty("customerid");
		
		System.out.println(url+" "+email+" "+pwd+" "+oid+" "+" "+cid);
		
		//Reading all the keys
		//1
		Set<String>allkeys=abcobj.stringPropertyNames();
		System.out.println(allkeys);
		
		//2
		Set<Object> keys=abcobj.keySet();
		System.out.println(keys);
		
		//Reading all the values
		Collection<Object> values=abcobj.values();
		System.out.println(values);
		
		file.close();
		
	}

}
