package com.trashgo.app.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;

import com.trashgo.app.MainActivity;
import com.trashgo.app.R;
import com.trashgo.app.aiActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private ViewFlipper viewFlipper;
    private ProgressBar progressBar;
    private Button button;
    private int progressValue = 0;
    private int clickCount = 0;

    private List<String> buttonTexts;
    private int currentIndex = 0;

    MainActivity mainActivity;

    public TreeFragment() {
        // Required empty public constructor
    }

    public static TreeFragment newInstance(String param1, String param2) {
        TreeFragment fragment = new TreeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**by dotom**/
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tree, container, false);

        viewFlipper = view.findViewById(R.id.imageViewtree);
        //viewFlipper.setFlipInterval(3000); // 이미지 전환 간격 (3초)
        //viewFlipper.startFlipping(); // 자동으로 이미지 전환 시작

        viewFlipper.addView(createImageView(R.drawable.seed));
        viewFlipper.addView(createImageView(R.drawable.sprout));
        viewFlipper.addView(createImageView(R.drawable.treemain));
        viewFlipper.addView(createImageView(R.drawable.trees));

        progressBar = view.findViewById(R.id.progressBar);
        button = view.findViewById(R.id.button);
        initializeButtonTexts();
        setNextButtonText();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;

                if (clickCount == buttonTexts.size()) {
                    clickCount = 0;
                    setNextButtonText();
                } else {
                    setNextButtonText();
                    if (progressValue < 100) {
                        progressValue += 20;
                        progressBar.setProgress(progressValue);
                    }
                }

                if (clickCount == buttonTexts.size() - 1) {
                    progressValue = 0;
                    progressBar.setProgress(progressValue);
                    if (viewFlipper.getDisplayedChild() == viewFlipper.getChildCount() - 1) {
                        viewFlipper.stopFlipping(); // 이미지 전환 중지
                        button.setVisibility(View.GONE); // 버튼을 숨김
                    } else {
                        viewFlipper.showNext(); // 다음 이미지로 넘어감
                    }
                }
            }
        });

        return view;
    }

    private ImageView createImageView(int imageResId) {
        ImageView imageView = new ImageView(requireContext());
        imageView.setImageResource(imageResId);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    private void initializeButtonTexts() {
        buttonTexts = new ArrayList<>();
        buttonTexts.add("쓰래기3개이상 줍기");
        buttonTexts.add("분리 수거하기");
        buttonTexts.add("친구랑 플로깅하기");
        buttonTexts.add("쓰래기 1kg줍기");
        buttonTexts.add("더러워진 손씻기");
        buttonTexts.add("플로깅 30분이상하기");
        Collections.shuffle(buttonTexts); // 텍스트를 섞음

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    /**
     * by dotom
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tree, container, false);

        view.findViewById(R.id.aibutton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), aiActivity.class);
                startActivity(intent);

            }



        });

        return view;

    }

    private void setNextButtonText() {
        button.setText(buttonTexts.get(currentIndex));
        currentIndex = (currentIndex + 1) % buttonTexts.size();
    }
}
