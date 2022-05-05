package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.repositorios.VueloRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicioImpl implements AdministradorServicio{

    AdministradorRepo administradorRepo;
    CiudadRepo ciudadRepo;
    VueloRepo vueloRepo;
    AdminHotelRepo adminHotelRepo;

    public AdministradorServicioImpl(AdministradorRepo administradorRepo, CiudadRepo ciudadRepo,
                                     VueloRepo vueloRepo, AdminHotelRepo adminHotelRepo) {
        this.administradorRepo = administradorRepo;
        this.ciudadRepo = ciudadRepo;
        this.vueloRepo = vueloRepo;
        this.adminHotelRepo = adminHotelRepo;
    }

    @Override
    public Administrador registrarAdministrador(Administrador a) throws Exception {
        Optional<Administrador> buscado = administradorRepo.findById(a.getCedula());
        if(buscado.isPresent()){
            throw new Exception("La cédula ya se encuentra en uso");
        }
        buscado = administradorRepo.findByEmail(a.getEmail());
        if(buscado.isPresent()){
            throw new Exception("El correo ya se encuentra en uso");
        }
        return administradorRepo.save(a);
    }

    @Override
    public Administrador actualizarAdministrador(Administrador a) throws Exception {
        Optional<Administrador> buscado = administradorRepo.findById(a.getCedula());
        if(!buscado.isEmpty()){
            throw new Exception("El administrador no esta registrado");
        }

        return administradorRepo.save(a);
    }

    @Override
    public Administrador obtenerAdministrador(String cedula)  {
        return administradorRepo.findById(cedula).orElse(null);
    }

    @Override
    public void eliminarAdministrador(String cedula) throws Exception {

        Optional<Administrador> buscado = administradorRepo.findById(cedula);
        if(buscado.isEmpty()){
            throw new Exception("El administrador no se encuentra");
        }
        administradorRepo.delete(buscado.get());
    }

    @Override
    public List<Administrador> listarAdministradores() {
        List<Administrador> administradorList = administradorRepo.findAll();
        return administradorList;
    }

    @Override
    public Administrador validarLogin(String email, String contraseña) throws Exception {
        Optional<Administrador> administrador = administradorRepo.findByEmailAndPassword(email, contraseña);

        if (administrador.isEmpty()){
            throw new Exception("Los datos de autenticacion son incorrectos");
        }
        return administrador.get();
    }

    //Gestionar Destinos

    @Override
    public Ciudad registrarCiudad(Ciudad c) throws Exception {
        Optional<Ciudad> buscado= ciudadRepo.findById(c.getCodCiudad());
        if (buscado.isPresent()){
            throw new Exception("La ciudad ya esta registrada");
        }
        return ciudadRepo.save(c);
    }

    @Override
    public Ciudad actualizarCiudad(Ciudad c) throws Exception {
        Optional<Ciudad> buscado = ciudadRepo.findById(c.getCodCiudad());
        if (buscado.isEmpty()){
            throw new Exception("La ciudad no esta registrada");
        }
        return ciudadRepo.save(c);
    }

    @Override
    public Ciudad obtenerCiudad(int codigo){
        return ciudadRepo.findById(codigo).orElse(null);
    }

    @Override
    public void eliminarCiudad(int codigo) throws Exception {
        Optional<Ciudad> buscado= ciudadRepo.findById(codigo);
        if (buscado.isEmpty()){
            throw new Exception("La ciudad no esta registrada");
        }
        ciudadRepo.delete(buscado.get());
    }

    @Override
    public List<Ciudad> listarCiudades()  {
        List<Ciudad> ciudades = ciudadRepo.findAll();
        return ciudades;
    }

    //Gestionar Vuelos


    @Override
    public Vuelo registrarVuelo(Vuelo v) throws Exception {
        Optional<Vuelo> buscado = vueloRepo.findById(v.getCodigo());
        if (buscado.isPresent()){
            throw new Exception("El vuelo ya esta registrado");
        }

        return vueloRepo.save(v);
    }

    @Override
    public Vuelo actualizarVuelo(Vuelo v) throws Exception {
        Optional<Vuelo> buscado = vueloRepo.findById(v.getCodigo());
        if (buscado.isEmpty()){
            throw new Exception("El vuelo no esta registrado");
        }
        return vueloRepo.save(v);
    }

    @Override
    public Vuelo obtenerVuelo(int codigo)  {
        return vueloRepo.findById(codigo).orElse(null);
    }

    @Override
    public void eliminarVuelo(int codigo) throws Exception {
        Optional<Vuelo> buscado = vueloRepo.findById(codigo);
        if (buscado.isEmpty()){
            throw new Exception("El vuelo no esta registrado");
        }

        vueloRepo.delete(buscado.get());
    }

    @Override
    public List<Vuelo> listarVuelos() {
        List<Vuelo> vuelos = vueloRepo.findAll();
        return vuelos;
    }

    //Gestionar administradores de Hotel

    @Override
    public AdminHotel registrarAdminHotel(AdminHotel a) throws Exception {
        Optional<AdminHotel> buscado = adminHotelRepo.findById(a.getCedula());
        if (buscado.isPresent()){
            throw new Exception("El administrador de hotel ya se encuentra registrado");
        }
        buscado = adminHotelRepo.findByEmail(a.getEmail());
        if (buscado.isPresent()){
            throw new Exception("El correo ya esta en uso");
        }
        return adminHotelRepo.save(a);
    }

    @Override
    public AdminHotel actualizarAdminHotel(AdminHotel a) throws Exception {
        Optional<AdminHotel> buscado = adminHotelRepo.findById(a.getCedula());
        if (buscado.isEmpty()){
            throw new Exception("El administrador de hotel no se encuentra registrado");
        }
        return adminHotelRepo.save(a);
    }

    @Override
    public AdminHotel obtenerAdminHotel(String cedula) {
        return adminHotelRepo.findById(cedula).orElse(null);
    }

    @Override
    public void eliminarAdminHotel(String cedula) throws Exception {
        Optional<AdminHotel> buscado = adminHotelRepo.findById(cedula);
        if (buscado.isEmpty()){
            throw new Exception("El administrador de hotel no se encuentra registrado");
        }
        adminHotelRepo.delete(buscado.get());
    }

    @Override
    public List<AdminHotel> listarAdminsHotel() {
        List<AdminHotel> adminHotelList = adminHotelRepo.findAll();
        return adminHotelList;
    }


}
