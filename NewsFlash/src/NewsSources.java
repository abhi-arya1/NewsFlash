import java.util.*;
import core.data.DataSource;

/**
 * 
 * Class that gets News from different sites.
 * [using DataSource objects from <code>sinbad.jar</code>]
 * Those articles are then processed into NewsPage objects [based on their specific News Site] 
 * using Inheritance.
 * --> VergeNewsPage, NPRNewsPage, TelegraphNewsPage "are-all-a" NewsPage <--
 * 
 * After that, all articles are put into an ArrayList, which is organized into
 * seperate genres and sent in list form to "GUI.java", to run the Swing Application. 
 * 
 * @author Abhi Arya
 * 
 */

public class NewsSources {
	
	// All NewsPages
	private ArrayList<NewsPage> arrList = new ArrayList<NewsPage>();
	
	// All NewsPages sent to GUI
	private ArrayList<NewsPage> arr2 = new ArrayList<NewsPage>();
	
	// Links to Sources
	public String[] srcs = {"http://www.telegraph.co.uk/", "https://npr.org/"
							,"https://www.theverge.com/", "https://www.espn.com/",
			 				"https://www.techspot.com/"};
	
	// Source Names
	public String[] srcNames = {"Telegraph", "NPR", "theVerge", "ESPN", "TechSpot"};
	
	
	// Constructor that gets News Sources from 
	// http://www.telegraph.co.uk
	// https://npr.org
	public NewsSources()
	{
		// News Site RSS Feeds:
		// https://gist.github.com/stungeye/fe88fc810651174d0d180a95d79a8d97 
		DataSource dsTele = DataSource.connect(
			     "http://www.telegraph.co.uk/rss.xml").load(); 
				
		DataSource dsNPR = DataSource.connect(
				"https://feeds.npr.org/1004/rss.xml").load(); 
		
		DataSource dsVerge = DataSource.connect(
				"https://www.theverge.com/rss/index.xml").load();
		
		DataSource dsESPN = DataSource.connect(
				"https://www.espn.com/espn/rss/news.xml").load();
		
		DataSource dsTS = DataSource.connect(
				"https://www.techspot.com/backend.xml").load();
		

		// For Testing: 
		// ds.printUsageString(); ds2.printUsageString(); 
		// ds3.printUsageString(); dsESPN.printUsageString();
		// dsTS.printUsageString();

		// List Formal Var. Order -> Link, Title, Date, Author
		ArrayList<TelegraphNewsPage> TeleArr = dsTele.fetchList("TelegraphNewsPage", 
				"channel/item/link", 
				"channel/item/pubDate", "channel/item/title", 
				"channel/item/dc:creator");

		ArrayList<NPRNewsPage> NPRArr = dsNPR.fetchList("NPRNewsPage", 
				"channel/item/link", 
				"channel/item/pubDate", "channel/item/title", 
				"channel/item/dc:creator");
		
		ArrayList<VergeNewsPage> VergeArr = dsVerge.fetchList("VergeNewsPage", 
				"entry/link/href", 
				"entry/published", "entry/title", 
				"entry/author/name");
		
		ArrayList<ESPNNewsPage> ESPNArr = dsESPN.fetchList("ESPNNewsPage",
				"channel/item/link", "channel/item/pubDate",
				"channel/item/title", "channel/item/description");
		
		ArrayList<TSNewsPage> TSArr = dsTS.fetchList("TSNewsPage",
				"channel/item/link", "channel/item/pubDate",
				"channel/item/title");
				
		// Due to Inheritance, all different News Pages can be added to the 
		// main "NewsPage" array list. 
		for(TelegraphNewsPage t : TeleArr)
			arrList.add(t);
		
		for(NPRNewsPage n : NPRArr)
			arrList.add(n);
		
		for(VergeNewsPage v : VergeArr)
			arrList.add(v);
		
		for(ESPNNewsPage e : ESPNArr)
			arrList.add(e);
		
		for(TSNewsPage t : TSArr)
			arrList.add(t);
	}
	
