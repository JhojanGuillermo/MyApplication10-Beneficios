package ugarte.tecsup.com.myapplication10.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ugarte.tecsup.com.myapplication10.R;
import ugarte.tecsup.com.myapplication10.activities.NoticiaDetalleActivity;
import ugarte.tecsup.com.myapplication10.models.Noticia;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.ViewHolder> {

    private Activity activity;

    private List<Noticia> noticias;

    public NoticiasAdapter(){
        this.noticias = new ArrayList<>();
    }

    public NoticiasAdapter(Activity activity, List<Noticia> noticias){
        this.noticias = noticias;
        this.activity = activity;
    }

    public void setProductos(List<Noticia> noticias) {
        this.noticias = noticias;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView picture;
        public TextView tema;
        public TextView titulo;
        public TextView fecha;
        public TextView detalles;

        public ViewHolder(View itemView){
            super (itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture_image);
            tema = (TextView) itemView.findViewById(R.id.tema);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            fecha = (TextView) itemView.findViewById(R.id.fecha);
            //detalles = (TextView) itemView.findViewById(R.id.descripcion);
        }
    }

    @Override
    public NoticiasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noticias, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final NoticiasAdapter.ViewHolder viewHolder, int position) {
        final Noticia noticia = this.noticias.get(position);
        viewHolder.tema.setText(noticia.getTema());
        viewHolder.titulo.setText(noticia.getTitulo());
        viewHolder.fecha.setText(noticia.getFecha());
        //viewHolder.detalles.setText(noticia.getDesc2());

        Context context = viewHolder.itemView.getContext();
        //int idRes = context.getResources().getIdentifier(noticia.getImagen(), "drawable", context.getPackageName());
        //viewHolder.picture.setImageResource(idRes);

        Picasso.with(context).load("https://usuarios-api-martincs27.c9users.io/images/noticias/"+ noticia.getImagen()).into(viewHolder.picture);

        //ver su respectivo detalle
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, NoticiaDetalleActivity.class);

                intent.putExtra("ID", noticia.getId());
//                    intent.putExtra("TITULO", noticia.getTitulo())
//                            .putExtra("FECHA", noticia.getFecha())
//                            .putExtra("HORA", noticia.getHora())
//                            .putExtra("DETALLES", noticia.getDesc2())
//                            .putExtra("PICTURE", noticia.getImagen());

                activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.noticias.size();
    }

}
