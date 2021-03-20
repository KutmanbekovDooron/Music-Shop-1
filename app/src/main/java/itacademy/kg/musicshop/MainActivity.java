package itacademy.kg.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{

    private final String TAG = "My tag";
    Spinner spinner;
    Button minas, plas, addToCart;
    TextView sum, number;
    ArrayAdapter<String> adapter;
    ImageView imageView;
    EditText personInfo;

    private int count = 0;
    private int priceItam = 0;
    private int product = 0;
    private Map<String, Integer> lastName;
    private int image1 [] = {R.drawable.keyboard,R.drawable.guitar,R.drawable.drums,R.drawable.rock};
    private ArrayList<User> persona;
    private String selectedItam;

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
        addToCart = (Button) findViewById(R.id.addToCart);
        sum = (TextView) findViewById(R.id.sum);
        number = (TextView) findViewById(R.id.number);
        spinner = (Spinner) findViewById(R.id.spinner);
        imageView = (ImageView) findViewById(R.id.images);
        personInfo = (EditText) findViewById(R.id.editTextTextPersonName);

        minas.setOnClickListener(this);
        plas.setOnClickListener(this);
        addToCart.setOnClickListener(this);
        spinner.setOnItemSelectedListener( this);

        ArrayList<String> name = new ArrayList<>();
        name.add("Keyboard");
        name.add("Guitar");
        name.add("Dram");
        name.add("Rock");

        lastName =  new HashMap<>();
        lastName.put("Keyboard", 500);
        lastName.put("Guitar", 300);
        lastName.put("Dram", 320);
        lastName.put("Rock",800);


        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, name);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        selectedItam = parent.getSelectedItem().toString();
        priceItam = lastName.get(selectedItam);
        sum.setText(String.valueOf(priceItam));
        count = 1;
        number.setText(String.valueOf(count));
        imageView.setImageResource(image1[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plas:
                count++;
                product = priceItam * count;
                number.setText(String.valueOf(count));
                sum.setText(String.valueOf(product));
                break;
            case R.id.minas:
                count--;
                product = priceItam * count;
                if (count < 0) {
                    count = 0;
                    product = 0;
                }
                number.setText(String.valueOf(count));
                sum.setText(String.valueOf(product));
                break;
            case R.id.addToCart:
                persona = new ArrayList<>();
                persona.add(new User(personInfo.getText().toString(),selectedItam, count,product));
                for (User info : persona) {
                    if (info.name.equals("")){
                        Toast.makeText(MainActivity.this,"Введите имя ",Toast.LENGTH_SHORT).show();
                    }else {
                        Log.i(TAG,info.toString());
                    }

                }

                break;
        }
    }


}

 class User{
    String name;
    String thingsName;
    int amount;
    int quantity;

     public User(String name, String thingsName, int amount, int quantity) {
         this.name = name;
         this.thingsName = thingsName;
         this.amount = amount;
         this.quantity = quantity;
     }

     @Override
     public String toString() {
         return "User{" +
                 "name='" + name + '\'' +
                 ", thingsName='" + thingsName + '\'' +
                 ", amount=" + amount +
                 ", quantity=" + quantity +
                 '}';
     }
 }