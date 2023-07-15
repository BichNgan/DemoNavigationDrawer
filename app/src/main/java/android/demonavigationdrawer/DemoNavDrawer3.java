package android.demonavigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class DemoNavDrawer3 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_nav_drawer3);
        //-------------------------------------------------
        frameLayout= (FrameLayout)findViewById(R.id.frame_layout3);

        toolbar=(Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        //Gắn toggle vào toolbar và khi click vào toggle thì nav_draw được đóng/mở
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_3);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this,drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Xử lý sự kiện click từng item của nav
        navigationView = (NavigationView) findViewById(R.id.nav_drawer3);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.home3)
                {
                    loadFragment(new HomeFrag3());

                    return true;
                }else if(id==R.id.gallery3)
                {
                    loadFragment(new GallFrag3());
                    return true;
                }
                return false;
            }
        });
    }

    public void  loadFragment(Fragment fragment)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();
        ft.replace(R.id.frame_layout3,fragment);
        ft.commit();
        drawerLayout.closeDrawer(GravityCompat.START); //đóng nav
    }
}