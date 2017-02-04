package com.example.xiao.commonlistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by xiao on 2017/2/3.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mList;
    protected int mLayoutId;

    public CommonAdapter(Context context, List<T> list, int layoutId) {
        mContext=context;
        mList=list;
        mLayoutId=layoutId;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 根据OO思想,第一行和最后一行不存在变化,所以封装起来,中间适配内容的部分通过convertView抽象方法交给调用者去实现
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getHolder(mContext, mLayoutId, convertView, parent);
        convertView(holder,mList.get(position));
        return holder.getConvertView();
    }

    /**
     * 真正内容适配的方法
     * @param holder
     * @param t
     */
    public abstract void convertView(ViewHolder holder,T t);
}
