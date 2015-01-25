package com.example.rose.myapplication;

        import android.app.Activity;
        import android.os.Parcelable;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.KeyEvent;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;


public class MainActivity extends Activity {

    EditText waluta;
    EditText kurs;
    TextView wynik;

    public void przelicz(View view){
        try {
            double ilosc = Double.parseDouble(waluta.getText().toString());
            double razy = Double.parseDouble(kurs.getText().toString());
            if(ilosc > 0 & razy > 0)
                wynik.setText(Double.toString(ilosc * razy));
            else
                Toast.makeText(getApplicationContext(), "Podałeś liczbę ujemną. Zmień liczbę.", Toast.LENGTH_SHORT).show();
        }
        catch (final NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "A to nie jest liczba :D", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waluta = (EditText) findViewById(R.id.wartosc);
        kurs = (EditText) findViewById(R.id.kurs);
        wynik = (TextView) findViewById(R.id.wynik);

        if (savedInstanceState != null){
            waluta.setText(Float.toString(savedInstanceState.getFloat("ilosc")));
            kurs.setText(Float.toString(savedInstanceState.getFloat("kwota")));
        }

    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "wstecz()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onUserLeaveHint(){
        super.onUserLeaveHint();
        Toast.makeText(getApplicationContext(), "home()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle zestaw){

        Toast.makeText(getApplicationContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        //Bundle zestaw = new Bundle();
        try {
            zestaw.putFloat("ilosc", Float.valueOf(waluta.getText().toString()));
            zestaw.putFloat("kwota", Float.parseFloat(kurs.getText().toString()));
            super.onSaveInstanceState(zestaw);
        }
        catch (NumberFormatException e){

        }
    }


    protected void onRestoreInstanceState(Bundle stan){
        super.onRestoreInstanceState(stan);
        Toast.makeText(getApplicationContext(), "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        waluta.setText(Float.toString(stan.getFloat("ilosc")));
        kurs.setText(Float.toString(stan.getFloat("kwota")));

    }

}
