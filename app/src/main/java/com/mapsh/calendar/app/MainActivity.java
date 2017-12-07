package com.mapsh.calendar.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mapsh.calendar.DatePickerController;
import com.mapsh.calendar.DayPickerView;
import com.mapsh.calendar.MonthAdapter;

import java.util.ArrayList;
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
        dataModel.yearStart = 2017;
        dataModel.monthStart = 9;
        dataModel.monthCount = 3;
        dataModel.defTag = "";
        dataModel.leastDaysNum = 2;
        dataModel.mostDaysNum = 30;

        List<MonthAdapter.CalendarDay> invalidDays = new ArrayList<>();
        MonthAdapter.CalendarDay invalidDay1 = new MonthAdapter.CalendarDay(2016, 8, 10);
        MonthAdapter.CalendarDay invalidDay2 = new MonthAdapter.CalendarDay(2016, 8, 11);
        MonthAdapter.CalendarDay invalidDay3 = new MonthAdapter.CalendarDay(2016, 8, 12);
        invalidDays.add(invalidDay1);
        invalidDays.add(invalidDay2);
        invalidDays.add(invalidDay3);
        // dataModel.invalidDays = invalidDays;

        List<MonthAdapter.CalendarDay> busyDays = new ArrayList<>();
        MonthAdapter.CalendarDay busyDay1 = new MonthAdapter.CalendarDay(2016, 8, 20);
        MonthAdapter.CalendarDay busyDay2 = new MonthAdapter.CalendarDay(2016, 8, 21);
        MonthAdapter.CalendarDay busyDay3 = new MonthAdapter.CalendarDay(2016, 8, 22);
        busyDays.add(busyDay1);
        busyDays.add(busyDay2);
        busyDays.add(busyDay3);
        // dataModel.busyDays = busyDays;

        MonthAdapter.CalendarDay startDay = new MonthAdapter.CalendarDay(2017, 9, 20);
        MonthAdapter.CalendarDay endDay = new MonthAdapter.CalendarDay(2017, 9, 22);
        MonthAdapter.SelectedDays<MonthAdapter.CalendarDay> selectedDays = new MonthAdapter.SelectedDays<>(startDay, endDay);
        dataModel.selectedDays = selectedDays;

        MonthAdapter.CalendarDay tag = new MonthAdapter.CalendarDay(2017, 9, 19);
        tag.setTag("标签1");

        MonthAdapter.CalendarDay tag2 = new MonthAdapter.CalendarDay(2016, 8, 15);
        tag2.setTag("标签2");
        List<MonthAdapter.CalendarDay> tags = new ArrayList<>();
        tags.add(tag);
        tags.add(tag2);
        dataModel.tags = tags;

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
