package co.edu.uniquindio.unitravel.convertidores;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.servicios.AdminHotelServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class  CaracteristicasConverter implements Converter<Caracteristica>, Serializable {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private AdminHotelServicio adminHotelServicio;


    @Override
    public Caracteristica getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Caracteristica ca = adminHotelServicio.obtenerCaracteristica(Integer.parseInt(value));
            return ca;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Caracteristica value) {
        if (value != null){
            return "" + value.getCodCaracteristica();
        }
        return "";
    }

}
