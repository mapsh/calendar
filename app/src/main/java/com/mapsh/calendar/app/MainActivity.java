package com.mapsh.calendar.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mapsh.calendar.DatePickerController;
import com.mapsh.calendar.DayPickerView;
import com.mapsh.calendar.MonthAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DayPickerView dayPickerView;
    Context       context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        dayPickerView = (DayPickerView) findViewById(R.id.dpv_calendar);

        DayPickerView.DataModel dataModel = new DayPickerView.DataModel();
        dataModel.yearStart = 2018;
        dataModel.monthStart = 2;
        dataModel.monthCount = 3;
        dataModel.defTag = "";
        dataModel.leastDaysNum = 2;
        dataModel.mostDaysNum = 30;





        dayPickerView.setParameter(dataModel, new DatePickerController() {
            @Override
            public void onDayOfMonthSelected(MonthAdapter.CalendarDay calendarDay) {
                Toast.makeText(context, "onDayOfMonthSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateRangeSelected(List<MonthAdapter.CalendarDay> selectedDays) {
                Toast.makeText(context, "onDateRangeSelected: " + selectedDays.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void alertSelectedFail(FailEven even) {
                Toast.makeText(context, "alertSelectedFail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
