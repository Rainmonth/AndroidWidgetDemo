package com.randy.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.randy.demo.recyclerView.activity.GridTypeRecyclerViewActivity;
import com.randy.demo.recyclerView.activity.ListTypeRecyclerViewActivity;
import com.randy.demo.recyclerView.activity.StaggeredGridLayoutActivity;
import com.randy.demo.viewPager.ViewPagerDemoActivity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private LinkedHashMap<String, Class> mData = new LinkedHashMap<>();
    private ArrayList<String> demoNameList = new ArrayList<>();
    private ArrayList<Class> demoActivityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(android.R.id.list);

        initData();

        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                demoNameList));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, demoActivityList.get(position));
                startActivity(intent);
            }
        });
    }

    private void initData() {
        mData.put(ListTypeRecyclerViewActivity.class.getSimpleName() + " Demo",
                ListTypeRecyclerViewActivity.class);
        mData.put(GridTypeRecyclerViewActivity.class.getSimpleName() + " Demo",
                GridTypeRecyclerViewActivity.class);
        mData.put(StaggeredGridLayoutActivity.class.getSimpleName() + " Demo",
                StaggeredGridLayoutActivity.class);

        mData.put(ViewPagerDemoActivity.class.getSimpleName() + " Demo", ViewPagerDemoActivity.class);

        for (Map.Entry<String, Class> entry : mData.entrySet()) {
            String key = entry.getKey();
            Class value = entry.getValue();
            demoNameList.add(key);
            demoActivityList.add(value);
        }
    }
}
