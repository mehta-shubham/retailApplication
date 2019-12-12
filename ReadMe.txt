1. Clone the git repository to your local system using following command
	git clone https://github.com/mehta-shubham/retailApplication.git

2. now if you have maven installed on your system then you can directly go inside project folder and open command prompt at that location   and run 'mvn clean install' to build the project.

3. If you dont have maven installed on your system then you can also download eclipse and import the project via New Project -> Existing Maven Projects -> Select cloned directory and Import. Project will be imported to eclipse.

4. Once Project is imported Right Click Project -> Run As -> mvn build -> Goals: clean install (inside pop-up) -> Run.

5. You will also need database. As per my system configurations I have used Oracle database. You can configure your own database in application.properties file.

One table is required store_users with following columns:
	
	Name 		NullAllowed?  Type
	_______________________________
	ID 			NOT NULL 	Number(10)
	FIRST_NAME  NOT NULL    VARCHAR(50)
	LAST_NAME   NOT NULL    VARCHAR2(50)
	CREATED_AT  NOT NULL    DATE
	UPDATED_AT  NOT NULL    DATE
	USER_TYPE   NOT NULL    VARCHAR2(50)

6. I have also provided API fpr creating users, if you require this API then you also need to create sequence in your database
	script for creating sequence

	create sequence users_seq
	start with 1
	increment by 1
	nocache
	nocycle;
________________________________________________________________________________________________________________________________

API Url : http://localhost:8080/applyDiscount/{id}

Note: replace {id} with user id present in data base.

Sample Request: 

{
    "billingItems": {
        "itemsList": [
            {
                "name": "facewash",
                "value": 30.0
            },
            {
                "name": "soap",
                "value": 20.0
            },
            {
                "name": "shampoo",
                "value": 40.0
            },
            {
                "name": "handwash",
                "value": 70.0
            },
            {
                "name": "insense stick",
                "value": 10.0
            }
        ],
        "groceries": {
            "groceriesList": [
                {
                    "name": "Mango",
                    "value": 50.0
                },
                {
                    "name": "Orange",
                    "value": 40.0
                },
                {
                    "name": "Banana",
                    "value": 10.0
                }
            ]
        },
        "total": 0.0
    },
    "totalItemsPrice": 170.0,
    "discountedItemsPrice": 161.5,
    "totalGroceryPrice": 100.0,
    "netPayableAmount": 251.5
}

________________________________________________________________________________________________________



API Url: http://localhost:8080/createUser

Sample request:

{
    "firstName": "SampleName",
    "lastName": "SampleSurname",
    "createdAt": "2019-12-12",
    "updatedAt": "",
    "userType": "customer"
}

_____________________________________________________________________________________________________________
ASSUMPTIONS:

1. when only one type of % based discount is applied, highest amount of discount will be applied as per current business logic coded