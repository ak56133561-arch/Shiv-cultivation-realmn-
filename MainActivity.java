package com.example.shivacultivation;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.os.Build;
import android.Manifest;
import android.content.pm.PackageManager;
public class MainActivity extends Activity {
 @Override public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  if (Build.VERSION.SDK_INT >= 33 && checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
   requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 100);
  WebView web = new WebView(this);
  WebSettings settings = web.getSettings();
  settings.setJavaScriptEnabled(true);
  settings.setDomStorageEnabled(true);
  web.setWebViewClient(new WebViewClient());
  setContentView(web);
  web.loadUrl("file:///android_asset/index.html");
 }
 @Override public void onBackPressed() {
  setResult(RESULT_CANCELED);
  super.onBackPressed();
 }
}