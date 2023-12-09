package com.example.creative;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Map;

public class ThirdActivity extends Activity {
    EditText editsearch3;
    TextView txt1224,txtseoul, txttime;
    Integer value1;
    ImageView imgBus, imgMap,imageView4;
    private boolean isStar1Displayed = true;
    String busRouteId = "";
    String busPos2 = "";

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
        imageView4=(ImageView)findViewById(R.id.imageView4);


        txt1224.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FourthActivity.class);
                intent.putExtra("Num2", value1);
                intent.putExtra("busRouteId", busRouteId);
                intent.putExtra("busNum", txt1224.getText());
                intent.putExtra("busPos", txtseoul.getText());
                intent.putExtra("busPos2", busPos2);
                intent.putExtra("busTerm", txttime.getText());
                startActivity(intent);
            }
        });

        imageView4.setImageResource(R.drawable.star1);

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStar1Displayed) {
                    imageView4.setImageResource(R.drawable.star2);

                } else {
                    imageView4.setImageResource(R.drawable.star1);
                }

                // 상태 업데이트
                isStar1Displayed = !isStar1Displayed;
            }
        });

        Intent intent = getIntent();
        Map<String, Object> busInfoMap = (Map<String, Object>)intent.getSerializableExtra("busInfo");
        busRouteId = (String) busInfoMap.get("busRouteId");
        String busRouteNm = (String) busInfoMap.get("busRouteNm");
        String stStationNm = (String) busInfoMap.get("stStationNm");
        String edStationNm = (String) busInfoMap.get("edStationNm");
        String firstBusTm = (String) busInfoMap.get("firstBusTm");  // 20231209041000
        String lastBusTm = (String) busInfoMap.get("lastBusTm");    // 20231209223000
        String term = (String) busInfoMap.get("term");

        String tmp01 = "서울 | " + stStationNm + " ~ " + edStationNm;
        String tmp02 = firstBusTm.substring(8, 10) + ":" + firstBusTm.substring(10, 12)
                        + " ~ " + lastBusTm.substring(8, 10) + ":" + lastBusTm.substring(10, 12)
                        + "  *배차간격 " + term + "분";
        String tmp03 = "서울 | " + stStationNm + "\n~ " + edStationNm;

        busPos2 = tmp03;
        value1 = Integer.parseInt(busRouteNm);
        editsearch3.setText(value1.toString()); //버스번호 자동 입력//
        txt1224.setText(busRouteNm);
        txtseoul.setText(tmp01);
        txttime.setText(tmp02);
    }
}
