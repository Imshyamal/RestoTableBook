package com.example.andiroot.restotablebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
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
        startActivity(new Intent(getApplicationContext(),TableManager.class));
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
