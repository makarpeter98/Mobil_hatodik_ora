package hu.unideb.inf.mobilsz12.shoppinglist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AppleColorFragment extends Fragment {

    static String colorString = "";

    public AppleColorFragment() {
        colorString = "";

    }

    public static AppleColorFragment newInstance(String param1, String param2) {
        AppleColorFragment fragment = new AppleColorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_apple_color, container, false);

        RadioGroup radioGroup = rootView.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((rg, i) ->
        {
            RadioButton radioButton = rg.findViewById(i);
            colorString = radioButton.getText().toString();
        });

        return rootView;
    }
}