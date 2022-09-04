package com.mandiri;

import com.mandiri.config.DBConnection;
import com.mandiri.repositories.PerformerRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws SQLException {
        PerformerRepository performerRepository = new PerformerRepository();
        System.out.println(performerRepository.getAllPerformer());
        //performerRepository.addPerformer("Julian","1999-01-01","Indonesia","M");
//        System.out.println(performerRepository.getAllPerformerByGenderAndNationality("F", "France"));
    }
}
