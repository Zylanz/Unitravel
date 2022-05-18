package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

//:v
@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private final UsuarioRepo usuarioRepo;
    private final ReservaRepo reservaRepo;
    private final HotelRepo hotelRepo;
    private final SillaRepo sillaRepo;
    private final CiudadRepo ciudadRepo;
    private final ComentarioRepo comentarioRepo;
    private EmailService emailService;


    public UsuarioServicioImpl(UsuarioRepo usuarioRepo, ReservaRepo reservaRepo, HotelRepo hotelRepo,
                               SillaRepo sillaRepo, CiudadRepo ciudadRepo, ComentarioRepo comentarioRepo,
                               EmailService emailService) {
        this.usuarioRepo = usuarioRepo;
        this.reservaRepo = reservaRepo;
        this.hotelRepo = hotelRepo;
        this.sillaRepo = sillaRepo;
        this.ciudadRepo = ciudadRepo;
        this.comentarioRepo = comentarioRepo;
        this.emailService = emailService;
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
    public Usuario obtenerUsuario(String cedula){
        return usuarioRepo.findById(cedula).orElse(null);
    }

    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCedula());
        if(buscado.isEmpty()){
            throw new Exception("El usuario no esta registrado");
        }
        return usuarioRepo.save(u);
    }

    @Override
    public void eliminarUsuario(String cedula) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(cedula);
        if(buscado.isEmpty()){
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
    public Usuario login (String email, String pass) throws Exception
    {
        Optional<Usuario> buscado = usuarioRepo.findUsuarioByEmailAndPassword(email,pass);

        if (buscado.isEmpty())
        {
            throw new Exception("Datos de acceso inválidos");
        }

        return buscado.get();
    }

    @Override
    public Reserva realizarReserva(Hotel h, Reserva r, Usuario u, int cantidadSillas) throws Exception
    {
        Optional<Hotel> hotelBuscado=hotelRepo.findByCodHotel(h.getCodHotel());
        Optional<Reserva> reservaBuscada=reservaRepo.buscarReservaPorHotel(r.getFechaReserva(), hotelBuscado.get().getCodHotel());

        if (reservaBuscada.isPresent())
        {
            throw new Exception("No se puede realizar una reserva en esta fecha");
        }

        Optional<Usuario> usuarioBuscado=usuarioRepo.findUsuarioByEmailAndPassword(u.getEmail(), u.getPassword());

        if (usuarioBuscado.isEmpty())
        {
            throw new Exception("El usuario no se encuentra loggeado");
        }


        int contador=0;
        List<Silla> sillasReservadas=new ArrayList<>();

        while(contador<cantidadSillas)
        {
            Random rnd = new Random();
            int codSilla = (int) (rnd.nextDouble() * 50 + 1);
            Optional<Silla> sillaReservada = sillaRepo.findByCodSilla(codSilla);

            if(sillaReservada.isEmpty())
            {
                throw new Exception("La silla no se encuentra disponble");
            }

            sillasReservadas.add(sillaReservada.get());

            contador++;
        }

        //qué pasa si es afiliado?
        //mandar correo de reserva

        r.setSillas(sillasReservadas);

        return reservaRepo.save(r);
    }

    @Override
    public void eliminarReserva(int codigoReserva) throws Exception
    {
        Optional<Reserva> buscado = reservaRepo.findById(codigoReserva);

        if(!buscado.isPresent())
        {
            throw new Exception("La reserva no esta registrada");
        }
        reservaRepo.delete(buscado.get());
    }

    @Override
    public Reserva actualizarReserva(Reserva r) throws Exception
    {
        Optional<Reserva> buscado = reservaRepo.findById(r.getCodReserva());

        if(!buscado.isPresent())
        {
            throw new Exception("La reserva no se encuentra registrada");
        }
        return reservaRepo.save(r);
    }

    @Override
    public List<Reserva> listarReservas()
    {
        List<Reserva> reservas = reservaRepo.findAll();
        return reservas;
    }

    @Override
    public boolean isAfiliado(Usuario u) throws Exception
    {
        boolean afiliado=false;
        Optional<Usuario> buscado=usuarioRepo.findById(u.getCedula());

        if (buscado.isPresent())
        {
            buscado.get().isAfiliado();
        }

        return afiliado;
    }

    @Override
    public List<Hotel> listarHotelesPorCiudad(String nombreCiudad) throws Exception
    {
        Optional<Ciudad> ciudad=ciudadRepo.findByNombre(nombreCiudad);

        if(ciudad.isEmpty())
        {
            throw new Exception("La ciudad no se encuentra registrada");
        }

        return hotelRepo.buscarHotelPorCiudad(ciudad.get().getCodCiudad());
    }

    @Override
    public Reserva obtenerReserva(int codigoReserva) throws Exception
    {
        Optional<Reserva> buscado=reservaRepo.findById(codigoReserva);

        if (buscado.isEmpty())
        {
            throw new Exception("No se encuentra la reserva solicitada");
        }

        return buscado.get();
    }


    @Override
    public void recuperarPassword(String email) throws Exception
    {
        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);

        if (usuario.isEmpty()){
            throw new Exception("El correo no pertenece a ningún usuario");
        }
        String password = usuario.get().getPassword();
        emailService.enviarEmail("Recuperación Contraseña", "Hola, esta es tu contraseña " + password, email );

    }

    @Override
    public Comentario agregarComentario(Comentario c) throws Exception
    {
        Hotel hotel = c.getComentarioHotel();
        Optional<Hotel> hotelVerificado = hotelRepo.findByCodHotel(hotel.getCodHotel());
        if(hotelVerificado.isEmpty()){
            throw new Exception("El hotel no se encuentra");
        }
        Usuario user = c.getUsuario();
        Optional<Usuario> usuarioVerificado = usuarioRepo.findById(user.getCedula());
        if (usuarioVerificado.isEmpty()){
            throw new Exception("El usuario no esta registrado");
        }
        return  comentarioRepo.save(c);
    }

    @Override
    public List<Hotel> buscarPorNombre(String nombreHotel) {
           return hotelRepo.buscarPorNombre(nombreHotel);
    }
}
