package com.example.groupfun;

import java.util.Vector;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView;


public class MyGLRenderer implements GLSurfaceView.Renderer{
	
	private Vector<DrawingPoint> mPoints = new Vector<DrawingPoint>();
	
	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		int num = this.mPoints.size();
		for(int i=0; i < num; i++){
			this.mPoints.get(i).draw(gl);
		}

	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		gl.glViewport(0, 0, width, height);
		
        //float aspect = (float)width/(float)height;
		
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		
		gl.glOrthof(0.f, width, 0.f, height, 1.f, -1.f);
	
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		// TODO Auto-generated method stub
		gl.glClearColor(1.f, 1.f, 1.f, 1.f);
	}
	
	public void addPoint(float x,float y,float z,float[] c,float s){
		
		this.mPoints.addElement(new DrawingPoint(x,y,z,c,s));
	}
	
}
