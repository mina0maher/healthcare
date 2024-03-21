package com.mina.maher.healthcare.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mina.maher.healthcare.R;
import com.mina.maher.healthcare.models.ClinicModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DropDownAdapter extends ArrayAdapter<ClinicModel> {

    public DropDownAdapter(@NonNull Context context, ArrayList<ClinicModel> arrayList) {


        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, R.layout.item_dropdown,R.id.text_car_name, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_dropdown, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        ClinicModel currentVehiclePosition = getItem(position);


        // then according to the position of the view assign the desired image for the same
        CircleImageView numbersImage = currentItemView.findViewById(R.id.carImage);
        assert currentVehiclePosition != null;
        numbersImage.setImageResource(currentVehiclePosition.getImageId());
        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.text_car_name);
        textView1.setText(currentVehiclePosition.getName());
        Log.d("ADebugTag", "name : " +currentVehiclePosition.getName() );
        Log.d("ADebugTag", "image: " +currentVehiclePosition.getImageId() );

        // then return the recyclable view
        return currentItemView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_dropdown, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        ClinicModel currentVehiclePosition = getItem(position);


        // then according to the position of the view assign the desired image for the same
        CircleImageView numbersImage = currentItemView.findViewById(R.id.carImage);
        assert currentVehiclePosition != null;
        numbersImage.setImageResource(currentVehiclePosition.getImageId());
        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.text_car_name);
        textView1.setText(currentVehiclePosition.getName());

        // then return the recyclable view
        return currentItemView;    }
}