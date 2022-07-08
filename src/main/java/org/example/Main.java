package org.example;

import org.example.utilities.MensajesLogger;

public class Main {

    static MensajesLogger mensaje = MensajesLogger.getInstance();

    public static void main(String[] args) {
        mensaje.saludar();
    }
}