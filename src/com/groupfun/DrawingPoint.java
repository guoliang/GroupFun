package com.example.groupfun;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class DrawingPoint {

	private FloatBuffer vertexBuffer;
	private final float[] mColor;
	private float mCoords[];
	private final float mSize;
	
	public DrawingPoint(float x,float y,float z,float[] c,float size){
		
		mCoords = new float[3];
		mCoords[0] = x;
		mCoords[1] = y;
		mCoords[2] = z;
		mColor = c;
		mSize = size;
		load();
	}
	
	private void load(){
		
		ByteBuffer bb = ByteBuffer.allocateDirect(
               // (number of coordinate values * 4 bytes per float)
               mCoords.length * 4);
       // use the device hardware's native byte order
       bb.order(ByteOrder.nativeOrder());

       // create a floating point buffer from the ByteBuffer
       vertexBuffer = bb.asFloatBuffer();
       // add the coordinates to the FloatBuffer
       vertexBuffer.put(mCoords);
       // set the buffer to read the first coordinate
       vertexBuffer.position(0);
		
	}
	
	public void draw(GL10 gl){
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
   	
   	    gl.glColor4f(this.mColor[0], this.mColor[1], this.mColor[2], 1);
   	    
   	    gl.glPointSize(mSize);
   	    
   	    gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
   	
   	    gl.glDrawArrays(GL10.GL_POINTS, 0, 1);
   	
   	    gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}
