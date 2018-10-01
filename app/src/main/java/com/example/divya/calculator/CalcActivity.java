package com.example.divya.calculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    // IDs of all the numeric buttons
    private int[] numericButtons = {R.id.btnZero, R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour, R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine};
    // IDs of all the operator buttons
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnEqual, btnClear, btnDot;
    // TextView used to display the output
    private TextView txtScreen;

    float mValueOne , mValueTwo, result ;


    boolean mAddition , mSubtract ,mMultiplication ,mDivision ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        // Find the TextView
        txtScreen = (TextView) findViewById(R.id.txtScreen);
        // Find and set OnClickListener to numeric buttons
        setNumericOnClickListener();
        //Initialise operation buttons
        InitOperations();
        //Display Values

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtScreen == null) {
                    txtScreen.setText("");
                } else {
                    mValueOne = Float.parseFloat(txtScreen.getText() + "");
                    mAddition = true;
                    txtScreen.setText(mValueOne + " + ");
                }
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtScreen == null) {
                    txtScreen.setText("");
                } else {
                    mValueOne = Float.parseFloat(txtScreen.getText() + "");
                    mSubtract = true;
                    txtScreen.setText(mValueOne + " - ");
                }
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtScreen == null) {
                    txtScreen.setText("");
                } else {
                    mValueOne = Float.parseFloat(txtScreen.getText() + "");
                    mMultiplication = true;
                    txtScreen.setText(mValueOne + " * ");
                }
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtScreen == null) {
                    txtScreen.setText("");
                } else {
                    mValueOne = Float.parseFloat(txtScreen.getText() + "");
                    mDivision = true;
                    txtScreen.setText(mValueOne + " / ");
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mAddition == true) {
                    String value[] = txtScreen.getText().toString().split(" + ",2);
                    mValueTwo = Float.parseFloat(value[1]);
                    txtScreen.setText(mValueOne + mValueTwo + "");
                    mAddition = false;
                }


                if (mSubtract == true) {
                    String value[] = txtScreen.getText().toString().split(" - ",2);
                    mValueTwo = Float.parseFloat(value[1]);
                    txtScreen.setText(mValueOne - mValueTwo + "");
                    mSubtract = false;
                }

                if (mMultiplication == true) {
                    String value[] = txtScreen.getText().toString().split(" * ",2);
                    mValueTwo = Float.parseFloat(value[1]);
                    txtScreen.setText(mValueOne * mValueTwo + "");
                    mMultiplication = false;
                }

                if (mDivision == true) {
                    String value[] = txtScreen.getText().toString().split(" / ",2);
                    mValueTwo = Float.parseFloat(value[1]);
                    txtScreen.setText(mValueOne / mValueTwo + "");
                    mDivision = false;
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtScreen.setText("");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtScreen.setText(txtScreen.getText() + ".");
            }
        });
    }

    private void InitOperations() {
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnDot = (Button) findViewById(R.id.btnDot);
    }

    private void setNumericOnClickListener() {

        // Create a common OnClickListener
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Just append/set the text of clicked button
                Button button = (Button) v;
                txtScreen.append(button.getText());
            }
        };
        // Assign the listener to all the numeric buttons
        for (int id : numericButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

}
