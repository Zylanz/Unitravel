package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.repositorios.ComentarioRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private  UsuarioRepo usuarioRepo;
    private  ComentarioRepo comentarioRepo;
    private CiudadRepo ciudadRepo;
    private HotelRepo hotelRepo;
    private EmailService emailService;



    public UsuarioServicioImpl(UsuarioRepo usuarioRepo, CiudadRepo ciudadRepo, HotelRepo hotelRepo, ComentarioRepo comentarioRepo,EmailService emailService) {
        this.usuarioRepo = usuarioRepo;
        this.ciudadRepo = ciudadRepo;
        this.hotelRepo = hotelRepo;
        this.comentarioRepo = comentarioRepo;
        this.emailService=emailService;
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCedula());
        if(buscado.isPresent()){
            throw new Exception("La cédula ya se encuentra en uso");
        }
        buscado = usuarioRepo.findByEmail(u.getEmail());
        if(buscado.isPresent()){
            throw new Exception("El correo ya se encuentra en uso");
        }
        return usuarioRepo.save(u);
    }

    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCedula());
        if(!buscado.isPresent()){
            throw new Exception("El usuario no esta registrado");
        }
        return usuarioRepo.save(u);
    }

    @Override
    public void eliminarUsuario(String cedula) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(cedula);
        if(!buscado.isPresent()){
            throw new Exception("El usuario no esta registrado");
        }
       usuarioRepo.delete(buscado.get());

    }

    @Override
    public Usuario obtenerUsuario(String cedula) throws Exception {
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepo.listarUsuarios();
        return usuarios;
    }

    @Override
    public List<Reserva> listarReservas(Usuario u) {
        List<Reserva> reservas = usuarioRepo.listarReservas();

        return reservas;
    }

    @Override
    public Comentario agregarComentario(Comentario c) {
        // validar que el user y el hotel existan
        return  comentarioRepo.save(c);
    }

    @Override
    public Reserva reservar() throws Exception {
        return null;
    }

    @Override
    public Reserva actualizarReserva() throws Exception {
        return null;
    }

    @Override
    public void eliminarReserva() throws Exception {

    }

    @Override
    public List<Reserva> reservasUsuario(String email) {
        return null;
    }





























































































    @Override
    public void recuperarPassword(String email) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);

        if (usuario.isEmpty()){
            throw new Exception("El correo no pertenece a ningún usuario");
        }
        String password = usuario.get().getPassword();
        emailService.enviarEmail("Recuperación Contraseña", "Hola, esta es tu contraseña " + password, email );

    }
}
