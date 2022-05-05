package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Vuelo;

import java.util.List;

public interface AdministradorServicio {

    Administrador registrarAdministrador(Administrador a) throws Exception;

    Administrador actualizarAdministrador(Administrador a) throws Exception;

    Administrador obtenerAdministrador(String cedula);

    void eliminarAdministrador(String cedula) throws Exception;

    List<Administrador> listarAdministradores();

    Administrador validarLogin(String email, String contraseña) throws Exception;

    //Gestionar Destinos

    Ciudad registrarCiudad(Ciudad c) throws Exception;

    Ciudad actualizarCiudad(Ciudad c) throws Exception;

    Ciudad obtenerCiudad(int codigo);

    void eliminarCiudad(int codigo) throws Exception;

    List<Ciudad> listarCiudades();

    //Gestionar Vuelos

    Vuelo registrarVuelo(Vuelo v) throws Exception;

    Vuelo actualizarVuelo(Vuelo v) throws Exception;

    Vuelo obtenerVuelo(int codigo);

    void eliminarVuelo(int codigo) throws Exception;

    List<Vuelo> listarVuelos();

    //Gestionar administradores de hotel

    AdminHotel registrarAdminHotel(AdminHotel a) throws Exception;

    AdminHotel actualizarAdminHotel(AdminHotel a) throws Exception;

    AdminHotel obtenerAdminHotel(String cedula);

    void eliminarAdminHotel(String cedula) throws Exception;

    List<AdminHotel> listarAdminsHotel();

}
