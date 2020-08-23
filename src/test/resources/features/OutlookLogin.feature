
@tag
Feature: Updating Time Sheet
  I want to use this template for my feature file

  @tag3
  Scenario Outline: <TC_ID>_<TC_Description>
  Given Login to outlook
  Then Navigate to open air from outlook 
  And Open time sheet editor
  And Update and submit time sheet
  
  Examples:
	|TC_ID|TC_Description|
	|TC001|Update Timesheet|