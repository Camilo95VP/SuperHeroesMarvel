package org.example.utilities;

import org.jboss.logging.Logger;

public class MensajesLogger {
    private static final Logger logger = Logger.getLogger(MensajesLogger.class);
    private static MensajesLogger instance = null;

    public static MensajesLogger getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new MensajesLogger();
        }
        return instance;
    }

    public void estadoConexion(){
        logger.info("CONEXION EXITOSA 200 ok");
    }
    public void respuestaApi(StringBuilder resultado){
        logger.info(resultado);
    }
    public void error(String q){
        logger.info("Ha ocurrido un error: " + q);
    }


}
