package com.anshultiwari.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.anshultiwari.entity.Number;
import com.anshultiwari.recyclerviewwithcheckbox.R;

import java.util.ArrayList;
import java.util.List;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.ViewHolder> {

    public ArrayList<Number> numbers;

    public NumbersAdapter(List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.client_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(numbers.get(position));
        //in some cases, it will prevent unwanted situations
        holder.checkbox.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
        holder.checkbox.setChecked(numbers.get(position).isSelected());

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                numbers.get(holder.getAdapterPosition()).setSelected(isChecked);


//                if (isChecked)
//                {
//                    numbers.remove(holder.getAdapterPosition());
//                    for dynamically changing , removing
//                    notifyItemRemoved(holder.getAdapterPosition());
//                  poora adapter statically change ho raha hai
//                    notifyDataSetChanged();
//                }
            }
        });

//        holder.DeleteSelected(numbers.get(position));
//        btnDeleteSelected.setOnClickListner(new View)

    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView ONEs;
        private TextView textONEs;
        private CheckBox checkbox;

        public ViewHolder(View v) {
            super(v);
            ONEs = (TextView) v.findViewById(R.id.ONEs);
            textONEs = (TextView) v.findViewById(R.id.textONEs);
            checkbox = (CheckBox) v.findViewById(R.id.checkbox);
        }

        public void bindData(Number number) {
            ONEs.setText(number.getONEs());
            textONEs.setText(number.getTextONEs());
        }


//        public void DeleteSelected(Number number) {
//        numbers.get(holder.getAdapterPosition()).setSelected(isChecked);
//        numbers.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, numbers.size());
//        }


    }





}