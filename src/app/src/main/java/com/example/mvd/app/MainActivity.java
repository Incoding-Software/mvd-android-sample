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

import org.json.JSONObject;

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
        GetQuestionByLocationQueryRequest request = new GetQuestionByLocationQueryRequest();
        request.LocationId = "71b35aca-a727-4951-ae03-a33e00e942a0";
        new GetQuestionByLocationQueryTask(this, request)
                .On(new IGetQuestionByLocationQueryListener() {
                    @Override
                    public void Success(GetQuestionByLocationQueryResponse[] response) {
                        Button button = (Button) view.findViewById(R.id.button2);
                        String names = "";
                        for (GetQuestionByLocationQueryResponse question : response) {
                            names += question.Type.toString() + ",";
                        }
                        button.setText(names);
                    }

                    @Override
                    public void Error(JsonModelStateData[] modelState) {

                    }
                });
    }

    public void OnClick_Query_Array(final View view) {
       new GetLocationsQueryTask(this)
               .On(new IGetLocationsQueryListener() {
                   @Override
                   public void Success(GetLocationsQueryResponse[] response) {
                       Button button = (Button) view.findViewById(R.id.button3);
                       String allBrand = "";
                       for (GetLocationsQueryResponse locationsQueryResponse : response) {
                           allBrand += locationsQueryResponse.Name + ",";
                       }
                       button.setText(allBrand);
                   }
                   @Override
                   public void Error(JsonModelStateData[] modelState) {

                   }
               });
    }

    public void OnClick_Command(final View view) {

        SignUserCommandRequest request = new SignUserCommandRequest();
        request.UserName = "admin@mail.com";
        request.Password = "password";
        new SignUserCommandTask(this, request)
                .On(new ISignUserCommandListener() {
                    @Override
                    public void Success(SignUserCommandResponse response) {
                        Button button = (Button) view.findViewById(R.id.button);
                        button.setText("Ready");
                    }

                    @Override
                    public void Error(JsonModelStateData[] state) {
                        Button button = (Button) view.findViewById(R.id.button);
                        button.setText(state[0].name + " / " + state[0].errorMessage);
                    }
                });
    }

}
