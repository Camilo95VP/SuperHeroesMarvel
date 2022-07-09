package org.example.utilities;

import org.example.interfaces.InterfacePropiedades;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConstruccionURL implements InterfacePropiedades {
    static MensajesLogger mensaje = MensajesLogger.getInstance();
    public static final String PATH = "src/main/resources/configuracion.properties";
    Properties propiedades = new Properties();

    @Override
    public String ts() throws IOException {
        propiedades.load(new FileReader(PATH));
        return propiedades.getProperty("ts");
    }

    @Override
    public String clavePrivada() {

        try {
            propiedades.load(new FileReader(PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return propiedades.getProperty("clave_privada");
    }

    @Override
    public String clavePublica() throws FileNotFoundException {
        try {
            propiedades.load(new FileReader(PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
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
