package com.example.bouncycube;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        GLSurfaceView view = new GLSurfaceView(this);
        view.setEGLContextClientVersion(1);
        view.setRenderer(new CubeRenderer());

        setContentView(view);
    }
}