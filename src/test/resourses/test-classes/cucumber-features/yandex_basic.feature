Feature: Yandex basic test
#comment is here - feature description for search testing

#recurrent actions/preconditions go below - in "Background" section
#this section is optional. 
#Uncomment it and delete/comment duplicating step from Scenario description
#Background:
#Given user navigates to github home page

@newMail
Scenario: New mail creation
Given user navigates to Yandex mail
When  enters user credentials and submits login form
Then  yandex mail home page is displayed

