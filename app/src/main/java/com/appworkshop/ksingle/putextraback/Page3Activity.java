package com.appworkshop.ksingle.putextraback;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ksingle on 2017/9/1.
 */

public class Page3Activity extends AppCompatActivity{
    private int sourcePosition;
    private TextView source;
    private int PAGE_POSITION = 3;

    private int RESULTCODE_FROM_PAGE2 = 2;
    private int RESULTCODE_FROM_PAGE3 = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        sourcePosition = getIntent().getIntExtra("source_position",0);

        source = (TextView) findViewById(R.id.source);
        String feedbackText = "last position: " + getIntent().getIntExtra("source_position",0);

        source.setText(feedbackText);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sourcePosition == 0){
                    Toast.makeText(Page3Activity.this,"Unknown Source Page",Toast.LENGTH_SHORT).show();
                }else{
                    setFeedback();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (sourcePosition == 0){
            Toast.makeText(Page3Activity.this,"Unknown Source Page",Toast.LENGTH_SHORT).show();
        }else{
            setFeedback();
        }
    }
    private void setFeedback(){
        if (sourcePosition == 1){
            Intent feedback = new Intent(Page3Activity.this,Page1Activity.class);
            feedback.putExtra("source_position",PAGE_POSITION);
            setResult(RESULTCODE_FROM_PAGE3,feedback);
            finish();
        }else if (sourcePosition == 2){
            Intent feedback = new Intent(Page3Activity.this,Page2Activity.class);
            feedback.putExtra("source_position",PAGE_POSITION);
            setResult(RESULTCODE_FROM_PAGE3,feedback);
            finish();
        }
    }
}
