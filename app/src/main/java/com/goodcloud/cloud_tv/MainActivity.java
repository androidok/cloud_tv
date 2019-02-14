package com.goodcloud.cloud_tv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 厚丰液晶屏APP
 * 两种实现方式
 * 1：ListView
 * 更新时有闪烁问题
 * 2：TextView
 *
 */

public class MainActivity extends AppCompatActivity {

    public static final String WORKDATA = "com.cpuele.houfengtv.service.WorkDataService";//广播标志
    public static final String ANDENG_NULL = "com.cpuele.houfengtv.service.AndengService";//无 安灯 信息
    public static final String ANDENG_INFO = "com.cpuele.houfengtv.service.AndengService";//有 安灯 信息

    private LinearLayout layout_workData,layout_andeng;

    /*
    生产信息显示相关
     */
    //显示信息
    private String[] machineName ;//线体
    private String[] workShiftName;//班次
    private String[] userName;//产线负责人
    private String[] code;//产品编号
    private String[] productName;//产品名称
    private int[] planNum;//计划数
    private int[] reallyNum;//下线数
    private String[] difference;//差额
    private String[] completionRate;//完成率
    private int[] status;//生产状态
    //列表相关
//    List<WorkData> list = new ArrayList<WorkData>();
//    ListView tableListView;
//    TableAdapter adapter;
    //TextView模拟表格
    //线体
    private TextView lineId1,lineId2,lineId3,lineId4,lineId5,lineId6,lineId7,lineId8,lineId9;
    //班次
    private TextView classId1,classId2,classId3,classId4,classId5,classId6,classId7,classId8,classId9;
    //产线负责人
    private TextView lineLeader1,lineLeader2,lineLeader3,lineLeader4,lineLeader5,lineLeader6,lineLeader7,lineLeader8,lineLeader9;
    //产品编号
    private TextView productionNum1,productionNum2,productionNum3,productionNum4,productionNum5,productionNum6,productionNum7,productionNum8,productionNum9;
    //产品名称
    private TextView productionName1,productionName2,productionName3,productionName4,productionName5,productionName6,productionName7,productionName8,productionName9;
    //计划数
    private TextView planNum1,planNum2,planNum3,planNum4,planNum5,planNum6,planNum7,planNum8,planNum9;
    //下线数
    private TextView offLineNum1,offLineNum2,offLineNum3,offLineNum4,offLineNum5,offLineNum6,offLineNum7,offLineNum8,offLineNum9;
    //差额
    private TextView difference1,difference2,difference3,difference4,difference5,difference6,difference7,difference8,difference9;
    //完成率（%）
    private TextView completionRate1,completionRate2,completionRate3,completionRate4,completionRate5,completionRate6,completionRate7,completionRate8,completionRate9;
    //生产状态
    private TextView workStatu1,workStatu2,workStatu3,workStatu4,workStatu5,workStatu6,workStatu7,workStatu8,workStatu9;

    /*
    andon触发相关
     */
    private TextView zhuangxin1,zhuangxin2,zhuangxin3,zhuangxin4,zhuangxin5,zhuangxin6,zhuangxin7,zhuangxin8,feimaxun1;
    private TextView andengInfo1,andengInfo2,andengInfo3,andengInfo4,andengInfo5,andengInfo6,andengInfo7,andengInfo8,andengInfo9
            ,andengInfo10,andengInfo11,andengInfo12,andengInfo13,andengInfo14,andengInfo15;

