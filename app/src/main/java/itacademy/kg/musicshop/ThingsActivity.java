package itacademy.kg.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThingsActivity extends AppCompatActivity {
    ListView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        view = (ListView) findViewById(R.id.listView);
        ArrayList<Resourse> informations = UserInformation.resourses2;

        ResourseAdaptor resourseAdaptor = new ResourseAdaptor(ThingsActivity.this,R.layout.list_itam,informations);
        view.setAdapter(resourseAdaptor);

    }





}