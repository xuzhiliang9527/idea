package Main;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
public class Reptile {
    public static void main(String[] args) throws IOException {
        javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView(); 
        File home=fsv.getHomeDirectory();
        File photos=new File(home+"/photos");
        if(!photos.exists())
        	photos.mkdir();//�����ļ���
        URL url=new URL("https://bing.ioliu.cn/ranking?p=1");
        Document document = Jsoup.parse(url, Integer.MAX_VALUE);
        Elements span = document.getElementsByTag("span");
        String p=span.get(span.size()-1).text();
        int intp=Integer.parseInt(p.substring(p.lastIndexOf("/")+2));//��ҳ��
        System.out.println("ͼƬ��ҳ��Ϊ��"+intp);
        for(int i=1;i<=intp;i++){
            URL tempurl=new URL("https://bing.ioliu.cn/ranking?p="+i);
            Document tempdocument=Jsoup.parse(tempurl,Integer.MAX_VALUE);//��ȡhtml
            Elements img = tempdocument.getElementsByTag("img");//��ȡ��ǰҳ���img��ǩ
            System.out.println("---------------��"+i+"ҳ��ʼ����---------------");
            System.out.println("------------��ǰҳ���У�"+img.size()+"��ͼƬ------------");
            for(Element e:img){
                String imgsrc=e.attr("src");
                String imgname=imgsrc.substring(imgsrc.lastIndexOf("/")+1);
                URL imgurl=new URL(imgsrc);
                URLConnection imgconnect=imgurl.openConnection();
                //��վ�����������˰�ȫ���ʣ�������java������Ϊ�ͻ��˷��ʡ�Ҫ��������⣬��Ҫ�ڳ��������ÿͻ��˵�User Agent
                imgconnect.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                InputStream is=imgconnect.getInputStream();
                OutputStream os=new FileOutputStream(new File(photos,imgname));//PATHΪ�洢·��
                byte[] b=new byte[1024];
                int len=0;
                while ((len=is.read(b))!=-1){
                    os.write(b,0,len);
                }
                System.out.println(imgname+"��������ɣ�");
                os.close();//�ر�������
                is.close();//�ر������
            }
            System.out.println("--------------��"+i+"ҳ���������--------------");
        }
    }
}
