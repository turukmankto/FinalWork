package com.example.finalwork;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String QUESTIONS = "QUESTIONS";
    private static final String START_INDEX = "START_INDEX";
    private static final String FINISH_INDEX = "FINISH_INDEX";

    // TODO: Rename and change types of parameters


    private List<Storage> getQuestions;
    private Integer startIndex;
    private Integer finishIndex;

    public TaskFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TaskFragment newInstance(
            List<Storage> getQuestions,
            Integer startIndex,
            Integer finishIndex) {
        TaskFragment fragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putSerializable(QUESTIONS, (Serializable) getQuestions);
        args.putSerializable(START_INDEX, startIndex);
        args.putSerializable(FINISH_INDEX, finishIndex);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            getQuestions = (List<Storage>) getArguments().getSerializable(QUESTIONS);
            startIndex = (Integer) getArguments().get(START_INDEX);
            finishIndex = (Integer) getArguments().get(FINISH_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        final Integer[] currentIndex = {startIndex};
        final Storage[] question = {getQuestions.get(currentIndex[0])};

        final String[] imageName = {"image" + String.valueOf(currentIndex[0] + 1)};
        @SuppressLint("DiscouragedApi")
        final int[] imageResId = {getResources().getIdentifier(imageName[0], "drawable", requireContext().getPackageName())};

        // Get references to the views in the layout
        ImageView taskImageView = view.findViewById(R.id.taskImageView);
        TextView taskText = view.findViewById(R.id.taskText);
        TextView taskHelpText = view.findViewById(R.id.taskHelpText);
        RadioButton answerButton1 = view.findViewById(R.id.answerButton1);
        RadioButton answerButton2 = view.findViewById(R.id.answerButton2);
        RadioButton answerButton3 = view.findViewById(R.id.answerButton3);
        RadioButton answerButton4 = view.findViewById(R.id.answerButton4);
        Button helpButton = view.findViewById(R.id.helpButton);
        Button nextButton = view.findViewById(R.id.nextButton);

        List<RadioButton> allButtons = new ArrayList<RadioButton>(){{
            add(answerButton1);
            add(answerButton2);
            add(answerButton3);
            add(answerButton4);
        }};

        final boolean[] answers = new boolean[10];

        taskHelpText.setVisibility(View.GONE);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskHelpText.setVisibility(View.VISIBLE);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DiscouragedApi")
            @Override
            public void onClick(View view) {
                int idSelectedButton = -1;
                for (int i = 0; i < allButtons.size(); i++) {
                    if (allButtons.get(i).isChecked()) {
                        idSelectedButton = i;
                        break;
                    }
                }

                if (currentIndex[0] < finishIndex && idSelectedButton != -1) {

                    if (idSelectedButton == question[0].checkchoice) {
                        answers[currentIndex[0] % 10] = true;
                    }

                    currentIndex[0]++;

                    if (currentIndex[0] >= finishIndex) {
                        currentIndex[0]--;
                        Intent intent = new Intent(getActivity(), StatisticsActivity.class);
                        intent.putExtra("answers", answers);
                        startActivity(intent);
                        return;
                    }



                    taskHelpText.setVisibility(View.GONE);
                    imageName[0] = "image" + String.valueOf(currentIndex[0] + 1);
                    imageResId[0] = getResources().getIdentifier(
                            imageName[0],
                            "drawable",
                            requireContext().getPackageName()
                    );

                    taskImageView.setImageResource(imageResId[0]);
                    question[0] = getQuestions.get(currentIndex[0]);
                    taskText.setText(question[0].question);
                    answerButton1.setText(question[0].answer1);
                    answerButton2.setText(question[0].answer2);
                    answerButton3.setText(question[0].answer3);
                    answerButton4.setText(question[0].answer4);
                    taskHelpText.setText(question[0].help);

                    for (RadioButton button: allButtons) {
                        button.setVisibility(View.VISIBLE);
                        button.setChecked(false);
                        if (button.getText().equals("")) {
                            button.setVisibility(View.GONE);
                        } else {
                            button.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });

        taskImageView.setImageResource(imageResId[0]);
        taskText.setText(question[0].question);
        answerButton1.setText(question[0].answer1);
        answerButton2.setText(question[0].answer2);
        answerButton3.setText(question[0].answer3);
        answerButton4.setText(question[0].answer4);
        taskHelpText.setText(question[0].help);

        for (RadioButton button: allButtons) {
            button.setVisibility(View.VISIBLE);
            button.setChecked(false);
            if (button.getText().equals("")) {
                button.setVisibility(View.GONE);
            } else {
                button.setVisibility(View.VISIBLE);
            }
        }

        return view;
    }
}