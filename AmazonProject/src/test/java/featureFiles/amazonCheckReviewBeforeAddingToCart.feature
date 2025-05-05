#User checks the reviews of all the mentioned items and 
#adds items to the cart which have average review above 4 with atleast 300 reviews

Feature: Add to items to cart with average review above 4.0 with atleast 300 reviews

Scenario Outline: Add to items to cart with average review above 4.0 with atleast 300 reviews
					
				Given the user is on Amazon homepage
				When the user searches for <ItemSearchEntry1>
				And the user clicks <ItemListSelection1> with <Extra Info1>
				And the user clicks AddToCart button if globalRatings is > 300 and starRating is > 4
#				And the user searches for <ItemSearchEntry2>
#				And the user selects <ItemListSelection2> with <Extra Info2>
#				And the user clicks AddToCart button if globalRatings is > 300 and starRating is > 4
#				And the user searches for <ItemSearchEntry3>
#				And the user selects <ItemListSelection3> with <Extra Info3>
#				And the user clicks AddToCart button if globalRatings is > 300 and starRating is > 4
#				And the user searches for <ItemSearchEntry4>
#				And the user selects <ItemListSelection4> with <Extra Info4>
#				And the user clicks AddToCart button if globalRatings is > 300 and starRating is > 4
#				And the user searches for <ItemSearchEntry5>
#				And the user selects <ItemListSelection5> with <Extra Info5>
#				And the user clicks AddToCart button if globalRatings is > 300 and starRating is > 4
				And the user navigates to the cart
				Then all items with GlobalRatings > 300 and StarRatings > 4 are displayed in the cart
				
				Examples: 
				|	ItemSearchEntry1				|	ItemListSelection1																				|	Extra Info1																	|	ItemSearchEntry2				|	ItemListSelection2																				|	Extra Info2																	|	ItemSearchEntry3			|	ItemListSelection3																				|	Extra Info3																	|	ItemSearchEntry4				|	ItemListSelection4																				|	Extra Info4																	|	ItemSearchEntry5				|	ItemListSelection5																				|	Extra Info5																	|
				|	Boult X Mustang 				|	Boult X Mustang Newly Launched Torq TWS Earbuds						|	Yellow																			|	Puma Unisex Softride		|	Unisex-Adult Softride Enzo Evo														|	Walking Shoe																|	Urban Jungle by Safari|	Urban Jungle by Safari Roam Briefpack											|	22 Liters Water Resistant										|	Apple Watch Ultra 2			|	Apple Watch Ultra 2 [GPS + Cellular 49 mm] Smartwatch			|	Natural Titanium Milanese Loop							|	insta360 X4-8K					|	insta360 X4-8K Waterproof 360 Optical Zoom Action Camera	|	Removable Lens Guards, 135 Min Battery Life	|
#				|	Urban Jungle by Safari	|	Urban Jungle by Safari Roam Briefpack											|	22 Liters Water Resistant										|	insta360 X4-8K					|	insta360 X4-8K Waterproof 360 Optical Zoom Action Camera	|	Removable Lens Guards, 135 Min Battery Life	|	Puma Unisex Softride	|	Unisex-Adult Softride Enzo Evo														|	Walking Shoe																|	Boult X Mustang					|	Boult X Mustang Newly Launched Torq TWS Earbuds						| Yellow																			|	Apple Watch Ultra 2			|	Apple Watch Ultra 2 [GPS + Cellular 49 mm] Smartwatch			|	Natural Titanium Milanese Loop							|
#				|	Puma Unisex Softride		|	Unisex-Adult Softride Enzo Evo														|	Walking Shoe																|	Apple Watch Ultra 2			|	Apple Watch Ultra 2 [GPS + Cellular 49 mm] Smartwatch			|	Natural Titanium Milanese Loop							|	insta360 X4-8K				|	insta360 X4-8K Waterproof 360 Optical Zoom Action Camera	|	Removable Lens Guards, 135 Min Battery Life	|	Puma Unisex Softride		|	Unisex-Adult Softride Enzo Evo														|	Walking Shoe																|	Boult X Mustang					|	Boult X Mustang Newly Launched Torq TWS Earbuds						|	Yellow																			|
#				|	Apple Watch Ultra 2			|	Apple Watch Ultra 2 [GPS + Cellular 49 mm] Smartwatch			|	Natural Titanium Milanese Loop							|	Urban Jungle by Safari	|	Urban Jungle by Safari Roam Briefpack											|	22 Liters Water Resistant										|	Boult X Mustang				|	Boult X Mustang Newly Launched Torq TWS Earbuds						|	Yellow																			|	insta360 X4-8K					|	insta360 X4-8K Waterproof 360 Optical Zoom Action Camera	|	Removable Lens Guards, 135 Min Battery Life	|	Puma Unisex Softride		|	Unisex-Adult Softride Enzo Evo														|	Walking Shoe																|
#				|	insta360 X4-8K					|	insta360 X4-8K Waterproof 360 Optical Zoom Action Camera	|	Removable Lens Guards, 135 Min Battery Life	|	Boult X Mustang					|	Boult X Mustang Newly Launched Torq TWS Earbuds						|	Yellow																			|	Apple Watch Ultra 2		|	Apple Watch Ultra 2 [GPS + Cellular 49 mm] Smartwatch			|	Natural Titanium Milanese Loop							|	Urban Jungle by Safari	|	Urban Jungle by Safari Roam Briefpack											|	22 Liters Water Resistant										|	Puma Unisex Softride		|	Unisex-Adult Softride Enzo Evo														|	Walking Shoe																|