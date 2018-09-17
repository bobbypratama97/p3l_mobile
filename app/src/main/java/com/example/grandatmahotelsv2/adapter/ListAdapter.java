package com.example.grandatmahotelsv2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grandatmahotelsv2.R;
import com.example.grandatmahotelsv2.model.faq;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.FaqViewHolder>{

    private Context context;
    private ArrayList<faq> list;

    public ListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public FaqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_faq,parent,false);

        return new FaqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FaqViewHolder holder, int position) {

     //  holder.txtIdFaq.setText(getList().get(position).getIdFaq());
      // holder.txtQuestion.setText(getList().get(position).getQuestion());
       //holder.txtAnswer.setText(getList().get(position).getAnswer());

    }

    @Override
    public int getItemCount() {
        return getList().size();
    }

    public ArrayList<faq> getList() {
        return list;
    }

    public void setList(ArrayList<faq> list) {
        this.list = list;
    }

    class FaqViewHolder extends RecyclerView.ViewHolder{
        TextView txtIdFaq;
        TextView txtQuestion;
        TextView txtAnswer;
        public FaqViewHolder(View itemView) {
            super(itemView);
            txtIdFaq = (TextView) itemView.findViewById(R.id.idfaq);
            txtQuestion = (TextView) itemView.findViewById(R.id.question);
            txtAnswer = (TextView) itemView.findViewById(R.id.answer);


        }
    }

}
