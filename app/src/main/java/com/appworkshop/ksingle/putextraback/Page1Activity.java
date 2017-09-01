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

public class Page1Activity extends AppCompatActivity{
    private TextView source;
    private int PAGE_POSITION = 1;

    private int REQUESTCODE_TOPAGE3_THROUGH_PAGE2 = 0;
    private int REQUESTCODE_TOPAGE3_DIRECTLY = -1;

    private int RESULTCODE_FROM_PAGE2 = 2;
    private int RESULTCODE_FROM_PAGE3 = 3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        source = (TextView) findViewById(R.id.source);

        Button toPage2 = (Button) findViewById(R.id.topage2);
        toPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page1Activity.this,Page2Activity.class);
                intent.putExtra("source_position",PAGE_POSITION);
                startActivityForResult(intent,REQUESTCODE_TOPAGE3_THROUGH_PAGE2);
            }
        });
        Button toPage3 = (Button) findViewById(R.id.topage3);
        toPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page1Activity.this,Page3Activity.class);
                intent.putExtra("source_position",PAGE_POSITION);
                startActivityForResult(intent,REQUESTCODE_TOPAGE3_DIRECTLY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        String feedbackText = "last position: "+data.getIntExtra("source_position",0);
        source.setText(feedbackText);
        /*if (requestCode == REQUESTCODE_TOPAGE3_THROUGH_PAGE2 && resultCode == RESULTCODE_FROM_PAGE2){
            source.setText(feedbackText);
        }else if (requestCode == REQUESTCODE_TOPAGE3_THROUGH_PAGE2 &&requestCode == RESULTCODE_FROM_PAGE3){
            source.setText(feedbackText);
        }else if...*/
    }

}
