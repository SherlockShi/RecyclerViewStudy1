package com.sh.recyclerviewstudy1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Author: SherlockShi
 * E-mail: sherlock_shi@163.com
 * Date:   2016-03-29 21:54
 * Description: 主界面
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView rvBook;
    private String[] mBooks = {"认知盈余", "和喜欢的一切在一起", "从0到1", "从你的全世界路过", "打工旅行", "番茄工作法图解"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBook = (RecyclerView) findViewById(R.id.rv_book);

        // 1. 这里用线性显示,类似于ListView
        rvBook.setLayoutManager(new LinearLayoutManager(this));

        // 2. 这里用线性宫格显示,类似于GridView
//        rvBook.setLayoutManager(new GridLayoutManager(this, 2));

        // 3. 这里用线性宫格显示,类似于瀑布流
//        rvBook.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));

        rvBook.setAdapter(new BookRecyclerViewAdapter(MainActivity.this, mBooks));
    }
}
