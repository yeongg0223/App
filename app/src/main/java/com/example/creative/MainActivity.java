package com.example.creative;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import android.widget.ViewFlipper;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    ImageView imageView;
    TextView txtBusnum, txtRestime, txtDepart, txtArrive;
    Button btnCancel, button8;
    ViewFlipper viewFlipper; // ViewFlipper 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        imageView = findViewById(R.id.imageView);
        txtBusnum = findViewById(R.id.txtBusnum);
        txtRestime = findViewById(R.id.txtRestime);
        txtDepart = findViewById(R.id.txtDepart);
        txtArrive = findViewById(R.id.txtArrive);
        btnCancel = findViewById(R.id.btnCancel);
        viewFlipper = findViewById(R.id.viewFlipper);
        button8 = findViewById(R.id.button8);

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

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });



    }
}
