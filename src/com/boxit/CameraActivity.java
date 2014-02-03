package com.boxit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.boxit.R.id;
import com.boxit.camera.CameraPreview;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Context;


//!!! vérifier que la camera fonctionne et existe sinon ne fonctionne pas


public class CameraActivity extends Activity {

    private Camera mCamera;
    private CameraPreview mPreview;
    private // Add a listener to the Capture button
    ImageButton captureButton;
    ImageButton friendMenuButton;
    Button cadeauMenuButton;
    public final static String DEBUG_TAG = "MakePhotoActivity";
	private static final String IMAGE_DIRECTORY_NAME = "Boxit";
	private static final int MEDIA_TYPE_IMAGE = 1;
	private static final int MEDIA_TYPE_VIDEO = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
     // Nous mettons l'application en plein écran et sans barre de titre
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        
        setContentView(R.layout.activity_camera);
        
 
        // Create an instance of Camera
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
        
        
        captureButton = (ImageButton) findViewById(id.button_capture);
        captureButton.bringToFront();
        captureButton.setOnClickListener(new OnPictureClickListener());
        
        friendMenuButton = (ImageButton) findViewById(id.buttonMenuFriend);
        friendMenuButton.bringToFront();
        friendMenuButton.setOnClickListener(new OnMenuFriendClickListener());
        cadeauMenuButton = (Button) findViewById(id.buttonMenuCad);
        cadeauMenuButton.bringToFront();
        cadeauMenuButton.setOnClickListener(new OnMenuCadeauClickListener());
        

    }
    /*
     * ActionListener pour prendre une photo
     */
    private class OnPictureClickListener implements View.OnClickListener{
 
    	        @Override
    	        public void onClick(View v) {
    	            // get an image from the camera
    	            mCamera.takePicture(null, null, mPicture);
    	        }
    	    }
  
    /*
     * ActionListener pour aller au menu des amis
     */
    private class OnMenuFriendClickListener implements View.OnClickListener{
    	
    	@Override
        public void onClick(View v) {
    		Intent i = new Intent(CameraActivity.this, MenuFriendActivity.class);

			startActivity(i);
        }
    	
    	
    }
    
    /*
     * ActionListener pour aller au menu des amis
     */
    private class OnMenuCadeauClickListener implements View.OnClickListener{
    	
    	@Override
        public void onClick(View v) {
    		Intent i = new Intent(CameraActivity.this, MenuFriendActivity.class);

			startActivity(i);
        }
    	
    	
    }
    	
    	
    
    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
            c.setDisplayOrientation(90);
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
    
    private PictureCallback mPicture = new PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

        	/**
        	 * partie du code pour mettre les photos dans la galerie 
        	 */
            File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri contentUri = Uri.fromFile(pictureFile);
            mediaScanIntent.setData(contentUri);
            CameraActivity.this.sendBroadcast(mediaScanIntent);
            
            
            if (pictureFile == null){
                Log.d(DEBUG_TAG, "Error creating media file, check storage permissions ");
                return;
            }

            try {
                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
                Log.d(DEBUG_TAG, "File not found: " + e.getMessage());
            } catch (IOException e) {
                Log.d(DEBUG_TAG, "Error accessing file: " + e.getMessage());
            }
        }
    };
    
    
    /**
     * Creating file uri to store image/video
     */
    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }
     
    /*
     * returning image / video
     */
    private static File getOutputMediaFile(int type) {
     
        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME);
     
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }
     
        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }
     
        return mediaFile;
    }
}