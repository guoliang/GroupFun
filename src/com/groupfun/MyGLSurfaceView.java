package com.groupfun;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class MyGLSurfaceView extends GLSurfaceView {

	private final MyGLRenderer mRenderer;
	private float[] mColor;
	private float mSize;
	
	public MyGLSurfaceView(Context context,int w,int h) {
		super(context);
		// TODO Auto-generated constructor stub
		// Create an OpenGL ES 2.0 context.

        //setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
	
	//
	public void setColor(float[] c){
		this.mColor = c;
	}
	
	//
	public void setSize(float s){
		this.mSize = s;
	}
	
	@Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.
		this.mRenderer.addPoint(e.getX(), e.getY(), 0.f, this.mColor, this.mSize);
		requestRender();
		return true;
		
	}
}

