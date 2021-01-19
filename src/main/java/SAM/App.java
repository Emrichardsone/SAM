package SAM;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class App {

    public static void main(String[] args) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet getRequest = new HttpGet("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=%2B61293744000&inputtype=phonenumber&fields=place_id&key=AIzaSyAzf4YH2HBMV1oFIJUIwq4-LnnKuu9xWTM");

            System.out.println("executing request to " );


            String apiKey = "AIzaSyAzf4YH2HBMV1oFIJUIwq4-LnnKuu9xWTM";
           // getRequest.addHeader("x-api-key", apiKey);
            HttpResponse httpResponse = httpclient.execute(getRequest);
            HttpEntity entity = httpResponse.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(httpResponse.getStatusLine());
            Header[] headers = getRequest.getAllHeaders();
            for (int i = 0; i < headers.length; i++) {
                System.out.println(headers[i]);
            }
            System.out.println("----------------------------------------");

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }
}