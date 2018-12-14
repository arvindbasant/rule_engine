package com.programdesignlab.rule_engine;

import com.programdesignlab.RuleType;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private boolean valid;
    private String ruleType;
    private List<String> message;

    public String getRuleType() {
        return ruleType;
    }

    public List<String> getMessage() {
        return message;
    }

    public boolean isValid() {
        return valid;
    }


    public Result(ResultBuilder resultBuilder) {
        this.valid = resultBuilder.valid;
        this.message = resultBuilder.message;
        this.ruleType = resultBuilder.ruleType;
    }

    public static class ResultBuilder {
        private boolean valid;
        private List<String> message;
        private String ruleType;

        public ResultBuilder rule(RuleType ruleType) {
            this.ruleType = ruleType.toString();
            return this;
        }

        public ResultBuilder valid(boolean valid) {
            this.valid = valid;
            return this;
        }

        public ResultBuilder message(List<String> message) {
            if (null == message)
                this.message = new ArrayList<>();
            this.message = message;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }
}
