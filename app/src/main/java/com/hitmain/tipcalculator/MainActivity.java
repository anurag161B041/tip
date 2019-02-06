package com.hitmain.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editText;
    private SeekBar seekBar;
    private Button button;
    private TextView textView;
    private TextView textviewseekbar;
    private TextView totalBill;
    private Float enteredBillFloat;
    private int seekbarPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText) findViewById(R.id.editTextID);
        seekBar=(SeekBar)findViewById(R.id.seekBarID);
        textView=(TextView)findViewById(R.id.resultTextView);
        totalBill=(TextView)findViewById(R.id.totalBillID);
        textviewseekbar=(TextView)findViewById(R.id.seekbarTextView);
        button=(Button)findViewById(R.id.buttonID);

        button.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textviewseekbar.setText(String.valueOf(seekBar.getProgress()) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekbarPercentage=seekBar.getProgress();
            }
        });

    }
    @Override
    public void onClick(View v){
        calculate();

    }
    public void calculate(){
        float result=0.0f;
        if(!editText.getText().toString().equals("")){
            enteredBillFloat=Float.parseFloat(editText.getText().toString());
            result = enteredBillFloat*seekbarPercentage/100;
            textView.setText("Your tip will be" +"$" + String.valueOf(result));
            totalBill.setText("Total bill will be." + "$"+ String.valueOf(enteredBillFloat+result));


        }else{
            Toast.makeText(MainActivity.this,"Please enter some bill amount.",Toast.LENGTH_LONG).show();
        }
    }
}
