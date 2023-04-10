    # Calorie Counter

## Introduction   
The main purpose of this application is to *keep track of the foods you eat 
and calculate the total amount of their calories*. You can select the food
you eat with a specific amount then the application will keep the information 
and show you the individual food's calories and the total calories. You can 
also add new kinds of food to the application to make sure it will cover
your diet. 

There are **three** kinds of this application's targeted users:
- The people who want to lose weight.
- The People who want to maintain their current body shape.
- The people who want to build up their muscles.

This project interests me because the topic of body shape troubles a
lot of people including me that want to make some progress on it. In
this case, an application that records the approximate calorie intake
per day can help people achieve their goals in a more scientific way 
and encourage them to keep a healthy lifestyle.

## User Stories
- As a user, I want to be able to add what I eat from the list of food choice.
- As a user, I want to be able to add new food choice.
- As a user, I want to be able to view the foods in list of food intake and choice.
- As a user, I want to be able to delete food in the list of food intake and choice.
- As a user, I want to be able to see the number of the total calorie intake.
- As a user, I want to be able to save my list of food choices/eaten to file (if I so choose).
- As a user, I want to be able to load my list of food choices/eaten from file (if I so choose).

# Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by selecting one of the
food choices on the left side then click the button "add to list of food eaten" and type amount
to add selected food with specified to list of food eaten.
- You can generate the second required action related to adding Xs to a Y by selecting one of the
  food eaten on the right side then click the button "delete from list of food eaten"
  to delete selected food from list of food eaten.
- You can locate my visual component at the middle of the App and the lists of food choices&eaten 
can be located at the left and right side of screen.
- You can save the state of my application by clicking the button "Save the current lists".
- You can reload the state of my application by clicking the button "Load the saved lists".

# Phase 4: Task 2
- below are the events after the user loaded the saved lists and deleted "rice"
from list of food eaten.

Sun Apr 09 03:01:50 PDT 2023

added ramen to list of food choice

Sun Apr 09 03:01:50 PDT 2023

added pizza to list of food choice

Sun Apr 09 03:01:50 PDT 2023

added 1.5 bowl of ramen to list of food eaten

Sun Apr 09 03:01:55 PDT 2023

added ramen to list of food choice

Sun Apr 09 03:01:55 PDT 2023

added pizza to list of food choice

Sun Apr 09 03:01:55 PDT 2023

added coke to list of food choice

Sun Apr 09 03:01:55 PDT 2023

added rice to list of food choice

Sun Apr 09 03:01:55 PDT 2023

added 1.0 can of coke to list of food eaten

Sun Apr 09 03:01:55 PDT 2023

added 2.0 bowl of rice to list of food eaten

Sun Apr 09 03:02:00 PDT 2023

deleted 2.0 bowl of rice from list of food eaten

# Phase 4: Task 3
- My design is pretty simple and the main function of the App is 
achieved by two classes which are ListOfFood and Food. They allow user
to add Food into ListOfFood or delete from it. The changes between Food
and ListOfFood 
will first be represented in the two fields of ListOfFood and then the Food
inside will be loaded into the JList through DefaultListModel.
The Main method will
instantiate launchpage which also instantiates CounterApp and the class is
the graphic UI. The function of saving and loading the lists are
achieved by one field JsonWriter and two fields JsonReader of CounterApp.
Each time the user make changes, an Event will be created and added into the EventLog,
which will be printed to the console once the app is finished running.
- If I have more time to work on my project, I would make Food&ListOfFood
abstract classes and make new sub-classes like FoodChoice and ListOfFoodEaten
because it's more clearly for people to read the code and make the classed less
cohesive. Right now this app is checking the Food's amount to determine 
whether it's "FoodChoice" or "FoodEaten" and it's easy to forget writing branches
for them. I believe the refactoring could improve the quality of my code so
I'll probably apply it after final.




