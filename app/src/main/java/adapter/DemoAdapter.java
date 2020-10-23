package adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import viewholders.DemoViewHolder;

public class DemoAdapter extends RecyclerView.Adapter<DemoViewHolder> {
    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
