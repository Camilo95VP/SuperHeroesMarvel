package org.example.utilities;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ServiciosApi extends ConstruccionURL {

    static MensajesLogger mensaje = MensajesLogger.getInstance();
    ConstruccionURL propiedad = new ConstruccionURL();

    public String invocar(Integer id) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(1000, TimeUnit.MILLISECONDS)
                .writeTimeout(1000, TimeUnit.MILLISECONDS)
                .build();

        String base = propiedad.baseUrl();
        String publica = propiedad.clavePublica();
        String hash = propiedad.hash();

        Request request = new Request.Builder()

                .url(base + id + "?nameStartsWith=sp&ts=1&apikey=" + publica + "&hash=" + hash)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
