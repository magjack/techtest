#Test application 

This is a spring boot application that processes 50 messages about the sale of products

To run the project clone this repo and run the following in a command line within the project directory:

``
    mvn spring-boot:run 
``

This will create a REST Api with two POST endpoints sale and saleAdjust
To use these endpoint use a http client like postman or curl passing the following. 

``
POST localhost:8080/message/sale
``
Passing: 

```json
{
	"product": "<StringValue>",
	"value": <Number> ,
    "Quantity": <Integer> //Optional
}
```
Examples: 
```json
   {
   	"product": "Bike",
   	"value": 10.10 ,
       "Quantity": 10
   }
   ```
```json
{
	"product": "Scooter",
	"value": 13.20
}
```

The other endpoint is : 
``
POST localhost:8080/message/saleAdjust
`` which accepts:

```json
{
	"sale":{
	     "product": "<StringValue>",
         "value": <Number> ,
        "Quantity": <Integer> //Optional
	},
	"adjustment":{
		"product": "<StringValue>",
		"operation":"<SUBTRACT|ADD|MULTIPLE>",
		"value":<NUMBER>
	}
}
``` 
Example : 
```json
{
	"sale":{
		"product": "bike",
		"value": 10,
		"quantity":1
	},
	"adjustment":{
		"product": "bike",
		"operation":"SUBTRACT",
		"value":10
	}
}
```
