import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Subclass for Verge News Pages to Process Info
 * 
 * @see NewsPage 
 * 
 */
public class VergeNewsPage extends NewsPage {
	 
	 // Constructor based on Superclass/NewsPage methods.
	 // @param pubDate = Throwaway for VergeList
	 VergeNewsPage(String link, String pubDate, String title, String creator) 
	 {
	      setTitle(title);
	      setPub(setDate());
	      setLink(link);
	      setAuth(creator);
	 }
	
	 
	// Fixes the date, since Verge articles are not typically formatted.
	// --> Takes current date, since Verge XML feed only contains articles 
	//	   from the day that the XML feed is accessed. 
	// Old Date Format: 2022-03-02T09:00
	// New Date Format: 02 March, 2022
	private String setDate()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 LocalDateTime now = LocalDateTime.now();  
		 return dtf.format(now);
	}
}
