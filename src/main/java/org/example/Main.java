package org.example;

import org.example.utilities.ServiciosApi;
import java.io.IOException;
import java.net.URISyntaxException;


public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {

        ServiciosApi respuesta = new ServiciosApi();
        respuesta.invocar();
    }
}