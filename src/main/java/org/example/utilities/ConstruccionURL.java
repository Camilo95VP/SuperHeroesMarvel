package org.example.utilities;

import org.example.interfaces.InterfacePropiedades;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConstruccionURL implements InterfacePropiedades {
    public static final String PATH = "src/main/resources/configuracion.properties";
    static MensajesLogger mensaje = MensajesLogger.getInstance();
    Properties propiedades = new Properties();

    @Override
    public String clavePublica() {
        try {
            propiedades.load(new FileReader(PATH));
        } catch (IOException e) {
            mensaje.error(String.valueOf(e));
        }
        return propiedades.getProperty("clave_publica");
    }

    @Override
    public String hash() throws IOException {
        propiedades.load(new FileReader(PATH));
        return propiedades.getProperty("hash");
    }

    @Override
    public String baseUrl() throws IOException {
        propiedades.load(new FileReader(PATH));
        return propiedades.getProperty("url_base");
    }
}
