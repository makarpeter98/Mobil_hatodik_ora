package hu.unideb.inf.mobilsz12.shoppinglist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ItemsActivity extends AppCompatActivity {

    public static final String ITEM_KEY = "hu.unideb.inf.mobilsz12.shoppinglist.ItemsActivity.ITEM_KEY_fhgfdhvchfhzfjjfujfjhg";

    private boolean isColorFragmentVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
    }

    public void addItem(View view) {
        Intent replyIntent = new Intent();

        //if (lenyomott gomb szövege == "Cukor") {}

        String buttonText = ((Button) view).getText().toString();
        String sugarString = getString(R.string.sugar);
        String appleString = getString(R.string.apple);

        if(buttonText.equals(sugarString))
        {
            if(isColorFragmentVisible)
            {
                replyIntent.putExtra(ITEM_KEY, buttonText + " " + ColorFragment.colorString);
            }
            else
            {
                displayColorFragment();
                isColorFragmentVisible = true;
                return;
            }
        }
        else if(buttonText.equals(appleString))
        {
            if(isColorFragmentVisible)
            {
                replyIntent.putExtra(ITEM_KEY, buttonText + " " + AppleColorFragment.colorString);
            }
            else
            {
                displayAppleColorFragment();
                isColorFragmentVisible = true;
                return;
            }
        }
        else
        {
            replyIntent.putExtra(ITEM_KEY, ((Button) view).getText());
        }

        setResult(RESULT_OK, replyIntent);
        finish();
    }

    private void displayColorFragment()
    {
        ColorFragment colorFragment = ColorFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, colorFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void displayAppleColorFragment()
    {
        AppleColorFragment appleColorFragment = new AppleColorFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, appleColorFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}