    //安灯显示信息
    private String[] areaName;//"区域名称
    private String[] arriveTime;//到达时间
    private String[] arriveUserName;//"到达人员名称
    private String[] triggerName;//触发终端名称
    private int[] value;//对应按钮值(1:故障,2:缺料,3:调机)
    //广播接收器
    private ReceiveBroadCast receiveBroadCast;
    class ReceiveBroadCast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            //生产信息广播
            try{
                if(intent.getAction().equals(WORKDATA)){
                    machineName = intent.getExtras().getStringArray("machineName");
                    workShiftName = intent.getExtras().getStringArray("workShiftName");
                    userName = intent.getExtras().getStringArray("userName");
                    code = intent.getExtras().getStringArray("code");
                    productName = intent.getExtras().getStringArray("productName");
                    planNum = intent.getExtras().getIntArray("planNum");
                    reallyNum = intent.getExtras().getIntArray("reallyNum");
                    status = intent.getExtras().getIntArray("status");

                    /**
                     * ListView 开始
                     */
                    //对 除数为 0 做判断
//                if(Double.valueOf(planNum) != 0){
//                    completionRate = (Double.valueOf(reallyNum)/Double.valueOf(planNum))*10+"";
//                }else {
//                    completionRate = "--";
//                }
////                difference = 1+"";
////                completionRate = 1*10+"%";
//
//                if(status == "1.0"){
//                    status = "生产中";
//                }else {
//                    status = "--";
//                }

//                list.add(new WorkData(machineName,workShiftName,userName,code,productName,planNum,reallyNum,difference,completionRate,status));
//                name.add(machineName);
//                adapter = new TableAdapter(MainActivity.this, list);
//                tableListView.setAdapter(adapter);
                    /**
                     * ListView 结束
                     */

//                    /**
//                     * TextView 开始
//                     */
//
//                    lineId1.setText(machineName[0]);
//                    lineId2.setText(machineName[1]);
//                    lineId3.setText(machineName[2]);
//                    lineId4.setText(machineName[3]);
//                    lineId5.setText(machineName[4]);
//                    lineId6.setText(machineName[5]);
//                    lineId7.setText(machineName[6]);
//                    lineId8.setText(machineName[7]);
//                    lineId9.setText(machineName[16]);
//
//                    classId1.setText(workShiftName[0]);
//                    classId2.setText(workShiftName[1]);
//                    classId3.setText(workShiftName[2]);
//                    classId4.setText(workShiftName[3]);
//                    classId5.setText(workShiftName[4]);
//                    classId6.setText(workShiftName[5]);
//                    classId7.setText(workShiftName[6]);
//                    classId8.setText(workShiftName[7]);
//                    classId9.setText(workShiftName[16]);
//
//                    lineLeader1.setText(userName[0]);
//                    lineLeader2.setText(userName[1]);
//                    lineLeader3.setText(userName[2]);
//                    lineLeader4.setText(userName[3]);
//                    lineLeader5.setText(userName[4]);
//                    lineLeader6.setText(userName[5]);
//                    lineLeader7.setText(userName[6]);
//                    lineLeader8.setText(userName[7]);
//                    lineLeader9.setText(userName[16]);
//
//                    productionNum1.setText(code[0]);
//                    productionNum2.setText(code[1]);
//                    productionNum3.setText(code[2]);
//                    productionNum4.setText(code[3]);
//                    productionNum5.setText(code[4]);
//                    productionNum6.setText(code[5]);
//                    productionNum7.setText(code[6]);
//                    productionNum8.setText(code[7]);
//                    productionNum9.setText(code[16]);
//
//                    productionName1.setText(productName[0]);
//                    productionName2.setText(productName[1]);
//                    productionName3.setText(productName[2]);
//                    productionName4.setText(productName[3]);
//                    productionName5.setText(productName[4]);
//                    productionName6.setText(productName[5]);
//                    productionName7.setText(productName[6]);
//                    productionName8.setText(productName[7]);
//                    productionName9.setText(productName[16]);
//
//
//                    planNum1.setText(planNum[0]+"");
//                    planNum2.setText(planNum[1]+"");
//                    planNum3.setText(planNum[2]+"");
//                    planNum4.setText(planNum[3]+"");
//                    planNum5.setText(planNum[4]+"");
//                    planNum6.setText(planNum[5]+"");
//                    planNum7.setText(planNum[6]+"");
//                    planNum8.setText(planNum[7]+"");
//                    planNum9.setText(planNum[16]+"");
//
//                    offLineNum1.setText(reallyNum[0]+"");
//                    offLineNum2.setText(reallyNum[1]+"");
//                    offLineNum3.setText(reallyNum[2]+"");
//                    offLineNum4.setText(reallyNum[3]+"");
//                    offLineNum5.setText(reallyNum[4]+"");
//                    offLineNum6.setText(reallyNum[5]+"");
//                    offLineNum7.setText(reallyNum[6]+"");
//                    offLineNum8.setText(reallyNum[7]+"");
//                    offLineNum9.setText(reallyNum[16]+"");
//
//                    difference1.setText((planNum[0]-reallyNum[0])+"");
//                    difference2.setText((planNum[1]-reallyNum[1])+"");
//                    difference3.setText((planNum[2]-reallyNum[2])+"");
//                    difference4.setText((planNum[3]-reallyNum[3])+"");
//                    difference5.setText((planNum[4]-reallyNum[4])+"");
//                    difference6.setText((planNum[5]-reallyNum[5])+"");
//                    difference7.setText((planNum[6]-reallyNum[6])+"");
//                    difference8.setText((planNum[7]-reallyNum[7])+"");
//                    difference9.setText((planNum[16]-reallyNum[16])+"");
//
//                    completionRate1.setText(d(Double.valueOf(reallyNum[0]),Double.valueOf(planNum[0])));
//                    completionRate2.setText(d(Double.valueOf(reallyNum[1]),Double.valueOf(planNum[1])));
//                    completionRate3.setText(d(Double.valueOf(reallyNum[2]),Double.valueOf(planNum[2])));
//                    completionRate4.setText(d(Double.valueOf(reallyNum[3]),Double.valueOf(planNum[3])));
//                    completionRate5.setText(d(Double.valueOf(reallyNum[4]),Double.valueOf(planNum[4])));
//                    completionRate6.setText(d(Double.valueOf(reallyNum[5]),Double.valueOf(planNum[5])));
//                    completionRate7.setText(d(Double.valueOf(reallyNum[6]),Double.valueOf(planNum[6])));
//                    completionRate8.setText(d(Double.valueOf(reallyNum[7]),Double.valueOf(planNum[7])));
//                    completionRate9.setText(d(Double.valueOf(reallyNum[16]),Double.valueOf(planNum[16])));
//
//
//                    workStatu1.setText(status[0] == 1?"生产中":"--");
//                    workStatu2.setText(status[1] == 1?"生产中":"--");
//                    workStatu3.setText(status[2] == 1?"生产中":"--");
//                    workStatu4.setText(status[3] == 1?"生产中":"--");
//                    workStatu5.setText(status[4] == 1?"生产中":"--");
//                    workStatu6.setText(status[5] == 1?"生产中":"--");
//                    workStatu7.setText(status[6] == 1?"生产中":"--");
//                    workStatu8.setText(status[7] == 1?"生产中":"--");
//                    workStatu9.setText(status[16] == 1?"生产中":"--");
//                    /**
//                     * TextView 结束
//                     */


                }
            }catch (RuntimeException e){
                e.printStackTrace();
                Toast.makeText(MainActivity.this,"服务器连接中,请联系管理员！",Toast.LENGTH_LONG).show();
            }

