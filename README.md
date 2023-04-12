# Travel Planner Project

## Description

This project is an application for recording and managing travel itineraries. 
The program will include an arbitrary number of travel entries, each with a name that specifies the content 
of each trip. Within each trip entry, further and more detailed information will be given. Some examples of these 
possible sections included in each
trip are:
- pricing
- flight information
- hotel details

## Audience and Reasoning

The primary target audience for this project is frequent travelers. 
The program will give them a space to keep all information regarding future, current, and 
past trips in one place in an organized fashion. This is highly beneficial for people who go 
on multiple trips a year, whether that be for business or pleasure, as it is quite easy to
lose track of the details mentioned above. This topic is of personal interest to me as I love 
traveling and am fortunate enough to get to enjoy vacationing often. And as previously stated,
it is really easy to lose track of important information unless it is kept in a single location
that is easily assessable. Therefore, I want to use this project as a way to make traveling 
more convenient and prevent logistical problems from occurring.

## User Story
- As a user, I want to be able to see an overview of all my trips.
- As a user, I want to be able to add a trip to my overview.
- As a user, I want to be able to access detailed information on individual trips.
- As a user, I want to be able to change the details of one of my trips.
- As a user, I want to be able to remove a trip.
- As a user, I want to be able to save all trips in my list of trips if I choose to.
- As a user, I want to be able to load my list of trips from file if I choose to.

## Instructions for Grader
- You can add multiple trips to a list of trips by entering all trip information in the specified text fields and 
  then clicking the add trip button.
- You can remove trips from a list of trips by entering the name of the trip to remove in the specified text field and 
  then clicking the remove trip button.
- You can locate my visual component by viewing the splash screen that occurs when first opening the application.
- You can save the state of my application by clicking the save button.
- You can reload the state of my application by clicking the load button.

## Phase 4: Task 2
Fri Mar 31 15:18:33 PDT 2023 

Trip named bob added to list of trips

Fri Mar 31 15:18:39 PDT 2023

Trip named bob removed from list of trips

Fri Mar 31 15:18:47 PDT 2023

Trip named john added to list of trips

Fri Mar 31 15:18:59 PDT 2023

Trip named sarah added to list of trips

## Phase 4: Task 3
If I had more time for this project, I would make some significant changes to improve 
its cohesion and coupling. One of the main ways I would refactor my project would be to
make the Hotel and Flight class extend a new abstract class. These two classes have a 
lot of duplication as they both are features of a trip. Additionally, by creating this 
abstract class, it would be easy to add new features to a trip, such as an activity. 
This change would reduce the coupling in the project as a change to the abstract class 
would alter the subclasses. Another way I would refactor my trips project would be to 
split some of the larger classes into multiple smaller ones. For example, the 
ListOfTrips class has multiple methods related to grouping and arranging trips by the 
date. I would improve the cohesion by splitting the ListOfTrips class into ListOfTrips
and a new class named TripsGrouping, where TripsGrouping is in charge of handling all 
the methods related to groups. Another class that should be split is the TripsUI class.
It contains many methods that could be grouped into their own class, such as a class 
for the action buttons and a class for the text fields. Overall, these refactoring 
changes that I could make would improve the project's cohesion and coupling by reducing
dependencies and ensuring that every class is responsible for only one thing.

