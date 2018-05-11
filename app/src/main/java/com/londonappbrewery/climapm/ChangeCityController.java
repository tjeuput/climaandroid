package com.londonappbrewery.climapm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeCityController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //135 link with layout
        setContentView(R.layout.change_city_layout);

        //135-2 the change_city_layout has two views that we need to link to the activity.
        //enter city name and back button
        // create EditText as editTextField = cast as (EditText) findViewById is contructor/method that read/translate from  (paramater)
        final EditText editTextField = (EditText) findViewById(R.id.queryET);
        ImageButton backbutton = (ImageButton) findViewById(R.id.backButton);

        //135-3 set unclick listener on the back button then inside of oncllick callback
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
            //135-4 hook up the <=> button in the weather controller so that sends the user to the change City.


        });

editTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        String newCity = editTextField.getText().toString();

        //137 - navigate back to the weather control / activity
        Intent newCityIntent = new Intent(ChangeCityController.this, WeatherController.class);

       //138 - to let the weather controller activity know about the newCityName, we package the city name into the intent as extra
        newCityIntent.putExtra("City", newCity);
        startActivity(newCityIntent);
        return false;
    }
});

    }

}