            //没有 安灯 消息的广播
            if(intent.getAction().equals(ANDENG_NULL)){
                layout_andeng.setVisibility(View.GONE);
                layout_workData.setVisibility(View.VISIBLE);
//                Log.e(TAG, "没有安灯消息: 广播中" );
            }


            //有 安灯 消息的广播
            try{
                if(intent.getAction().equals(ANDENG_INFO)){

                    areaName = intent.getExtras().getStringArray("areaName");
                    if(areaName == null){

                        layout_andeng.setVisibility(View.GONE);
                        layout_workData.setVisibility(View.VISIBLE);
//                        Log.e(TAG, "onReceive: 没有" );
                    }else{
                        layout_andeng.setVisibility(View.VISIBLE);
                        layout_workData.setVisibility(View.GONE);
//                        Log.e(TAG, "onReceive: 有" );
                    }
                    arriveTime = intent.getExtras().getStringArray("arriveTime");
                    arriveUserName = intent.getExtras().getStringArray("arriveUserName");
                    triggerName = intent.getExtras().getStringArray("triggerName");
                    value = intent.getExtras().getIntArray("value");
//                    Log.e(TAG, "onReceive: " +areaName[0]+arriveTime[0]+arriveUserName[0]+triggerName[0]+value[0]);

                    if(check("触屏1",triggerName)){
                        zhuangxin1.setBackgroundColor(Color.RED);
                    }else{
                        zhuangxin1.setBackgroundColor(Color.WHITE);
                    }
                    if(check("多开",triggerName)){
                        zhuangxin2.setBackgroundColor(Color.RED);
                    }else{
                        zhuangxin2.setBackgroundColor(Color.WHITE);
                    }
                    if(triggerName[2] != null){
                        zhuangxin3.setBackgroundColor(Color.RED);
                    }else{
                        zhuangxin3.setBackgroundColor(Color.WHITE);
                    }
                    if(triggerName[3] != null){
                        zhuangxin4.setBackgroundColor(Color.RED);
                    }else{
                        zhuangxin4.setBackgroundColor(Color.WHITE);
                    }
                    if(triggerName[4] != null){
                        zhuangxin5.setBackgroundColor(Color.RED);
                    }else{
                        zhuangxin5.setBackgroundColor(Color.WHITE);
                    }
                    if(triggerName[5] != null){
                        zhuangxin6.setBackgroundColor(Color.RED);
                    }else{
                        zhuangxin6.setBackgroundColor(Color.WHITE);
                    }
                    if(triggerName[6] != null){
                        zhuangxin7.setBackgroundColor(Color.RED);
                    }else{
                        zhuangxin7.setBackgroundColor(Color.WHITE);
                    }
                    if(triggerName[7] != null){
                        zhuangxin8.setBackgroundColor(Color.RED);
                    }else{
                        zhuangxin8.setBackgroundColor(Color.WHITE);
                    }
                    if(triggerName[8] != null){
                        feimaxun1.setBackgroundColor(Color.RED);
                    }else{
                        feimaxun1.setBackgroundColor(Color.WHITE);
                    }

                    //刷新信息前先清空
                    andengInfo2.setText("");
                    andengInfo3.setText("");
                    andengInfo4.setText("");
                    andengInfo5.setText("");
                    andengInfo6.setText("");
                    andengInfo7.setText("");
                    andengInfo8.setText("");
                    andengInfo9.setText("");
                    andengInfo10.setText("");
                    andengInfo11.setText("");
                    andengInfo12.setText("");
                    andengInfo13.setText("");
                    andengInfo14.setText("");
                    andengInfo15.setText("");
//                    Log.e(TAG, "onReceive: >>>>>>>>>>"+arriveUserName[0]+"+++++"+(arriveUserName[0].equals("")?"触发":"到达"));
                    andengInfo2.setText(areaName[0]+"-"+triggerName[0]+" 触发 "+value[0]+" 触发时间:"+timeToStr(arriveTime[0])+" 当前状态:"+(arriveUserName[0].equals("")?"触发":"到达")+" 人员:"+arriveUserName[0]);
                    andengInfo3.setText(areaName[1]+"-"+triggerName[1]+" 触发 "+value[1]+" 触发时间:"+timeToStr(arriveTime[1])+" 当前状态:"+(arriveUserName[1].equals("")?"触发":"到达"+" 人员:"+arriveUserName[1]));
                    andengInfo4.setText(areaName[2]+"-"+triggerName[2]+" 触发 "+value[2]+" 触发时间:"+timeToStr(arriveTime[2])+" 当前状态:"+(arriveUserName[2].equals("")?"触发":"到达"+" 人员:"+arriveUserName[2]));
                    andengInfo5.setText(areaName[3]+"-"+triggerName[3]+" 触发 "+value[3]+" 触发时间:"+timeToStr(arriveTime[3])+" 当前状态:"+(arriveUserName[3].equals("")?"触发":"到达"+" 人员:"+arriveUserName[3]));
                    andengInfo6.setText(areaName[4]+"-"+triggerName[4]+" 触发 "+value[4]+" 触发时间:"+timeToStr(arriveTime[4])+" 当前状态:"+(arriveUserName[4].equals("")?"触发":"到达"+" 人员:"+arriveUserName[4]));
                    andengInfo7.setText(areaName[5]+"-"+triggerName[5]+" 触发 "+value[5]+" 触发时间:"+timeToStr(arriveTime[5])+" 当前状态:"+(arriveUserName[5].equals("")?"触发":"到达"+" 人员:"+arriveUserName[5]));
                    andengInfo8.setText(areaName[6]+"-"+triggerName[6]+" 触发 "+value[6]+" 触发时间:"+timeToStr(arriveTime[6])+" 当前状态:"+(arriveUserName[6].equals("")?"触发":"到达"+" 人员:"+arriveUserName[6]));
                    andengInfo9.setText(areaName[7]+"-"+triggerName[7]+" 触发 "+value[7]+" 触发时间:"+timeToStr(arriveTime[7])+" 当前状态:"+(arriveUserName[7].equals("")?"触发":"到达"+" 人员:"+arriveUserName[7]));
                    andengInfo10.setText(areaName[8]+"-"+triggerName[8]+" 触发 "+value[8]+" 触发时间:"+timeToStr(arriveTime[8])+" 当前状态:"+(arriveUserName[8].equals("")?"触发":"到达"+" 人员:"+arriveUserName[8]));
                    andengInfo11.setText(areaName[9]+"-"+triggerName[9]+" 触发 "+value[9]+" 触发时间:"+timeToStr(arriveTime[9])+" 当前状态:"+(arriveUserName[9].equals("")?"触发":"到达"+" 人员:"+arriveUserName[9]));
                    andengInfo12.setText(areaName[10]+"-"+triggerName[10]+" 触发 "+value[10]+" 触发时间:"+timeToStr(arriveTime[10])+" 当前状态:"+(arriveUserName[10].equals("")?"触发":"到达"+" 人员:"+arriveUserName[10]));
                    andengInfo13.setText(areaName[11]+"-"+triggerName[11]+" 触发 "+value[11]+" 触发时间:"+timeToStr(arriveTime[11])+" 当前状态:"+(arriveUserName[11].equals("")?"触发":"到达"+" 人员:"+arriveUserName[11]));
                    andengInfo14.setText(areaName[12]+"-"+triggerName[12]+" 触发 "+value[12]+" 触发时间:"+timeToStr(arriveTime[12])+" 当前状态:"+(arriveUserName[12].equals("")?"触发":"到达"+" 人员:"+arriveUserName[12]));
                    andengInfo15.setText(areaName[13]+"-"+triggerName[13]+" 触发 "+value[13]+" 触发时间:"+timeToStr(arriveTime[13])+" 当前状态:"+(arriveUserName[13].equals("")?"触发":"到达"+" 人员:"+arriveUserName[13]));

                }
            }catch (Exception e){
                e.printStackTrace();
//                Toast.makeText(MainActivity.this,"服务器连接中,请联系管理员！",Toast.LENGTH_LONG).show();
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_textview);

