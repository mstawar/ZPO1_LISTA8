package ib.edu.bmicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        TextView wynik=(TextView) findViewById(R.id.PPMWynik);

        Spinner spinner= (Spinner) findViewById(R.id.opcjaObliczen);
        Spinner plec = (Spinner) findViewById(R.id.wyborPlec);
        String wyborObliczenia=String.valueOf(spinner.getSelectedItem());
        String wyborPlci = String.valueOf(plec.getSelectedItem());

        EditText poleWzrost=(EditText) findViewById(R.id.wzrost);
        EditText poleMasy=(EditText) findViewById(R.id.masa);
        EditText poleWiek=(EditText) findViewById(R.id.wiek);

        try{
            double wzrost= Double.valueOf(poleWzrost.getText().toString());
            double masa= Double.valueOf(poleMasy.getText().toString());
            double wiek = Double.valueOf(poleWiek.getText().toString());

            double Wynik=0;

            if(wyborObliczenia.equals("Wzor Bennedicta-Harrisa")){
                if(wyborPlci.equals("Mezczyzna")){
                   Wynik=66.5+(13.75*masa)+(5.003*wzrost)-(6.775*wiek);

                }else{
                    Wynik=655.1+(9.563*masa)+(1.85*wzrost)-(4.676*wiek);

                }

            }else {
                if(wyborPlci.equals("Mezczyzna")){
                    Wynik=(10*masa)+(6.25*wzrost)-(5*wiek)-161;
                }else {
                    Wynik=(10*masa)+(6.25*wzrost)-(5*wiek)+5;
                }
            }

            DecimalFormat twoDFormat= new DecimalFormat("#.##");

            wynik.setText("PPM = " + String.valueOf(twoDFormat.format(Wynik))+" kcal");


        }catch (NumberFormatException e){
            wynik.setText("Co najmniej jedno z pól nie jest liczbą");
        }

    }// ON CLICK
}
