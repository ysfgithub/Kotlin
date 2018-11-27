package com.example.yashuan.mykotlin.activitys

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import com.example.yashuan.mykotlin.R

//import com.scwang.smartrefresh.layout.SmartRefreshLayout
//import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator
//import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator
//import com.scwang.smartrefresh.layout.api.RefreshLayout
//import com.scwang.smartrefresh.layout.footer.ClassicsFooter
//import com.scwang.smartrefresh.layout.header.ClassicsHeader

class SecondAct : Activity() {


    //static 代码段可以防止内存泄露
    companion object {
        //设置全局的Header构建器
//        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
//            @Override
//            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
//                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
//            }
//        });
//        //设置全局的Footer构建器
//        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
//            @Override
//            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
//                //指定为经典Footer，默认是 BallPulseFooter
//                return new ClassicsFooter(context).setDrawableSize(20);
//            }
//        });

//        init {
//            SmartRefreshLayout.setDefaultRefreshHeaderCreator(DefaultRefreshHeaderCreator RefreshHeader@{ context, layout ->
//                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
//                return@RefreshHeader ClassicsHeader (context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
//            })
//            SmartRefreshLayout.setDefaultRefreshFooterCreator(DefaultRefreshFooterCreator
//            RefreshFooter@{ context, layouat ->
//                return@RefreshFooter ClassicsFooter(context).setDrawableSize(20F);
//            })
//
//        }
    }


    private lateinit var listView : ListView
    private lateinit var adapter: BaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        listView = findViewById(R.id.lv)
        var adapter = Adapter(this)
        listView.adapter = adapter

    }


    class Adapter() : BaseAdapter() {
        override fun getItemId(p0: Int): Long {
            TODO("not implemented")
        }

        private lateinit var ct:Context

        constructor(context: Context) : this() {
            this.ct = context
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var textV = TextView(ct)
            textV.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    60)
            textV.text = "postion:" + p0
            return textV
        }

        override fun getItem(p0: Int): Any {
            return p0
        }
        override fun getCount(): Int {
            return 10
        }
    }
}