        layout_workData = findViewById(R.id.layout_workData);
        layout_andeng = findViewById(R.id.layout_andeng);

        lineId1 = findViewById(R.id.lineId1);
        lineId2 = findViewById(R.id.lineId2);
        lineId3 = findViewById(R.id.lineId3);
        lineId4 = findViewById(R.id.lineId4);
        lineId5 = findViewById(R.id.lineId5);
        lineId6 = findViewById(R.id.lineId6);
        lineId7 = findViewById(R.id.lineId7);
        lineId8 = findViewById(R.id.lineId8);
        lineId9 = findViewById(R.id.lineId9);

        classId1 = findViewById(R.id.classId1);
        classId2 = findViewById(R.id.classId2);
        classId3 = findViewById(R.id.classId3);
        classId4 = findViewById(R.id.classId4);
        classId5 = findViewById(R.id.classId5);
        classId6 = findViewById(R.id.classId6);
        classId7 = findViewById(R.id.classId7);
        classId8 = findViewById(R.id.classId8);
        classId9 = findViewById(R.id.classId9);

        lineLeader1 = findViewById(R.id.lineLeader1);
        lineLeader2 = findViewById(R.id.lineLeader2);
        lineLeader3 = findViewById(R.id.lineLeader3);
        lineLeader4 = findViewById(R.id.lineLeader4);
        lineLeader5 = findViewById(R.id.lineLeader5);
        lineLeader6 = findViewById(R.id.lineLeader6);
        lineLeader7 = findViewById(R.id.lineLeader7);
        lineLeader8 = findViewById(R.id.lineLeader8);
        lineLeader9 = findViewById(R.id.lineLeader9);

