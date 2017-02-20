package com.spartahacks.app.bargamescores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rogal-dorn on 2/2/17.
 */

public class MyListAdapter extends BaseExpandableListAdapter implements Filterable{

    private Context context;
    private ArrayList<GameItem> itemList;


    public MyListAdapter(Context context, ArrayList<GameItem> itemList){
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getGroupCount() {
        return itemList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return itemList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return itemList.get(groupPosition).getGameDescItem();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GameItem item = (GameItem) getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.gamelist_item, null);
        }
        TextView title = (TextView) convertView.findViewById(R.id.game_listItem_label);
        title.setText(item.getGameTitle());
        TextView type = (TextView) convertView.findViewById(R.id.game_listItem_entityCreated);
        if (item.isUserDefined() == true){
            type.setText("USER");
        }else{
            type.setText("CORE");
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        GameItemDesc item = (GameItemDesc) getChild(groupPosition, childPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.gamelist_item_desc, null);
        }
        TextView desc = (TextView) convertView.findViewById(R.id.game_item_description);
        desc.setText(item.getGameDesc());
        ImageView gameIcon = (ImageView) convertView.findViewById((R.id.game_list_icon));
        gameIcon.setImageBitmap(item.getGameIcon());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public Filter getFilter(){
        Filter filter = new Filter(){
            @Override
            protected FilterResults performFiltering(CharSequence cs){
                FilterResults results = new FilterResults();
                if (cs == null || cs.length() == 0){
                    results.values = itemList;
                    results.count = itemList.size();
                } else {
                    ArrayList<GameItem> tempList = new ArrayList<>();
                    for (GameItem item: itemList){
                        if (item.getGameTitle().toLowerCase().contains(cs.toString().toLowerCase())){
                            tempList.add(item);
                        }
                    }

                    results.values = tempList;
                    results.count = tempList.size();
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results){
                if (results.count == 0){
                    notifyDataSetInvalidated();
                }else {
                    itemList = (ArrayList<GameItem>) results.values;
                    notifyDataSetChanged();
                }
            }
        };
        return filter;
    }
}
