package org.example.utilities;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ServiciosApi extends ConstruccionURL {

    static MensajesLogger mensaje = MensajesLogger.getInstance();
    ConstruccionURL propiedad = new ConstruccionURL();

    public void invocar(Integer id) throws IOException {
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

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                mensaje.error(String.valueOf(call));
            }

            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                assert response.body() != null;
                mensaje.respuestaApi(new StringBuilder(response.body().string()));
                mensaje.estadoConexion();
            }

        });
    }
}
