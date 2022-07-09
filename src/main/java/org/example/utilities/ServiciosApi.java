package org.example.utilities;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ServiciosApi {

    static MensajesLogger mensaje = MensajesLogger.getInstance();
    public void invocar() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(1000, TimeUnit.MILLISECONDS)
                .writeTimeout(1000, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url("https://gateway.marvel.com/v1/public/characters/1009351?nameStartsWith=sp&ts=1&apikey=9573d939ccaabc4773ecd00010c4b6d8&hash=e816be62b5be403d1800105aa80ab80b")
                .get()
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                mensaje.error(String.valueOf(call));
            }

            public void onResponse(Call call, Response response)
                    throws IOException {
                mensaje.respuestaApi(new StringBuilder(response.body().string()));
                mensaje.estadoConexion();
            }
        });
    }
}
