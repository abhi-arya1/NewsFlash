import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
/**
 * 
 * Object Class for Individual News Pages
 * -> Contains elements of News Pages necessary to information.
 * -> Contains toString and toArray methods for the Article. 
 * 
 *  @author Abhi Arya
 *
 */
public class NewsPage {
	 
	 private String title;
	 private String link;
	 private String creator;
	 private String pubDate;
	 
	 // Accessors:
	 
	 public String getTitle() 
	 { 
	      return title;
	 }
	 public String getLink()
	 {
		 return link;
	 }
	 public String getCreator()
	 {
		 return creator;
	 }
	 public String getDate()
	 {
		 return pubDate;
	 }
	
	 // Mutators:
	 
	 // @param title -- title of the article
	 public void setTitle(String title) 
	 {
		 this.title = title;
	 }
	 // @param link -- link of the article
	 public void setLink(String link)
	 {
		 this.link = link;
	 }
	 // @param creator -- author of the article
	 public void setAuth(String creator)
	 {
		 this.creator = creator;
	 }
	 // Gets the date and cuts off the exact time published
	 //	ex: Sun, 27 Feb 2022 23:03:57 -0500 --> Sun, 27 Feb 2022
	 // @param pubDate -- date published
	 public void setPub(String pubDate)
	 {
		 this.pubDate = pubDate;
	 }

	 // Other methods:
	 
	 // Gets the link of the article in URL format
	 // @returns -- link converted into a URL that can be browsed. 
	 public URI getURI() throws URISyntaxException
	 {
		 return new URI(link);
	 }
	 
	 // Gets the Exact Words of the NewsPage Title to Organize Based on Genre.
	 // @param s -- the title to split into an ArrayList
	 // @returns -- an ArrayList of the Split title. 
	 public ArrayList<String> getTitleWords() 
	 {
	    String[] s2 = title.split(" ");
	    ArrayList<String> words = new ArrayList<String>();

	    for(int x = 0; x < s2.length - 1; x++)
	    {
	         words.add(s2[x]);
	    }
	    
	    return words;
	 }
	 
	 // @returns -- formatted news page.
	 public String toString()
	 {
		return "Title: " + getTitle() + 
				"\nAuthor: " + getCreator()
				+ "\nPublished: " + getDate() + 
				"\nLink: " + getLink(); 
	 }
}
