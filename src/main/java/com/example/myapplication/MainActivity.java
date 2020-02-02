package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String result;
    private Double exchangeValue = 0.0;
    private Map<String, Double> currencyValue = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCurrencyValue();
    }

    private void setCurrencyValue() {
        Map<String, Double> currencyValue = new HashMap<>();
        currencyValue.put("Dollar", 71.02);
        currencyValue.put("Euro", 50.0);
        currencyValue.put("Pound", 60.02);
        currencyValue.put("Yen", 80.02);
        this.currencyValue = currencyValue;
    }

    public void convertDollar(View view) {
        EditText dollarAmount = findViewById(R.id.amount);
        double amount = Double.parseDouble(dollarAmount.getText().toString());
        Double result = this.exchangeValue * amount;
        Log.i("TAG", String.valueOf(amount));

        String toastText = amount + " $ = " + result + " rs";

        View result1 = findViewById(R.id.result);


        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
        TextView textView =findViewById(R.id.result);
        textView.setText(String.valueOf(result));
        attachCurrencyDropdown();

    }

    public void attachCurrencyDropdown() {
        Spinner spinner = findViewById(R.id.currencyType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String currencyType = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), currencyType, Toast.LENGTH_SHORT).show();
        switch (currencyType) {
            case "Dollar": {
                Log.i("TAG", ":::" + currencyType);
                this.exchangeValue = this.currencyValue.get(currencyType);
            }
            break;
            case "Pound": {
                Log.i("TAG", ":::" + currencyType);
                this.exchangeValue = this.currencyValue.get(currencyType);
            }
            break;
            case "Euro": {
                Log.i("TAG", ":::" + currencyType);
                this.exchangeValue = this.currencyValue.get(currencyType);
            }
            break;
            case "Yen": {
                Log.i("TAG", ":::" + currencyType);
                this.exchangeValue = this.currencyValue.get(currencyType);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + currencyType);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
//        adapterView.setEmptyView();
    }
}
