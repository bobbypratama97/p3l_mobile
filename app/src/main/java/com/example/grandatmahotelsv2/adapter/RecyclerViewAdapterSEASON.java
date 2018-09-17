package com.example.grandatmahotelsv2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grandatmahotelsv2.R;
import com.example.grandatmahotelsv2.model.Season;
import com.example.grandatmahotelsv2.model.faq;

import java.util.List;

public class RecyclerViewAdapterSEASON extends RecyclerView.Adapter<RecyclerViewAdapterSEASON.SeasonViewHolder>  {

    private Context mCtx;
    private List<Season> seasonList;

    public RecyclerViewAdapterSEASON(Context mCtx, List<Season> seasonList) {
        this.mCtx = mCtx;
        this.seasonList = seasonList;
    }

    @Override
    public SeasonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_viewseason,null);
        return new SeasonViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterSEASON.SeasonViewHolder holder, int position) {

        Season season = seasonList.get(position);

        holder.txtIdSeason.setText(String.valueOf(season.getIdSeason()));
        holder.txtIdPrice.setText(String.valueOf(season.getIdPrice()));
        holder.txtSeasonName.setText(season.getSeasonName());
        holder.txtStartDate.setText(season.getStartDate());
        holder.txtEndDate.setText(season.getEndDate());
        holder.txtDetail.setText(season.getDetail());
    }

    @Override
    public int getItemCount() {
        return seasonList.size();
    }

    class SeasonViewHolder extends RecyclerView.ViewHolder{
        TextView txtIdSeason,txtIdPrice,txtSeasonName,txtStartDate,txtEndDate,txtDetail;

        public SeasonViewHolder(View itemView) {
            super(itemView);

            txtIdSeason = itemView.findViewById(R.id.txtIDSeason);
            txtIdPrice = itemView.findViewById(R.id.txtIDPrice);
            txtSeasonName = itemView.findViewById(R.id.txtSeasonName);
            txtStartDate = itemView.findViewById(R.id.txtStartDate);
            txtEndDate = itemView.findViewById(R.id.txtEndDate);
            txtDetail = itemView.findViewById(R.id.txtDetail);
        }
    }


}
