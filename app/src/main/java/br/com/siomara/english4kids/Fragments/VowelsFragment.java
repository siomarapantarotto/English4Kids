package br.com.siomara.english4kids.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.siomara.english4kids.R;


/**
 * Vowels fragment.
 */
public class VowelsFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    private TextView txtA, txtE, txtI, txtO, txtU;


    public VowelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vowels, container, false);

        txtA = view.findViewById(R.id.txtA);
        txtE = view.findViewById(R.id.txtE);
        txtI = view.findViewById(R.id.txtI);
        txtO = view.findViewById(R.id.txtO);
        txtU = view.findViewById(R.id.txtU);

        // Apply click events to all buttons to be treated by one method
        txtA.setOnClickListener(this);
        txtE.setOnClickListener(this);
        txtI.setOnClickListener(this);
        txtO.setOnClickListener(this);
        txtU.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("Button Clicked", "Item: " + v.getId());

        switch (v.getId()) {
            case R.id.txtA:
                playSound(R.raw.a);
                break;
            case R.id.txtE:
                playSound(R.raw.e);
                break;
            case R.id.txtI:
                playSound(R.raw.i);
                break;
            case R.id.txtO:
                playSound(R.raw.o);
                break;
            case R.id.txtU:
                playSound(R.raw.u);
                break;
        }
    }

    public void playSound (int sound) {
        mediaPlayer = MediaPlayer.create(getActivity(), sound);
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

