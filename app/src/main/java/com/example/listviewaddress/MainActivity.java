package com.example.listviewaddress;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Item> item_list;
    Button btn_add, btn_del;
    EditText ed_name, ed_phonenumber, ed_email;
    ListView lv;
    myCustomAdapter ca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_del = (Button) findViewById(R.id.btn_del);
        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_phonenumber = (EditText) findViewById(R.id.ed_phonenumber);
        ed_email = (EditText) findViewById(R.id.ed_email);
        lv = (ListView) findViewById(R.id.listview);
        item_list = new ArrayList<Item>();
        ca = new myCustomAdapter(this, R.layout.item_layout, item_list);
        btn_add.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        lv.setAdapter(ca);

    }
    public class myCustomAdapter extends BaseAdapter {
        LayoutInflater inflater;
        Context context;
        int layout;
        ArrayList<Item> alist;

        public myCustomAdapter(Context context, int layout, ArrayList<Item> alist) {
            this.context = context;
            this.layout = layout;
            this.alist = alist;
            inflater = LayoutInflater.from(context);
        }

        //BaseAdapter 상속 받으려면 BaseAdapter 내에 정의된 추상메서드를 구현해야함
        @Override
        public int getCount() { //리스트 객체 내 item 갯수 반환
            return alist.size();
        }

        @Override
        public Object getItem(int position) {   //전달받은 position 위치에 해당하는 리스트 객체의 item을 객체 형태로 반환
            return alist.get(position);
        }

        @Override
        public long getItemId(int position) {   //전달받은 position 위치에 해당하는 리스트 객체의 item rowID를 반환해주는 함수
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { //해당되는 항목의 adapter에서 위치값, 재사용할 항목의 view, 항목의 view들을 포함하고 있는 ListView
            if (convertView == null) {
                convertView = inflater.inflate(layout, parent, false);
            }
            TextView tv_item_name = (TextView) convertView.findViewById(R.id.item_name_txt);
            TextView tv_item_phonenumber = (TextView) convertView.findViewById(R.id.item_phonenumber_txt);
            TextView tv_item_email = convertView.findViewById(R.id.item_email_txt);
            LinearLayout item_layout = (LinearLayout) convertView.findViewById(R.id.item_layout);

            tv_item_name.setText(alist.get(position).getName());
            tv_item_phonenumber.setText(alist.get(position).getPhoneNum());
            tv_item_email.setText(alist.get(position).getEmail());
            item_layout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    item_list.remove(position);
                    ca.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Removed", Toast.LENGTH_SHORT).show();

                    return false;
                }
            });
            return convertView;
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                Item item = new Item(ed_name.getText().toString(), ed_phonenumber.getText().toString(), ed_email.getText().toString());
                item_list.add(item);
                ca.notifyDataSetChanged();
                break;
            case R.id.btn_del:
                Item item1 = new Item(ed_name.getText().toString(), ed_phonenumber.getText().toString(), ed_email.getText().toString());
                //item_list.(item1);
                ca.notifyDataSetChanged();
                break;
        }
    }

}