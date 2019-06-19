package xml;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
/*
 * 读取xml内容
 */
public class XML2 {
	public static void main(String[] args) {
		SAXReader read = new SAXReader();
		Document doc = null;
		try {
			doc = read.read(new File("stuInfo.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		//获取根标签
		String xpath="/school[@name='woniuxy']/class[@id='52']/students[@name='vip']/name1";
		Node node = doc.getRootElement().selectSingleNode(xpath);
		if(node!=null)
			System.out.println(node.getText());
		else
			System.out.println("error!");
	}
}
