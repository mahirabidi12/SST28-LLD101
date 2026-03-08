package com.example.reports;

public class ReportViewer {

    public void open(ReportProxy report, User user) {
        report.display(user);
    }
}
