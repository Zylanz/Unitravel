package co.edu.uniquindio.unitravel.convertidores;


import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.management.relation.Role;
import java.io.Serializable;

@Component
public class CiudadConverter implements Converter<Ciudad>, Serializable {
    @Autowired
    private CiudadRepo ciudadRepo;

    private UsuarioServicio usuarioServicio;

    @Override
    public Ciudad getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Ciudad ciudad = usuarioServicio.obtenerCiudad(Integer.parseInt(value));
            return ciudad;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Ciudad value) {
        if (value != null){
            return "" + value.getCodCiudad();
    }
        return "";
    }
}
