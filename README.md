# rule_engine
Simple RuleEngine where each rule is abstracted using Strategy Design Pattern, keeping in mind that each algorithm can grow separately. A client can chain multiple rules and and execute. Strategy, builder, generics and open closed principles are used out of box to achieve the functionality. 

# Using Rule Engine

### Create a new RuleStrategy class by implementing RuleStrategy<T>. This is base interface having `boolean validate(T rule)` method.

### Create a new Rule by extending Base `Rule` abstract class. Its constructor should pass the rule strategy.

## Sample Client

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
