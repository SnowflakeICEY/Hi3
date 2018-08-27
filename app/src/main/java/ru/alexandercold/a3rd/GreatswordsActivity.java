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

public class GreatswordsActivity extends AppCompatActivity {
    private String[] mGroupsArray = new String[]{"★★★☆/☆","★★★★☆/☆☆",};
    private String mThreeStars[] = {
            "Nitro Crystal",
            "Vanguard",
            "Ion Resonance",
            "King Cobra",
            "Violet Knight",
            "Crimson Queen",
            "Sprocket Greatsword",
            "Alloy Godfather Greatsword",
            "Alloy Betrayer's Greatsword",
            "Ai-Chan's Hammer",
            "Inquisition Torch",};
    private String mFourStars[] = {
            "7th Sacred Relic",
            "Nidhogg's Claws",
            "Blood Dance",
            "Sunfire Greatsword",
            "Dragon Spine",
            "Schwert Gewehr",
            "Dark Xuanyuan Sword",
            "Ghostslayer Nagamitsu",
            "Balmung",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greatswords);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Greatswords");

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
            map.put("GreatswordsName", month);
            сhildDataItemList.add(map);
        }
        // добавляем в коллекцию коллекций
        сhildDataList.add(сhildDataItemList);

        // создаем коллекцию элементов для второй группы
        сhildDataItemList = new ArrayList<>();
        for (String month : mFourStars) {
            map = new HashMap<>();
            map.put("GreatswordsName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);



        // список атрибутов элементов для чтения
        String childFrom[] = new String[]{"GreatswordsName"};
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
                intent.setClass(GreatswordsActivity.this, GreatswordsViewActivity.class);
                intent.putExtra("mGreatswordsName", childPosition);
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