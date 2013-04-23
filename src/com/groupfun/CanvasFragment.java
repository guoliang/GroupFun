package com.example.groupfun;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.groupfun.MyGLSurfaceView;

public class CanvasFragment extends Fragment{
	
	private GLSurfaceView mView;
	private float[]       mColor = {0,0,0};
	private float         mSize = 3.f;
	private int           mWinWidth;
	private int           mWinHeight;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		Display disp = this.getActivity().getWindowManager().getDefaultDisplay();
		this.mWinWidth = disp.getWidth();
		this.mWinHeight = disp.getHeight();
		
		mView = new MyGLSurfaceView(this.getActivity(),this.mWinWidth,this.mWinHeight);
		this.setColor(mColor);
		this.setSize(mSize);
        // Inflate the layout for this fragment
        return mView;
    }

	@Override
	public void onPause(){
		super.onPause();
		mView.onPause();
	}
	
	@Override
	public void onResume(){
		super.onResume();
		mView.onResume();
	}
	
	//set the current drawing color
	public void setColor(float[] c){
		this.mColor = c;
		MyGLSurfaceView temp = (MyGLSurfaceView)this.mView;
		temp.setColor(this.mColor);
	}
	
	//set the current drawing size
	public void setSize(float s){
		this.mSize = s;
		MyGLSurfaceView temp = (MyGLSurfaceView)this.mView;
		temp.setSize(this.mSize);
	}
}


