import java.net.URISyntaxException;

/** 
 * 
 * Runner file for:
 * - GUI.java
 * - NewsSources.java
 * - NewsPage.java (extended by:
 * 		- NPRNewsPage.java
 *  	- TelegraphNewsPage.java
 *  	- TSNewsPage.java
 *  	- VergeNewsPage.java
 *  	- ESPNNewsPage.java)
 * - SwingLink.java [External Class to help with Hyperlinks]
 *  
 * 
 * Precondition/s: - DataSource objects in "NewsSources.java" have 
 * 				  gathered all website-based news articles properly.
 *                 - GUI is running properly
 * 
 * @author Abhi Arya
 */

public class NewsFlashRunner {

	/**
	 * Main Method
	 * 
	 * @param args [unused in this use-case]
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException 
	{
		// Simply creating a new instance of the GUI runs the application. 
		GUI g = new GUI();
	}
}
