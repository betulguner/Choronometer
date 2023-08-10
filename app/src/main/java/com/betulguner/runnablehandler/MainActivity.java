package com.betulguner.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button button;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button =findViewById(R.id.button);
        button2 =findViewById(R.id.button2);
        button3 =findViewById(R.id.button3);
        number=0;

    }

    public void start(View view)
    {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run()
            {
                textView.setText("Time:" +number);
                number++;
                textView.setText("Time:" +number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);
    }

    public void restart(View view)
    {
        button.setEnabled(false);

        handler.removeCallbacks(runnable);
        number = 0;
        textView.setText("Time: " + number);


        //start işlemine başlıyor
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run()
            {
                textView.setText("Time:" +number);
                number++;
                textView.setText("Time:" +number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);

    }

    public void stop(View view)
    {
        button.setEnabled(true);

        handler.removeCallbacks(runnable);
        textView.setText("Time: " + number);
    }
}