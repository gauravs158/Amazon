#search 5 books and add to cart
#verify that the sum of prices of 5 books is displayed correctly on cart page

Feature: Verify that the sum of prices of the books is displayed correctly on cart page

Scenario Outline: Verify that the sum of prices of the books is displayed correctly
		
				Given the user is on Amazon homepage
				When the user searches for <bookName1>
				And the user adds <bookName1> price to total
				And the user selects <bookName1>
				And the user clicks AddToCart button on <bookName1>
				When the user searches for <bookName2>
				And the user adds <bookName2> price to total
				And the user selects <bookName2>
				And the user clicks AddToCart button on <bookName2>
				When the user searches for <bookName3>
				And the user adds <bookName3> price to total
				And the user selects <bookName3>
				And the user clicks AddToCart button on <bookName3>
				And the user navigates to the cart
				Then total displayed in cart page should be equal to the total book price
				
				Examples: 
				| bookName1						| bookName2							| bookName3																		|
				|	Bakar Puran					| Ramayana Unravelled		|	Shift Left																	|
#				|	Shift Left					|	Bakar Puran						|	Market Wizards: Interviews with Top Traders	|
#				|	Ramayana Unravelled	|	Market Wizards				|
#				|	Market Wizards			|	Shift Left						|
#				|	Shift Left					|	Bakar Puran						|
#				|	Shift Left					|	Arthashastra					|