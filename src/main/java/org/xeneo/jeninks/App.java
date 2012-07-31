package org.xeneo.jeninks;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndPerson;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            URL feed = new URL("http://www.wi.fh-kufstein.ac.at:23456/jenkins/rssAll");            
            
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed sf = input.build(new XmlReader(feed));
            List entries = sf.getEntries();
            Iterator it = entries.iterator();
            
            System.out.println(((SyndPerson) sf.getAuthors().get(0)).getName());            
            
            while (it.hasNext()) {
                SyndEntry entry = (SyndEntry) it.next();
                
                System.out.println(entry.getTitle());
                System.out.println(entry.getLink());
                
            }
        } catch (IllegalArgumentException ex) {
        } catch (FeedException ex) {
        } catch (IOException ex) {
        }
    }
}
