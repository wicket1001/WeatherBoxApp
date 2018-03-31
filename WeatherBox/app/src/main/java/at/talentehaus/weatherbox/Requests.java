package at.talentehaus.weatherbox;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Requests {
    public enum Method {
        GET, POST, PUT;
    }

    public String get(String suffix, String json) {
        return request(Method.GET, Credentials.url + suffix, json);
    }

    public String put(String suffix, String json) {
        // return request(Method.PUT, Credentials.url + suffix + "?json=" + json, json);
        return request(Method.PUT, Credentials.url + suffix, json);
    }

    public String post(String suffix, String json) {
        return request(Method.POST, Credentials.url + suffix, json);
    }

    private String request(Method method, String targetURL, String json) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            if (json != null) {
                targetURL += "?json=" + json;
            }

            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();

            String key = getKey();
            if (key != null) {
                connection.setRequestProperty("Authorization", "Basic " + getKey());
            }

            connection.setRequestMethod(method.toString().toUpperCase());
            /*
            connection.setRequestProperty("Content-Length",
                    Integer.toString(json.getBytes().length));

            connection.setDoOutput(true);

            connection.setRequestMethod("POST");
            */
            connection.setDoOutput(true);

            printConnection(connection);

            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            //wr.writeBytes(json);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append("\r\n");
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private void printConnection(HttpURLConnection connection) {
        System.out.println(connection.getRequestMethod());
        //System.out.println(connection.getHeaderFields());
        //System.out.println(connection.);
    }

    private String getKey() {
        if (Credentials.cid != null && Credentials.passwd != null) {
            return Converter.encodeBase64(Credentials.cid + ":" + Credentials.passwd);
        } else {
            return null;
        }
    }
}
