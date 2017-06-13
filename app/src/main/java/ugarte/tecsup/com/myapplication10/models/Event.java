package ugarte.tecsup.com.myapplication10.models;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class Event {
    private Integer id;

    private String titulo;

    private String fecha;

    private String lugar;

    private String descripcion;

    private String imagen;

    private int asistentes;

    public Event(Integer id, String titulo, String fecha, String lugar,String descripcion, String imagen, int asistentes){
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.asistentes = asistentes;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion(){ return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion;}

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getAsistentes() { return asistentes; }

    public void setAsistentes(int asistentes) { this.asistentes = asistentes; }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", lugar='" + lugar + '\'' +
                ", descripcion= '" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", asistentes='" + asistentes + '\'' +
                '}';
    }

}
