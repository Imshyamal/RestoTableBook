package com.example.andiroot.restotablebook;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ImageView img;
    private String msg = "resto_chairtab";
    private Random rand = new Random();
    RelativeLayout.LayoutParams layoutParams;

    RelativeLayout rel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
        rel = (RelativeLayout)findViewById(R.id.second);

    }








    private void setListeners() {
        findViewById(R.id.btnMainScreen).setOnClickListener(this);
        findViewById(R.id.btnAddTable).setOnClickListener(this);
        findViewById(R.id.btnChair).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {











        switch (view.getId()){
            case R.id.btnMainScreen:
             //   startActivity(new Intent(getApplicationContext(),TableManager.class));
                Globals.tablesAndChairs.clear();
                clarall();
                Toast.makeText(this, "Hall Cleared", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnAddTable:
                addImage(R.drawable.table2);

                Toast.makeText(this, R.string.table_added, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnChair:
                addImage2(R.drawable.chair2);
                Toast.makeText(this, R.string.child_added, Toast.LENGTH_SHORT).show();
                break;
        }

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


     /*   rel.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));*/
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
                           layoutParams.leftMargin = x_cord - 50;
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


       // setContentView(rel);










    }

    private void clarall() {
        rel.removeAllViews();



    }

    private void addImage(int image){
        ImageView img = new ImageView(this);
        img.setImageResource(image);
        img.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        img.setAdjustViewBounds(true);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        img.setMaxHeight(300);
        img.setMaxWidth(300);
        img.setMinimumHeight(300);
        img.setMinimumWidth(300);
        img.setTag(new Random().nextInt());
        Globals.tablesAndChairs.add(img);
    }
    private void addImage2(int image){
        ImageView img = new ImageView(this);
        img.setImageResource(image);
        img.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        img.setAdjustViewBounds(true);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        img.setMaxHeight(100);
        img.setMaxWidth(100);
        img.setMinimumHeight(100);
        img.setMinimumWidth(100);
        img.setTag(new Random().nextInt());
        Globals.tablesAndChairs.add(img);
    }







}
