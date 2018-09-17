package com.example.grandatmahotelsv2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grandatmahotelsv2.R;
import com.example.grandatmahotelsv2.model.faq;
import com.example.grandatmahotelsv2.model.report1;
import com.example.grandatmahotelsv2.model.report2;

import java.util.List;

public class RecyclerViewAdapterREPORT2 extends RecyclerView.Adapter<RecyclerViewAdapterREPORT2.REPORT2ViewHolder> {
    private Context mCtx;
    private List<report2> report2List;

    public RecyclerViewAdapterREPORT2(Context mCtx, List<report2> report2List) {
        this.mCtx = mCtx;
        this.report2List = report2List;
    }

    @Override
    public REPORT2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_reportpesananterbanyak,null);
        return new REPORT2ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterREPORT2.REPORT2ViewHolder holder, int position) {
        report2 report2 = report2List.get(position);

        holder.txtNama.setText(report2.getNAMA());
        holder.txtJumlahReservasi.setText(String.valueOf(report2.getJUMLAH_RESERVASI()));
        holder.txtTotalPembayaran.setText(String.valueOf(report2.getTOTAL_PEMBAYARAN()));

    }

    @Override
    public int getItemCount() {
        return report2List.size();
    }

     class REPORT2ViewHolder extends RecyclerView.ViewHolder {
         TextView txtNama,txtJumlahReservasi,txtTotalPembayaran;

         public REPORT2ViewHolder(View itemView) {

             super(itemView);

             txtNama = itemView.findViewById(R.id.txtNama);
             txtJumlahReservasi = itemView.findViewById(R.id.txtJumlahReservasi);
             txtTotalPembayaran = itemView.findViewById(R.id.txtTotalPembayaran);

         }

    }

}
