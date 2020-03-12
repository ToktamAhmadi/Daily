package com.example.daily1.view.home.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daily1.R;
import com.example.daily1.components.RvAdapter;
import com.example.daily1.components.RvViewHolder;
import com.example.daily1.components.image.ImageLoadingService;
import com.example.daily1.components.image.MyImageView;
import com.example.daily1.model.data.Material;
import com.example.daily1.model.data.Pack;

import java.util.List;

import androidx.annotation.NonNull;

public class MaterialAdapterHome extends RvAdapter<Material, MaterialAdapterHome.MatrialViewHolder> {
    private final ImageLoadingService imageLoadingService;

    public MaterialAdapterHome(List<Material> materials, ImageLoadingService imageLoadingService) {
        super(materials);
        this.imageLoadingService = imageLoadingService;
    }

    @NonNull
    @Override
    public MatrialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new  MatrialViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_material_home,parent,false
        ));
    }


    public class MatrialViewHolder extends RvViewHolder<Material> {
        private MyImageView imageView;
        private TextView textView;
        private LinearLayout linearLayout;

        public MatrialViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_material);
            textView = itemView.findViewById(R.id.tv_title_material);
            linearLayout= itemView.findViewById(R.id.linear_material_home);
        }

        @Override
        public void bind(Material item) {
            imageLoadingService.loadImage(imageView, item.getUrl());
            textView.setText(item.getTitle());
            linearLayout.setBackgroundColor(Color.parseColor(item.getColor()));

        }
    }
}
