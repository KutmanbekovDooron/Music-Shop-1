package itacademy.kg.musicshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ScrollingTabContainerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner;
    Button minas, plas;
    TextView sum, number;
    ArrayAdapter<String> adapter;
    public static int count = 0;
    public static int summa = 0;
    public static int sum1 = 0;
    public static Map<String, String> lastName = new HashMap<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minas = (Button) findViewById(R.id.minas);
        plas = (Button) findViewById(R.id.plas);
        sum = (TextView) findViewById(R.id.sum);
        number = (TextView) findViewById(R.id.number);
        spinner = (Spinner) findViewById(R.id.spinner);

        minas.setOnClickListener(this);
        plas.setOnClickListener(this);

        ArrayList<String> name = new ArrayList<>();
        name.add("Piano");
        name.add("Guitar");
        name.add("Dram");
        name.add("Komuz");
        name.add("Quarnet");


        lastName.put("Piano", "500");
        lastName.put("Guitar", "300");
        lastName.put("Dram", "320");
        lastName.put("Komuz", "200");
        lastName.put("Quarnet", "150");


        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, name);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sum1 = 0;
                count = 0;
                for (Map.Entry<String, String> hashMap : lastName.entrySet()) {
                    if (hashMap.getKey().equals(name.get(position))) {
                        summa = Integer.parseInt(hashMap.getValue());
                        sum.setText(hashMap.getValue());
                        count++;
                        sum1 += summa;
                        number.setText(String.valueOf(count));
                    } else {

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plas:
                count++;
                number.setText(String.valueOf(count));
                sum1 += summa;
                sum.setText(String.valueOf(sum1));
                break;
            case R.id.minas:
                if (count > 0) {
                    count--;
                    number.setText(String.valueOf(count));
                    sum1 -= summa;
                    sum.setText(String.valueOf(sum1));
                }
                break;

        }
    }
}