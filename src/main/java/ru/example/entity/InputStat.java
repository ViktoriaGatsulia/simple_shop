package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InputStat implements InputMes{
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") private Date start_date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") private Date end_date;

    @JsonIgnore private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public InputStat(Date start_date, Date end_date) {
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public InputStat() {}

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  'start_date' : '" + dateFormat.format(start_date) + "',\n" +
                "  'end_date' : '" + dateFormat.format(end_date) + "'\n" +
                "}";
    }
}
