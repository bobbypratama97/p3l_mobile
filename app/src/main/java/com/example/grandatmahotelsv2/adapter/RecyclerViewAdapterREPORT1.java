package com.example.grandatmahotelsv2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grandatmahotelsv2.R;
import com.example.grandatmahotelsv2.model.Season;
import com.example.grandatmahotelsv2.model.report1;

import java.util.List;

public class RecyclerViewAdapterREPORT1  extends RecyclerView.Adapter<RecyclerViewAdapterREPORT1.REPORT1ViewHolder>{
    private Context mCtx;
    private List<report1> report1List;

    public RecyclerViewAdapterREPORT1(Context mCtx, List<report1> report1List) {
        this.mCtx = mCtx;
        this.report1List = report1List;
    }

    @Override
    public RecyclerViewAdapterREPORT1.REPORT1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_reportpelangganbaru,null);
        return new RecyclerViewAdapterREPORT1.REPORT1ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterREPORT1.REPORT1ViewHolder holder, int position) {

        report1 report1 = report1List.get(position);

        holder.txtIdBulan.setText(String.valueOf(report1.getBULAN()));
        holder.txtJumlah.setText(String.valueOf(report1.getJUMLAH()));
    }

    @Override
    public int getItemCount() {
        return report1List.size();
    }

    class REPORT1ViewHolder extends RecyclerView.ViewHolder{
        TextView txtIdBulan,txtJumlah;

        public REPORT1ViewHolder(View itemView) {
            super(itemView);

            txtIdBulan = itemView.findViewById(R.id.txtIDBulan);
            txtJumlah = itemView.findViewById(R.id.txtJumlah);

        }
    }
}
