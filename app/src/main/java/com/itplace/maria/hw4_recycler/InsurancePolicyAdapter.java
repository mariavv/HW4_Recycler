package com.itplace.maria.hw4_recycler;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.itplace.maria.hw4_recycler.InsurancePolicyDataStruct.Policy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maria on 25.08.2017.
 */

public class InsurancePolicyAdapter extends RecyclerView.Adapter<InsurancePolicyAdapter.ViewHolder> {

    List<Policy> items;

    @Override
    public InsurancePolicyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_insurance_policy, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InsurancePolicyAdapter.ViewHolder holder, int position) {
        holder.bindData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void addItem(Policy entity) {
        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(entity);

        notifyDataSetChanged();
    }

    public void updateItems(List<Policy> items) {
        if (items == null) {
            return;
        }

        this.items = items;

        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iType;
        TextView titleView;
        TextView rest;

        public ViewHolder(final View itemView) {
            super(itemView);

            iType = (ImageView) itemView.findViewById(R.id.iType);
            titleView = (TextView) itemView.findViewById(R.id.tvType);
            rest = (TextView) itemView.findViewById(R.id.rest);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //checkBoxView.performClick();
                }
            });
        }

        public void bindData(final Policy entity) {
            String type = "";
            switch (entity.getType()) {
                case OSAGO: {
                    type = String.valueOf(R.string.osago);
                    iType.setImageResource(R.drawable.icon_car);
                    break;
                }
                case CASCO: {
                    type = String.valueOf(R.string.casco);
                    iType.setImageResource(R.drawable.icon_car_kasko);
                    break;
                }
                case Medical: {
                    type = String.valueOf(R.string.medical);
                    iType.setImageResource(R.drawable.icon_medec);
                    break;
                }
                case Realty: {
                    type = String.valueOf(R.string.realty);
                    iType.setImageResource(R.drawable.icon_key);
                    break;
                }
            }
            titleView.setText(type + " " + entity.getNumber() + "\n" + entity.getInsurancedObject()
                               + "\n с " + entity.getBeginDate().toString() + " по " + entity.getBeginDate().toString());

            rest.setText("Осталось");


            //checkBoxView.setChecked(entity.isChecked());

            // Пример бага с переиспользованием
//            if (titleView.getText().equals("тест")){
//                titleView.setBackgroundColor(itemView.getResources().getColor(R.color.colorPrimaryDark));
//            }

            /*checkBoxView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    entity.setChecked(b);
                }
            });*/
        }
    }
}
