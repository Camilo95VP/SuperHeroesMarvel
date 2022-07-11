package org.example.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InterfacePropiedades {
     String clavePublica() throws FileNotFoundException;
     String hash() throws IOException;
     String baseUrl() throws IOException;
}
