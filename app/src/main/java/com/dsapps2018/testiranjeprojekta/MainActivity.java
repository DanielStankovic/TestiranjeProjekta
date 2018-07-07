package com.dsapps2018.testiranjeprojekta;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listView;
    private EditText searchBar;
    private Button exportBtn;
    private ArrayList<Product> productList;
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = findViewById(R.id.searchEt);
        exportBtn = findViewById(R.id.exportBtn);
        listView = findViewById(R.id.listView);
        productList = new ArrayList<>();

        for (int i = 0; i <30 ; i++) {
            Product product = new Product();
            product.setTitle("Naslov "+ i);
            productList.add(product);

        }

        adapter = new CustomAdapter(this, productList);
        listView.setAdapter(adapter);



        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());
            }
        });

        exportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Product> list = adapter.getList();
                StringBuilder builder = new StringBuilder();

                for(Product product : list){
                    builder.append(product.getTitle() + "  ");

                }

                Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void filter(String s){

        ArrayList<Product> list = new ArrayList<>();

        for(Product product : productList){
            if(product.getTitle().toLowerCase().contains(s.toLowerCase())){
                list.add(product);
            }
        }
        adapter.findList(list);

    }
}
