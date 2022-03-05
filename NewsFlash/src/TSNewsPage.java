/**
 * Subclass for TechSpot News Pages to Process Info
 * 
 * @see NewsPage 
 */
public class TSNewsPage extends NewsPage 
{
	// Constructor using Superclass/NewsPage methods.
	TSNewsPage(String link, String pubDate, String title) 
	{
		setTitle(title);
		setPub(pubDate.substring(0, 15));
		setLink(link);
		setAuth("TechSpot Media");
	}
}
