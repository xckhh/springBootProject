package com.cc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conditions {
    private int condition_id;
    private String monthly_income;
    private String car_number;
    private String house_number;
    private String work_type;
    private String marital_status;
    private String hobby;
    private String requirement;
    private String personal_signature;
    private String id;
}
