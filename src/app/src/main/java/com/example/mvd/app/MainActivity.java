package com.example.mvd.app;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void OnClick_Query_Single(final View view) {
        new GetCarByIdQueryTask(this, new GetCarByIdQueryRequest())
                .On(new IGetCarByIdQueryListener() {
                    @Override
                    public void Success(GetCarByIdQueryResponse response) {
                        Button button = (Button) view.findViewById(R.id.button2);
                        button.setText(response.Brand);
                    }
                });
    }

    public void OnClick_Query_Array(final View view) {
        new GetCarsQueryTask(this)
                .On(new IGetCarsQueryListener() {
                    @Override
                    public void Success(GetCarsQueryResponse[] response) {
                        Button button = (Button) view.findViewById(R.id.button3);
                        String allBrand = "";
                        for (GetCarsQueryResponse car : response) {
                            allBrand += car.Brand + ",";
                        }
                        button.setText(allBrand);
                    }
                });
    }

    public void OnClick_Command(final View view) {
   /*     SignCommandRequest request = new SignCommandRequest();
        request.Id = "id";
        new SignCommandTask(this, request)
                .On(new ISignCommandListener() {
                    @Override
                    public void Success(Object response) {
                        Button button = (Button) view.findViewById(R.id.button);
                        button.setText("Success");
                    }
                });*/
    }

}
