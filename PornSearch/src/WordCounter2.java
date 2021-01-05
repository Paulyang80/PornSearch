import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

public class WordCounter2 {
 private String title;
 private String url;
    private String content;
    
    public WordCounter2(String title, String url){
     this.title = title;
     this.url = "http://www.google.com/search?q="+url+"&oe=utf8&num=10";
    }
    
    public String getTitle() {
     return title;
    }
    
    public String getUrl() {
     return url;
    }
    
    private String fetchContent() throws IOException{
  
     String retVal = "";

  URL u = new URL(url);

  URLConnection conn = u.openConnection();

  conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

  InputStream in = conn.getInputStream();

  InputStreamReader inReader = new InputStreamReader(in,"utf-8");

  BufferedReader bufReader = new BufferedReader(inReader);
  
  String line = null;

  while((line=bufReader.readLine())!=null){
   
   retVal = retVal + line + "\n";

  }
  
  return retVal;
  
 }
    
    public int countKeyword(String keyword) throws IOException{
  if (content == null){
      content = fetchContent();
  }
  
  //To do a case-insensitive search, we turn the whole content and keyword into upper-case:
  content = content.toUpperCase();
  keyword = keyword.toUpperCase();
 
  int retVal = 0; 
  //Calculates appearances of keyword
  int position=content.indexOf(keyword);
  
  while(position!=-1) {
   retVal++;
   position=content.indexOf(keyword,position+1);
  }
  
  return retVal;
    }
    
    public float sum() throws IOException {
     LinkedList<Keyword> list = new LinkedList<Keyword>();
     list.add(new Keyword("性暴力", countKeyword("性暴力"), 5));
     list.add(new Keyword("Sexual violence", countKeyword("Sexual violence"), 5));
     list.add(new Keyword("性虐待", countKeyword("性虐待"), 3));
     list.add(new Keyword("Sexual abuse", countKeyword("Sexual abuse"), 3));
     list.add(new Keyword("未成年", countKeyword("未成年"), 1));
     list.add(new Keyword("Teenager", countKeyword("Teenager"), 1));
     list.add(new Keyword("Pornhub", countKeyword("Pornhub"), 5));
     
   //所有權重算出來的總合
     float total = 0;
     for(int i=0;i<list.size();i++) {
      total += list.get(i).score();
     }
     
     return total;
    }
}