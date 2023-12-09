package com.example.creative;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.creative.utils.BusApiUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SecondActivity extends Activity {
    EditText editsearch2;
    TextView txtRecord, txtNumrecord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        editsearch2 = (EditText) findViewById(R.id.editsearch2);
        txtRecord = (TextView) findViewById(R.id.txtRecord);
        txtNumrecord = (TextView) findViewById(R.id.txtNumrecord);


        editsearch2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)) {
                    // 사용자 입력 검증 (예: 숫자 여부 확인)
                    try {
//                        int num = Integer.parseInt(editsearch2.getText().toString());
//                        // Intent를 사용하여 ThirdActivity로 이동
//                        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
//                        intent.putExtra("Num1", num);
//                        startActivity(intent);

                        String busNum = String.valueOf(editsearch2.getText());
                        NetworkTask networkTask = new NetworkTask(busNum);
                        networkTask.execute();

                        // 키보드 숨기기
                        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editsearch2.getWindowToken(), 0);

                        return true; // 이벤트 처리를 완료했음을 반환
                    } catch (NumberFormatException e) {
                        // 숫자로 변환할 수 없는 입력에 대한 처리 (예: 에러 메시지 표시)
                        // 사용자에게 올바른 입력을 요청하는 메시지를 표시하는 것이 좋습니다.
                    }
                }
                return false; // 이벤트 처리를 계속 진행
            }
        });
    }

    public class NetworkTask extends AsyncTask<Void, Void, Map<String, Object>> {
        private String busNum;

        public NetworkTask(String busNum) {
            this.busNum = busNum;
        }
        @Override
        protected Map<String, Object> doInBackground(Void... params) {

            List<Map<String, Object>> infoList = BusApiUtil.getBusRouteList(busNum);
            Map<String, Object> retMap = null;
            if(infoList != null && infoList.size() > 0) {
                retMap = infoList.get(0);
            }

            return retMap;
        }

        @Override
        protected void onPostExecute(Map<String, Object> map) {
            super.onPostExecute(map);

            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            if(map == null) {
                Toast.makeText(getApplicationContext(),busNum + "는 없는 버스번호입니다.", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("busInfo", (Serializable) map);
                startActivity(intent);
            }
        }
    }
}
