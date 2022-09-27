Feature: Login Test k
		

Scenario: login Test
 	Given url 'http://localhost:8080/Testk'
	When method GET
	Then status 404
	Then print response.data 
	
	


	