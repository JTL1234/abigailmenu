package com.estellore.estelloremenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the action bar title and subtitle
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Main Title");
            getSupportActionBar().setSubtitle("Subtitle");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search) {
            loadFragment(new My_Fragment()); // Should now be recognized
            return true;
        } else if (item.getItemId() == R.id.folder) {
            displayDialogFragment();
            return true;
        } else if (item.getItemId() == R.id.exit) {
            finishAffinity();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Method to load a fragment
    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    // Method to display the dialog fragment
    private void displayDialogFragment() {
        MyDialog dialogFragment = new MyDialog();
        dialogFragment.show(getSupportFragmentManager(), "MyDialog");
    }
}
