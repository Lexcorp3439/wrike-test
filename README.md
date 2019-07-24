# wrike-test
Wrike test assignment

Test case scenario:

1. Open url: wrike.com;
2. Click "Get started for free" button near "Login" button;
3. Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);
4. Click on "Create my Wrike account" button + check with assertion that you are moved to the next page;
5. Fill in the Q&A section at the left part of page (like random generated answers) + check with assertion that your answers are submitted;
6. Check that section "Follow us" at the site footer contains the "Twitter" button that leads to the correct url and has the correct icon;
7. Create results report using allure plugin (by maven). 
(you may close all needless tooltips on your way)


Stack of technologies for implementation:

Platform: java8;
Build and run: maven;
Test framework: junit4;
UI test: selenium 3 (without wrappers);
Pattern: pageObject (test -> steps -> pages);
Reporting: allure plugin;
Selector: xpath (should be short and stable);

**How to create a html report using Allure?**
1. run «mvn clean test» command;
2. check that «allure-results» directory has appeared in «target» directory; 
3. run «mvn allure:serve» command; 
