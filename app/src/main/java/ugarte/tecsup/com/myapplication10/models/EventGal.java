package ugarte.tecsup.com.myapplication10.models;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class EventGal {
    private Integer id;

    private String fullname;

    private String fecha;

    private String pictureGal;

    public EventGal(Integer id, String fullname, String fecha, String pictureGal){
        this.id = id;
        this.fullname = fullname;
        this.fecha = fecha;
        this.pictureGal = pictureGal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPictureGal() {
        return pictureGal;
    }

    public void setPictureGal(String pictureGal) {
        this.pictureGal = pictureGal;
    }

    @Override
    public String toString() {
        return "EventGal{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", fecha='" + fecha + '\'' +
                ", pictureGal='" + pictureGal + '\'' +
                '}';
    }
}
