package sg.edu.np.mad.practical4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView txtName;
    TextView txtDesc;
    ImageView image;

    public CustomViewHolder(View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.textView3);
        txtDesc = itemView.findViewById(R.id.textView4);
        image = itemView.findViewById(R.id.imageView2);

    }
}
