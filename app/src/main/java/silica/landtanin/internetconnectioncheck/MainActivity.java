package silica.landtanin.internetconnectioncheck;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button checkNetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bindwidget
        bindwidget();

        //Check Online Method
        isOnline();

        //button controller
        buttonController();
    }

    private void bindwidget() {

        checkNetButton = (Button) findViewById(R.id.button);

    }

    private void buttonController() {
        checkNetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOnline() == true) {
                    Toast.makeText(MainActivity.this, "Connected", 5000).show();
                } else {
                    Toast.makeText(MainActivity.this, "Connection Failed", 5000).show();
                }
            }
        });
    }

    private boolean isOnline() {

        Boolean result = false;

        ConnectivityManager objConnectManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo objNetWorkInfo = objConnectManager.getActiveNetworkInfo();

        if (objNetWorkInfo != null && objNetWorkInfo.isConnected()) {
            result = true;
        } else {
            result = false;
        }

        return result;
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
}
