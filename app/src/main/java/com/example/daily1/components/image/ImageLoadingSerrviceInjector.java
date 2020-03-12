package com.example.daily1.components.image;

/**
 *in this class edit fresco to picasso
 */
public class ImageLoadingSerrviceInjector {

    private static ImageLoadingService imageLoadingService;
    public static ImageLoadingService getImageLoadingService()
    {
        if(imageLoadingService == null){
            imageLoadingService = new FrascoImageLoadingService();
        }
        return imageLoadingService;
    }

}
