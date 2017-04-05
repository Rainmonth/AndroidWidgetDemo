package com.randy.demo.recyclerView.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.randy.demo.R;
import com.randy.demo.recyclerView.adapter.DemoAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.randy.demo.recyclerView.decoration.DividerItemDecoration.VERTICAL_LIST;

public class ListTypeRecyclerViewActivity extends AppCompatActivity {
    List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_demo);

        // 初始化数据
        initData(50);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_container);
        // 设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // 设置adapter
        DemoAdapter demoAdapter = new DemoAdapter(this, dataList);
        recyclerView.setAdapter(demoAdapter);
        // 设置divider，由于官方比没有给ItemDecoration的默认实现，需我们自己实现
        recyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL_LIST));
        // 设置Item增加、移除动画

    }

    private void initData(int count) {
        for (int i = 0; i < count; i++) {
            dataList.add("Item " + i);
        }
    }
}
