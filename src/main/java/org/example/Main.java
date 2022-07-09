package org.example;

import org.example.utilities.ServiciosApi;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ServiciosApi respuesta = new ServiciosApi();
        respuesta.invocar(1011054);//Spiderman
        respuesta.invocar(1009368);//IronMan
        respuesta.invocar(1009351);//Hulk
        respuesta.invocar(1009220);//Capitan America
        respuesta.invocar(1009664);//Thor
    }
}