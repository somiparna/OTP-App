package com.example.otp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class MainActivity extends AppCompatActivity {

    EditText pin1,pin2,pin3,pin4;
    StringBuilder sb=new StringBuilder();
    public static int KEYCODE_DEL=67;
    int c1=0,c2=0,c3=0,c4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Pinview pinview = (Pinview)findViewById(R.id.pinOTP);
//        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
//            @Override
//            public void onDataEntered(Pinview pinview, boolean fromUser) {
//                Toast.makeText(MainActivity.this,""+pinview.getValue(),Toast.LENGTH_SHORT).show();
//            }
//        });

        pin1= findViewById(R.id.pin1);
        pin2= findViewById(R.id.pin2);
        pin3= findViewById(R.id.pin3);
        pin4= findViewById(R.id.pin4);

//        pin1.addTextChangedListener(this);
//        pin1.setOnKeyListener(this);

        pin1.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(sb.length()==0& pin1.length()==1)
                {
                    sb.append(s);
                    pin1.clearFocus();
                    pin2.requestFocus();
                    pin2.setCursorVisible(true);
                    c1=0;
                    Log.e("t1",""+sb);

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

                if(sb.length()==1)
                {

                    sb.deleteCharAt(0);

                }

            }

            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {

                    pin1.requestFocus();
                }

            }
        });

        pin2.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(sb.length()==0& pin2.length()==1)
                {
                    sb.append(s);
                    pin2.clearFocus();
                    pin3.requestFocus();
                    pin3.setCursorVisible(true);
                    c2=0;
                    Log.e("t2",""+sb);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

                if(sb.length()==1)
                {

                    sb.deleteCharAt(0);

                }

            }

            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {

                    pin2.requestFocus();
                }

            }
        });

        pin3.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(sb.length()==0& pin3.length()==1)
                {
                    sb.append(s);
                    pin3.clearFocus();
                    pin4.requestFocus();
                    pin4.setCursorVisible(true);
                    c3=0;
                    Log.e("t3",""+sb);

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

                if(sb.length()==1)
                {

                    sb.deleteCharAt(0);

                }

            }

            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {

                    pin3.requestFocus();
                }

            }
        });

        pin4.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(sb.length()==0& pin4.length()==1)
                {
                    sb.append(s);
                    pin4.clearFocus();
                    Log.e("t4",""+sb);
                    c4=0;

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

                if(sb.length()==1)
                {

                    sb.deleteCharAt(0);

                }


            }

            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {
                    pin4.requestFocus();
                }

            }
        });

        pin1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.e("pin 1", "backspace");
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if(keyCode == KeyEvent.KEYCODE_DEL && c1==0) {
                    pin1.setText(null);
                    c1=1;
                    Log.e("c1","pin1 cleared");
                }
                return false;
            }
        });

        pin2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.e("pin 2", "backspace");
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if(keyCode == KeyEvent.KEYCODE_DEL && c2==0) {
                    //this is for backspace
                    Log.e("c2","pin2 cleared");
                    pin2.setText(null);
                    c2=1;
                }
                else if(keyCode == KeyEvent.KEYCODE_DEL && c2==1){
                    Log.e("d2","pn2 clear");
                    pin2.clearFocus();
                    pin1.requestFocus();
                    pin1.setCursorVisible(true);
                }
                return false;
            }
        });
        pin3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.e("pin 3", "backspace");
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if(keyCode == KeyEvent.KEYCODE_DEL && c3==0) {
                    //this is for backspace
                    Log.e("c3","pin3 cleared");
                    pin3.setText(null);
                    c3=1;
                }
                else if(keyCode == KeyEvent.KEYCODE_DEL && c3==1){
                    Log.e("d3","pn3 clear");
                    pin3.clearFocus();
                    pin2.requestFocus();
                    pin2.setCursorVisible(true);
                }
                return false;
            }
        });
        pin4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_

                Log.e("pin 4", "backspace");

                if(keyCode == KeyEvent.KEYCODE_DEL && c4==0) {
                    //this is for backspace
                    Log.e("c4","pin4 cleared");
                    pin4.setText(null);
                    c4=1;
                }
                else if(keyCode == KeyEvent.KEYCODE_DEL && c4==1){
                    Log.e("d4","pin4 clear");
                    pin4.clearFocus();
                    pin3.requestFocus();
                    pin3.setCursorVisible(true);
                }
                return false;
            }
        });

    }
}

//public class KeyEvent  extends InputEvent implements Parcelable {
//
//    @Override
//    public int getDeviceId() {
//        return 0;
//    }
//
//    @Override
//    public int getSource() {
//        return 0;
//    }
//
//    @Override
//    public long getEventTime() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//
//    }
//}