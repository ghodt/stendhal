## Project
Name: Stendhal
URL: https://github.com/ghodt/stendhal

Stendhal is a fully fledged multiplayer online adventures game (MMORPG). It is completely open source (client, server, everything).

## Onboarding experience

#### Did it build as documented?
    
It was fairly easy to get onboard the project. The documentation helped with setup and informed about the scope of the project. The documentation included everything from how to compile and run tests to how to contribute.

Starting point for [developing](https://stendhalgame.org/development/introduction.html)

## Complexity

#### What are your results for the six most complex functions?

To calculate the complexity of the program we used `lizard` on the source directory of the project. The methods were sorted by their cyclomatic complexity (CC). Because our group consist of 3 members we picked the top 6 of these.  

| NLOC |CCN  | token | PARAM | length | function@line@file |
|--|--|--|--|--|--|
| 94 | 72 | 1348 | 1 | 107 | [Grammar::singular](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/common/grammar/Grammar.java#L594) |
| 208 | 68 | 1253 | 0 | 230 | [RPClassGenerator::createRPClassesWithoutBaking](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/server/core/engine/RPClassGenerator.java#L95) |
| 159 | 63 | 1540 | 4 | 173 | [CreaturesXMLLoader::startElement](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/server/core/config/CreaturesXMLLoader.java#L173) |
| 88 | 60 | 1159 | 1 | 103 | [Grammar::plural](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/common/grammar/Grammar.java#L466) |
| 170 | 51 | 1140 | 2 | 244 | [RPEntity::onChangedAdded](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/client/entity/RPEntity.java#L1134) |
| 95 | 33 | 580 | 0 | 137 | [SentenceImplementation::mergeTwoWordExpressions](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/common/parser/SentenceImplementation.java#L493) |

Then we looked at the three functions with the highest complexity with OpenClover to see how it counted the complexity. We also counted the complexity of the functions by hand. The results can be found in the table below.

| Function | Lizard | OpenClover | Fredrik | Emma | Ted |
|--|--|--|--|--|--|
| [Grammar::singular](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/common/grammar/Grammar.java#L594) | 72 | 72 |    83 | 67 | 70 |
| [RPClassGenerator::createRPClassesWithoutBaking](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/server/core/engine/RPClassGenerator.java#L95) | 68 | 68 | 68 | 68 | 68 |
| [CreaturesXMLLoader::startElement](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/server/core/config/CreaturesXMLLoader.java#L173) | 63 | 63 | 56 | 69 | 59 |



### Are the functions just complex, or also long?

The functions are mostly long since many of them contain a lot of `if` and `else if` statements that return different values depending on the input. The methods clearly do a lot of decisions and it would be clearer if the decisions was divided up into smaller functions.

### Purpose

[Grammar::singular](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/common/grammar/Grammar.java#L594)
`Returns the singular form of the given noun if not already given in the singular form.`
The method is considered complex because the outcome very much depends on the input. The method has a lot of `if` statements in most cases for each special case.

[RPClassGenerator::createRPClassesWithoutBaking](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/server/core/engine/RPClassGenerator.java#L95)
`creates the RPClass definitions, unless this was already done.`
This is a creation method for a class object. It contains a lot of `if`statements because it controls if its input as already been initialized. First, it has a control section that makes sure it has not been initiated already, but it still needs to control every single method.


[CreaturesXMLLoader::startElement](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/server/core/config/CreaturesXMLLoader.java#L173)
`<no comments>`
Very hard to get a grasp on this method. This method is an `@overide` of DefaultHandler interface. This class is for processing an XML-file. Depending on what is in the file the output of the method will be different. [DefaultHandler documentations](http://tutorials.jenkov.com/java-xml/sax-defaulthandler.html)

[Grammar::plural](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/common/grammar/Grammar.java#L466)
`Returns the plural form of the given noun if not already given in the plural form.`
The function takes a string with a noun as an argument and returns the plural form of the word. The function checks if the noun ends with a certain suffix and then changes the suffix to the plural form and returns that. This function probably has to be long, since different suffixes have different plural forms, and you need to check all of them. The function is easy to understand, and the high complexity comes from having a lot of `else if`-statements. Not much refactoring could be done.

[RPEntity::onChangedAdded](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/client/entity/RPEntity.java#L1134)
`The object added/changed attribute(s).`
The function has something to do with changes made to objects in the game. The function has the above comment above the declaration, but other than that it has no documentation and is very hard to understand. The function seems to deal with changes in a lot of different objects, so splitting the function into separate smaller functions for different objects and documenting the code better would make it easier to understand.

[SentenceImplementation::mergeTwoWordExpressions](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/common/parser/SentenceImplementation.java#L493)
`Merge two-word expressions into single expressions.`
The function merges words, but it’s not clear why. The function is somewhat documented, but it’s hard to understand for someone who doesn’t know about how sentences are handled and parsed in the code. It’s hard to tell how the function could be refactored since it’s hard to understand.

### Are exceptions taken into account in the given measurements?

No exceptions are used in the methods.

### Is the documentation clear w.r.t. all the possible outcomes?

[Grammar::singular](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/common/grammar/Grammar.java#L594)
Pretty clear. Every `if` ha a single return, it's basically a map function written in a   way. Some of the `if`-statements are not clear but they are. They are also divided into sections that are well documented.


[RPClassGenerator::createRPClassesWithoutBaking](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/server/core/engine/RPClassGenerator.java#L95)
Very little documentation, but the methods and variables are very verbose and don't really require more documentation.


[CreaturesXMLLoader::startElement](https://github.com/ghodt/stendhal/blob/master/src/games/stendhal/server/core/config/CreaturesXMLLoader.java#L173)
This method is not well documented, it is impossible by looking at the method alone to figure out what exactly it does. It is used by something else in a very special way. Almost no line is documented in this method.

## Coverage

### Tools

During the assignment, different tools were used. Among them were _OpenClover_, _IDEA Coverage_, _Jacoco_. Ultimately OpenClover was our favourite and the one we used to get the final measurements.

_OpenClover_ was well documented for several environments. We had no problem using the tool together with our project and the results of the report could easily be understood.

### DYI

Added manual coverage for six functions. a coverage class [AdHocCoverage](https://github.com/ghodt/stendhal/blob/new-tests/src/games/stendhal/tools/statistics/AdHocCoverage.java#L20) was created and used to store 

* [WordList::isNameCompatibleLastType](https://github.com/ghodt/stendhal/blob/new-tests/src/games/stendhal/common/parser/WordList.java#L673)
* [NameSearch::search](https://github.com/ghodt/stendhal/blob/new-tests/src/games/stendhal/common/parser/NameSearch.java#L48)
* [EquipRandomItemAction::equals](https://github.com/ghodt/stendhal/blob/ac50efcdd2c949abc3ec5d4e5d25bc8ceed2d8ed/src/games/stendhal/server/entity/npc/action/EquipRandomItemAction.java#L133])
* [ShouterMain::main](https://github.com/ghodt/stendhal/blob/ac50efcdd2c949abc3ec5d4e5d25bc8ceed2d8ed/src/games/stendhal/bot/shouter/ShouterMain.java#L78)
* [Creature::getNearestEnemy](https://github.com/ghodt/stendhal/blob/ac50efcdd2c949abc3ec5d4e5d25bc8ceed2d8ed/src/games/stendhal/server/entity/creature/Creature.java#L696)
* [ExpressionMatcher::match](https://github.com/ghodt/stendhal/blob/ac50efcdd2c949abc3ec5d4e5d25bc8ceed2d8ed/src/games/stendhal/common/parser/ExpressionMatcher.java#L305)



What kinds of constructs do your tool support, and how accurate is
it's output?

### Evaluation

Report of old coverage: [link]

Report of new coverage: [link]

Test cases added:

git diff ...

## Refactoring

*WordList::isNameCompatibleLastType*

This method control if the last expression of a sentence is compatible with a given typeString. This method is only used by another public method, `registerName`. The methods complexity comes from it's repeated checks of equivalent states, i.e. 1+1=2 <-> 2=1+1.

To reduce complexity these double checks if necessary could be put into their own method. They check for one thing and could, therefore, be one method. Example of one such instance.

```
if (lastType.getTypeString().startsWith(typeString)) {
    return true;
}

if (typeString.startsWith(lastType.getTypeString())) {
    return true;
}
```
This check could be turned into its own method, while this is no priority the function could look a lot cleaner and the purpose of it clearer if this refactoring would go through.


*NameSearch::search*

This method searches for an item to match the given `Expression` in a word list. The complexity arises from how the _expression_ is interpreted. It can have many forms, _normalized_, _plural_, _singular_ for example.

This leads the code to be nested with a lot of checks after another with repeated code. It is not to hard to get a grasp on what the code wants to achieve and when a different branch will be used instead of another. To be able to refactor this code for the better I would want to increase its performance and reduce its length.

A simple way to refactor the code would be to control all the checks for each _entry_ in the map. This would only require the method to iterate through the list once per call. This could have drawbacks if the first check is correct most of the time and the other one are just for special cases. 

A more extensive refactoring would see the WordList be changed to a data structure that could find the match faster. An ordered list so that binary search could be performed would increase performance if _WordList_ is used with larger sets.

*ShouterMain::main*

The function check the input arguments for the program and interprets them.

The complexity seems to be necessary in this case, as all branching has a valid purpose, and I cannot see a better way to do it. It is however possible to divide the function into smaller functions, as it currently do 3 (or a pedantic 4) different things.

Since this is the main function, it’ll catch and prints out all exceptions thrown in the program that hasn’t been catched.
It makes sure there are arguments passed in, otherwise it provides with an error message.
It parses the arguments from the command line and sets the corresponding attributes.
It checks all necessary variables are set.

Things that could be done are to at least refactor the parsing and interpretation of the command arguments to its own function. You could have the validation in the refactored function or even divide refactor it to another function still. This would allow the parsing and interpretation code to be cleaner and more understandable. The validation function could also throw an exception, which would be caught by the main function, which would reduce code.



git diff ...

## Effort spent

For each team member, how much time was spent in

| Area | Fredrik | Emma | Ted |
|--|--|--|--|
| plenary discussions/meetings | 4h | 4h | 4h |
| discussions within parts of the group| 3h | 3h | 3h |
| reading documentation | 4h | 2h | 2h |
| configuration | 2h | 2h | 2h |
| analyzing code/output | 3h | 3h | 2h |
| writing documentation | 2h | 1h | 1h |
| writing code | 3h | 2h | 1h |
| running code | 2h | 2h | 3h |


## Overall experience

### What are your main takeaways from this project? What did you learn?
It gave us quite an insight into how code complexity is related to branching. For example, we gave up on testing one function because it had uncovered branches that were nested several layers deep and branched on a singleton. 



