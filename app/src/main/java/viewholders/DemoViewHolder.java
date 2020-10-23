package viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.finder.R;

public class DemoViewHolder extends RecyclerView.ViewHolder {
    CardView cvDemoContainer;
    TextView tvDemo;

    public DemoViewHolder(@NonNull View v) {
        super(v);

        cvDemoContainer = v.findViewById(R.id.cvDemoContainer);
        tvDemo = v.findViewById(R.id.tvDemo);


    }
}
