package br.com.rw.the_weather.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.rw.the_weather.R;
import br.com.rw.the_weather.model.Location;


public class LocationsAdapter extends AdapterController<Location> {


    public LocationsAdapter(Context context, List<Location> list)
    {
        super(context, list);
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder
    {
        private AppCompatTextView text_city;
        private LinearLayoutCompat llCardLocations;


        public AdapterViewHolder(View view) {
            super(view);
            //
            text_city = view.findViewById(R.id.text_city);
            llCardLocations = view.findViewById(R.id.llCardLocations);
        }
    }

    @Override
    public RecyclerView.ViewHolder setViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_city, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindData(RecyclerView.ViewHolder holder, int position)
    {
        Location item = list.get(position);
        AdapterViewHolder viewHolder = (AdapterViewHolder) holder;
        //
        viewHolder.text_city.setText(item.getCountry());
        viewHolder.llCardLocations.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context, WeatherActivity.class);
                intent.putExtra("LAT", item.getLatitude());
                intent.putExtra("LON", item.getLongitude());
                context.startActivity(intent);
            }
        });
    }
}