        productionNum1 = findViewById(R.id.productionNum1);
        productionNum2 = findViewById(R.id.productionNum2);
        productionNum3 = findViewById(R.id.productionNum3);
        productionNum4 = findViewById(R.id.productionNum4);
        productionNum5 = findViewById(R.id.productionNum5);
        productionNum6 = findViewById(R.id.productionNum6);
        productionNum7 = findViewById(R.id.productionNum7);
        productionNum8 = findViewById(R.id.productionNum8);
        productionNum9 = findViewById(R.id.productionNum9);

        productionName1 = findViewById(R.id.productionName1);
        productionName2 = findViewById(R.id.productionName2);
        productionName3 = findViewById(R.id.productionName3);
        productionName4 = findViewById(R.id.productionName4);
        productionName5 = findViewById(R.id.productionName5);
        productionName6 = findViewById(R.id.productionName6);
        productionName7 = findViewById(R.id.productionName7);
        productionName8 = findViewById(R.id.productionName8);
        productionName9 = findViewById(R.id.productionName9);

        planNum1 = findViewById(R.id.planNum1);
        planNum2 = findViewById(R.id.planNum2);
        planNum3 = findViewById(R.id.planNum3);
        planNum4 = findViewById(R.id.planNum4);
        planNum5 = findViewById(R.id.planNum5);
        planNum6 = findViewById(R.id.planNum6);
        planNum7 = findViewById(R.id.planNum7);
        planNum8 = findViewById(R.id.planNum8);
        planNum9 = findViewById(R.id.planNum9);

