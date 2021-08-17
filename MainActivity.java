package com.example.minimalcalcy;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    Button btn_clear, btn_add, btn_sub, btn_mul, btn_div, btn_backspace, btn_right, btn_decimal, btn_left, btn_equals;
    TextView input, output;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 =findViewById(R.id.btn_0);
        btn_1 =findViewById(R.id.btn_1);
        btn_2 =findViewById(R.id.btn_2);
        btn_3 =findViewById(R.id.btn_3);
        btn_4 =findViewById(R.id.btn_4);
        btn_5 =findViewById(R.id.btn_5);
        btn_6 =findViewById(R.id.btn_6);
        btn_7 =findViewById(R.id.btn_7);
        btn_8 =findViewById(R.id.btn_8);
        btn_9 =findViewById(R.id.btn_9);

        btn_clear =findViewById(R.id.btn_clear);
        btn_add =findViewById(R.id.btn_add);
        btn_sub =findViewById(R.id.btn_sub);
        btn_mul =findViewById(R.id.btn_mul);
        btn_div =findViewById(R.id.btn_div);
        btn_backspace =findViewById(R.id.btn_backspace);
        btn_right =findViewById(R.id.btn_right);
        btn_decimal =findViewById(R.id.btn_decimal);
        btn_left =findViewById(R.id.btn_left);
        btn_equals =findViewById(R.id.btn_equals);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s0", data));
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s1", data));
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s2", data));
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s3", data));
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s4", data));
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s5", data));
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s6", data));
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s7", data));
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s8", data));
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s9", data));
            }
        });
        btn_decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s.", data));
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s+", data));
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s-", data));
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%sx", data));
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s/", data));
            }
        });
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s(", data));
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(String.format("%s)", data));
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
                output.setText("");
            }
        });
        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();

                data = data.replaceAll("x", "*");
                data = data.replaceAll("/", "/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String result = "";

                Scriptable scriptable = rhino.initStandardObjects();
                result = rhino.evaluateString(scriptable, data, "Javascript", 1, null).toString();
                output.setText(result);
            }
        });
        btn_backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = input.getText().toString();
                if (str.length() >1 ) {
                    str = str.substring(0, str.length() - 1);
                    input.setText(str);
                }
                else if (str.length() <=1 ) {
                    input.setText("");
                }
            }
        });
    }
}