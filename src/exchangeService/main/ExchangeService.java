package exchangeService.main;


import exchangeService.services.FileUtil;
import exchangeService.services.JsonService;
import exchangeService.services.StringConverter;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.X509Certificate;

public class ExchangeService {
    private final static String URL = "https://exchangeratesapi.io/api/latest";

    public static void main(String[] args) throws IOException {
        disableSSL();
        JsonService service = new JsonService();
        new FileUtil().write(new StringConverter().convert(service.readJson(URL)));
    }

    private static void disableSSL() {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {}

            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
        }};
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
