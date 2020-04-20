package com.vruddhi.bmi_calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    EditText height,weight;
    TextView result;
    Button calculate;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);
        reset = (Button) findViewById(R.id.reset);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }

    private void reset()
    {
        height.setText(null);
        weight.setText(null);
        result.setText(null);
    }
    private void calculateBMI()
    {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)  && weightStr != null && !"".equals(weightStr))
        {
            double heightValue = Float.parseFloat(heightStr) / 3.281;
            float weightValue = Float.parseFloat(weightStr);

            double bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);

        }

    }
    private void displayBMI(double bmi)
    {
        String bmiLabel = "";

        if (Float.compare((float) bmi,15f) <= 0)
        {
            bmiLabel = "Very Severely Underweight";
        }
        else if (Float.compare((float) bmi, 15f) > 0 && Float.compare((float) bmi, 16f) <= 0)
        {
            bmiLabel = "Severely Underweight";
        }
        else if (Float.compare((float) bmi, 16f) > 0 && Float.compare((float) bmi, 18.5f) <= 0)
        {
            bmiLabel = "Underweight";
        }
        else if (Float.compare((float) bmi, 18.5f) > 0 && Float.compare((float) bmi, 25f) <= 0)
        {
            bmiLabel = "Healthy";
        }
        else if (Float.compare((float) bmi, 25f) > 0 && Float.compare((float) bmi, 30f) <= 0)
        {
            bmiLabel = "Overweight";
        }
        else if (Float.compare((float) bmi, 30f) > 0 && Float.compare((float) bmi, 35f) <= 0)
        {
            bmiLabel = "You need to eat less";
        }
        else
        {
            bmiLabel = "Dude you need to starve";
        }


        bmiLabel = bmi + "\n" + bmiLabel;
        result.setText(bmiLabel);
    }
}
