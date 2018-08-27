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

/**
 * Created by User on 07.07.2018.
 */

public class ValkyriaActivity extends AppCompatActivity {
    private String[] mGroupsArray = new String[]{"Kiana Kaslana", "Raiden Mei","Bronya Zaychik","Murata Himeko","Yae Sakura","Theresa Apocalypse",};

    private String[] mKiana = new String[]{"White Comet","Valkyrie Ranger","Divine Prayer","Knight Moonbeam",};
    private String[] mMei = new String[]{ "Crimson Impulse","Valkyrie Bladestrike","Shadow Dash","Lightning Empress",};
    private String[] mBronya = new String[]{ "Valkyrie Chariot","Yamabuki Armor","Snowy Sniper","Dimensional Breaker","Wolf's Dawn","Black Nuclers"};
    private String[] mHimeko= new String[]{ "Battlestorm","Valkyrie Triumph","Scarlet Fusion","Blood Rose",};
    private String[] mSakura = new String[]{ "Gyakushin Miko","Goushinnso Memento",};
    private String[] mTheresa = new String[]{ "Valkyrie Pledge","Violet Executer", "Sakuno Rondo",};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_valkyria);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Valkyria");

        Map<String, String> map;
        // коллекция для групп
        ArrayList <Map <String, String>> groupDataList = new ArrayList <>();
        // заполняем коллекцию групп из массива с названиями групп

        for (String group : mGroupsArray) {
            // заполняем список атрибутов для каждой группы
            map = new HashMap <>();
            map.put("groupName", group);
            groupDataList.add(map);
        }

        // список атрибутов групп для чтения
        String groupFrom[] = new String[]{"groupName"};
        // список ID view-элементов, в которые будет помещены атрибуты групп
        int groupTo[] = new int[]{android.R.id.text1};

        // создаем общую коллекцию для коллекций элементов
        ArrayList <ArrayList <Map <String, String>>> сhildDataList = new ArrayList <>();

        // в итоге получится сhildDataList = ArrayList<сhildDataItemList>

        // создаем коллекцию элементов для первой группы
        ArrayList <Map <String, String>> сhildDataItemList = new ArrayList <>();
        // заполняем список атрибутов для каждого элемента
        for (String month : mKiana) {
            map = new HashMap <>();
            map.put("valkyrieName", month);
            сhildDataItemList.add(map);
        }
        // добавляем в коллекцию коллекций
        сhildDataList.add(сhildDataItemList);

        // создаем коллекцию элементов для второй группы
        сhildDataItemList = new ArrayList<>();
        for (String month : mMei) {
            map = new HashMap<>();
            map.put("valkyrieName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (String month : mBronya) {
            map = new HashMap<>();
            map.put("valkyrieName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (String month : mHimeko) {
            map = new HashMap<>();
            map.put("valkyrieName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (String month : mSakura) {
            map = new HashMap<>();
            map.put("valkyrieName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (String month : mTheresa) {
            map = new HashMap<>();
            map.put("valkyrieName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);


        // список атрибутов элементов для чтения
        String childFrom[] = new String[]{"valkyrieName"};
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
                intent.setClass(ValkyriaActivity.this, ValkyriaViewActivity.class);
                intent.putExtra("mSuitName", childPosition);
                intent.putExtra("mValkyrieName",groupPosition);
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


