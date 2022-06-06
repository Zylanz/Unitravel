package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.AdminHotelServicio;
import co.edu.uniquindio.unitravel.servicios.AdministradorServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class HotelBean implements Serializable {

    @Value("${upload.url}")
    private String urlImagenes;
    @Getter@Setter
    private Hotel hotel;
    @Getter@Setter
    private Ciudad ciudad;
    @Getter@Setter
    private List<Ciudad> ciudades;
    @Getter@Setter
    private Caracteristica caracteristica;
    @Getter@Setter
    private List<Caracteristica> caracteristicasHotel;
    @Getter@Setter
    private List<Caracteristica> caracteristicasHabitacion;
    @Autowired
    private AdminHotelServicio adminHotelServicio;
    @Autowired
    private AdministradorServicio ciudadServicio;
    @Setter@Getter
    private ArrayList<String> imagenesHotel;
    @Setter@Getter
    private ArrayList<String> imagenesHabitacion;
    @Setter@Getter
    private Habitacion habitacion;

    @Setter@Getter
    private ArrayList<Habitacion> habitaciones;

    @Setter@Getter
    private List<Cama> camas;
    @PostConstruct
    public void inicializar(){
        hotel = new Hotel();
        imagenesHotel = new ArrayList<>();
        imagenesHabitacion = new ArrayList<>();
        habitacion = new Habitacion();
        habitaciones = new ArrayList<>();
        ciudades = ciudadServicio.listarCiudades();
        caracteristicasHotel = adminHotelServicio.listarCaracteristicasHotel();
        caracteristicasHabitacion = adminHotelServicio.listarCaracteristicasHabitacion();
        camas = adminHotelServicio.listarCamas();
    }

    public String registrarHotel(){
        try {
            if (imagenesHotel.size()>0){
                if (habitaciones.size() > 0){
                    AdminHotel adminHotel= adminHotelServicio.obtenerAdminHotel("1");


                    hotel.setAdministrador(adminHotel);
                    hotel.setFotos(imagenesHotel);

                    Hotel h = adminHotelServicio.registrarHotel(hotel);

                    habitaciones.forEach(hab -> {
                        hab.setHotel(h);
                        try {
                            adminHotelServicio.registrarHabitacion(hab);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });

                    FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Hotel c reado correctamente");
                    FacesContext.getCurrentInstance().addMessage(null,ms);
                    return "registro_exitoso?faces-redirect=true";
                }


            }else {
                FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Es obligatorio subir imagenes del hotel");
                FacesContext.getCurrentInstance().addMessage(null,ms);

            }

        }catch (Exception e){
            FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,ms);
        }
        return null;
    }

    public void subirImagenes(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if(nombreImagen!=null) {
            imagenesHotel.add(nombreImagen);
        }
    }

    public  String subirImagen(UploadedFile imagen){

        try {
            File archivo = new File(urlImagenes+"/"+imagen.getFileName());
            OutputStream outputStream = new FileOutputStream(archivo);
            IOUtils.copy(imagen.getInputStream(),outputStream);
            return imagen.getFileName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void crearHabitacion(){
        if (!imagenesHabitacion.isEmpty()){
            habitacion.setFotos(imagenesHabitacion);
            habitaciones.add(habitacion);

            habitacion = new Habitacion();
            imagenesHabitacion = new ArrayList<>();
        }else{
            FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Es obligatorio subir imagenes de la habitación");
            FacesContext.getCurrentInstance().addMessage(null,ms);

        }

    }

}
