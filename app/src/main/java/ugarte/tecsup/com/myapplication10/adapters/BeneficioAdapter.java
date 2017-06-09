package ugarte.tecsup.com.myapplication10.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ugarte.tecsup.com.myapplication10.models.Beneficio;
import ugarte.tecsup.com.myapplication10.R;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class BeneficioAdapter extends RecyclerView.Adapter<BeneficioAdapter.ViewHolder> {

    private List<Beneficio> beneficios;

    public BeneficioAdapter(){
        this.beneficios = new ArrayList<>();
    }

    public void setBeneficios(List<Beneficio> beneficios){
        this.beneficios = beneficios;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView beneficio;
        public TextView detalle;

        public ViewHolder(View itemView){
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.photo_img);
            beneficio = (TextView) itemView.findViewById(R.id.names_Beneficio);
            detalle = (TextView) itemView.findViewById(R.id.names_Detalles);
        }
    }

    @Override
    public BeneficioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beneficios, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BeneficioAdapter.ViewHolder viewHolder, int position) {
        Beneficio beneficio = this.beneficios.get(position);
        viewHolder.beneficio.setText(beneficio.getBeneficio());
        viewHolder.detalle.setText(beneficio.getDetalle());
        Context context = viewHolder.itemView.getContext();

        Picasso.with(context).load("https://usuarios-api-martincs27.c9users.io/images/beneficios/"+ beneficio.getImage()).into(viewHolder.image);


    }

    @Override
    public int getItemCount() {
        return this.beneficios.size();
    }
}