        offLineNum1 = findViewById(R.id.offLineNum1);
        offLineNum2 = findViewById(R.id.offLineNum2);
        offLineNum3 = findViewById(R.id.offLineNum3);
        offLineNum4 = findViewById(R.id.offLineNum4);
        offLineNum5 = findViewById(R.id.offLineNum5);
        offLineNum6 = findViewById(R.id.offLineNum6);
        offLineNum7 = findViewById(R.id.offLineNum7);
        offLineNum8 = findViewById(R.id.offLineNum8);
        offLineNum9 = findViewById(R.id.offLineNum9);

        difference1 = findViewById(R.id.difference1);
        difference2 = findViewById(R.id.difference2);
        difference3 = findViewById(R.id.difference3);
        difference4 = findViewById(R.id.difference4);
        difference5 = findViewById(R.id.difference5);
        difference6 = findViewById(R.id.difference6);
        difference7 = findViewById(R.id.difference7);
        difference8 = findViewById(R.id.difference8);
        difference9 = findViewById(R.id.difference9);

        completionRate1 = findViewById(R.id.completionRate1);
        completionRate2 = findViewById(R.id.completionRate2);
        completionRate3 = findViewById(R.id.completionRate3);
        completionRate4 = findViewById(R.id.completionRate4);
        completionRate5 = findViewById(R.id.completionRate5);
        completionRate6 = findViewById(R.id.completionRate6);
        completionRate7 = findViewById(R.id.completionRate7);
        completionRate8 = findViewById(R.id.completionRate8);
        completionRate9 = findViewById(R.id.completionRate9);

