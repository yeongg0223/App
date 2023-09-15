package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ThirdActivity extends Activity {
    EditText editsearch3;
    TextView txt1224,txtseoul, txttime;
    Integer value1;
    ImageView imgBus, imgMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        txt1224 = (TextView) findViewById(R.id.txt1224);
        txtseoul = (TextView) findViewById(R.id.txtseoul);
        txttime = (TextView) findViewById(R.id.txttime);
        editsearch3 = (EditText) findViewById(R.id.editsearch3);
        imgBus = (ImageView) findViewById(R.id.imgBus);
        imgMap = (ImageView) findViewById(R.id.imgMap) ;


        txt1224.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FourthActivity.class);
                intent.putExtra("Num2", value1);
                startActivity(intent);
            }
        });



        Intent intent = getIntent();
        value1 = intent.getIntExtra("Num1",0);

        editsearch3.setText(value1.toString()); //버스번호 자동 입력//


    }
}
