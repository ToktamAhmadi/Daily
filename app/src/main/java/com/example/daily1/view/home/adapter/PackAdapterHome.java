package com.example.daily1.view.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daily1.R;
import com.example.daily1.components.RvAdapter;
import com.example.daily1.components.RvViewHolder;
import com.example.daily1.components.image.ImageLoadingService;
import com.example.daily1.components.image.MyImageView;
import com.example.daily1.model.data.Pack;

import java.util.List;

import androidx.annotation.NonNull;

public class PackAdapterHome extends RvAdapter<Pack, PackAdapterHome.PackViewHolder> {
    private final ImageLoadingService imageLoadingService;

    public PackAdapterHome(List<Pack> packs, ImageLoadingService imageLoadingService) {
        super(packs);
        this.imageLoadingService = imageLoadingService;
    }

    @NonNull
    @Override
    public PackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PackViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_pack_home, parent, false
        ));
    }

    public class PackViewHolder extends RvViewHolder<Pack> {
        private MyImageView imageView;
        private TextView textView;

        public PackViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_pack);
            textView = itemView.findViewById(R.id.tv_title_pack);
        }

        @Override
        public void bind(Pack item) {
            imageLoadingService.loadImage(imageView, item.getUrl());
            textView.setText(item.getTitle());
        }
    }
}
