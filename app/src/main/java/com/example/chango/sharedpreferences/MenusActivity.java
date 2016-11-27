package com.example.chango.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenusActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        Button bShowPreferences =
                (Button) findViewById(R.id.button);
        preferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        bShowPreferences.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                String username =
                        preferences.getString("username", "n/a");
                String password = preferences.getString(
                        "password", "n/a");
                showPreferences(username, password);
            }
        });

        Button buttonChangePreferences =
                (Button) findViewById(R.id.button2);
        buttonChangePreferences.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        actualizarValorPrefrerencias();
                    }
        });
    }

    private void actualizarValorPrefrerencias() {
        SharedPreferences.Editor edit = preferences.edit();
        String username = preferences.getString("username", "n/a");
        StringBuffer buffer = new StringBuffer();
        for (int i = username.length() - 1; i >= 0; i--) {
            buffer.append(username.charAt(i));
        }
        edit.putString("username", buffer.toString());
        edit.commit();
        Toast.makeText(this, "Explique que realiza",
                Toast.LENGTH_LONG).show();
    }

    private void showPreferences(String username, String password) {
        Context context = getApplicationContext();
        String text = username+"::"+password;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_preferences, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.preferences:
                Intent i = new Intent(this, MisPreferencias.class);
                startActivity(i);
                Toast.makeText(this, "Introduce nombre/pass",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

}
