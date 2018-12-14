package com.programdesignlab.rule_engine;

import com.programdesignlab.RuleType;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {

    private List<Rule> rules;

    public List<Result> getResults() {
        return results;
    }

    private List<Result> results;

    public RuleEngine(RuleExecutor ruleExecutor) {
        this.rules = ruleExecutor.rules;
        this.results = ruleExecutor.results;
    }

    public static class RuleExecutor {
        private List<Rule> rules;
        private List<Result> results;

        public RuleExecutor addRule(Rule rule) {
            if (rules == null)
                rules = new ArrayList<>();
            rules.add(rule);
            return this;
        }

        public RuleEngine execute() {
            results = new ArrayList<>();
            RuleEngine ruleEngine = new RuleEngine(this);
            rules.forEach(rule -> results.add(
                    rule.validate() ?
                            new Result.ResultBuilder()
                                    .valid(true)
                                    .rule(RuleType.AGE)
                                    .message(rule.success)
                                    .build()
                            :
                            new Result.ResultBuilder()
                                    .valid(false)
                                    .rule(RuleType.AGE)
                                    .message(rule.fail)
                                    .build()));
            return new RuleEngine(this);
        }
    }
}
