package org.example.utilities;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class MenuNavegacion {

    public void correr() throws IOException {

        MensajesLogger mensaje = MensajesLogger.getInstance();
        ServiciosApi respuesta = new ServiciosApi();
        boolean estado = true;
        Scanner leerSuperHeroe = new Scanner(System.in);
        /*
        (1011054)Spiderman
        (1009368)IronMan
        (1009351)Hulk
        (1009220)Capitan America
        (1009664)Thor*/

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SuperHeroe.class, new Deserializacion());


        do {
            System.out.println("SUPERHEROES: \n 1.Spiderman\n 2.Iron Man\n 3.Hulk\n 4.Capitan America\n 5.Thor\n 6.Salir\n");
            System.out.println("SELECCIONE EL SUPERHEROE FAVORITO: ");
            int opcion = leerSuperHeroe.nextInt();
            switch (opcion) {

                case 1:
                    String superman = respuesta.invocar(1011054);
                    SuperHeroe objetoSuperMan = gsonBuilder.create().fromJson(superman, SuperHeroe.class);
                    mensaje.informacion(objetoSuperMan.toString());
                    break;

                case 2:
                    String ironMan = respuesta.invocar(1009368);
                    SuperHeroe objetoIronMan = gsonBuilder.create().fromJson(ironMan, SuperHeroe.class);
                    mensaje.informacion(objetoIronMan.toString());
                    break;

                case 3:
                    String hulk = respuesta.invocar(1009351);
                    SuperHeroe objetoHulk = gsonBuilder.create().fromJson(hulk, SuperHeroe.class);
                    mensaje.informacion(objetoHulk.toString());
                    break;

                case 4:
                    String capitanAmerica = respuesta.invocar(1009220);
                    SuperHeroe objetoCapitanAmerica = gsonBuilder.create().fromJson(capitanAmerica, SuperHeroe.class);
                    mensaje.informacion(objetoCapitanAmerica.toString());
                    break;

                case 5:
                    String thor = respuesta.invocar(1009664);
                    SuperHeroe objetoThor = gsonBuilder.create().fromJson(thor, SuperHeroe.class);
                    mensaje.informacion(objetoThor.toString());
                    break;

                case 6:
                    mensaje.informacion("Hasta Pronto!");
                    estado = false;
                    break;
            }

        } while (estado);


        /*System.out.println(objetoSuperHeroe.getName());
        objetoSuperHeroe.setName("CAPITAN");
        System.out.println(objetoSuperHeroe.getName());
        ArrayList<SuperHeroe> superheroes = new ArrayList<>();
        superheroes.add(objetoSuperHeroe);
        System.out.println(superheroes);
        System.out.println(superheroes.get(0).getName());*/
    }

}
