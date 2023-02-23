package com.example.internvilla.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentManager fm;
    NavigationView nav_view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        fm = getSupportFragmentManager();
        drawerLayout = findViewById(R.id.drawer);
        nav_view1=findViewById(R.id.nav_view);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nav_view1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_login) {
                    fm.beginTransaction().replace(R.id.frame, new LoginPage()).commit();
                }else if(id == R.id.menu_register){
                    fm.beginTransaction().replace(R.id.frame, new RegisterPage()).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT | GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }
}

/*
drawer = findViewById(R.id.drawer);
        nav_view1 = findViewById(R.id.nav_view);
        DrawerLayout drawer = findViewById(R.id.drawer);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.purple_200));
        } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
        Window window = MainActivity.this.getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // int statusBarHeight = (int) dpToPx(24);
        View view = new View(MainActivity.this);
        view.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT));
        //view.getLayoutParams().height = statusBarHeight;
        ((ViewGroup) window.getDecorView()).addView(view);
        view.setBackgroundColor(getResources().getColor(R.color.purple_200));
        }
        fm = getSupportFragmentManager();
        nav_view1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
@Override
public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_login) {
        fm.beginTransaction().replace(R.id.frame, new LoginPage()).commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
        }
        });
        }

@Override
public void onBackPressed() {
        // TODO Auto-generated method stub
        if (drawer.isDrawerOpen(Gravity.LEFT | GravityCompat.START)) {
        drawer.closeDrawers();
        return;
        }
        super.onBackPressed();
        }*/
