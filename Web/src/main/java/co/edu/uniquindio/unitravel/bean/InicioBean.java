package co.edu.uniquindio.unitravel.bean;
import org.springframework.stereotype.Component;
import javax.faces.view.ViewScoped;
import java.io.Serializable;


@Component
@ViewScoped
public class InicioBean implements Serializable {
    private String mensaje = "Mi primera página en JSF posdata Muñeton es una perra";

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
