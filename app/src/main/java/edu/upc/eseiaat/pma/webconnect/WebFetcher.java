package edu.upc.eseiaat.pma.webconnect;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pauek on 9/10/17.
 */

class WebFetcher {

    static String getUrl(String s_url) {
        try {
            URL url = new URL(s_url);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return "<error: no HTTP_OK>";
            }
            InputStream in = conn.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            copyStream(in, out);
            return out.toString();
        }
        catch (IOException e) {
            return "<error: IOException>";
        }
    }

    private static void copyStream(InputStream in, ByteArrayOutputStream out)
            throws IOException
    {
        byte[] bytes = new byte[1024];
        int nbytes = in.read(bytes);
        while (nbytes > 0) {
            out.write(bytes, 0, nbytes);
            nbytes = in.read(bytes);
        }
    }
}
