package com.example.accountbook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Flag_outlay extends Fragment {
    private View vi_outlay;

    public static Flag_outlay newinstance() {
        Flag_outlay flag_outlay = new Flag_outlay();
        return flag_outlay;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vi_outlay = inflater.inflate(R.layout.flag_view_outlay, container, false);

        return vi_outlay;
    }
}
