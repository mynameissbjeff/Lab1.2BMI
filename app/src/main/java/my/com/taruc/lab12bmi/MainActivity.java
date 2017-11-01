package my.com.taruc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to program
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewResult = (TextView) findViewById(R.id.textViewBMI);
        imageViewResult = (ImageView)findViewById(R.id.imageViewResult);
    }

    public void calculateBMI(View view){
        //TODO: calculate BMI and display the result
        double weight, height, bmi=0;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());
        height = Math.pow((height/100),2);
        bmi = weight/height;

        bmi = Math.round(bmi*100);
        bmi = bmi/100;

        //Set image during run time
        if(bmi<=18.5){
            imageViewResult.setImageResource(R.drawable.under);
            textViewResult.setText(getString(R.string.under_weight)+" "+bmi+"");
        }
        else if(bmi>18.5&&bmi<21) {
            imageViewResult.setImageResource(R.drawable.normal);
            textViewResult.setText(getString(R.string.normal) + " " + bmi + "");
        }
        else if(bmi>=21) {
            imageViewResult.setImageResource(R.drawable.over);
            textViewResult.setText(getString(R.string.over_weight) + " " + bmi + "");
        }



    }

    public void Resetinput(View view){
        editTextWeight.setText("");
        editTextHeight.setText("");
        textViewResult.setText("");
        imageViewResult.setImageResource(R.drawable.empty);
    }
}
