import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/**
 *
 * @author Jan Becker
 */
public class Updater {
    private final static String versionURL = "http://theclashingtribes.weebly.com/version.html";
    private final static String downloadURL = "http://theclashingtribes.weebly.com/latest.html";
    private final static String historyURL = "http://theclashingtribes.weebly.com/version.html";
    public static String getLatestVersion() throws Exception
    {
        String data = getData(versionURL);
        return data.substring(data.indexOf("[version]")+9,data.indexOf("[/version]"));
    }
    public static String getLatestLink() throws Exception
    {
        String data = getData(downloadURL);
        return data.substring(data.indexOf("[link]")+6,data.indexOf("[/link]"));
    }
    public static String getWhatsNew() throws Exception
    {
        String data = getData(historyURL);
        return data.substring(data.indexOf("[history]")+9,data.indexOf("[/history]"));
    }
    private static String getData(String address)throws Exception
    {
        URL url = new URL(address);
        
        InputStream html = null;

        html = url.openStream();
        
        int c = 0;
        StringBuffer buffer = new StringBuffer("");

        while(c != -1) {
            c = html.read();
            
        buffer.append((char)c);
        }
        return buffer.toString();
    }
}
