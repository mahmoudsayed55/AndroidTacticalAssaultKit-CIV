
package com.atakmap.android.metrics.activity;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.annotation.Nullable;

import com.atakmap.android.metrics.MetricsApi;

/**
 * Augments the TabActivity class to provide for metric logging utilizing the same metrics api.
 */
public class MetricTabActivity extends TabActivity {

    private void recordState(String state) {
        if (MetricsApi.shouldRecordMetric()) {
            final Bundle b = new Bundle();
            b.putString("class", this.getClass().toString());
            b.putString("state", "onStart");
            MetricsApi.record("activity", b);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recordState("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        recordState("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        recordState("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        recordState("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        recordState("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recordState("onDestroy");
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (MetricsApi.shouldRecordMetric()) {
            Bundle b = new Bundle();
            b.putString("class", this.getClass().toString());
            b.putParcelable("keyevent", event);
            MetricsApi.record("activity", b);

        }
        return super.dispatchKeyEvent(event);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (MetricsApi.shouldRecordMetric()) {
            Bundle b = new Bundle();
            b.putString("class", this.getClass().toString());
            b.putParcelable("keyevent", event);
            MetricsApi.record("activity", b);
        }
        return super.dispatchTouchEvent(event);
    }

}
