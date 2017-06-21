package Pack1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;



public class Sample1  {

	public static void main(String[] args) throws IOException {
		
		 System.out.println("Check");
		String str = "Prem"+ ":" +"Suwalka";
//		String s = new String(str, "UTF-8");
//		System.out.println(Charset.forName("UTF-8").encode(str));
		
		String text = "This is an example é";
		byte[] byteText = text.getBytes(Charset.forName("UTF-8"));
		//To get original string from byte.
		try {
			String originalString= new String(byteText , "UTF-8");
			System.out.println("In string "+originalString);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(byte b : byteText) {
		System.out.println("In byte "+byteText);
		}
		String username = "PP";
		String password = "SS";
		URL url;
		try {
//			url = new URL("location address");
//			URLConnection uc = url.openConnection();

			String userpass = username + ":" + password;
			String basicAuth1 = "Basic " + new String(new Base64().encode(userpass.getBytes()));
//			uc.setRequestProperty ("Authorization", basicAuth);
//			InputStream in = uc.getInputStream();
			System.out.println("basicAuth1 is :"+basicAuth1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));
//		String basicAuth2 = "Basic "+basicAuth;
		
		byte[] message = (username+":"+password).getBytes("UTF-8");
		String encod = javax.xml.bind.DatatypeConverter.printBase64Binary(message);		
		System.out.println("basicAuth2 is :"+encod);
				
	}

}
