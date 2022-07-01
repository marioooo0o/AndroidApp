package com.example.clientside;

import android.graphics.Bitmap;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Slide {
    private Long id;
    private String title;
    private String image;
    private Bitmap imageBitmap = null;

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
