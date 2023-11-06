package com.example.catapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView catImageView;
    private GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        catImageView = findViewById(R.id.catImageView);
        gestureDetector = new GestureDetector(this, new GestureListener());
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
            float diffX = event2.getX() - event1.getX();
            float diffY = event2.getY() - event1.getY();

            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (diffX > 0) {
                    // Swipe right
                    catImageView.setImageResource(R.drawable.cat_right);
                } else {
                    // Swipe left
                    catImageView.setImageResource(R.drawable.cat_left);
                }
            } else {
                if (diffY > 0) {
                    // Swipe down
                    catImageView.setImageResource(R.drawable.cat_down);
                } else {
                    // Swipe up
                    catImageView.setImageResource(R.drawable.cat_up);
                }
            }
            return true;
        }
    }
}
