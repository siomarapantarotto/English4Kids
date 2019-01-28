package br.com.siomara.english4kids.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import br.com.siomara.english4kids.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    private ImageButton imageButtonOne, imageButtonTwo, imageButtonThree,
                        imageButtonFour, imageButtonFive, imageButtonSix;

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);

        imageButtonOne      = view.findViewById(R.id.imageButtonOne);
        imageButtonTwo      = view.findViewById(R.id.imageButtonTwo);
        imageButtonThree    = view.findViewById(R.id.imageButtonThree);
        imageButtonFour     = view.findViewById(R.id.imageButtonFour);
        imageButtonFive     = view.findViewById(R.id.imageButtonFive);
        imageButtonSix      = view.findViewById(R.id.imageButtonSix);

        // Apply click events to all buttons to be treated by one method
        imageButtonOne.setOnClickListener(this);
        imageButtonTwo.setOnClickListener(this);
        imageButtonThree.setOnClickListener(this);
        imageButtonFour.setOnClickListener(this);
        imageButtonFive.setOnClickListener(this);
        imageButtonSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("Button Clicked", "Item: " + v.getId());

        switch (v.getId()) {
            case R.id.imageButtonOne:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                playSound();
                break;
            case R.id.imageButtonTwo:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                playSound();
                break;
            case R.id.imageButtonThree:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                playSound();
                break;
            case R.id.imageButtonFour:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                playSound();
                break;
            case R.id.imageButtonFive:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                playSound();
                break;
            case R.id.imageButtonSix:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                playSound();
                break;
        }
    }

    public void playSound () {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
