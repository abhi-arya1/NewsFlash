/**
 * Subclass for Telegraph News Pages to Process Info
 * 
 * @see NewsPage 
 */
public class TelegraphNewsPage extends NewsPage
{
	// Constructor using Superclass/NewsPage methods.
	 TelegraphNewsPage(String link, String pubDate, String title, String creator) 
	 {
	      setTitle(title);
	      setPub(pubDate.substring(0, 16));
	      setLink(link);
	      setAuth(creator);
	 }
}
