package com.example.anphoqua.bundleobject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText_width, editText_height;
    Button btn_solve;
    TextView textView_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_width = findViewById(R.id.activity_main_edt_width);
        editText_height = findViewById(R.id.activity_main_edt_height);
        btn_solve = findViewById(R.id.activity_main_btn_solve);
        textView_result = findViewById(R.id.activity_main_textview_result);

        btn_solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editText_width.getText().toString().trim());
                int b = Integer.parseInt(editText_height.getText().toString().trim());

                Rectangle rec = new Rectangle(a, b);

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("a", 12);
                bundle.putSerializable("rec",rec);
                intent.putExtras(bundle);
                startActivityForResult(intent, 5);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 && resultCode==RESULT_OK) {
            String perimeter = String.valueOf(data.getExtras().getInt("perimeter"));
            String area = String.valueOf(data.getExtras().getInt("area"));
            textView_result.setText(getString(R.string.activity_main_textview_result, perimeter, area));
        }
    }
}
