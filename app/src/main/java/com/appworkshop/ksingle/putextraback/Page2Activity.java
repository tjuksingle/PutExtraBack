package com.appworkshop.ksingle.putextraback;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ksingle on 2017/9/1.
 */

public class Page2Activity extends AppCompatActivity{
    private TextView source;
    private int PAGE_POSITION = 2;

    private int REQUESTCODE_TOPAGE3_THROUGH_PAGE2 = 0;

    private int RESULTCODE_FROM_PAGE3 = 3;
    private int RESULTCODE_FROM_PAGE2 = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);


        source = (TextView) findViewById(R.id.source);
        String feedbackText = "last position: " + getIntent().getIntExtra("source_position",0);

        source.setText(feedbackText);

        Button toPage3 = (Button) findViewById(R.id.topage3);
        toPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page2Activity.this,Page3Activity.class);
                intent.putExtra("source_position",PAGE_POSITION);
                startActivityForResult(intent,REQUESTCODE_TOPAGE3_THROUGH_PAGE2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        Intent feedback = new Intent(Page2Activity.this,Page1Activity.class);
        feedback.putExtra("source_position",data.getIntExtra("source_position",0));
        setResult(RESULTCODE_FROM_PAGE3,feedback);
        finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent feedback = new Intent(Page2Activity.this,Page1Activity.class);
        feedback.putExtra("source_position",PAGE_POSITION);
        setResult(RESULTCODE_FROM_PAGE2,feedback);
        finish();
    }
}
