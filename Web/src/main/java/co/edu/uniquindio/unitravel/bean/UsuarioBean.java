package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.AdministradorServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class UsuarioBean implements Serializable {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private Usuario usuario;

    @Autowired
    private AdministradorServicio ciudadServicio;

    @Getter@Setter
    private Ciudad ciudad;
    @Getter@Setter
    private List<Ciudad> ciudades;

    @PostConstruct
    public void init(){
        ciudades = ciudadServicio.listarCiudades();
        usuario = new Usuario();
    }
    public void registrarUsuario(){
        try {
            usuarioServicio.registrarUsuario(usuario);

            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null,msg);

        } catch (Exception e) {
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,msg);
        }


    }
}
