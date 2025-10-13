package com.example.helloworld;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("This is a custom dialog")
                .setPositiveButton("Ok", (dialog, id)
                        -> System.out.println("User Clicked Ok Button"))
                .setNegativeButton("Cancel", (dialog, id)
                        -> System.out.println("User Clicked Cancel Button"));

        return builder.create();
    }
}
