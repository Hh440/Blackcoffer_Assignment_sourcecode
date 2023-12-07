package com.example.asiignment_problem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnvw;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnvw= findViewById(R.id.bottom_navg);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout= findViewById(R.id.drawable_layout);
        navigationView=findViewById(R.id.drwaer_navg);



        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Howdy Harsh hi!!");
        getSupportActionBar().setSubtitle("Unknown");

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opendrwaer,R.string.closedrwaer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int navid=item.getItemId();
                if(navid==R.id.profile){
                    loadfrag(new Profile(),false);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });





        btnvw.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();

                if(id==R.id.explore){
                    loadfrag(new Explore(),false);

                }else if(id==R.id.network){
                    loadfrag(new Network(),false);
                }else if(id==R.id.chat){
                    loadfrag(new Chat(),false);
                }else if(id==R.id.contact){
                    loadfrag(new Contact(),false);
                }else if(id==R.id.group){
                    loadfrag(new Group(),false);

                }
                return true;
            }
        });

    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void loadfrag(Fragment fragment, Boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag){
            ft.add(R.id.containerframe,fragment);
        }else{
            ft.replace(R.id.containerframe,fragment);
        }
        ft.commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.refine_manu,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.filter){
            try {
                // Handle the filter menu item click here
                Intent intent = new Intent(this, Refine.class);
                startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("YourActivity", "Error starting Refine activity: " + e.getMessage());
                Toast.makeText(this, "Error starting Refine activity", Toast.LENGTH_SHORT).show();
                return false;
            }


        }


        return super.onOptionsItemSelected(item);
    }
}