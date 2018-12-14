package com.programdesignlab.rule_engine;


public interface RuleStrategy<T> {
    boolean validate(T t);
}
