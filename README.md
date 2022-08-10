# Irrigation System App


This is an irrigation scheduling system that automate the scheduling of land irrigation base on timeslot and amount of water configuration 



## Instructions

To compile (also runs unit tests)

```
mvn package
```

## Dependencies

The system make use of MySql database as such an isntance of mysql database is required to run the application so ensure the application.properties configuration is updated with database configuration before running the application

## To run the app 

```
mvn spring-boot:run
```

....and navigate your browser to  http://localhost:8080/

To  add land post request to http://localhost:8080/api/v1/land

```JSON
{
    "code": "73732823y723899",
    "area": 2000,
    "landType": "Sandy",
    "agricType": "Rice farming"
}
```

To  edit land put request to http://localhost:8080/api/v1/land/{landId}

```JSON
{
    "code": "29388933",
    "area": 2000,
    "landType": "Clay Soil",
    "agricType": "Rice farming"
}
```

To  edit configure land post request to http://localhost:8080/api/v1/land/{landId}/configure

```JSON
{
    "deviceName": "Sensie153",
    "timeSlot":"2022-08-10T22:09:32.000+00:00",
    "durationInMinutes": 3600,
    "intervalInDays": 4,
    "amountOfWater": 2000
}
```

To  get land details navigate to http://localhost:8080/api/v1/land/
```JSON
[
    {
        "id": 1,
        "code": "29388933",
        "landType": "Clay Soil",
        "agricType": "Rice farming",
        "area": 2000.0,
        "landConfigurations": [
            {
                "id": 1,
                "deviceName": "Sensie123",
                "timeSlot": "2022-08-10T23:45:32.000+00:00",
                "intervalInDays": 4,
                "durationInMinutes": 3600,
                "amountOfWater": 2000,
                "nextTimeSlot": "2022-12-14T23:45:32.000+00:00",
                "createdOn": "2022-08-10T20:46:32.000+00:00",
                "modifiedOn": null
            }
        ]
    },
    {
        "id": 2,
        "code": "7373282",
        "landType": "Loamy",
        "agricType": "Rice farming",
        "area": 2000.0,
        "landConfigurations": [
            {
                "id": 2,
                "deviceName": "Sensie153",
                "timeSlot": "2022-08-10T23:45:32.000+00:00",
                "intervalInDays": 4,
                "durationInMinutes": 3600,
                "amountOfWater": 2000,
                "nextTimeSlot": "2022-09-26T11:45:32.000+00:00",
                "createdOn": "2022-08-10T20:47:36.000+00:00",
                "modifiedOn": null
            },
            {
                "id": 3,
                "deviceName": "Sensie153",
                "timeSlot": "2022-08-10T22:09:32.000+00:00",
                "intervalInDays": 4,
                "durationInMinutes": 3600,
                "amountOfWater": 2000,
                "nextTimeSlot": "2022-08-10T22:09:32.000+00:00",
                "createdOn": "2022-08-10T21:08:48.000+00:00",
                "modifiedOn": null
            }
        ]
    },
    {
        "id": 3,
        "code": "2722782392889",
        "landType": "sandy soil",
        "agricType": "Rice Farming",
        "area": 23348.0,
        "landConfigurations": []
    }
]
```

## To run integration tests

```
mvn spring-boot:run
mvn verify
```

## Run all the unit test.
$ mvn test


Enjoy!