package com.example.xiao.commonlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ContactsBean> mList = new ArrayList<>();
    //    private ContactsAdapter mAdapter;
    private CommonAdapter mAdapter;
    private android.widget.ListView lv;
    private android.widget.RelativeLayout activitymain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.activitymain = (RelativeLayout) findViewById(R.id.activity_main);
        this.lv = (ListView) findViewById(R.id.lv);
//        lv.setAdapter(mAdapter=new ContactsAdapter(this,mList));
        lv.setAdapter(mAdapter = new CommonAdapter<ContactsBean>(this, mList, R.layout.item_layout) {
            @Override
            public void convertView(ViewHolder holder, ContactsBean contactsBean) {
                holder.set(R.id.name, contactsBean.getName())
                        .set(R.id.phone_number, contactsBean.getPhoneNumber())
                        .set(R.id.head_img, contactsBean.getHead_img());
            }
        });
        initData();
    }

    public void initData() {
        for (int i = 0; i < 20; i++) {
            ContactsBean bean = new ContactsBean();
            bean.setName("小明");
            bean.setPhoneNumber("110");
            bean.setHead_img("http://img.qqai.net/uploads/i_2_1826721258x2403292640_21.jpg");
            mList.add(bean);
        }
        mAdapter.notifyDataSetChanged();
    }
}
