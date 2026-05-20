package com.example.bouncycube;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;
import java.lang.Math;

public class CubeRenderer implements GLSurfaceView.Renderer {

    private Cube mCube;
    private float mTransY = 0;
    private float mAngle = 0;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        mCube = new Cube();

        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glClearColor(0f, 0f, 0f, 1f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        gl.glViewport(0,0,width,height);

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        float fieldOfView = 30.0f / 57.3f;
        float aspect = (float) width / height;
        float zNear = 0.1f;
        float zFar = 1000f;

        float size = zNear * (float)Math.tan(fieldOfView / 2.0f);

        gl.glFrustumf(
                -size, size,
                -size / aspect, size / aspect,
                zNear, zFar
        );

        gl.glMatrixMode(GL10.GL_MODELVIEW);
    }

    @Override
    public void onDrawFrame(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();

        // translation (bounce)
        gl.glTranslatef(0.0f, (float)Math.sin(mTransY), -7.0f);
        mTransY += 0.075f;

        // rotations
        gl.glRotatef(mAngle, 0f, 1f, 0f);
        gl.glRotatef(mAngle, 1f, 0f, 0f);
        mAngle += 0.4f;

        mCube.draw(gl);
    }
}