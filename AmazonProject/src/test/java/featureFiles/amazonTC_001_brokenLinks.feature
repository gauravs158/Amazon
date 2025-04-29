#Objective 1: Scroll down to the footer section of the landing page and count the number of links present
#Objective 2: Scroll down to the footer section of the landing page and count the number of broken links

Feature: Count the number of links in the Amazon Landing page footer section
@brokenlinks
Scenario Outline: Count the number of links in the Amazon Landing page footer section

				Given the user is on Amazon homepage
				When the user scrolls down to the footer section
				And the user counts the number of links present in the <Section Name> section
				Then the count is <Expected Count>
				
				Examples:		
				| Section Name 					| Expected Count	|
				| Get to Know Us				|		4							|
				| Connect with Us				|		3							|
				| Make Money with Us		|		9							|
				| Let Us Help You				|		6							|
@brokenlinks				
Scenario Outline: Count the number of broken links in the Amazon Landing page footer section

				Given the user is on Amazon homepage
				And the user scrolls down to the footer section
				And the user counts the number of broken links present in the <Section Name> section
				Then the count is <Expected Count>
				
				Examples:		
				| Section Name 					| Expected Count	|
				| Get to Know Us				|		0							|
#				| Connect with Us				|		3							|
#				| Make Money with Us		|		0							|
#				| Let Us Help You				|		0							|