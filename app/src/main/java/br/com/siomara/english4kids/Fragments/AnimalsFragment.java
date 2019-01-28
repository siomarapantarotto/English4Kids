package br.com.siomara.english4kids.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;

import br.com.siomara.english4kids.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalsFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    private ImageButton imageButtonDog, imageButtonCat, imageButtonLion,
                        imageButtonCow, imageButtonSheep, imageButtonMonkey;

    public AnimalsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        imageButtonDog      = view.findViewById(R.id.imageButtonDog);
        imageButtonCat      = view.findViewById(R.id.imageButtonCat);
        imageButtonLion     = view.findViewById(R.id.imageButtonLion);
        imageButtonCow      = view.findViewById(R.id.imageButtonCow);
        imageButtonSheep    = view.findViewById(R.id.imageButtonSheep);
        imageButtonMonkey   = view.findViewById(R.id.imageButtonMonkey);

        // Apply click events to all buttons to be treated by one method
        imageButtonDog.setOnClickListener(this);
        imageButtonCat.setOnClickListener(this);
        imageButtonLion.setOnClickListener(this);
        imageButtonCow.setOnClickListener(this);
        imageButtonSheep.setOnClickListener(this);
        imageButtonMonkey.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("Button Clicked", "Item: " + v.getId());

        switch (v.getId()) {
            case R.id.imageButtonDog:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                playSound();
                break;
            case R.id.imageButtonCat:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                playSound();
                break;
            case R.id.imageButtonLion:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                playSound();
                break;
            case R.id.imageButtonCow:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                playSound();
                break;
            case R.id.imageButtonSheep:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                playSound();
                break;
            case R.id.imageButtonMonkey:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
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
