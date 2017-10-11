package com.itplace.maria.hw4_recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itplace.maria.hw4_recycler.InsurancePolicyDataStruct.Policy;

import java.sql.Date;

import static com.itplace.maria.hw4_recycler.InsurancePolicyDataStruct.PolicyType.CASCO;
import static com.itplace.maria.hw4_recycler.InsurancePolicyDataStruct.PolicyType.Medical;
import static com.itplace.maria.hw4_recycler.InsurancePolicyDataStruct.PolicyType.OSAGO;
import static com.itplace.maria.hw4_recycler.InsurancePolicyDataStruct.PolicyType.Realty;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    InsurancePolicyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureViews();

        configureRecyclerView();
    }

    private void configureRecyclerView() {
        adapter = new InsurancePolicyAdapter();
        recycler.setAdapter(adapter);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        adapter.addItem(new Policy("EАE0555555888", Realty, "г.Москва, ул Дмитриевского, д. 5, кв. 55", new Date(111111)/*Date.valueOf("10.01.2017")*/, 100));
        adapter.addItem(new Policy("EEE0858555888", OSAGO, "Nissan Qashqai", new Date(111112)/*Date.valueOf("10.01.2017")*/, 102));
        adapter.addItem(new Policy("EEE0454555555", CASCO, "Nissan Qashqai", new Date(111113)/*Date.valueOf("10.01.2017")*/, 103));
        adapter.addItem(new Policy("10088К555567895", Medical, "Снегирев Иван Петрович", new Date(111114)/*Date.valueOf("10.01.2017")*/, 105));
    }

    private void configureViews() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
    }
}
