package com.example.samplemvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CommonViewModel commonViewModel;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    private Button btnAdd;
    private TextView tvAddItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rvData);
        btnAdd = (Button) findViewById(R.id.btn_add);
        tvAddItem = (TextView) findViewById(R.id.tvAddItem);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvAddItem.getText().toString().length() > 0) {
                    commonViewModel.addDataInList(tvAddItem.getText().toString());
                }
            }
        });

//        commonViewModel = ViewModelProviders.of(this).get(CommonViewModel.class);
        commonViewModel = new ViewModelProvider(this).get(CommonViewModel.class);
        getLifecycle().addObserver(commonViewModel);
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recyclerViewAdapter);
        commonViewModel.getListOfData().observe(this, new Observer<List<String>>(){
            @Override
            public void onChanged(List<String> strings) {
                recyclerViewAdapter.updateAdapterData(strings);
            }
        });
    }
}