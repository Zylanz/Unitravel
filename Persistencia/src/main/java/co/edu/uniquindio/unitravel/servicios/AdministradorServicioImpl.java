package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicioImpl implements AdministradorServicio{

    AdministradorRepo administradorRepo;

    public AdministradorServicioImpl(AdministradorRepo administradorRepo){
        this.administradorRepo = administradorRepo;
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
        if(!buscado.isPresent()){
            throw new Exception("El administrador no esta registrado");
        }

        return administradorRepo.save(a);
    }

    @Override
    public void eliminarAdministrador(String cedula) throws Exception {

    }

    @Override
    public List<Administrador> listarAdministradores() {
        return null;
    }
}
