package com.example.accountbook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_outlay extends Fragment {
    private View vi_outlay;

    public static Frag_outlay newinstance() {
        Frag_outlay flag_outlay = new Frag_outlay();
        return flag_outlay;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vi_outlay = inflater.inflate(R.layout.flag_view_income, container, false);

        return vi_outlay;
    }
}
