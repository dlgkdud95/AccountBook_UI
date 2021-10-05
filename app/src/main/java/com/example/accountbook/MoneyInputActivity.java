package com.example.accountbook;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MoneyInputActivity extends AppCompatActivity {
   // private FragmentStateAdapter fragmentStateAdapter;
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter adapter;

    TextView in_txt_date, in_txt_price, in_txt_method, in_txt_catalog, in_txt_details;
    EditText in_editTextDate, in_editTextMoney, in_editTextDetails;
    private Spinner in_sp_method, in_sp_catalog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money_input);

        Button button = findViewById(R.id.in_bt_register);
        in_txt_date = (TextView) findViewById(R.id.in_txt_date);
        in_txt_price = (TextView) findViewById(R.id.in_txt_price);
        in_txt_method = (TextView) findViewById(R.id.in_txt_method);
        in_txt_catalog = (TextView) findViewById(R.id.in_txt_catalog);
        in_txt_details = (TextView) findViewById(R.id.in_txt_details);
        in_editTextDate = (EditText) findViewById(R.id.in_editTextDate);
        in_editTextMoney = (EditText) findViewById(R.id.in_editTextMoney);
        in_editTextDetails = (EditText) findViewById(R.id.in_editTextDetails);
        in_sp_method = (Spinner) findViewById(R.id.in_sp_method);
        in_sp_catalog = (Spinner) findViewById(R.id.in_sp_catalog);

        //money_input
        tabLayout = findViewById(R.id.tablayout);
        pager2 = findViewById(R.id.viewPager);

        //수입,지출 창 viewPager
        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter); //viewpager와 adapter연결

        //탭 셋팅
        tabLayout.addTab(tabLayout.newTab().setText("수입"));
        tabLayout.addTab(tabLayout.newTab().setText("지출"));

        //탭 메뉴 누르면 해당 프래그먼트로 변경됨
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { //선택 시
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { //탭 선택 안 했을 시

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { //선택된 탭 다시 클릭 시

            }
        });
        //추상클래스, 페이지 바뀔 때 실행, 콜백
        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}
