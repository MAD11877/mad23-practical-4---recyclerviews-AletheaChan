package sg.edu.np.mad.practical4;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private ArrayList<myObject> list_objects;
    public CustomAdapter(ArrayList<myObject> obj) {
        this.list_objects = obj;
    }

    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if(viewType == 7) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout2, parent, false
            );
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout, parent, false);
        }
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        myObject list_items = list_objects.get(position);
        holder.txtName.setText(list_items.getMyText());
        holder.txtDesc.setText(list_items.getMyText());

        holder.image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(holder.image.getContext())
                        .setTitle("Profile")
                        .setMessage(list_items.getMyText())
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent viewProfile = new Intent(holder.image.getContext(), MainActivity.class);
                                viewProfile.putExtra("id", position);
                                holder.image.getContext().startActivity(viewProfile);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();
            }
        });
    }

    public int getItemCount() {
        return list_objects.size();
    }
}
