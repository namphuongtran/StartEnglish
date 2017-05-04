package com.southern.startenglish.englishgrammar;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PartBTimeClauseActivity extends AppCompatActivity {

    TextView partb_time_clause_header;
    TextView partb_time_clause_sub_header;

    TextView partb_time_clause_form1;
    TextView partb_time_clause_form2;
    TextView partb_time_clause_form3;
    TextView partb_time_clause_form4;
    TextView partb_time_clause_form5;
    TextView partb_time_clause_form6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_btime_clause);


        partb_time_clause_header=(TextView)findViewById(R.id.partb_time_clause_header);
        partb_time_clause_header.setText("Mệnh đề trạng ngữ chỉ thời gian được bắt đầu bằng: When, By the time, Before, Till, Untill, After, As soon as, Since, While, ...");
        partb_time_clause_header.setTypeface(Typeface.DEFAULT_BOLD);

        partb_time_clause_sub_header=(TextView)findViewById(R.id.partb_time_clause_sub_header);
        partb_time_clause_sub_header.setText("Các trường hợp có cấu trúc cố định:");
        partb_time_clause_sub_header.setTypeface(Typeface.DEFAULT_BOLD);

        partb_time_clause_form1=(TextView)findViewById(R.id.partb_time_clause_form1);
        partb_time_clause_form1.setText("1- S + had + V3/ed before S + V2/ed");

        partb_time_clause_form2=(TextView)findViewById(R.id.partb_time_clause_form2);
        partb_time_clause_form2.setText("2- S + had + V3/ed by the time S + V2/ed");

        partb_time_clause_form3=(TextView)findViewById(R.id.partb_time_clause_form3);
        partb_time_clause_form3.setText("3- S + had (already/just) + V3/ed when S + V2/ed");

        partb_time_clause_form4=(TextView)findViewById(R.id.partb_time_clause_form4);
        partb_time_clause_form4.setText("4- S + V2/ed + after S + had + V3/ed");

        partb_time_clause_form5=(TextView)findViewById(R.id.partb_time_clause_form5);
        partb_time_clause_form5.setText("5- S + V2/ed + as soon as S + had + V3/ed");

        partb_time_clause_form6=(TextView)findViewById(R.id.partb_time_clause_form6);
        partb_time_clause_form6.setText("6- S + have/has + V3/ed + O + since S + V2/ed");
    }
}
