package com.example.andiroot.restotablebook;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;


public class TableManager extends AppCompatActivity {

    private ImageView img;
    private String msg = "drag_activity";
    private Random rand = new Random();
    RelativeLayout.LayoutParams layoutParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_manager_2);
      /*  findViewById(R.id.myimage1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.relMainContainer).setOnDragListener(new MyDragListener());

*/
        final int width,height;
        if(Build.VERSION.SDK_INT >= 13){
            android.graphics.Point p = new android.graphics.Point();
            this.getWindowManager().getDefaultDisplay().getSize(p);
            width = p.x;
            height = p.y;
        }
        else{
            Display display = getWindowManager().getDefaultDisplay();
            width = display.getWidth();
            height = display.getHeight();
        }

        RelativeLayout rel = new RelativeLayout(this);
        rel.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));
        rel.setBackgroundResource(R.drawable.shape);

        for(final ImageView imageView : Globals.tablesAndChairs){
            layoutParams =(RelativeLayout.LayoutParams)imageView.getLayoutParams();
            // To do convert oixels to dp
            layoutParams.leftMargin = 20;
            layoutParams.topMargin = 20;
            imageView.setLayoutParams(layoutParams);

            if(imageView.getParent() != null) ((ViewGroup)imageView.getParent()).removeView(imageView);

            rel.addView(imageView);
            imageView.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int index = Integer.valueOf(v.getTag().toString());
                    layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                    switch(event.getActionMasked())
                    {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            //Move object to another place
                            int x_cord = (int) event.getRawX();
                            int y_cord = (int) event.getRawY();
                            if (x_cord > width) {
                                x_cord = width;
                            }
                            if (y_cord > height) {
                                y_cord = height;
                            }
                            layoutParams.leftMargin = x_cord - 44;
                            layoutParams.topMargin = y_cord - 50;
                            imageView.setLayoutParams(layoutParams);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });




        }


        setContentView(rel);
    }



}