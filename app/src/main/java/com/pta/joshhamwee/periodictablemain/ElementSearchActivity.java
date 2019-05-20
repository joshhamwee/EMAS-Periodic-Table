package com.pta.joshhamwee.periodictablemain;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

public class ElementSearchActivity extends AppCompatActivity {
    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_search);

        // Created a text view that will be displayed when no results are found
        textView = findViewById(R.id.textView);
        textView.setText(Html.fromHtml("<p style = text-shadow:4px 4px 8px #666;> <b> Uh oh! No search results were found... </b> </p>" +
                                        "<p> (Click the back button to return to the home page.) </p>") );
        textView.setVisibility(View.INVISIBLE);

        //Find the list of elements
        listView = findViewById(R.id.listView);
        //Set onClick listeners for each element in the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Convert the text data into a string
                CharSequence charSequence = ((TextView)view).getText();
                final StringBuilder sb = new StringBuilder(charSequence.length());
                sb.append(charSequence);
                //Send full string to handleListItemClick
                handleListItemClick(sb.toString());
            }
        });

        //Start the search Intent
        handleSearch();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleSearch();
    }

    //when the search starts
    private void handleSearch(){
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            String searchQuery = intent.getStringExtra(SearchManager.QUERY);

            if (ElementsData.filterData(searchQuery).isEmpty()){
                // If there are no search results, display the text view instead of the list view
                listView.setVisibility(View.INVISIBLE);
                textView.setVisibility((View.VISIBLE));
            }
            else {
                //Use our customSearchAdapter to filter the data
                CustomSearchAdapter adapter = new CustomSearchAdapter(this, android.R.layout.simple_dropdown_item_1line, ElementsData.filterData(searchQuery));
                listView.setAdapter(adapter);
            }

        }else if(Intent.ACTION_VIEW.equals(intent.getAction())) {
            String selectedSuggestionRowId =  intent.getDataString();
            Toast.makeText(this, "selected search suggestion "+ selectedSuggestionRowId, Toast.LENGTH_SHORT).show();
        }
    }

    //String of element is passed into this function
    private void handleListItemClick(String selectedItem) {
        String[] splitElementName = selectedItem.split(" - ");  //Use regular expressions to get the Elements atomic size
        Intent intent = new Intent(this,DisplayElementDataActivity.class); //Create the intent that opens the new activity
        intent.putExtra("ElementIDSearch", Integer.parseInt(splitElementName[2])); //Put extra data into the intent so that next activity knows what element was clicked on
        startActivity(intent); //Execute the intent
    }

    //Make sure that the activity is closed when back button is pressed. returns to main activity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

}
