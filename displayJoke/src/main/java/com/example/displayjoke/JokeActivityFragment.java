package com.example.displayjoke;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);

        Intent intent = getActivity().getIntent();
        String joke = null;
        if (intent.hasExtra(JokeActivity.JOKE_KEY)) {
            joke = intent.getExtras().getString(JokeActivity.JOKE_KEY);
        }

        TextView textView = rootView.findViewById(R.id.joke_textView);
        if (joke != null && joke.length() != 0)
            textView.setText(joke);

        return rootView;

    }
}
