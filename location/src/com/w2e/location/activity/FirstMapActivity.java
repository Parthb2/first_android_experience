package com.w2e.location.activity;

import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.FrameLayout.LayoutParams;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;

public class FirstMapActivity extends MapActivity {

	private MapView mapView;
	private LinearLayout rootView;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		rootView = new LinearLayout(this);
		setContentView(rootView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		initializeMap();
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	protected boolean isLocationDisplayed() {
		return true;
	}
	
	/**
	 * Set up the map. First get a key:
	 * $ keytool -list -alias androiddebugkey -keystore <path_to_debug_keystore>.keystore -storepass android -keypass android
	 */
	private void initializeMap() {
		FrameLayout frame = new FrameLayout(this);
		frame.setBackgroundColor(Color.BLACK);
		frame.setPadding(2, 2, 2, 2);
		mapView = new MapView(this, "0xNpjXHPZ2YOlycg_Qr6KRiCRXiOBgNrbBGu12g");
		frame.addView(mapView, new FrameLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		mapView.setSatellite(false);
		mapView.setClickable(true);
		mapView.setEnabled(true);
		rootView.addView(frame, 0, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		
		View zoomControls = mapView.getZoomControls();
		FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM
						| Gravity.CENTER_HORIZONTAL);
		frame.addView(zoomControls, layoutParams);
		
		final List<Overlay> overlays = mapView.getOverlays();
		MyLocationOverlay myLocationOverlay = new MyLocationOverlay(this, mapView);
		overlays.add(myLocationOverlay);
	}

}
