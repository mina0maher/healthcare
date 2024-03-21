package com.mina.maher.healthcare.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mina.maher.healthcare.R;
import com.mina.maher.healthcare.models.AppointmentModel;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.MessagesViewHolder> {
    private final List<AppointmentModel> appointmentModels;
    public AppointmentAdapter(List<AppointmentModel> appointmentModels){
        this.appointmentModels = appointmentModels;
    }


    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment, parent, false);
        return new MessagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        holder.setData(appointmentModels.get(position));
    }


    @Override
    public int getItemCount() {
        return appointmentModels.size();
    }

    static class MessagesViewHolder extends RecyclerView.ViewHolder{
        TextView senderName;
        TextView appointmentTime;
        TextView hospitalName;
        public MessagesViewHolder(@NonNull View itemView) {
            super(itemView);
            senderName = itemView.findViewById(R.id.senderName);
            appointmentTime=itemView.findViewById(R.id.messageTime);
            hospitalName=itemView.findViewById(R.id.messageBody);
        }

        void setData(AppointmentModel appointmentModel){
            senderName.setText(appointmentModel.getSenderName());
            appointmentTime.setText(appointmentModel.getAppointmentTime());
            hospitalName.setText(appointmentModel.getHospitalName());
        }
    }
}
