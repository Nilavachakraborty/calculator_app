package com.example.calculator_real;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    TextView result_tv, solution_tv;

    MaterialButton clear, open_bracket, close_bracket;
    MaterialButton seven, eight, nine, six, five, four, three , two, one;
    MaterialButton multiply,divide, minus, addition;
    MaterialButton auto, btn_zero, dot ,equal_to;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_tv = findViewById(R.id.result_tv);
        solution_tv = findViewById(R.id.solution_tv);

        assignId(clear,R.id.button_c);
        assignId(open_bracket, R.id.button_open_bracket);
        assignId(close_bracket,R.id.button_close_bracket);
        assignId(divide,R.id.button_divide);
        assignId(seven,R.id.seven);
        assignId(eight,R.id.eight);
        assignId(nine,R.id.button_nine);
        assignId(addition,R.id.button_plus);
        assignId(six,R.id.six);
        assignId(five,R.id.five);
        assignId(four,R.id.four);
        assignId(minus,R.id.button_minus);
        assignId(three,R.id.three);
        assignId(two,R.id.two);
        assignId(one,R.id.one);
        assignId(multiply,R.id.button_multiply);
        assignId(auto,R.id.AC);
        assignId(btn_zero,R.id.zero);
        assignId(dot,R.id.dot);
        assignId(equal_to,R.id.button_equal);

    }
    void  assignId(MaterialButton btn , int id){
         btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    MaterialButton button = (MaterialButton) view;
    String buttonText = button.getText().toString();
    String datatocalculate = solution_tv.getText().toString();

    if(buttonText.equals("AC")){
        solution_tv.setText("");
        result_tv.setText("0");

    }
    if(buttonText.equals("C")){
        datatocalculate = datatocalculate.substring(0, datatocalculate.length()-1);
    }else{
        datatocalculate = datatocalculate + buttonText;
    }



    solution_tv.setText(datatocalculate);

    }
     String getResult(String data){
        try{
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            context.evaluateString(scriptable, data, "javascript", 1, null).toString();
        }catch (Exception e){
            return "error";
        }
        return "result";
     }
}