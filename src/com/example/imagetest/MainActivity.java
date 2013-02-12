package com.example.imagetest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView imageView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView = (ImageView) this.findViewById(R.id.imageView2);
		
		// From Resources
		//imageView.setImageResource(R.drawable.test);
		
		// From the Assets Folder
		try {
			InputStream is = this.getAssets().open("test.png");
			Bitmap bm = BitmapFactory.decodeStream(is);
			imageView.setImageBitmap(bm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// From the SD Card
		//Bitmap bm = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/test.png");
		//imageView.setImageBitmap(bm);
	}
	
	public void buttonClicked(View v) {
		Uri data = Uri.parse("file:///" + Environment.getExternalStorageDirectory() + "/myfavoritepicture.mp3");
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(data, "audio/mp3");
		startActivity(intent);
	}

}
