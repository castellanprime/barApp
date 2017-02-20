package com.spartahacks.app.bargamescores;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

/**
 * Created by rogal-dorn on 2/2/17.
 */

public class GameItemDesc {

    private String description;
    private String gameRulesPath;
    private String gameIconPath;

    GameItemDesc(String description, String gameRulesPath){;
        this.description = description;
        this.gameRulesPath = Environment.getExternalStorageDirectory() + gameRulesPath;
    }

    public void setGameIconPath(String imagePath){
        this.gameIconPath = Environment.getExternalStorageDirectory() + imagePath;
    }

    public String getGameDesc(){
        return description;
    }

    public String getGameRulesPath(){
        return gameRulesPath;
    }

    public String getGameIconPath(){
        return gameIconPath;
    }

    public Bitmap getGameIcon(){
        return decodeSampledBitmap(getGameIconPath(), 50, 50);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    private Bitmap decodeSampledBitmap(String pathName,int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(pathName, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(pathName, options);
    }
}
