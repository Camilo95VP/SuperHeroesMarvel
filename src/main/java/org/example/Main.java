package org.example;

import org.example.utilities.MensajesLogger;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    static MensajesLogger mensaje = MensajesLogger.getInstance();

    public static void main(String[] args) {
        
            try {
                URL url = new URL("https://gateway.marvel.com/v1/public/characters/1009351?nameStartsWith=sp&ts=1&apikey=9573d939ccaabc4773ecd00010c4b6d8&hash=e816be62b5be403d1800105aa80ab80b");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                Integer resposeCode = conn.getResponseCode();
                if(resposeCode != 200){
                    throw new RuntimeException("Ocurrio un error");
                } else {
                    StringBuilder informationString = new StringBuilder();
                    Scanner sacanner = new Scanner(url.openStream());

                    while(sacanner.hasNext()) {
                        informationString.append(sacanner.nextLine());
                    }
                    sacanner.close();

                    mensaje.respuestaApi(informationString);
                    mensaje.estadoConexion();
                }

            } catch (Exception e) {
                mensaje.error(String.valueOf(e));
            }




    }
}