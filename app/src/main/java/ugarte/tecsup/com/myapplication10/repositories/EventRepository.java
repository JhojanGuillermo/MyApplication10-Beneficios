package ugarte.tecsup.com.myapplication10.repositories;

import java.util.ArrayList;
import java.util.List;
import ugarte.tecsup.com.myapplication10.models.EventGal;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class EventRepository {

    //EventDetalleActivity

    private static List<EventGal> eventsGal;

    static {
        eventsGal = new ArrayList<>();
        eventsGal.add( new EventGal(100, "Fiesta de Inauguracion", "16/04/2017", "fiesta"));
        eventsGal.add( new EventGal(200, "Cachimbos", "10/03/2017", "bienvenida"));
    }

    public  static List<EventGal> getEventsGal(){ return eventsGal;}
}
