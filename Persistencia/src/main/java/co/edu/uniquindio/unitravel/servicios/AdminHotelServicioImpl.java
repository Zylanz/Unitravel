package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminHotelServicioImpl implements AdminHotelServicio{

    @Autowired
    private AdminHotelRepo adminHotelRepo;

    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private HabitacionRepo habRepo;

    @Autowired
    private CaracteristicasRepo caracteristicasRepo;

    public AdminHotelServicioImpl(AdminHotelRepo adminHotelRepo,
                                  HotelRepo hotelRepo){
        this.adminHotelRepo = adminHotelRepo;
        this.hotelRepo = hotelRepo;
    }


    @Override
    public AdminHotel registrarAdminHotel(AdminHotel a) throws Exception {
        Optional<AdminHotel> buscado = adminHotelRepo.findById(a.getCedula());
        if (buscado.isPresent()){
            throw new Exception("La cedula ya se encuentra en uso");
        }
        buscado = adminHotelRepo.findByEmail(a.getEmail());
        if (buscado.isPresent()){
            throw new Exception("El correo ya se encuentra en uso");
        }

        return adminHotelRepo.save(a);
    }

    @Override
    public AdminHotel actualizarAdminHotel(AdminHotel a) throws Exception {
        Optional<AdminHotel> buscado = adminHotelRepo.findById(a.getCedula());
        if (buscado.isEmpty()){
            throw new Exception("El administrador no esta registrado");
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
            throw new Exception("El administrador no esta registrado");
        }
        adminHotelRepo.delete(buscado.get());
    }

    @Override
    public List<AdminHotel> listarAdminsHotel() {
        return adminHotelRepo.findAll();
    }

    @Override
    public AdminHotel validarLoginAdminHotel(String email, String contraseña) throws Exception {
        Optional<AdminHotel> adminHotel = adminHotelRepo.findByEmailAndPassword(email, contraseña);
        if (adminHotel.isEmpty()){
            throw new Exception("Los datos de autenticacion son incorrectos");
        }

        return adminHotel.get();
    }

    //Gestionar Hoteles

    @Override
    public Hotel registrarHotel(Hotel h) throws Exception {
        Optional<Hotel> buscado = hotelRepo.findById(h.getCodHotel());
        if(buscado.isPresent()){
            throw new Exception("El hotel ya se encuentra registrado");
        }
        return hotelRepo.save(h);
    }

    @Override
    public Hotel actualizarHotel(Hotel h) throws Exception {
        Optional<Hotel> buscado = hotelRepo.findById(h.getCodHotel());
        if(buscado.isEmpty()){
            throw new Exception("El hotel no se encuentra registrado");
        }
        return hotelRepo.save(h);
    }

    @Override
    public Hotel obtenerHotel(int codigo) {
        return hotelRepo.findById(codigo).orElse(null);
    }

    @Override
    public void eliminarHotel(int codigo) throws Exception {
        Optional<Hotel> buscado = hotelRepo.findById(codigo);
        if(buscado.isEmpty()){
            throw new Exception("El hotel no se encuentra registrado");
        }
        hotelRepo.delete(buscado.get());
    }

    @Override
    public List<Hotel> listarHoteles() {
        return hotelRepo.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        return ciudadRepo.findById(codigo).orElse(null);
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHotel() {
        return caracteristicasRepo.findAllByTipo(1);
    }
    @Override
    public List<Caracteristica> listarCaracteristicasHabitacion() {
       return caracteristicasRepo.findAllByTipo(2);
    }

    @Override
    public Caracteristica obtenerCaracteristica(int codCaracteristica) throws Exception {
        return caracteristicasRepo.findById(codCaracteristica).orElseThrow(() -> new Exception("El código no existe"));
    }

    @Override
    public Habitacion registrarHabitacion(Habitacion hab) throws Exception {
        Optional<Habitacion> buscado = habRepo.findById(hab.getCodHabitacion());
        if(buscado.isPresent()){
            throw new Exception("La habitación ya se encuentra registrada");
        }
        return habRepo.save(hab);
    }

    @Override
    public List<Cama> listarCamas() {
        return null;
    }
}