        workStatu1 = findViewById(R.id.workStatu1);
        workStatu2 = findViewById(R.id.workStatu2);
        workStatu3 = findViewById(R.id.workStatu3);
        workStatu4 = findViewById(R.id.workStatu4);
        workStatu5 = findViewById(R.id.workStatu5);
        workStatu6 = findViewById(R.id.workStatu6);
        workStatu7 = findViewById(R.id.workStatu7);
        workStatu8 = findViewById(R.id.workStatu8);
        workStatu9 = findViewById(R.id.workStatu9);

        zhuangxin1 = findViewById(R.id.zhuangxin1);
        zhuangxin2 = findViewById(R.id.zhuangxin2);
        zhuangxin3 = findViewById(R.id.zhuangxin3);
        zhuangxin4 = findViewById(R.id.zhuangxin4);
        zhuangxin5 = findViewById(R.id.zhuangxin5);
        zhuangxin6 = findViewById(R.id.zhuangxin6);
        zhuangxin7 = findViewById(R.id.zhuangxin7);
        zhuangxin8 = findViewById(R.id.zhuangxin8);
        feimaxun1 = findViewById(R.id.feimaxun1);

        andengInfo1 = findViewById(R.id.andengInfo1);
        andengInfo2 = findViewById(R.id.andengInfo2);
        andengInfo3 = findViewById(R.id.andengInfo3);
        andengInfo4 = findViewById(R.id.andengInfo4);
        andengInfo5 = findViewById(R.id.andengInfo5);
        andengInfo6 = findViewById(R.id.andengInfo6);
        andengInfo7 = findViewById(R.id.andengInfo7);
        andengInfo8 = findViewById(R.id.andengInfo8);
        andengInfo9 = findViewById(R.id.andengInfo9);
        andengInfo10 = findViewById(R.id.andengInfo10);
        andengInfo11 = findViewById(R.id.andengInfo11);
        andengInfo12 = findViewById(R.id.andengInfo12);
        andengInfo13 = findViewById(R.id.andengInfo13);
        andengInfo14 = findViewById(R.id.andengInfo14);
        andengInfo15 = findViewById(R.id.andengInfo15);

//        tableListView = (ListView) findViewById(R.id.list);
        //设置表格标题的背景颜色
//        ViewGroup tableTitle = (ViewGroup) findViewById(R.id.table_title);
//        tableTitle.setBackgroundColor(Color.rgb(177, 173, 172));

        /**
         * TextView 开始(固定值)
         */

        lineId1.setText("1号机台");
        lineId2.setText("2号机台");
        lineId3.setText("3号机台");
        lineId4.setText("4号机台");
        lineId5.setText("5号机台");
        lineId6.setText("6号机台");
        lineId7.setText("7号机台");
        lineId8.setText("8号机台");
        lineId9.setText("9号机台");

        classId1.setText("白班");
        classId2.setText("白班");
        classId3.setText("白班");
        classId4.setText("白班");
        classId5.setText("白班");
        classId6.setText("白班");
        classId7.setText("白班");
        classId8.setText("白班");
        classId9.setText("白班");

        lineLeader1.setText("马云");
        lineLeader2.setText("马化腾");
        lineLeader3.setText("李彦弘");
        lineLeader4.setText("张朝阳");
        lineLeader5.setText("丁磊");
        lineLeader6.setText("刘强东");
        lineLeader7.setText("王兴");
        lineLeader8.setText("黄光裕");
        lineLeader9.setText("上官雪儿");

