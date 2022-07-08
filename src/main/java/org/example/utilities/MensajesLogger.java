package org.example.utilities;

import org.jboss.logging.Logger;

public class MensajesLogger {
    private static final Logger logger = Logger.getLogger(MensajesLogger.class);
    private static MensajesLogger instance = null;

    public static MensajesLogger getInstance() {
        if (instance instanceof MensajesLogger) {
            return instance;
        } else {
            instance = new MensajesLogger();
        }
        return instance;
    }

    public void saludar(){
        logger.info("Hola desde logger");
    }
}
