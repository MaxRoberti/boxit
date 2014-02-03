package com.boxit;



import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;


import com.boxit.R;



public class MenuFriendActivity extends FragmentActivity  {
	
	/**
	   * The serialization (saved instance state) Bundle key representing the
	   * current tab position.
	   */

	  
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);//pour aller en arrière
		
		// for each of the sections in the app, add a tab to the action bar.
	    actionBar.addTab(actionBar.newTab().setIcon(R.drawable.ic_action_person)
	        .setTabListener(new TabListener<AmisFragment>(
                    this, "amis", AmisFragment.class)));
	    actionBar.addTab(actionBar.newTab().setIcon(R.drawable.ic_action_add_person)
	        .setTabListener(new TabListener<AddAmisFragment>(
                    this, "addAmis", AddAmisFragment.class)));
	    actionBar.addTab(actionBar.newTab().setText(R.string.label3)
	        .setTabListener(new TabListener<ContactAmisFragment>(
                    this, "contactAmis", ContactAmisFragment.class)));
	    
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 getMenuInflater().inflate(R.menu.menu_friend, menu);
		 SearchView searchView = new SearchView(getActionBar().getThemedContext());
		 MenuItem  refreshItem = menu.findItem(R.id.action_refresh).setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);
		 MenuItem searchItem = menu.findItem(R.id.action_search).setActionView(searchView).setIcon(android.R.drawable.ic_menu_search).setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);
		    // Configure the search info and add any event listeners
		   
		    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	  public void onSaveInstanceState(Bundle outState) {
	    // Serialize the current tab position.
	    outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
	        .getSelectedNavigationIndex());
	  }
	
	

	

	

	  public static class TabListener<T extends Fragment> implements ActionBar.TabListener {
		    private Fragment mFragment;
		    private final Activity mActivity;
		    private final String mTag;
		    private final Class<T> mClass;

		    /** Constructor used each time a new tab is created.
		      * @param activity  The host Activity, used to instantiate the fragment
		      * @param tag  The identifier tag for the fragment
		      * @param clz  The fragment's Class, used to instantiate the fragment
		      */
		    public TabListener(Activity activity, String tag, Class<T> clz) {
		        mActivity = activity;
		        mTag = tag;
		        mClass = clz;
		    }

		    /* The following are each of the ActionBar.TabListener callbacks */

		    public void onTabSelected(Tab tab, FragmentTransaction ft) {
		        // Check if the fragment is already initialized
		        if (mFragment == null) {
		            // If not, instantiate and add it to the activity
		            mFragment = Fragment.instantiate(mActivity, mClass.getName());
		            ft.add(android.R.id.content, mFragment, mTag);
		        } else {
		            // If it exists, simply attach it in order to show it
		            ft.attach(mFragment);
		        }
		    }

		    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		        if (mFragment != null) {
		            // Detach the fragment, because another one is being attached
		            ft.detach(mFragment);
		        }
		    }

		    public void onTabReselected(Tab tab, FragmentTransaction ft) {
		        // User selected the already selected tab. Usually do nothing.
		    }
		}

	


}
