package com.example.myfrontend.directionhelpers;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.location.Location;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DraggableCircle {

    private int mFillColorArgb;
    private int mStrokeColorArgb;

        private final Marker mCenterMarker;
        //private final Marker mRadiusMarker;
        private final Circle mCircle;

        public DraggableCircle(LatLng center, double radiusMeters, GoogleMap mMap) {

            //mFillColorArgb = Color.GRAY;
            mFillColorArgb = Color.HSVToColor(70, new float[]{170,218,255});
            mStrokeColorArgb = Color.TRANSPARENT;
            mCenterMarker = mMap.addMarker(new MarkerOptions()
                    .position(center)
                    .draggable(true)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            mCircle = mMap.addCircle(new CircleOptions()
                    .center(center)
                    .radius(radiusMeters)
                    .strokeWidth(10)
                    .strokeColor(mStrokeColorArgb)
                    .fillColor(mFillColorArgb)
                    .clickable(true));
        }
}
