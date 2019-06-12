package com.example.navigationstudy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drower);
        toolbar = (Toolbar)findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drowerlayout_id); //getting reference of drower layout
        navigationView = (NavigationView) findViewById(R.id.navigationView_id); //getting reference of drower layout
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);

        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.adddishes_id:

                Toast.makeText( getApplicationContext(),"add Dish", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addrecipies_id:

                Toast.makeText( getApplicationContext(),"add Recipie", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dishes_id:
                Toast.makeText( getApplicationContext()," view Dish", Toast.LENGTH_SHORT).show();
                break;

            case R.id.recipies_id:
                Intent intent = new Intent(this,CustomList.class);
                startActivity(intent);
                Toast.makeText( getApplicationContext()," view recipie", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START); // this close navigation drower to the left

        return true;
    }



    @Override
    /*  onBackpressed method here is used to close navigation drawer only.  */
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}
