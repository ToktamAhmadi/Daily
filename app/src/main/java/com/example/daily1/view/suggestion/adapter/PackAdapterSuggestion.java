package com.example.daily1.view.suggestion.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daily1.R;
import com.example.daily1.components.RvAdapter;
import com.example.daily1.components.RvViewHolder;
import com.example.daily1.components.image.ImageLoadingService;
import com.example.daily1.components.image.MyImageView;
import com.example.daily1.model.data.Pack;

import java.util.List;

import androidx.annotation.NonNull;

public class PackAdapterSuggestion extends RvAdapter<Pack, PackAdapterSuggestion.PackViewHolder> {

    private ImageLoadingService imageLoadingService;

    public PackAdapterSuggestion(List<Pack> packs,ImageLoadingService imageLoadingService){
        super(packs);
        this.imageLoadingService = imageLoadingService;
    }

    @NonNull
    @Override
    public PackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PackViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pack_suggestion,parent,false));
    }

    //---------------------------------------
    public class PackViewHolder extends RvViewHolder<Pack>{

        private MyImageView packIv;
        private TextView titleTv;
        private TextView priceTv;

    public PackViewHolder(@NonNull View itemView) {
        super(itemView);

        packIv = itemView.findViewById(R.id.iv_pack);
        titleTv =itemView.findViewById(R.id.tv_pack_title);
        priceTv=itemView.findViewById(R.id.tv_pack_price);
    }

    @Override
    public void bind(Pack item) {
       titleTv.setText(item.getTitle());
       priceTv.setText(item.getPrice() + " تومان");
       imageLoadingService.loadImage(packIv,item.getUrl());
    }
}
}
