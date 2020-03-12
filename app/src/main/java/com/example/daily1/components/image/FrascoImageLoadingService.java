package com.example.daily1.components.image;

import android.net.Uri;
import android.widget.ImageView;

public class FrascoImageLoadingService implements ImageLoadingService {
    @Override
    public void loadImage(MyImageView imageView, String url) {
        imageView.setImageURI(Uri.parse(url));
    }
}
