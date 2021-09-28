package com.example.accountbook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Flag_income extends Fragment {
    private View vi_income;

    public static Flag_income newinstance() {
        Flag_income flag_income = new Flag_income();
        return flag_income;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vi_income = inflater.inflate(R.layout.flag_view_income, container, false);

        return vi_income;
    }
}
