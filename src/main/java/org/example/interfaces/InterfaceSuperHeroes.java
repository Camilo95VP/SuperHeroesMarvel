package org.example.interfaces;
import org.example.utilities.SuperHeroe;

public interface InterfaceSuperHeroes {
    public boolean  agregarSuperHeroe(SuperHeroe h);
    public String  eliminarSuperHeroe(String heroename);

    public boolean actualizarSuperHeroe(String heroename, SuperHeroe h);
    public SuperHeroe listarSuperHeroe(String heroename);


}
