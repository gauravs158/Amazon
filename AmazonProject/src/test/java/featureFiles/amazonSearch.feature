#Search 5 books and add to cart
#Scenario1: Verify the 5 books are displaying in the cart
#Scenario2: Verify that the sum of prices of the books is displayed correctly


Feature: Verify the books added to cart are displaying correctly
@items
		Scenario Outline: Verify the books added to cart are displaying correctly
		
				Given the user is on Amazon homepage
				When the user searches for <bookName1>
				And the user adds <bookName1> to bookList
				And the user selects <bookName1>
				And the user clicks AddToCart button on <bookName1>
				When the user searches for <bookName2>
				And the user adds <bookName2> to bookList
				And the user selects <bookName2>
				And the user clicks AddToCart button on <bookName2>
				When the user searches for <bookName3>
				And the user adds <bookName3> to bookList
				And the user selects <bookName3>
				And the user clicks AddToCart button on <bookName3>
				When the user searches for <bookName4>
				And the user adds <bookName4> to bookList
				And the user selects <bookName4>
				And the user clicks AddToCart button on <bookName4>
				And the user navigates to the cart
				Then all books are displayed in the cart
				
		Examples: 
				| bookName1						| bookName2							| bookName3 																			| bookName4 					|
				|	Bakar Puran					|	Ramayana Unravelled		|	Market Wizards: Interviews with Top Traders			|	Shift Left					|
#				|	Arthashastra				|	Ramayana Unravelled		|	Shift Left					|	Bakar Puran					|	
#				|	Ramayana Unravelled	|	Market Wizards				|	Bakar Puran					|	Shift Left					|	
#				|	Market Wizards			|	Shift Left						|	Ramayana Unravelled	|	Arthashastra				|
#				|	Shift Left					|	Bakar Puran						|	Arthashastra				|	Ramayana Unravelled	|	
#				|	Shift Left					|	Arthashastra					|	Market Wizards			|	Bakar Puran					|