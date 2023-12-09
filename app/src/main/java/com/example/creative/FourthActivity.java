package com.example.creative;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.creative.utils.BusApiUtil;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FourthActivity extends Activity {
    EditText editsearch4;
    Button button4,button44,button5,button6,button7, button8;
    TextView txt,txttime2,txtseoul2,textV,textV4; //,tvYear, tvMonth, tvDay, textV2,textV3;
    CalendarView calendarView;
    int selectYear, selectMonth, selectDay;
    Integer value2;
    ImageView imageView,imageView2;
    ViewFlipper viewFlipper;

    TextInputLayout textInputLayout1, textInputLayout2;
    AutoCompleteTextView autoCompleteTextView1, autoCompleteTextView2;

    String busRouteId, stNm1, stId1, stNm2, stId2, staOrd, busPos2;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();

        if(v == textV4) {
            mInflater.inflate(R.menu.menu3, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemTime1:
                textV4.setText("13:00");
                break;
            case R.id.itemTime2:
                textV4.setText("13:30");
                break;
            case R.id.itemTime3:
                textV4.setText("14:00");
                break;
            case R.id.itemTime4:
                textV4.setText("14:30");
                break;
            case R.id.itemTime5:
                textV4.setText("15:00");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);

        editsearch4 = (EditText)findViewById(R.id.editsearch4);
//        textV2 = (TextView) findViewById(R.id.textV2);
//        textV3 = (TextView) findViewById(R.id.textV3);
        textV4 = (TextView) findViewById(R.id.textV4);
        txt = (TextView)findViewById(R.id.txt);
        txttime2 = (TextView)findViewById(R.id.txttime2);
        txtseoul2 = (TextView)findViewById(R.id.txtseoul2);
        textV = (TextView)findViewById(R.id.textV);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        button4 = (Button) findViewById(R.id.button4);
        button44 = (Button) findViewById(R.id.button44);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        calendarView = (CalendarView)findViewById(R.id.calendarView);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        textInputLayout1 = findViewById(R.id.select_layout1);
        autoCompleteTextView1 = findViewById(R.id.select_item1);
        textInputLayout2 = findViewById(R.id.select_layout2);
        autoCompleteTextView2 = findViewById(R.id.select_item2);

//        registerForContextMenu(textV2);
//        registerForContextMenu(textV3);
        registerForContextMenu(textV4);

        imageView.setImageResource(R.drawable.busicon);

        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textV.setVisibility(View.VISIBLE);
                viewFlipper.setVisibility(View.VISIBLE);
                button44.setVisibility(View.INVISIBLE);
                imageView2.setImageResource(R.drawable.change);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showNext();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showNext();
            }
        });

//        textV2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openContextMenu(textV2);
//            }
//        });
//
//        textV3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openContextMenu(textV3);
//            }
//        });

        textV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContextMenu(textV4);
            }
        });



        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // AlertDialog.Builder를 사용하여 팝업 창을 생성
                AlertDialog.Builder builder = new AlertDialog.Builder(FourthActivity.this);

                builder.setTitle("예약하시겠습니까?"); // 팝업 창 제목
                //builder.setMessage("2023.09.15 (금)\n1224번 삼육서울병원(중) → 청량리미주상가앞\n13:00"); // 팝업 창 메시지
                builder.setMessage(selectYear + "." + selectMonth + "." + selectDay + "\n"+ txt.getText()+"번 "+ stNm1 + "→" +stNm2+"\n"+textV4.getText().toString());

                // 확인 버튼을 눌렀을 때의 동작 설정
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // MainActivity로 이동하는 코드를 여기에 추가
                        Intent intent = new Intent(FourthActivity.this, MainActivity.class);

                        //데이터 연결
                        intent.putExtra("selectYear", String.valueOf(selectYear));
                        intent.putExtra("selectMonth", String.valueOf(selectMonth));
                        intent.putExtra("selectDay", String.valueOf(selectDay));
                        intent.putExtra("txt", txt.getText().toString());
                        intent.putExtra("textV3", stNm2);
                        intent.putExtra("textV2", stNm1);
                        intent.putExtra("textV4", textV4.getText().toString());
                        intent.putExtra("keyForValue", textV4.getText().toString());
                        intent.putExtra("busNum", txt.getText().toString());
                        intent.putExtra("busPos", txtseoul2.getText().toString());
                        intent.putExtra("busPos2", busPos2);
                        intent.putExtra("busTime", txttime2.getText().toString());
                        intent.putExtra("busRouteId", busRouteId);
                        intent.putExtra("stationId", stId1);
                        intent.putExtra("staOrd", staOrd);

                       //intent.getIntExtra("textV4", 0);

                        startActivity(intent);


                        //Toast.makeText(getApplicationContext(), "예약이 완료되었습니다.\n2023.09.15 13:00 1224번", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "예약이 완료되었습니다.\n"+selectYear + "." + selectMonth + "." + selectDay + "\n"+txt.getText()+"번 ", Toast.LENGTH_SHORT).show();
                        Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                        vib.vibrate(1000);

                    }
                });

                // 취소 버튼을 눌렀을 때의 동작 설정
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 팝업 창을 닫습니다.
                        dialog.dismiss();
                    }
                });

                // AlertDialog 객체를 생성하고 팝업 창을 표시
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                selectYear = i; //년
                selectMonth = i1+1; //월  특별히 달은 0부터 시작하여 1을 더해줌
                selectDay = i2; //일


            }
        });

                Intent intent = getIntent();
        value2 = intent.getIntExtra("Num2",0);
        String busNum = intent.getStringExtra("busNum");
        String busPos = intent.getStringExtra("busPos");
        String busTerm = intent.getStringExtra("busTerm");

        busPos2 = intent.getStringExtra("busPos2");
        busRouteId = intent.getStringExtra("busRouteId");
        editsearch4.setText(value2.toString());

        txt.setText(busNum);
        txtseoul2.setText(busPos);
        txttime2.setText(busTerm);

        NetworkTask2 networkTask = new NetworkTask2(busRouteId);
        networkTask.execute();
    }
    public class NetworkTask2 extends AsyncTask<Void, Void, List<Map<String, Object>>> {
        private String busRouteId;

        public NetworkTask2(String busRouteId) {
            this.busRouteId = busRouteId;
        }
        @Override
        protected List<Map<String, Object>> doInBackground(Void... params) {

            List<Map<String, Object>> infoList = BusApiUtil.getArrInfoByRouteAllList(busRouteId);

            return infoList;
        }

        @Override
        protected void onPostExecute(List<Map<String, Object>> infoList) {
            super.onPostExecute(infoList);

            List<String> stationList = new ArrayList<>();
            for(Map<String, Object> info : infoList) {
                stationList.add((String)info.get("stNm"));
            }
            ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(FourthActivity.this, R.layout.dropdown_item, stationList);
            autoCompleteTextView1.setAdapter(itemAdapter);
            autoCompleteTextView2.setAdapter(itemAdapter);


            autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    stNm1 = ((String)adapterView.getItemAtPosition(position));
                    Map<String, Object> tmpMap = infoList.get(position);
                    stId1 = (String)tmpMap.get("stId");
                    staOrd = (String)tmpMap.get("staOrd");
                }
            });
            autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    stNm2 = ((String)adapterView.getItemAtPosition(position));
                    Map<String, Object> tmpMap = infoList.get(position);
                    stId2 = (String)tmpMap.get("stId");
                }
            });
        }
    }
}
