package br.com.rw.the_weather.view;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public abstract class AdapterController<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    protected Context context;
    protected List<T> list;

    public AdapterController(Context context)
    {
        this.context = context;
    }

    public AdapterController(Context context, List<T> list)
    {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder holder = setViewHolder(parent, viewType);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        onBindData(holder, position);
    }

    @Override
    public int getItemCount()
    {
        return list != null ? list.size() : 0;
    }

    public void addlist(List<T> list)
    {
        if (this.list.size() == 0)
        {
            this.list.addAll(list);
        }
        else
        {
            this.list.addAll(this.list.size(), list);
        }
        this.notifyDataSetChanged();
    }

    public T getItem(int position)
    {
        return list.get(position);
    }

    public abstract RecyclerView.ViewHolder setViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindData(RecyclerView.ViewHolder holder, int position);
}
