package org.example;

import com.google.gson.GsonBuilder;
import org.example.utilities.*;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        MenuNavegacion app = new MenuNavegacion();
        app.correr();
        SuperHeroeDAO superH = new SuperHeroeDAO();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SuperHeroe.class, new Deserializacion());

        //Insertando un nuevo objeto de superheroe
        SuperHeroe SuperHeroeNuevo = new SuperHeroe(1, "Hulk", "aksdjhfkasdfhsd");
        SuperHeroeDAO.insertar(SuperHeroeNuevo);

        //Modificar un objeto de persona existente
        //SuperHeroe heroeModificar = new SuperHeroe(3, "Thor", "Superheroe thor");
        //SuperHeroeDAO.actualizar(heroeModificar);

        //SuperHeroe heroeEliminar = new SuperHeroe(2);
        //SuperHeroeDAO.eliminar(heroeEliminar);

        List<SuperHeroe> superheroes = superH.seleccionar();

        superheroes.forEach(heroe -> {
            System.out.println("superheroe = " + heroe);
        });
    }
}


