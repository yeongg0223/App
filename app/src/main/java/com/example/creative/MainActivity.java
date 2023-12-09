package com.example.creative;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hardware.camera2.params.BlackLevelPattern;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.creative.utils.BusApiUtil;

import android.widget.Toast;
import android.widget.ViewFlipper;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //ConstraintLayout constraintLayout3;
    MeowBottomNavigation bottomNavigation;
    ImageView imageView,imageView3,imageView5,imageView6;
    TextView txtBusnum, txtRestime, txtDepart, txtArrive,textView,title1,textVie1,textVie2,textVie3,textView1,textView11,textView5,textView6,textView7,textView8,textView12;
    Button btnCancel, button8,button4,button5,button6,button7,button2;
    ViewFlipper viewFlipper; // ViewFlipper 선언
    private boolean isStar1Displayed = true;
    private String busRouteId, stationId, staOrd;




    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        if (v==button5) {
            menu.setHeaderTitle("언어 설정");
            mInflater.inflate(R.menu.menu4, menu);
        }
    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemlanguage1:
                button4.setText("알림 설정");
                button5.setText("언어 설정");
                button6.setText("버전 정보");
                button7.setText("고객센터");
                textView.setText("권가은");
                button2.setText("회원정보 수정");
                button8.setText("신규 예약하기");
                txtBusnum.setText("버스를 예약하세요");
                txtArrive.setText("예약 현황이 없습니다.");
                return true;
            case R.id.itemlanguage2:
                button4.setText("Notification settings");
                button5.setText("Language Settings");
                button6.setText("Version Information");
                button7.setText("Customer Service");
                textView.setText("Kwon Ga Eun");
                button2.setText ("Member Information Correction");
                button8.setText("To make a new reservation");
                txtBusnum.setText("Please reserve a bus");
                txtArrive.setText("There is no reservation status");
                return true;
            case R.id.itemlanguage3:
                button4.setText("通知設定");
                button5.setText("言語設定");
                button6.setText("バージョン情報");
                button7.setText("カスタマーセンター");
                textView.setText("クォンガウン");
                button2.setText("会員情報修正");
                button8.setText("新規予約");
                txtBusnum.setText("バスを予約してください");
                txtArrive.setText("予約状況がありません。");
                return true;
        }
        return super.onContextItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ConstraintLayout constraintLayout3 = findViewById(R.id.constraintLayout3);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        imageView = findViewById(R.id.imageView);
        imageView3 = findViewById(R.id.imageView3);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        txtBusnum = findViewById(R.id.txtBusnum);
        txtRestime = findViewById(R.id.txtRestime);
        txtDepart = findViewById(R.id.txtDepart);
        txtArrive = findViewById(R.id.txtArrive);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        textView11 = findViewById(R.id.textView11);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView12 = findViewById(R.id.textView12);
        title1 = findViewById(R.id.title1);
        textVie1 = findViewById(R.id.textVie1);
        textVie2 = findViewById(R.id.textVie2);
        textVie3 = findViewById(R.id.textVie3);
        btnCancel = findViewById(R.id.btnCancel);
        viewFlipper = findViewById(R.id.viewFlipper);
        button8 = findViewById(R.id.button8);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button2 = findViewById(R.id.button2);

        registerForContextMenu(button5);

        // ViewFlipper에서 첫 번째 뷰를 보여줌 (2번 탭이 선택되었을 때)
        viewFlipper.setDisplayedChild(0);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_star_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_settings_24));

        // 기본적으로 2번 탭을 선택하도록 설정
        bottomNavigation.show(2, true);

        bottomNavigation.setOnClickMenuListener(item -> {
            int selectedTab = item.getId();
            switch (selectedTab) {
                case 1:
                    viewFlipper.setDisplayedChild(2);
                    viewFlipper.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    viewFlipper.setDisplayedChild(0);
                    viewFlipper.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    viewFlipper.setDisplayedChild(1);
                    viewFlipper.setVisibility(View.VISIBLE);
                    break;
                default:
                    viewFlipper.setVisibility(View.GONE);
                    break;
            }
            return null;
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
                startActivity(intent);
            }
        });



        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openContextMenu(button5);
               // Intent intent = new Intent(MainActivity.this, LanguageActivity.class);
               // startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VersionActivity.class);
                startActivity(intent);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

                //constraintLayout3.setVisibility(android.view.View.VISIBLE);

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("예약을 취소하시겠습니까?");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                        vib.vibrate(1000);
                        Toast.makeText(getApplicationContext(), "예약이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // 이 부분에 원하는 코드를 추가하세요
                                txtRestime.setVisibility(View.INVISIBLE);
                                txtDepart.setVisibility(View.INVISIBLE);
                                txtArrive.setText("예약 현황이 없습니다.");
                                txtBusnum.setText("버스를 예약하세요");
                                txtBusnum.setTextSize(22);
                                btnCancel.setVisibility(View.INVISIBLE);
                            }
                        }, 100); // 1초(2000 milliseconds) 지연
                    }
                });
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
        Intent intent = getIntent();
        busRouteId = intent.getStringExtra("busRouteId");
        stationId = intent.getStringExtra("stationId");
        staOrd = intent.getStringExtra("staOrd");

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkTask3 networkTask = new NetworkTask3(stationId, busRouteId, staOrd);
                networkTask.execute();
            }
        });
        imageView3.setImageResource(R.drawable.star2);

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStar1Displayed) {
                    imageView3.setImageResource(R.drawable.star1);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("즐겨찾기를 해제하시겠습니까?");
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                            vib.vibrate(1000);
                            Toast.makeText(getApplicationContext(), "즐겨찾기가 해제되었습니다.", Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // 이 부분에 원하는 코드를 추가하세요
                                    textVie2.setVisibility(View.INVISIBLE);
                                    textVie3.setVisibility(View.INVISIBLE);
                                    textView1.setText("즐겨찾는 버스를 등록해 보세요 :)");
                                    textView1.setTextSize(18);
                                    textView1.setTypeface(null, Typeface.NORMAL);
                                    textView1.setTextColor(Color.GRAY);
                                    textView1.setPadding(130, 50, 20, 0);
                                    textView11.setVisibility(View.VISIBLE);
                                    textView11.setVisibility(View.INVISIBLE);
                                    textView5.setVisibility(View.INVISIBLE);
                                    textView6.setVisibility(View.INVISIBLE);
                                    textView7.setVisibility(View.INVISIBLE);
                                    textView8.setVisibility(View.INVISIBLE);
                                    imageView3.setVisibility(View.INVISIBLE);
                                    imageView5.setVisibility(View.INVISIBLE);
                                }
                            }, 1000); // 1초(2000 milliseconds) 지연
                        }
                    });
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

                } else {
                    imageView3.setImageResource(R.drawable.star2);
                }

                // 상태 업데이트
                isStar1Displayed = !isStar1Displayed;
            }
        });

        //if((txtRestime.getText().toString() == null || txtRestime.getText().toString().isEmpty()) &&
        //        (txtDepart.getText().toString() == null || txtDepart.getText().toString().isEmpty())){

        //}
        String receivedValue = intent.getStringExtra("keyForValue");

        if(( receivedValue == null || receivedValue.isEmpty())){

            txtBusnum.setTextSize(22);
            txtArrive.setText("예약 현황이 없습니다.");

        } else{
            //textVie1.setVisibility(View.VISIBLE);
            textVie2.setVisibility(View.VISIBLE);
            textVie3.setVisibility(View.VISIBLE);
            textView1.setText(intent.getStringExtra("textV2"));
            textView1.setTextSize(20);
            textView1.setTypeface(null, Typeface.BOLD);
            textView1.setTextColor(Color.BLACK);
            textView1.setPadding(30, 40, 335, 0);
            textView11.setVisibility(View.VISIBLE);
            textView11.setText(intent.getStringExtra("textV3")+"방면");
            textView5.setVisibility(View.VISIBLE);
            textView5.setText(intent.getStringExtra("txt"));
            textView6.setVisibility(View.VISIBLE);
            textView6.setText(intent.getStringExtra("busPos2"));  // 버스시작끝
            textView7.setVisibility(View.VISIBLE); //2번째전 == 가장 가까이 남은 버스 거리
            textView8.setVisibility(View.VISIBLE); //4번째전
            imageView3.setVisibility(View.VISIBLE);
            imageView5.setVisibility(View.VISIBLE);

            textView12.setVisibility(View.VISIBLE); //업로드 시간:
            imageView6.setVisibility(View.VISIBLE);

            //title1.setVisibility(View.VISIBLE);

            txtRestime.setVisibility(View.VISIBLE);
            txtDepart.setVisibility(View.VISIBLE);
            btnCancel.setVisibility(View.VISIBLE);
            txtBusnum.setText(intent.getStringExtra("txt"));
            txtBusnum.setTextSize(28);
            txtRestime.setText(intent.getStringExtra("selectYear") + "." + intent.getStringExtra("selectMonth") + "." +
                    intent.getStringExtra("selectDay") + "  " + intent.getStringExtra("textV4"));
            txtDepart.setText("출발지:"+intent.getStringExtra("textV2"));
            txtArrive.setText("도착지:"+intent.getStringExtra("textV3"));

            NetworkTask3 networkTask = new NetworkTask3(stationId, busRouteId, staOrd);
            networkTask.execute();

        }
    }
    public class NetworkTask3 extends AsyncTask<Void, Void, List<Map<String, Object>>> {
        private String stationId3;
        private String busRouteId3;
        private String staOrd3;

        public NetworkTask3(String stationId, String busRouteId, String staOrd) {
            this.stationId3 = stationId;
            this.busRouteId3 = busRouteId;
            this.staOrd3 = staOrd;
        }
        @Override
        protected List<Map<String, Object>> doInBackground(Void... params) {

            List<Map<String, Object>> infoList = BusApiUtil.getArrInfoByRouteList(stationId3, busRouteId3, staOrd3);

            return infoList;
        }

        @Override
        protected void onPostExecute(List<Map<String, Object>> infoList) {
            super.onPostExecute(infoList);

            if(infoList != null && infoList.size() > 0) {
                Map<String, Object> map = infoList.get(0);
                String arrMsg1 = (String) map.get("arrmsg1");
                String arrMsg2 = (String) map.get("arrmsg2");
                String mkTm = (String) map.get("mkTm");
                textView7.setText(arrMsg1);
                textView8.setText(arrMsg2);
                textView12.setText("  업로드 시간 : "+mkTm+"  ");

            } else {
                textView7.setText("정보없음");
                textView8.setText("정보없음");
                textView12.setText("정보없음");
            }

        }
    }
}
