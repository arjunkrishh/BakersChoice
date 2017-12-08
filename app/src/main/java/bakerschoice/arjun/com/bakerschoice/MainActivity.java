package bakerschoice.arjun.com.bakerschoice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
private DrawerLayout drawerLayout;
private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        NavigationView drawers=(NavigationView)findViewById(R.id.navigation);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SetupDrawer(drawers);
    }

    public boolean selectItemDrawer(MenuItem item)
    {

        Fragment fragment=null;
        Class fragmentClass;
        switch (item.getItemId())
        {
            case R.id.Cakes:
                fragmentClass=Cakes.class;
                break;
            case R.id.Cookies
                    :
                fragmentClass=Cookies.class;
                break;
            case R.id.Chocolates:
                fragmentClass=Chocolates.class;
                break;
            case R.id.Burgers:
                fragmentClass=Burgers.class;
                break;
                case R.id.Desserts:
                fragmentClass=Desserts.class;
                break;
            case R.id.HotBeverages:
                fragmentClass=HotBeverages.class;
                break;
            case R.id.IceCreams:
                fragmentClass=IceCreams.class;
                break;
            case R.id.Juices:
                fragmentClass=Juices.class;
                break;
            case R.id.MilkShakes:
                fragmentClass=Milkshakes.class;
                break;
            case R.id.MockTails:
                fragmentClass=MockTails.class;
                break;
            case R.id.Pizzas:
                fragmentClass=Pizzas.class;
                break;
            case R.id.SandWiches:
                fragmentClass=Sandwiches.class;
                break;
                default:
                    fragmentClass=MainActivity.class;
        }
        try
        {
            fragment=(Fragment) fragmentClass.newInstance();
        }
          catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Main,fragment).commit();
        item.setChecked(true);
        drawerLayout.closeDrawers();
         return true;
    }
    public void SetupDrawer(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }
}
