package com.programdesignlab;

import com.programdesignlab.rule_engine.Result;
import com.programdesignlab.rule_engine.RuleEngine;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        RuleEngine ruleEngine = new RuleEngine.RuleExecutor()
                .addRule(new AgeRule
                        .Builder(new AgeRuleStrategy())
                        .dob(LocalDate.of(2018, 11, 11))
                        .onSuccess(Arrays.asList("success msg 1", "success msg 2"))
                        .onFail(Arrays.asList("Fail msg 1", "Fail msg 2"))
                        .build()
                )
                .addRule(new AgeRule
                        .Builder(new AgeRuleStrategy())
                        .dob(LocalDate.of(2016, 11, 11))
                        .onSuccess(Arrays.asList("success msg 1", "success msg 2"))
                        .onFail(Arrays.asList("Fail msg 1", "Fail msg 2"))
                        .build()
                )
                .execute();

        List<Result> results = ruleEngine.getResults();
        System.out.println(results.size());

//        results.forEach(result -> System.out.println(result.getMessage().get(0) + result.getRuleType() + result.isValid()));
    }
}
