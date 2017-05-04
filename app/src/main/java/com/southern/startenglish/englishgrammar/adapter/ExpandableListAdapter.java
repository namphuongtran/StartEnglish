package com.southern.startenglish.englishgrammar.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.southern.startenglish.englishgrammar.R;
import com.southern.startenglish.englishgrammar.entity.Category;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

/**
 * Created by trphu on 3/9/2016.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Category> listHeading;
    private HashMap<String,List<String>> listHeadingChild;

    public ExpandableListAdapter(Context context, List<Category> listHeading,
                                 HashMap<String, List<String>> listHeadingChild) {
        this.context=context;
        this.listHeading=listHeading;
        this.listHeadingChild = listHeadingChild;
    }

    @Override
    public String getChild(int groupPosition, int childPosition)
    {
        return this.listHeadingChild.get(this.listHeading.get(groupPosition).getName()).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {

        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        Log.d("trial","group Position = "+groupPosition+ "child position = " + childPosition); //log de thi anh chọn loglevel  la debug
        String childName=getChild(groupPosition, childPosition);
        if (convertView==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_item,null);
        }
        TextView tvChildName=(TextView)convertView.findViewById(R.id.tvChildName);
        tvChildName.setText(childName);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if(groupPosition<0)
            return 0;
        return this.listHeadingChild.get(this.listHeading.get(groupPosition).getName()).size();
    }

    @Override
    public Category getGroup(int groupPosition) {
        if(groupPosition<0)
            return new Category();
        return this.listHeading.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listHeading.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String parentName=getGroup(groupPosition).getName();
        String cateDescription=getGroup(groupPosition).getDescription();
        if (convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_group,null);
        }
        TextView tvParentName=(TextView) convertView.findViewById(R.id.tvParentName);
        tvParentName.setText(parentName);
        tvParentName.setTypeface(null, Typeface.BOLD);

        TextView cate_description=(TextView)convertView.findViewById(R.id.tvParentNameDes);
        cate_description.setText(cateDescription);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
