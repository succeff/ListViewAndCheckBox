package com.baway.listviewandcheckbox;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * 单选
     */
    private Button mButDan;
    /**
     * 反选
     */
    private Button mButFan;
    /**
     * 取消选择
     */
    private Button mButQue;
    private ListView mListItem;
    List<Bean> list = new ArrayList<>();
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {
        mButDan = (Button) findViewById(R.id.but_quan);
        mButDan.setOnClickListener(this);
        mButFan = (Button) findViewById(R.id.but_fan);
        mButFan.setOnClickListener(this);
        mButQue = (Button) findViewById(R.id.but_que);
        mButQue.setOnClickListener(this);
        mListItem = (ListView) findViewById(R.id.list_item);
        for (int i = 0; i < 50; i++) {
            Bean bean = new Bean(false,"item"+i);
            list.add(bean);
        }
        adapter = new MyAdapter(MainActivity.this,list);
        mListItem.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.but_quan:
               adapter.all();
               break;
           case  R.id.but_fan:
               adapter.reverse();
               break;
           case R.id.but_que:
               adapter.cancel();
               break;
       }
    }
}
