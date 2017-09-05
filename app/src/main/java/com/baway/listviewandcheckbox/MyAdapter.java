package com.baway.listviewandcheckbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * 类的描述：
 * 时间：  2017/9/5.10:06
 * 姓名：chenlong
 */
public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<Bean>list;

    public MyAdapter(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
         public int getCount() {
            return list.size();
         }

         @Override
         public Object getItem(int position) {
             return list.get(position);
         }

         @Override
         public long getItemId(int position) {
             return position;
         }

         @Override
         public View getView(final int position, View convertView, ViewGroup parent) {
             ViewHolder holder=null;
             if(convertView==null){
                 convertView=View.inflate(context,R.layout.item,null);
                 holder=new ViewHolder();
                 holder.tit = convertView.findViewById(R.id.titles);
                 holder.checkBox = convertView.findViewById(R.id.checkbox);
                 convertView.setTag(holder);
             }else{
                 holder=(ViewHolder)convertView.getTag();
             }
              holder.tit.setText(list.get(position).getStr());
              holder.checkBox.setChecked(list.get(position).isChecked());
              holder.checkBox.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      //单选
                      singleChoice(position);
                      //多选
                      //mutilChoice(position);
                  }
              });

             return convertView;
         }
    /**
     * 多选
     *
     * @param
     */
    public void mutilChoice(int position) {
        Bean bean = list.get(position);
        bean.setChecked(true);
        notifyDataSetChanged();
    }
    /**
     * 单选
     *
     * @param
     */
    private void singleChoice(int position) {
        for (int i = 0; i < list.size(); i++) {
            Bean b = list.get(i);
            b.setChecked(false);
        }
        Bean bean = list.get(position);
        bean.setChecked(true);
        notifyDataSetChanged();
    }
    /**
     * 全选
     */
    public void all() {
        for (int i = 0; i < list.size(); i++) {
            Bean b = list.get(i);
            b.setChecked(true);
        }
        notifyDataSetChanged();
    }
    /**
     * 反选
     */
    public void reverse() {
        for (int i = 0; i < list.size(); i++) {
            Bean b = list.get(i);
//            if (b.isChecked()) {
//                b.setChecked(false);
//            } else {
//                b.setChecked(true);
//            }
            b.setChecked(!b.isChecked());
        }
        notifyDataSetChanged();
    }
    /**
     * 取消选择
     */
    public void cancel() {
        for (int i = 0; i < list.size(); i++) {
            Bean b = list.get(i);
            b.setChecked(false);
        }
        notifyDataSetChanged();
    }

    class ViewHolder{
             TextView tit;
             CheckBox checkBox;
         }
}
