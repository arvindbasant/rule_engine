package com.programdesignlab;

import com.programdesignlab.rule_engine.RuleStrategy;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


public class AgeRuleStrategy implements RuleStrategy<AgeRule> {

    @Override
    public boolean validate(AgeRule ageRule) {
        return DAYS.between(ageRule.getDob(), LocalDate.now()) > 365;
    }
}
