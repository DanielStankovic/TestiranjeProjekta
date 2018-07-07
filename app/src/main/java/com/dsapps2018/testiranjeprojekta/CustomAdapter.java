package com.dsapps2018.testiranjeprojekta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Daniel on 7/8/2018.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Product> productList;
    private ArrayList<Product> tempList = new ArrayList<>();


    public CustomAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.productList = productList;

        for (int i = 0; i <30 ; i++) {
            if(i%3 == 0){
                productList.get(i).setChecked(true);
            }else{
                productList.get(i).setChecked(false);
            }
        }

        for(Product product : productList){
            if(product.isChecked()){
                tempList.add(product);
            }
        }

    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null){

            convertView = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);


        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Product product = (Product) getItem(position);

        viewHolder.title.setText(product.getTitle());
        viewHolder.checkBox.setChecked(product.isChecked());

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(((CheckBox)v).isChecked()){
                    product.setChecked(true);
                    tempList.add(product);

                    Toast.makeText(context, "Item: "+ product.getTitle() + " je setovan na " + String.valueOf(((CheckBox) v).isChecked()), Toast.LENGTH_SHORT).show();
                }else{
                    product.setChecked(false);
                    tempList.remove(product);

                    Toast.makeText(context, "Item: "+ product.getTitle() + " je setovan na " + String.valueOf(((CheckBox) v).isChecked()), Toast.LENGTH_SHORT).show();


                }
            }
        });


        return convertView;
    }

    private class ViewHolder{

        public TextView title;
        public CheckBox checkBox;

        public ViewHolder(View view){

            title = view.findViewById(R.id.title);
            checkBox = view.findViewById(R.id.checkBox);

        }
    }

    public void findList(ArrayList<Product> arrayList){

        productList = arrayList;
        notifyDataSetChanged();
    }

    public ArrayList<Product> getList(){
        return tempList;
    }
}
