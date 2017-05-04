package com.southern.startenglish.englishgrammar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PartAFormActivity extends AppCompatActivity {

    TextView parta_form_header_state;
    TextView parta_form_header_form;
    TextView parta_form_header_negative;
    TextView parta_form_header_question;

    TextView parta_form_state_subject1;
    TextView parta_form_state_auxiliary1;
    TextView parta_form_state_verb1;

    TextView parta_form_state_subject2;
    TextView parta_form_state_auxiliary2;
    TextView parta_form_state_verb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_aform);

        parta_form_header_state=(TextView)findViewById(R.id.parta_form_header_state);
        parta_form_header_state.setText("Khẳng định");

        parta_form_state_subject1=(TextView)findViewById(R.id.parta_form_state_subject1);
        parta_form_state_subject1.setText("S");

        parta_form_state_auxiliary1=(TextView)findViewById(R.id.parta_form_state_auxiliary1);
        parta_form_state_auxiliary1.setText("Will");

        parta_form_state_verb1=(TextView)findViewById(R.id.parta_form_state_verb1);
        parta_form_state_verb1.setText("V0");

        parta_form_state_subject2=(TextView)findViewById(R.id.parta_form_state_subject2);
        parta_form_state_subject2.setText("S");

        parta_form_state_auxiliary2=(TextView)findViewById(R.id.parta_form_state_auxiliary2);
        parta_form_state_auxiliary2.setText("");

        parta_form_state_verb2=(TextView)findViewById(R.id.parta_form_state_verb2);
        parta_form_state_verb2.setText("V1/s/es");

        /*parta_form_header_form=(TextView)findViewById(R.id.parta_form_header_form);
        parta_form_header_form.setText("Hình thức");

        parta_form_header_negative=(TextView)findViewById(R.id.parta_form_header_negative);
        parta_form_header_negative.setText("Phủ định");

        parta_form_header_question=(TextView)findViewById(R.id.parta_form_header_question);
        parta_form_header_question.setText("Nghi vấn");*/
    }
}
