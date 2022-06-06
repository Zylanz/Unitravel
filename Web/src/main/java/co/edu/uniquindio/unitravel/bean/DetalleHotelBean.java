package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdminHotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class DetalleHotelBean implements Serializable {

    @Value("#{param['hotel_id']}")
    private String codHotel;

    @Getter@Setter
    private Hotel hotel;

    @Autowired
    private AdminHotelServicio adminHotelServicio;

    @PostConstruct
    public void inicializar(){
        if (codHotel!=null && !codHotel.isEmpty()){
            hotel = adminHotelServicio.obtenerHotel(Integer.parseInt(codHotel));
        }

    }

}
