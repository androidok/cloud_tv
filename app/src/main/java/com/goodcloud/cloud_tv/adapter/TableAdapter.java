package com.goodcloud.cloud_tv.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.goodcloud.cloud_tv.R;
import com.goodcloud.cloud_tv.entity.WorkData;

import java.util.List;


public class TableAdapter extends BaseAdapter {

    private List<WorkData> list;
    private LayoutInflater inflater;

    public TableAdapter(Context context, List<WorkData> list){
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        int ret = 0;
        if(list!=null){
            ret = list.size();
        }
        return ret;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        WorkData workData = (WorkData) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){

            viewHolder = new ViewHolder();

            convertView = inflater.inflate(R.layout.list_item, null);

            viewHolder.lineId = (TextView) convertView.findViewById(R.id.lineId);
            viewHolder.classId = (TextView) convertView.findViewById(R.id.classId);
            viewHolder.lineLeader = (TextView) convertView.findViewById(R.id.lineLeader);
            viewHolder.productionNum = (TextView) convertView.findViewById(R.id.productionNum);
            viewHolder.productionName = (TextView) convertView.findViewById(R.id.productionName);
            viewHolder.planNum = (TextView) convertView.findViewById(R.id.planNum);
            viewHolder.offLineNum = (TextView) convertView.findViewById(R.id.offLineNum);
            viewHolder.difference = (TextView) convertView.findViewById(R.id.difference);
            viewHolder.completionRate = (TextView) convertView.findViewById(R.id.completionRate);
            viewHolder.workStatu = (TextView) convertView.findViewById(R.id.workStatu);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.lineId.setText(workData.getMachineName());
        viewHolder.lineId.setTextSize(12);
        viewHolder.lineId.setTextColor(Color.GREEN);
        viewHolder.classId.setText(workData.getWorkShiftName());
        viewHolder.classId.setTextSize(12);
        viewHolder.classId.setTextColor(Color.GREEN);
        viewHolder.lineLeader.setText(workData.getUserName());
        viewHolder.lineLeader.setTextSize(12);
        viewHolder.lineLeader.setTextColor(Color.GREEN);
        viewHolder.productionNum.setText(workData.getCode());
        viewHolder.productionNum.setTextSize(12);
        viewHolder.productionNum.setTextColor(Color.GREEN);
        viewHolder.productionName.setText(workData.getProductName());
        viewHolder.productionName.setTextSize(12);
        viewHolder.productionName.setTextColor(Color.GREEN);
        viewHolder.planNum.setText(workData.getPlanNum());
        viewHolder.planNum.setTextSize(12);
        viewHolder.planNum.setTextColor(Color.GREEN);
        viewHolder.offLineNum.setText(workData.getReallyNum());
        viewHolder.offLineNum.setTextSize(12);
        viewHolder.offLineNum.setTextColor(Color.GREEN);
        viewHolder.difference.setText(workData.getDifference());
        viewHolder.difference.setTextSize(12);
        viewHolder.difference.setTextColor(Color.GREEN);
        viewHolder.completionRate.setText(workData.getCompletionRate());
        viewHolder.completionRate.setTextSize(12);
        viewHolder.completionRate.setTextColor(Color.GREEN);
        viewHolder.workStatu.setText(workData.getStatus());
        viewHolder.workStatu.setTextSize(12);
        viewHolder.workStatu.setTextColor(Color.GREEN);

        // 为listView设置隔行变色
        if (position % 2 == 0) {
               convertView.setBackgroundResource(R.drawable.item_selector);
            } else {
                convertView.setBackgroundResource(R.drawable.item_selector1);
            }
        return convertView;
    }

    public static class ViewHolder{
        public TextView lineId;//线体
        public TextView classId;//班次
        public TextView lineLeader;//产线负责人
        public TextView productionNum;//产品编号
        public TextView productionName;//产品名称
        public TextView planNum;//计划数
        public TextView offLineNum;//下线数
        public TextView difference;//差额
        public TextView completionRate;//完成率
        public TextView workStatu;//生产状态
    }

}

