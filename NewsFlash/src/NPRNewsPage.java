/**
 * Subclass for NPR News Pages to Process Info
 * 
 * @see NewsPage 
 */

public class NPRNewsPage extends NewsPage {
	
	// Constructor using Superclass/NewsPage methods.
	 NPRNewsPage(String link, String pubDate, String title, String creator) 
	 {
	      setTitle(title);
	      setPub(pubDate.substring(0, 16));
	      setLink(link);
	      setAuth(creator);
	 }
}
