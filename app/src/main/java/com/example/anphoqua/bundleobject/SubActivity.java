package com.example.anphoqua.bundleobject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class SubActivity extends AppCompatActivity{
    TextView textView_perimeter, textView_area;
    Button btn_back;
    int perimeter, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView_perimeter = findViewById(R.id.activity_sub_textview_perimeter);
        textView_area = findViewById(R.id.activity_sub_textview_area);
        btn_back = findViewById(R.id.activity_sub_btn_back);

        Rectangle rec = (Rectangle) getIntent().getExtras().getSerializable("rec");

        perimeter = (rec.width+rec.height)*2;
        area = rec.height*rec.width;

        textView_perimeter.setText(getString(R.string.activity_sub_textview_perimeter, perimeter+""));
        textView_area.setText((getString(R.string.activity_sub_textview_area, area+"")));

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("perimeter", perimeter);
                bundle.putInt("area", area);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
