package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.gabriel.BarberApp.AgendamentoActivity;
import com.gabriel.BarberApp.R;
import java.util.List;
import Singleton.GerenciarDados;
import model.Agendamento;
import model.Barber;

public class BarberAdapter extends RecyclerView.Adapter<BarberAdapter.BarberViewHolder> {

        private Context mContext;
        private List<Barber> mBarberList;


        public BarberAdapter(Context context, List<Barber> barberList) {
            this.mContext = context;
            this.mBarberList = barberList;
        }


        @NonNull
        @Override
        public BarberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_barber, parent, false);
            return new BarberViewHolder(view);
        }


        @Override
        public void onBindViewHolder(@NonNull BarberViewHolder holder, int position) {
            Barber barber = mBarberList.get(position);

            holder.tvName.setText(barber.getNome());
            holder.tvSpecialty.setText(barber.getEspecialidade());
            holder.ivPhoto.setImageResource(barber.getFotoId());


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GerenciarDados.getInstance().getAgendamentoAtual().setBarbeiro(barber);
                    Intent intent = new Intent(mContext, AgendamentoActivity.class);
                    mContext.startActivity(intent);

                }
            });
        }


        @Override
        public int getItemCount() {
            return mBarberList.size();
        }


        public class BarberViewHolder extends RecyclerView.ViewHolder {
            ImageView ivPhoto;
            TextView tvName;
            TextView tvSpecialty;

            public BarberViewHolder(@NonNull View itemView) {
                super(itemView);

                ivPhoto = itemView.findViewById(R.id.iv_barber_photo);
                tvName = itemView.findViewById(R.id.tv_barber_name);
                tvSpecialty = itemView.findViewById(R.id.tv_barber_specialty);
            }
        }
    }


