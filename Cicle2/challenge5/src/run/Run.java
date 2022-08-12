package run;

import controller.Controller;

import java.sql.SQLException;

public class Run {
    public static void main(String[] args) {
        try {
            new Controller();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
