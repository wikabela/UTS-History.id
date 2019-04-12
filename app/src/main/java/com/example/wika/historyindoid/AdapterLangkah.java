package com.example.wika.historyindoid;

import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

import com.example.wika.historyindoid.models.Aturan;

import java.util.ArrayList;

public class AdapterLangkah extends RecyclerView.Adapter<AdapterLangkah.LangkahViewHolder> {
    private ArrayList<Aturan> dataList;
    public AdapterLangkah(ArrayList<Aturan> dataList){
        this.dataList = dataList;
    }

    @Override
    public LangkahViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new LangkahViewHolder(view);
    }


    @Override
    public void onBindViewHolder(LangkahViewHolder holder, int position) {
        holder.txtNo.setText(dataList.get(position).getNo());
        holder.txtTeks.setText(dataList.get(position).getTeks());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class LangkahViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNo, txtTeks;

        public LangkahViewHolder(View itemView){
            super(itemView);
            txtNo = itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtTeks =  itemView.findViewById(R.id.txt_npm_mahasiswa);
        }
    }
}

