package com.example.latihanrecyclerview;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private ArrayList<Hero> localDataSet;

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public HeroAdapter(ArrayList<Hero> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvHeroName;
        private final TextView tvHeroDesc;
        private final ImageView imgHeroPoster;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvHeroName = view.findViewById(R.id.hero_name);
            tvHeroDesc = view.findViewById(R.id.hero_description);
            imgHeroPoster = view.findViewById(R.id.hero_poster);
        }

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvHeroName.setText(localDataSet.get(position).getName());
        viewHolder.tvHeroDesc.setText(localDataSet.get(position).getDescription());
        viewHolder.imgHeroPoster.setImageResource(localDataSet.get(position).getPoster());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewHolder.itemView.getContext(), "Kamu memilih " + localDataSet.get(viewHolder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(viewHolder.itemView.getContext(),DetailActivity.class);
                intent.putExtra("name", localDataSet.get(viewHolder.getAdapterPosition()).getName());
                intent.putExtra("description", localDataSet.get(viewHolder.getAdapterPosition()).getDescription());
                intent.putExtra("poster", localDataSet.get(viewHolder.getAdapterPosition()).getPoster());
                viewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

