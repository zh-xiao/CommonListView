package com.example.xiao.commonlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by xiao on 2017/2/3.
 */

public class ContactsAdapter extends BaseAdapter{

    private Context mContext;
    private List<ContactsBean> mList;

    public ContactsAdapter(Context context, List<ContactsBean> list) {
        mContext = context;
        mList = list;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null==convertView){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_layout,parent,false);
            holder=new ViewHolder();
            holder.name= (TextView) convertView.findViewById(R.id.name);
            holder.phoneNumber= (TextView) convertView.findViewById(R.id.phone_number);
            holder.headImg= (ImageView) convertView.findViewById(R.id.head_img);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        ContactsBean contactsBean = mList.get(position);
        holder.name.setText(contactsBean.getName());
        holder.phoneNumber.setText(contactsBean.getPhoneNumber());
        Picasso.with(mContext).load(contactsBean.getHead_img()).into(holder.headImg);
        return convertView;
    }

    class ViewHolder{
        TextView name;
        TextView phoneNumber;
        ImageView headImg;
    }

}
