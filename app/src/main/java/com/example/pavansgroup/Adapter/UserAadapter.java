package com.example.pavansgroup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pavansgroup.Model.User;
import com.example.pavansgroup.R;

import java.util.List;

public class UserAadapter extends RecyclerView.Adapter<UserAadapter.ViewHolder> {

    Context context;
    List<User> userList;

    public UserAadapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

         holder.tvName.setText(""+userList.get(position).getName());
        holder.tvAddress.setText(""+userList.get(position).getAddress());


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvAddress, tvName;
        Button btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAddress = itemView.findViewById(R.id.tvAddress);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            tvName = itemView.findViewById(R.id.tvName);

        }
    }
}
