package com.example.grandatmahotelsv2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grandatmahotelsv2.R;
import com.example.grandatmahotelsv2.model.History;


import java.util.List;

public class RecyclerViewAdapterHISTORY extends RecyclerView.Adapter<RecyclerViewAdapterHISTORY.HistoryViewHolder> {

    private Context mCtx;
    private List<History> historyList;

    public RecyclerViewAdapterHISTORY(Context mCtx, List<History> historyList) {
        this.mCtx = mCtx;
        this.historyList = historyList;
    }

    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_viewhistory,null);
        return new HistoryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterHISTORY.HistoryViewHolder holder, int position) {
        History history = historyList.get(position);

        holder.txtIdBooking.setText(String.valueOf(history.getIdBooking()));
        holder.txtReservationDate.setText(history.getReservationDate());
        holder.txtReservationStatus.setText(history.getReservationStatus());
        holder.txtCheckInDate.setText(history.getCheckInDate());
        holder.txtCheckOutDate.setText(history.getCheckOutDate());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }


    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView txtIdBooking,txtReservationDate,txtReservationStatus,txtCheckInDate,txtCheckOutDate;

        public HistoryViewHolder(View itemView) {
            super(itemView);

            txtIdBooking = itemView.findViewById(R.id.txtIDBooking);
            txtReservationDate = itemView.findViewById(R.id.txtReservationDate);
            txtReservationStatus = itemView.findViewById(R.id.txtReservationStatus);
            txtCheckInDate = itemView.findViewById(R.id.txtCheckInDate);
            txtCheckOutDate = itemView.findViewById(R.id.txtCheckOutDate);


        }

    }
}
