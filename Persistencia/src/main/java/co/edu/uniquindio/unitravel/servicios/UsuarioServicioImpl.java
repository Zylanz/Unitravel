package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private final UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
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
    public List<Comentario> agregarComentario(Comentario c) {
        return null;
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
    public List<Reserva> reservasUsuario() {
        return null;
    }

    @Override
    public Usuario recuperarContrasena() throws Exception {
        return null;
    }
}
