package com.example.grandatmahotelsv2.adapter;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grandatmahotelsv2.R;
import com.example.grandatmahotelsv2.model.faq;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class RecyclerViewAdapterFAQ extends RecyclerView.Adapter<RecyclerViewAdapterFAQ.FaqViewHolder> {

    private Context mCtx;
    private List<faq> faqList;

    public RecyclerViewAdapterFAQ(Context mCtx, List<faq> faqList) {
        this.mCtx = mCtx;
        this.faqList = faqList;
    }

    @Override
    public FaqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_viewfaq,null);
        return new FaqViewHolder(view);

    }

    @Override
    public void onBindViewHolder(FaqViewHolder holder, int position) {

        faq faq = faqList.get(position);

        holder.txtIdFaq.setText(String.valueOf(faq.getIdFaq()));
        holder.txtQuestion.setText(faq.getQuestion());
        holder.txtAnswer.setText(faq.getAnswer());


    }


    @Override
    public int getItemCount() {
        return faqList.size();
    }

    class FaqViewHolder extends RecyclerView.ViewHolder{
        TextView txtIdFaq,txtQuestion,txtAnswer;

        public FaqViewHolder(View itemView) {
            super(itemView);

            txtIdFaq = itemView.findViewById(R.id.txtIDFaq);
            txtQuestion = itemView.findViewById(R.id.txtQuestion);
            txtAnswer = itemView.findViewById(R.id.txtAnswer);
        }
    }
}

