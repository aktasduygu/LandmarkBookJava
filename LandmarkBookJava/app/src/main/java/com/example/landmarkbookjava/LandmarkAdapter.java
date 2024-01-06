package com.example.landmarkbookjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.landmarkbookjava.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>{

    ArrayList<Landmark> landmarkArrayList;
    private LandmarkHolder holder;
    private int position;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    //ViewHolder sınıfından bir method oluşturulduğunda çağırılacak olan method binding'i, xml'i burada bağlayacağız.
    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    //ViewHolder bağlandığında neler olacağını gösterecek kısacası layout içerisinde hangi verilerin gösterilmesini istiyorsak burada göstereceğiz.
    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, @SuppressLint("RecyclerView") int position) {
        this.holder = holder;
        this.position = position;
        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    //xml'in kaç kere oluşturulacağını söyleyecek
    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

    //Görünümlerimizi tutacak olan sınıf
    public class LandmarkHolder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
