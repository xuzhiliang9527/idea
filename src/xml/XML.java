package xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XML {
	public static void main(String[] args) {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("school");
		root.addAttribute("name", "woniuxy");
		Element className = root.addElement("class");
		className.addAttribute("id", "52");
		Element stu = className.addElement("students");
		Element name = stu.addElement("name1");
		name.setText("张三");
		Element age = stu.addElement("name1");
		age.setText("18");
		Element stu1 = className.addElement("students");
		Element name1 = stu1.addElement("name1");
		name1.setText("李四");
		Element age1 = stu1.addElement("name1");
		age1.setText("19");
		File file = new File("stuInfo.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter write = null;
		try {
			write = new XMLWriter(new FileOutputStream(file), format);
			write.write(doc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				write.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
