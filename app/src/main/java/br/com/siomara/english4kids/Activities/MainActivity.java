package br.com.siomara.english4kids.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import br.com.siomara.english4kids.Fragments.AnimalsFragment;
import br.com.siomara.english4kids.Fragments.NumbersFragment;
import br.com.siomara.english4kids.Fragments.VowelsFragment;
import br.com.siomara.english4kids.R;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getActionBar().setElevation(0); // supress shadow
        //getActionBar().setTitle("Learn English"); // Instead of English 4 Kids as title

        smartTabLayout = findViewById(R.id.smartTabLayout);
        viewPager = findViewById(R.id.viewPager);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Animals", AnimalsFragment.class)
                        .add("Numbers", NumbersFragment.class)
                        .add("Vowels", VowelsFragment.class)
                        .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);

    }
}