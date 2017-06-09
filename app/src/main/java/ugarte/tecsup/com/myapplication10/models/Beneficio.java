package ugarte.tecsup.com.myapplication10.models;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class Beneficio {

    private Integer id;

    private String beneficio;

    private String detalle;

    private String image;

    public Beneficio(){

    }

    public Beneficio(Integer id, String beneficio, String detalle, String image) {
        this.id = id;
        this.beneficio = beneficio;
        this.detalle = detalle;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Beneficio{" +
                "id=" + id +
                ", beneficio='" + beneficio + '\'' +
                ", detalle='" + detalle + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