	// @return -- ArrayList of ALL recent News Pages. 
	public ArrayList<NewsPage> getFullArrayList()
	{
		return arrList;
	}
	
	public ArrayList<NewsPage> getWorldNewsList()
	{
		ArrayList<NewsPage> ret = new ArrayList<NewsPage>();
		
		for(NewsPage np : arrList)
		{
			ArrayList<String> a = np.getTitleWords();
			
			if(a.contains("Biden") || a.contains("Ukraine") ||
			   a.contains("Biden's") || a.contains("Ukrainian") ||
			   a.contains("Putin") || a.contains("Biden") || a.contains("Russia") || 
			   a.contains("Russian") || a.contains("EU.") || a.contains("EU"))
				{
					ret.add(np);
					arr2.add(np);
				}
		}
		
		return ret;
	}
	
	public ArrayList<NewsPage> getSportsNewsList()
	{
		ArrayList<NewsPage> ret = new ArrayList<NewsPage>();
		
		for(NewsPage np : arrList)
		{
			ArrayList<String> a = np.getTitleWords();
			
			if(a.contains("Olympics") || a.contains("Paralympics") ||
			   a.contains("Tennis") || a.contains("US Open") || a.contains("Soccer")
			   || a.contains("Cup") || a.contains("F1") || a.contains("season") || 
			   a.contains("Novak Djokovic's") || a.contains("Roger Federer") || 
			   a.contains("Champions") || a.contains("Champion") || a.contains("League"))
				{
					ret.add(np);
					arr2.add(np);
				}
			
			if(np.getCreator().equals("ESPN"))
			{
				ret.add(np);
				arr2.add(np);
			}
		}
		
		return ret;
	}
	
	public ArrayList<NewsPage> getTechNewsList()
	{
		ArrayList<NewsPage> ret = new ArrayList<NewsPage>();
		
		for(NewsPage np : arrList)
		{
			ArrayList<String> a = np.getTitleWords();
			
			if(a.contains("startup") || a.contains("electric") ||
			   a.contains("drone") || a.contains("Apple") || a.contains("Facebook")
			   || a.contains("updates") || a.contains("cars") || a.contains("Google")
				|| a.contains("next-gen") || a.contains("tech"))
				{
					ret.add(np);
					arr2.add(np);
				}
			else if(np.getCreator().equals("TechSpot Media"))
			{
				ret.add(np);
				arr2.add(np);
			}
		}
		
		return ret;
	}
	
	public ArrayList<NewsPage> getHealthNewsList()
	{
		ArrayList<NewsPage> ret = new ArrayList<NewsPage>();
		
		for(NewsPage np : arrList)
		{
			ArrayList<String> a = np.getTitleWords();
			
			if(a.contains("Covid") || a.contains("COVID-19") || a.contains("Covid-19") || 
			   a.contains("Health") || a.contains("Doctors") || a.contains("Medical") ||
			   a.contains("disease") || a.contains("healthcare") || a.contains("pandemic"))
				{
					ret.add(np);
					arr2.add(np);
				}
		}
		
		return ret;
	}
	
	public ArrayList<NewsPage> returnRandoms()
	{
		ArrayList<NewsPage> ret = new ArrayList<NewsPage>();
		
		for(NewsPage np : arrList)
		{
			if(!arr2.contains(np))
				{
					ret.add(np);
				}
		}
		
		return ret;
	}
	
	// A few Accessors
	public ArrayList<NewsPage> getMainArrayList()
	{
		return arrList;
	}
	public String[] getSrcNames()
	{
		return srcNames;
	}
	public String[] getSrcLinks()
	{
		return srcs;
	}
	
	// For Testing:
	/* public static void main(String[] args)
	{
		NewsSources n = new NewsSources();
		for(int i = 0; i < n.getFullArrayList().size(); i++)
		{
			System.out.println(n.getFullArrayList().get(i) + "\n");
			
		}
	} */
}