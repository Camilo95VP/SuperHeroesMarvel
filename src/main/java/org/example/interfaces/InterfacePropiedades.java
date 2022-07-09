package org.example.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InterfacePropiedades {
    public String  ts() throws IOException;
    public String clavePrivada();
    public String clavePublica() throws FileNotFoundException;
    public String hash() throws IOException;
    public String baseUrl() throws IOException;
}
