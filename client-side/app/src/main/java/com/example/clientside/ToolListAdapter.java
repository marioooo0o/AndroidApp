package com.example.clientside;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ToolListAdapter  extends RecyclerView.Adapter<ToolListAdapter.ToolViewHolder>  {
    public static final String TOOL_URL = "com.example.clientside.TOOL_URL";
    private final android.view.LayoutInflater layoutInflater;
    private List<Tool> toolList;

    public ToolListAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        this.toolList = null;
    }

    public void setToolList(List<Tool> toolList){
        this.toolList = toolList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ToolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = layoutInflater.inflate(R.layout.tool_row, parent, false);
        return  new ToolViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ToolViewHolder holder, int position) {
        Tool tool = toolList.get(position);
        holder.toolName.setText(tool.getTitle());
        holder.url = tool.getUrl();
    }

    @Override
    public int getItemCount() {
        if(toolList != null){
            return  toolList.size();
        }
        return 0;
    }

    public class ToolViewHolder extends RecyclerView.ViewHolder{

        Button toolName;
        String url;

        public ToolViewHolder(@NonNull View itemView) {
            super(itemView);
            toolName = itemView.findViewById(R.id.btn_tool);
            toolName.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), WebViewer.class);
                intent.putExtra(TOOL_URL, url);
                v.getContext().startActivity(intent);
            });
        }
    }

}
