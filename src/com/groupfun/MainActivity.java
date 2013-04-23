package com.groupfun;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends FragmentActivity implements ColorPanelFragment.OnButtonClickedListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//remove the title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//implements the interfaces of colorPanelfragment
	public void onGreenButtonClicked(){
		
		CanvasFragment canvas = (CanvasFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
		ColorPanelFragment colorpanel = (ColorPanelFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
		canvas.setColor(colorpanel.getGreenColor());

	}
	
	
}
