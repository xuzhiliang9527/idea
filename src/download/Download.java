package download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Download {
	public static void main(String[] args) {
		String address="175.6.244.211";
		int port =88;
		Socket soc = null;
		try {
			soc = new Socket(address,port);
			OutputStream os = soc.getOutputStream();
			os.write(("GET /code/201812web/zrlog_a5.zip HTTP/1.1\r\n" + 
					"Connection: keep-alive\r\n" + 
					"Pragma: no-cache\r\n" + 
					"Cache-Control: no-cache\r\n" + 
					"Upgrade-Insecure-Requests: 1\r\n" + 
					"User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36\r\n" + 
					"DNT: 1\r\n" + 
					"Accept-Language: zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7\r\n"+"\r\n").getBytes());
			os.flush();
			InputStream is = soc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String tmp = br.readLine();
			while(tmp!=null) {
				System.out.println(tmp);
				tmp = br.readLine();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
