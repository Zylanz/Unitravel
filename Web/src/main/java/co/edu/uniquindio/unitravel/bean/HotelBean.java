package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdminHotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class HotelBean implements Serializable {

    @Getter@Setter
    private Hotel hotel;

    @Autowired
    private AdminHotelServicio adminHotelServicio;

    @PostConstruct
    public void inicializar(){
        hotel = new Hotel();
    }

    public String registrarHotel(){
        try {
            Ciudad ciudad = adminHotelServicio.obtenerCiudad(2);
            AdminHotel adminHotel= adminHotelServicio.obtenerAdminHotel("1");


            hotel.setCodCiudad(ciudad);
            hotel.setAdministrador(adminHotel);
            adminHotelServicio.registrarHotel(hotel);


           /* FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Hotel c reado correctamente");
            FacesContext.getCurrentInstance().addMessage(null,ms);*/
            return "registro_exitoso?faces-redirect=true";
        }catch (Exception e){
            FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,ms);
        }
        return null;
    }

}
