package com.example.accountbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private DBHelper dbHelper; //데이터베이스

    public static Context mContext;

    private FragmentStateAdapter fragmentStateAdapter;

    //frame_main (메인화면) 변수
    CalendarView calendarView;
    FloatingActionButton fab_main, fab_camera, fab_writing;
    TextView txt_outlay, outlay, txt_income, income, txt_total, total;

    //frame_receipt 변수
    //frame_stats 변수

    //flag_view_income (수입창) 변수
    TextView in_txt_date, in_txt_price, in_txt_method, in_txt_catalog, in_txt_details;
    EditText in_editTextDate, in_editTextMoney, in_editTextDetails;
    private Spinner in_sp_method, in_sp_catalog;

    //flag_view_outcome (지출창) 변수
    /*TextView out_txt_date, out_txt_price, out_txt_method, out_txt_catalog, out_txt_details;
    EditText out_editTextDate, out_editTextMoney, out_editTextDetails;
    private Spinner out_sp_method, out_sp_catalog; */

    //money_input
   /* TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter frag; */

    //activity_main 화면
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Flag_main_view flagMainView;
    private Flag_stats_view flagStatsView;
    private Flag_receipt_view flagReceiptView;

    // 디자인들
    Button btn_delDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        mContext = this;

        //frame_main
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        fab_main = (FloatingActionButton) findViewById(R.id.fab_main);
        fab_camera = (FloatingActionButton) findViewById(R.id.fab_camera);
        fab_writing = (FloatingActionButton) findViewById(R.id.fab_writing);
        txt_income = (TextView) findViewById(R.id.txt_income);
        txt_outlay = (TextView) findViewById(R.id.txt_outlay);
        txt_total = (TextView) findViewById(R.id.txt_total);
        income = (TextView) findViewById(R.id.income);
        outlay = (TextView) findViewById(R.id.outlay);
        total = (TextView) findViewById(R.id.total);

        //버튼을 누르면 화면이 넘어감(fab_main 제외)
        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fab_writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //수입,지출 화면 전환
                Intent intent = new Intent(getApplicationContext(), MoneyInputActivity.class);
                startActivity(intent);
            }
        });
        fab_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //flag_view_income
        /*in_txt_date = (TextView) findViewById(R.id.in_txt_date);
        in_txt_price = (TextView) findViewById(R.id.in_txt_price);
        in_txt_method = (TextView) findViewById(R.id.in_txt_method);
        in_txt_catalog = (TextView) findViewById(R.id.in_txt_catalog);
        in_txt_details = (TextView) findViewById(R.id.in_txt_details);
        in_editTextDate = (EditText) findViewById(R.id.in_editTextDate);
        in_editTextMoney = (EditText) findViewById(R.id.in_editTextMoney);
        in_editTextDetails = (EditText) findViewById(R.id.in_editTextDetails);
        in_sp_method = (Spinner) findViewById(R.id.in_sp_method);
        in_sp_catalog = (Spinner) findViewById(R.id.in_sp_catalog); */

       /* //flag_view_outlay
        out_txt_date = (TextView) findViewById(R.id.out_txt_date);
        out_txt_price = (TextView) findViewById(R.id.out_txt_price);
        out_txt_method = (TextView) findViewById(R.id.out_txt_method);
        out_txt_catalog = (TextView) findViewById(R.id.out_txt_catalog);
        out_txt_details = (TextView) findViewById(R.id.out_txt_details);
        out_editTextDate = (EditText) findViewById(R.id.out_editTextDate);
        out_editTextMoney = (EditText) findViewById(R.id.out_editTextMoney);
        out_editTextDetails = (EditText) findViewById(R.id.out_editTextDetails);
        out_sp_method = (Spinner) findViewById(R.id.out_sp_method);
        out_sp_catalog = (Spinner) findViewById(R.id.out_sp_catalog); */

       //btn_delDB = (Button) findViewById(R.id.btn_delDB);

     /*   //money_input
        tabLayout = findViewById(R.id.tablayout);
        pager2 = findViewById(R.id.viewPager);

        //수입,지출 창 viewPager
        FragmentManager fm = getSupportFragmentManager();
        frag = new FragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(frag);

        //탭뷰 텍스트 지정
        tabLayout.addTab(tabLayout.newTab().setText("수입"));
        tabLayout.addTab(tabLayout.newTab().setText("지출"));

        //탭 메뉴 누르면 해당 프래그먼트로 변경됨
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
        //추상클래스, 페이지 바뀔 때 실행
        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        }); */

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
                dialog.setContentView(R.layout.money_input);
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

        //하단 네비게이션 눌렀을 때 화면 변경 됨
        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_calender:
                        setFrag(0);
                        break;
                    case R.id.action_stats:
                        setFrag(1);
                        break;
                    case R.id.action_receipt:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        flagMainView = new Flag_main_view();
        flagReceiptView = new Flag_receipt_view();
        flagStatsView = new Flag_stats_view();
        setFrag(0);  // 메인 화면 선택

    }
    //하단 네이게이션 프래그먼트 교체
    private void setFrag(int i) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch (i) {
            case 0:
                ft.replace(R.id.frame, flagMainView);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.frame, flagStatsView);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.frame, flagReceiptView);
                ft.commit();
                break;
        }
    }



}