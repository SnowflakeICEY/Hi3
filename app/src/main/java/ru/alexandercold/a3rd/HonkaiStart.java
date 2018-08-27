package ru.alexandercold.a3rd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class HonkaiStart extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honkai_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_pay) {
            intent =  new Intent(android.content.Intent.ACTION_VIEW);
            startActivity(new Intent(Intent.ACTION_VIEW)
                    .setData(Uri.parse("http://qiwi.me/hi3")));
        } else if (id == R.id.nav_thank) {
intent = new Intent(HonkaiStart.this, ThankActivity.class);
startActivity(intent);
        } else if (id == R.id.nav_settings) {
       //     intent = new Intent(HonkaiStart.this, SettingsActivity.class);
         //   startActivity(intent);
        } else if (id == R.id.nav_share) {
            intent =  new Intent(android.content.Intent.ACTION_VIEW);
            startActivity(new Intent(Intent.ACTION_VIEW)
                    .setData(Uri.parse("http://vk.com/snowflake_icey")));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onClickHonkai(View view) {
        Intent intent = new Intent(HonkaiStart.this, HonkaiActivity.class);
        startActivity(intent);
    }
}
