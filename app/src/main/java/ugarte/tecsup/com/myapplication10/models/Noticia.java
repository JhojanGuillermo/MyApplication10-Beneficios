package ugarte.tecsup.com.myapplication10.models;

/**
 * Created by JShanksX13 on 30/05/2017.
 */

public class Noticia {

    private Integer id;

    private String tema;

    private String titulo;

    private String fecha;

    private String desc2;

    private String imagen;

    public Noticia(int i, String nacimiento, String s, String s1, String s2, String abcsdsdsd){

    }

    public Noticia(Integer id, String tema, String titulo, String fecha, String desc2, String imagen) {
        this.id = id;
        this.tema = tema;
        this.titulo = titulo;
        this.fecha = fecha;
        this.desc2 = desc2;
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTitulo() {
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

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", tema='" + tema + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", desc2='" + desc2 + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
