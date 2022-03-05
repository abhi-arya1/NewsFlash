
/**
 * Subclass for ESPN News Pages to Process Info
 * 
 * @see NewsPage 
 */

public class ESPNNewsPage extends NewsPage
{
	// Constructor using Superclass/NewsPage methods.
		 ESPNNewsPage(String link, String pubDate, String title, String creator) 
		 {
		      setTitle(title);
		      setPub(pubDate.substring(0, 16));
		      setLink(link);
		      setAuth("ESPN");
		 }
}
