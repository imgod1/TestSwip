package com.example.gaokang.testswip;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * design库中包含V7包 V7包中包含V4包
 */
public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swip_refresh;
    private RecyclerView recyclerView;
    private List<String> titleList;
    private MyAdapter adapter;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initData();
    }

    private void initData() {
        swip_refresh.post(new Runnable() {
            @Override
            public void run() {
                swip_refresh.setRefreshing(true);
            }
        });
        getData(1, "Load");
    }

    private void initEvent() {
        swip_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.e("main", "refresh");
                titleList.clear();
                getData(1, "Refresh");
            }
        });
    }

    private void initView() {
        swip_refresh = (SwipeRefreshLayout) findViewById(R.id.swip_refresh);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        titleList = new ArrayList<>();
        adapter = new MyAdapter(titleList);
        recyclerView.setAdapter(adapter);
        //设置刷新时动画的颜色，可以设置4个
        swip_refresh.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);


    }


    private void getData(final int page, final String content) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int startPosition = 10 * (page - 1);
                int endPosition = 10 * page;
                for (int i = startPosition; i < endPosition; i++) {
                    titleList.add(content + i);
                }
                adapter.notifyDataSetChanged();
                swip_refresh.setRefreshing(false);
            }
        }, 3000);
    }

}
