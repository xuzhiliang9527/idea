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
        	photos.mkdir();//创建文件夹
        URL url=new URL("https://bing.ioliu.cn/ranking?p=1");
        Document document = Jsoup.parse(url, Integer.MAX_VALUE);
        Elements span = document.getElementsByTag("span");
        String p=span.get(span.size()-1).text();
        int intp=Integer.parseInt(p.substring(p.lastIndexOf("/")+2));//总页数
        System.out.println("图片总页数为："+intp);
        for(int i=1;i<=intp;i++){
            URL tempurl=new URL("https://bing.ioliu.cn/ranking?p="+i);
            Document tempdocument=Jsoup.parse(tempurl,Integer.MAX_VALUE);//获取html
            Elements img = tempdocument.getElementsByTag("img");//获取当前页面的img标签
            System.out.println("---------------第"+i+"页开始下载---------------");
            System.out.println("------------当前页共有："+img.size()+"张图片------------");
            for(Element e:img){
                String imgsrc=e.attr("src");
                String imgname=imgsrc.substring(imgsrc.lastIndexOf("/")+1);
                URL imgurl=new URL(imgsrc);
                URLConnection imgconnect=imgurl.openConnection();
                //网站服务器设置了安全访问，不接受java程序作为客户端访问。要解决此问题，需要在程序中设置客户端的User Agent
                imgconnect.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                InputStream is=imgconnect.getInputStream();
                OutputStream os=new FileOutputStream(new File(photos,imgname));//PATH为存储路径
                byte[] b=new byte[1024];
                int len=0;
                while ((len=is.read(b))!=-1){
                    os.write(b,0,len);
                }
                System.out.println(imgname+"已下载完成！");
                os.close();//关闭输入流
                is.close();//关闭输出流
            }
            System.out.println("--------------第"+i+"页已下载完成--------------");
        }
    }
}
