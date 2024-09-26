package com.estellore.estelloremenu;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (getActivity() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Title")
                    .setMessage("Message.")
                    .setPositiveButton("OK", (dialog, id) -> {
                        // Handle positive button
                        if (getActivity() instanceof MainActivity) {
                            ((MainActivity) getActivity()).loadFragment(new My_Fragment());
                        }
                    })
                    .setNegativeButton("Cancel", (dialog, id) -> {
                        // Handle negative button
                        if (getActivity() instanceof MainActivity) {
                            getActivity().finishAffinity();
                        }
                    });
            return builder.create();
        } else {
            throw new IllegalStateException("Activity cannot be null");
        }
    }
}
