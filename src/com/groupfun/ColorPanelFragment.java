package com.groupfun;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ColorPanelFragment extends Fragment{

    OnButtonClickedListener mCallback;
	
	public interface OnButtonClickedListener{
		public void onGreenButtonClicked();
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_colorpanel_, container, false);
		
		//green button
		ImageButton button1 = (ImageButton) view.findViewById(R.id.imageButton1);
        button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCallback.onGreenButtonClicked();
			}
		});
        
        return view;
    }
	
	public float[] getGreenColor(){
		float green[] = {0,1,0};
		return green;
	}
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnButtonClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnButtonClickedListener");
        }
    }
}
