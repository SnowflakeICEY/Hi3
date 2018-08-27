package ru.alexandercold.a3rd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SwordsActivity extends AppCompatActivity {
    private String[] mGroupsArray = new String[]{"★★★☆/☆","★★★★☆/☆☆",};
    private String mThreeStars[] = {
            "Alloy Gluttony Scimitar",
                    "Alloy Wind Wielder",
                    "Crystal Edge",
                    "Endergonic Tachi",
                    "Hell Thunder",
                    "Pulse Katana Type-17",
                    "Pulse katana Type-19",
                    "Lightning soul",
                    "Proto Katana",
                    "Thermal Cutter",
                    "Vermillion Edge",
                    "Xuanyuan Katana",
                    "Phoenix Sword",
    };
    private String mFourStars[] = {
            "3rd Sacred Relic",
                    "Candy Sword",
                    "Demon Blade - Florid Sakura",
                    "Fairy Sword Silven",
                    "Gluttony Scimitar",
                    "High Freaquency Cutter",
                    "Ice Epiphyllum",
                    "Jizo Mitama",
                    "MagStorm",
                    "Nuwa's Sword",
                    "Plasma Kagehide",
                    "Pledge of Rain",
                    "Raikiri",
                    "Sakura Blossom",
                    "Sheathed Blade",
                    "Sky Breaker",
                    "Void blade",
                    "Vorpal Sword Type-11",
                    "Wind Wielder",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swords);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Swords");

        Map<String, String> map;
        // коллекция для групп
        ArrayList <Map <String, String>> groupDataList = new ArrayList<>();
        // заполняем коллекцию групп из массива с названиями групп

        for (String group : mGroupsArray) {
            // заполняем список атрибутов для каждой группы
            map = new HashMap<>();
            map.put("groupName", group);
            groupDataList.add(map);
        }

        // список атрибутов групп для чтения
        String groupFrom[] = new String[]{"groupName"};
        // список ID view-элементов, в которые будет помещены атрибуты групп
        int groupTo[] = new int[]{android.R.id.text1};

        // создаем общую коллекцию для коллекций элементов
        ArrayList <ArrayList <Map <String, String>>> сhildDataList = new ArrayList <>();

        ArrayList <Map <String, String>> сhildDataItemList = new ArrayList <>();
        // заполняем список атрибутов для каждого элемента
        for (String month : mThreeStars) {
            map = new HashMap <>();
            map.put("SwordsName", month);
            сhildDataItemList.add(map);
        }
        // добавляем в коллекцию коллекций
        сhildDataList.add(сhildDataItemList);

        // создаем коллекцию элементов для второй группы
        сhildDataItemList = new ArrayList<>();
        for (String month : mFourStars) {
            map = new HashMap<>();
            map.put("SwordsName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);



        // список атрибутов элементов для чтения
        String childFrom[] = new String[]{"SwordsName"};
        // список ID view-элементов, в которые будет помещены атрибуты
        // элементов
        int childTo[] = new int[]{android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, groupDataList,
                android.R.layout.simple_expandable_list_item_1, groupFrom,
                groupTo, сhildDataList, android.R.layout.simple_list_item_1,
                childFrom, childTo);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expListView);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent();
                intent.setClass(SwordsActivity.this, SwordsViewActivity.class);
                intent.putExtra("mSwordsName", childPosition);
                intent.putExtra("mRareName",groupPosition);
                startActivity(intent);

                return false;

            }


        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}