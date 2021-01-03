Feature: HotelBooking
This feature is to implement Hotel Booking 
Scenario Outline: Free HotelBooking
Given open browser and enter url
And title of login is Hotel Booking Application
When user enter "<username>" and "<password>"
And user is on HotelBooking homepage
Then User enter all the required Details
Then Close the browser

Examples:
      |username | password|
      |admin|admin|