package com.programdesignlab.rule_engine;

import java.util.List;

public abstract class Rule<T extends Rule<T>> {

    private RuleStrategy<T> ruleStrategy;

    public Rule(RuleStrategy<T> ruleStrategy) {
        this.ruleStrategy = ruleStrategy;
    }

    protected abstract T getType();

    public boolean validate() {
        return ruleStrategy.validate(getType());
    }

    protected List<String> success;
    protected List<String> fail;

}