        productionNum1.setText("20080808");
        productionNum2.setText("20080808");
        productionNum3.setText("20080808");
        productionNum4.setText("20080808");
        productionNum5.setText("20080808");
        productionNum6.setText("20080808");
        productionNum7.setText("20080808");
        productionNum8.setText("20080808");
        productionNum9.setText("20080808");

        productionName1.setText("方向盘");
        productionName2.setText("发动机");
        productionName3.setText("手动变速箱");
        productionName4.setText("车玻璃");
        productionName5.setText("启动机");
        productionName6.setText("冷凝器");
        productionName7.setText("空调压缩机");
        productionName8.setText("自动变速箱");
        productionName9.setText("底盘");


        planNum1.setText("100");
        planNum2.setText("200");
        planNum3.setText("300");
        planNum4.setText("400");
        planNum5.setText("500");
        planNum6.setText("600");
        planNum7.setText("700");
        planNum8.setText("800");
        planNum9.setText("0");

        offLineNum1.setText("10");
        offLineNum2.setText("20");
        offLineNum3.setText("30");
        offLineNum4.setText("40");
        offLineNum5.setText("50");
        offLineNum6.setText("60");
        offLineNum7.setText("70");
        offLineNum8.setText("80");
        offLineNum9.setText("0");

        difference1.setText("90");
        difference2.setText("180");
        difference3.setText("270");
        difference4.setText("360");
        difference5.setText("450");
        difference6.setText("540");
        difference7.setText("630");
        difference8.setText("720");
        difference9.setText("0");

        completionRate1.setText("10%");
        completionRate2.setText("10%");
        completionRate3.setText("10%");
        completionRate4.setText("10%");
        completionRate5.setText("10%");
        completionRate6.setText("10%");
        completionRate7.setText("10%");
        completionRate8.setText("10%");
        completionRate9.setText("0%");


        workStatu1.setText("生产中");
        workStatu2.setText("生产中");
        workStatu3.setText("生产中");
        workStatu4.setText("生产中");
        workStatu5.setText("生产中");
        workStatu6.setText("生产中");
        workStatu7.setText("生产中");
        workStatu8.setText("生产中");
        workStatu9.setText("停产中");
        /**
         * TextView 结束（固定值）
         */

        //注册广播
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(WORKDATA);    //只有持有相同的action的接受者才能接收此广播
        filter.addAction(ANDENG_NULL);
        filter.addAction(ANDENG_INFO);
        MainActivity.this.registerReceiver(receiveBroadCast, filter);

        //隐藏顶部标题栏
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }

        /**
         * 定时启动服务_生产数据服务
         */
        Timer timer_bar = new Timer();
        TimerTask task_bar = new TimerTask() {
            @Override
            public void run() {
                try{
                    Intent  intent = new Intent(MainActivity.this,com.goodcloud.cloud_tv.service.WorkDataService.class);
                    MainActivity.this.startService(intent);

//                    Intent  intent2 = new Intent(MainActivity.this,com.cpuele.houfengtv.service.AndengService.class);
//                    MainActivity.this.startService(intent2);

                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        };
        timer_bar.schedule(task_bar,2*1000,5*1000);
    }

    /**
     * Double 显示两位小数点
     * @param d1 下线数
     * @param d2 计划数
     * @return 差额字段
     */
    public String d(Double d1,Double d2){
        if(d2 == 0.0 ){
            return "--%";
        }
        BigDecimal bg = new BigDecimal(d1/d2*100);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1+" %";
    }

    /**
     * 字符串的时间戳 转 12:12:12
     * @param time 字符串时间戳
     * @return 12:12:12
     */
    public String timeToStr(String time){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        long  l = Long.valueOf(time);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }

    public boolean check(String trrigerName,String[] arr){
//        boolean b = true;
//        if(arr != null){
//            for(int i = 0;i<arr.length;i++){
//
//            }
//        }

        return Arrays.asList(arr).contains(trrigerName);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainActivity.this.unregisterReceiver(receiveBroadCast);
    }
}
