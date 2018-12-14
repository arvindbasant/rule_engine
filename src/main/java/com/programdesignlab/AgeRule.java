package com.programdesignlab;

import com.programdesignlab.rule_engine.Rule;
import com.programdesignlab.rule_engine.RuleStrategy;

import java.time.LocalDate;
import java.util.List;

public class AgeRule extends Rule<AgeRule> {
    private LocalDate dob;

    public LocalDate getDob() {
        return dob;
    }

    public AgeRule(RuleStrategy<AgeRule> ageRuleStrategy, Builder builder) {
        super(ageRuleStrategy);
        this.dob = builder.dob;
        super.success = builder.success;
        super.fail = builder.fail;
    }

    @Override
    public AgeRule getType() {
        return this;
    }

    public static class Builder {

        public Builder(RuleStrategy<AgeRule> ageRuleStrategy) {
            this.ageRuleStrategy = ageRuleStrategy;
        }

        private RuleStrategy<AgeRule> ageRuleStrategy;
        private LocalDate dob;
        private List<String> success;
        private List<String> fail;

        public Builder onSuccess(List<String> success) {
            this.success = success;
            return this;
        }

        public Builder onFail(List<String> fail) {
            this.fail = fail;
            return this;
        }

        public Builder dob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public AgeRule build() {
            return new AgeRule(ageRuleStrategy, this);
        }
    }

}
