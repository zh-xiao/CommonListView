package com.example.xiao.commonlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiao on 2017/2/3.
 */

public class ViewHolder {
    private View mConvertView;
    private Map<Integer,View> mViewMap;
    private Context mContext;

    public ViewHolder(Context context,int layoutId,ViewGroup parent){
        mConvertView= LayoutInflater.from(context).inflate(layoutId,parent,false);
        mViewMap=new HashMap<>();
        mConvertView.setTag(this);
        mContext=context;
    }

    public synchronized static ViewHolder getHolder(Context context,int layoutId, View convertView, ViewGroup parent){
        if (null==convertView){
            return new ViewHolder(context,layoutId,parent);
        }else{
            return (ViewHolder) convertView.getTag();
        }
    }

    public View getConvertView(){
        return mConvertView;
    }

    public <T extends View> T getView(int id){
        if (mViewMap.containsKey(id)){
            return (T) mViewMap.get(id);
        }else{
            View view=mConvertView.findViewById(id);
            mViewMap.put(id,view);
            return (T) view;
        }
    }

    public ViewHolder set(int id,String s){
        View view=getView(id);
        if (view instanceof TextView){
            ((TextView) view).setText(s);
        }else if (view instanceof ImageView){
            Picasso.with(mContext).load(s).into((ImageView) view);
        }
        return this;
    }
}
