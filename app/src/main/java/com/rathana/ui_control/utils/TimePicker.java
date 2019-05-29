package com.rathana.ui_control.utils;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class TimePicker extends DialogFragment
    implements TimePickerDialog.OnTimeSetListener
{

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar c =Calendar.getInstance();
        int h=c.get(Calendar.HOUR);
        int mm=c.get(Calendar.MINUTE);
        int ss=c.get(Calendar.SECOND);

        return new TimePickerDialog(
                getActivity(),
                this,
                h,
                mm,
                false);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        picker.onTimeSet(hourOfDay,minute);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        picker=(OnTimeSetPicker) context;
    }

    OnTimeSetPicker picker;
    public interface OnTimeSetPicker{
        void onTimeSet(int h,int mn);
    }
}
