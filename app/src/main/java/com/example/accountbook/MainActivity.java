package com.example.accountbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private DBHelper dbHelper; //데이터베이스

    public static Context mContext;

    private FragmentStateAdapter fragmentStateAdapter;


    private Spinner sp_breakdown;
    private TextView btn_breakdown;
    private Spinner sp_catalog;
    private TextView btn_catalog;

    // 디자인들
    TextView incomeView;
    TextView outlayView;
    TextView sumView;
    Button btn_delDB;
    FloatingActionButton imageButton;
    CalendarView calendarView;
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        mContext = this;


        incomeView = (TextView) findViewById(R.id.incomeView);
        outlayView = (TextView) findViewById(R.id.outlayView);
        sumView = (TextView) findViewById(R.id.sumView);
        imageButton =  findViewById(R.id.ioButton);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        btn_delDB = (Button) findViewById(R.id.btn_delDB);
        sp_breakdown = (Spinner)findViewById(R.id.sp_breakdown);
        btn_breakdown = (TextView)findViewById(R.id.btn_breakdown);
        sp_catalog = (Spinner)findViewById(R.id.sp_catalog);
        btn_catalog = (TextView)findViewById(R.id.btn_catalog);
        tabLayout = findViewById(R.id.tab_layout);
        pager2 = findViewById(R.id.viewPager);

        FragmentManager fm = getSupportFragmentManager();
        frag = new FragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(frag);

        tabLayout.addTab(tabLayout.newTab().setText("수입"));
        tabLayout.addTab(tabLayout.newTab().setText("지출"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

       /* sp_breakdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                btn_breakdown.setText(adapterView.getItemIdAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
       */


        // 수입지출합계 init
        incomeView.setText(String.valueOf(dbHelper.getSum("수입")));
        outlayView.setText(String.valueOf(dbHelper.getSum("지출")));
        sumView.setText(String.valueOf(dbHelper.getSum("수입") - dbHelper.getSum("지출")));




        // 달력 테스트
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day)
            {
                Toast.makeText(MainActivity.this, Integer.toString(year)+"년"+Integer.toString(month+1)+"월"+Integer.toString(day)+"일", Toast.LENGTH_SHORT).show();
            }
        });

        //DB삭제버튼
        btn_delDB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dbHelper.DeleteDB();
                incomeView.setText(String.valueOf(dbHelper.getSum("수입")));
                outlayView.setText(String.valueOf(dbHelper.getSum("지출")));
                sumView.setText(String.valueOf(dbHelper.getSum("수입") - dbHelper.getSum("지출")));
            }
        });


        // 플로팅액션버튼 누를 시
        imageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                // 팝업창 띄우기
                Dialog dialog = new Dialog(MainActivity.this, android.R.style.Theme_Material_Light_Dialog);
                dialog.setContentView(R.layout.dialog_edit);
                EditText et_money = dialog.findViewById(R.id.et_money);
                //ton btn_income = dialog.findViewById(R.id.btn_income);
               // Button btn_outlay = dialog.findViewById(R.id.btn_outlay);


               /* btn_income.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {


                        int incomeValue = Integer.parseInt(et_money.getText().toString());

                        dbHelper.InsertDB("수입", incomeValue, "TEST", "TEST");

                        incomeView.setText(String.valueOf(dbHelper.getSum("수입")));
                        sumView.setText(String.valueOf(dbHelper.getSum("수입") - dbHelper.getSum("지출")));


                        dialog.dismiss(); // 수입 버튼 누를 시 팝업 dismiss
                    }
                });

                btn_outlay.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {


                        int outlayValue = Integer.parseInt(et_money.getText().toString());

                        dbHelper.InsertDB("지출", outlayValue,"TEST2","TEST2");

                        outlayView.setText(String.valueOf(dbHelper.getSum("지출")));
                        sumView.setText(String.valueOf(dbHelper.getSum("수입") - dbHelper.getSum("지출")));


                        dialog.dismiss(); // 지출 버튼 누를 시 팝업 dismiss


                    }
                });*/
                dialog.show();
            }
        });


    }




}