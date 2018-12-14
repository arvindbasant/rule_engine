package com.programdesignlab.rule_engine;

import com.programdesignlab.AgeRule;
import com.programdesignlab.AgeRuleStrategy;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RuleEngineTest {

    @Test
    public void testRuleEngineExecute(){
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

        assertEquals(2, ruleEngine.getResults().size());
    }

}
