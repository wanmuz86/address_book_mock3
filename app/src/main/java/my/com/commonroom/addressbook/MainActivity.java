package my.com.commonroom.addressbook;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AddressViewModel mAddressViewModel;
    public static final int NEW_ADDRESS_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, NEW_ADDRESS_ACTIVITY_REQUEST_CODE);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final AddressListAdapter adapter = new AddressListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAddressViewModel = ViewModelProviders.of(this).get(AddressViewModel.class);
        mAddressViewModel.getAllAddresses().observe(this, new Observer<List<Address>>() {
            @Override
            public void onChanged(@Nullable final List<Address> addresses) {
                // Update the cached copy of the words in the adapter.
                adapter.setAddresses(addresses);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_ADDRESS_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Address word = new Address(data.getStringExtra(AddActivity.EXTRA_REPLY_FIRST_NAME),data.getStringExtra(AddActivity.EXTRA_REPLY_LAST_NAME),data.getStringExtra(AddActivity.EXTRA_REPLY_ADDRESS1),"",data.getStringExtra(AddActivity.EXTRA_REPLY_ADDRESS2),"",data.getStringExtra(AddActivity.EXTRA_REPLY_EMAIL),data.getStringExtra(AddActivity.EXTRA_REPLY_PHONE),data.getStringExtra(AddActivity.EXTRA_REPLY_CELL));
            mAddressViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                   "Data not saved",
                    Toast.LENGTH_LONG).show();
        }
    }
}
