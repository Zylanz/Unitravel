package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.Administrador;

import java.util.List;

public interface AdministradorServicio {

    Administrador registrarAdministrador(Administrador a) throws Exception;

    Administrador actualizarAdministrador(Administrador a) throws Exception;

    void eliminarAdministrador(String cedula) throws Exception;

    List<Administrador> listarAdministradores();

}
