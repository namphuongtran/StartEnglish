package com.southern.startenglish.englishgrammar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.southern.startenglish.englishgrammar.adapter.ExpandableListAdapter;
import com.southern.startenglish.englishgrammar.adapter.NavDrawerListAdapter;
import com.southern.startenglish.englishgrammar.entity.Category;
import com.southern.startenglish.englishgrammar.entity.NavDrawerItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //expandable list view
    private ExpandableListAdapter expandableListAdapter;
    private ExpandableListView expandableListView;
    private List<Category> listHeadingParent;
    private HashMap<String,List<String>> listHeadingChild;

    //slide menu nav
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //expandable list view
        prepareListData();
        expandableListView=(ExpandableListView)findViewById(R.id.expandListParent);
        expandableListAdapter=new ExpandableListAdapter(this,listHeadingParent,listHeadingChild);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new OnChildClickListener());

        //slide menu
        mTitle = mDrawerTitle = getTitle();

        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        prepareDataSlideMenu();
        // Recycle the typed array
        navMenuIcons.recycle();
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        /*getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);*/

        /*mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.mipmap.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ){
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);*/

        /*if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }*/
    }

    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    private void prepareListData() {
        listHeadingParent = new ArrayList<Category>();
        listHeadingChild = new HashMap<String, List<String>>();

        // Adding child data
        Category categoryA=new Category();
        categoryA.setName("Part A: Tenses");
        categoryA.setDescription("Hình thức cơ bản của động từ trong tiếng Anh");

        listHeadingParent.add(categoryA);

        Category categoryB=new Category();
        categoryB.setName("Part B: Clauses");
        categoryB.setDescription("Các loại mệnh đề");

        listHeadingParent.add(categoryB);

        Category categoryC=new Category();
        categoryC.setName("Part C: The Active & Passive voice");
        categoryC.setDescription("Câu chủ động và câu bị động");
        listHeadingParent.add(categoryC);

        // Adding child data
        List<String> partA = new ArrayList<String>();
        partA.add("Hình thức cơ bản của Động từ");
        partA.add("Cách sử dụng & Từ chìa khóa");

        List<String> partB = new ArrayList<String>();
        partB.add("Mệnh đề trạng ngữ chỉ thời gian");
        partB.add("Mệnh đề điều kiện");
        partB.add("Mệnh đề sau WISH và IF ONLY");
        partB.add("Cụm từ & mệnh đề chỉ mục đích");
        partB.add("Từ, cụm từ chỉ kết quả");
        partB.add("Cụm từ chỉ lý do");
        partB.add("Cụm từ & mệnh đề chỉ sự nhượng bộ");
        partB.add("Mệnh đề quan hệ");
        partB.add("Cách giải bài tập dùng đại từ quan hệ WHO, WHICH");
        partB.add("Rút gọn mệnh đề quan hệ");
        partB.add("Câu gián tiếp");
        partB.add("Nguyên mẫu & danh động từ");

        List<String> partC = new ArrayList<String>();
        partC.add("Cấu trúc");
        partC.add("How to change into the passive voice");
        partC.add("Causative forms");
        partC.add("Verbs of opinion");

        listHeadingChild.put(listHeadingParent.get(0).getName(), partA); // Header, Child data
        listHeadingChild.put(listHeadingParent.get(1).getName(), partB);
        listHeadingChild.put(listHeadingParent.get(2).getName(), partC);
    }

    private void prepareDataSlideMenu(){
        navDrawerItems = new ArrayList<NavDrawerItem>();

        // adding nav drawer items to array
        // Home
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        // Find People
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        // Photos
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        // Communities, Will add a counter here
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
        // Pages
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        // What's hot, We  will add a counter here
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1)));
    }

    private class OnChildClickListener implements ExpandableListView.OnChildClickListener{
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Log.d("trial","child position = "+ childPosition); //log de thi anh chọn loglevel  la debug

        switch (groupPosition){
            case 0:
                switch (childPosition){
                    case 0:
                        Intent intentPartA1=new Intent(MainActivity.this,PartAFormActivity.class);
                        startActivity(intentPartA1);
                        break;
                    case 1:
                        Intent intentPartA2=new Intent(MainActivity.this,PartAKeyWordActivity.class);
                        startActivity(intentPartA2);
                        break;
                }
                break;
            case 1:
                switch (childPosition){
                    case 0:
                        Intent intentPartB1=new Intent(MainActivity.this,PartBTimeClauseActivity.class);
                        startActivity(intentPartB1);
                        break;
                    case 1:
                        Intent intentPartB2=new Intent(MainActivity.this,PartAKeyWordActivity.class);
                        startActivity(intentPartB2);
                        break;
                }
                break;
        }

        return false;
    }}

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    /*@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }*/

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    /*@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }*/

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new RemindersFragment();
                break;
            /*case 1:
                fragment = new FindPeopleFragment();
                break;
            case 2:
                fragment = new PhotosFragment();
                break;
            case 3:
                fragment = new CommunityFragment();
                break;
            case 4:
                fragment = new PagesFragment();
                break;
            case 5:
                fragment = new WhatsHotFragment();
                break;*/

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
}
