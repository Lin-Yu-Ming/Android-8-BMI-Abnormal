package com.example.android_num8_bmiabnormal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bmi_Answer();
    }
    //返回上一頁
    public void back_pageA(View v){
        finish();
    }
    private void bmi_Answer(){

        double Height;
        double Weight;
        double BMI ;
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null){
            DecimalFormat nf = new DecimalFormat("0.00");
            Height = Double.parseDouble(bundle.getString("Height")) / 100;
            Weight = Double.parseDouble(bundle.getString("Weight"));

            BMI = Weight / (Height * Height);

            TextView BMI_Value = (TextView)findViewById(R.id.BMI_value);
            BMI_Value.setText(nf.format(BMI));
            TextView Abnormal = (TextView)findViewById(R.id.result);
            //判斷式
            if (BMI < 18){
                Abnormal.setText("Abnormal(Weight to thin)");
            }
            else if (BMI > 24){
                Abnormal.setText("Abnormal(Weight to Heavy)");
            }
            else
                Abnormal.setText("Normal(Weight Normal)");
        }
    }
}