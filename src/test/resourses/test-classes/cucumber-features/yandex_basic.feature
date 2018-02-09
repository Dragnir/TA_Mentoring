Feature: Yandex basic test
#comment is here - feature description for search testing

#recurrent actions/preconditions go below - in "Background" section
#this section is optional. 
#Uncomment it and delete/comment duplicating step from Scenario description
#Background:
#Given user navigates to github home page

Background:
Given New scenario started

@newMail
Scenario: Log in to mail
Given user navigates to Yandex mail
When  enters user credentials and submits login form
Then  yandex mail home page is displayed

@newMail
Scenario Outline: New mail creation
Given user create new mail
When  user enter mail "<address>" and theme and save mail as draft
Then  new mail available in draft folder

Examples:
  | address                |
  | dragnir@tut.by         |
  | vadim.kuryan@gmail.com |

@newMail
Scenario: Send mail
Given user send new mail
When  user go to draft folder and send mail
Then  new mail is removed from draft folder