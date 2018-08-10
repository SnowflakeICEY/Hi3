package ru.alexandercold.a3rd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HonkaiActivity extends AppCompatActivity {

    String[] point = {"Валькирии", "Стигматы","Оружие","Таблицы","Гайды","Армады(В разработке)","Анонсы(В разработке)"}; //Список элементов ListView
    Intent intent; //Переменная Intent для возможности нескольких использований

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honkai2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // находим список
        ListView listView = (ListView) findViewById(R.id.listView);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, point);
        // присваиваем адаптер списку
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent = new Intent(HonkaiActivity.this, ValkyriaActivity.class);
                        break;
                    case 1:
                        intent = new Intent(HonkaiActivity.this, StigmataActivity.class);
                        break;
                    case 2:
                        intent = new Intent(HonkaiActivity.this, WeaponActivity.class);
                        break;
                    case 3:
                        intent = new Intent(HonkaiActivity.this, TableActivity.class);
                        break;
                    case 4:
                        intent = new Intent(HonkaiActivity.this, GuidActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
