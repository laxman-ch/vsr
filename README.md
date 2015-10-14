# vsr
VSR logistics

# Requirement
1. java 1.7
2. maven
3. mysql - configure correctly in application.properties

# How to build
1. mvn spring-boot:run

# REST apis
1. All apis are available at http://localhost:8080/alps

POST, PUT - Accepts json input

# Stations
- GET - http://localhost:8080/stations{?page,size,sort}
- POST - http://localhost:8080/stations
- PUT - http://localhost:8080/stations/id
- DELETE - http://localhost:8080/stations/id

# Fares
- GET - http://localhost:8080/fares{?page,size,sort,projection=fare_details}
- POST - http://localhost:8080/fares
- PUT - http://localhost:8080/fares/id
- DELETE - http://localhost:8080/fares/id

# Departments
- GET - http://localhost:8080/departments{?page,size,sort}
- POST - http://localhost:8080/departments
- PUT - http://localhost:8080/departments/id
- DELETE - http://localhost:8080/departments/id

# Invoices
- GET - http://localhost:8080/invoices{?page,size,sort,projection=invoice_details}
- POST - http://localhost:8080/invoices
- PUT - http://localhost:8080/invoices/id
- DELETE - http://localhost:8080/invoices/id

# Paginated GET Example
- url : http://localhost:8080/stations?page=1&size=25&sort=stationName,asc&sort=state,desc
- page - required page number. starts from 0.
- size - required page size
- Multiple sorts are supported

# GET stations response
- url: http://localhost:8080/stations?page=0&size=25&sort=stationName,asc&sort=state,desc

```json
{
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/stations{?page,size,sort}",
      "templated" : true
    }
  },
  "_embedded" : {
    "stations" : [ {
      "id" : 4,
      "shortCode" : "HYD",
      "stationName" : "HYDERABAD",
      "district" : "HYDERABAD",
      "state" : "TG",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/stations/4"
        }
      }
    }, {
      "id" : 1,
      "shortCode" : "BZA",
      "stationName" : "VIJAYAWADA",
      "district" : "KRISHNA",
      "state" : "AP",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/stations/1"
        }
      }
    } ]
  },
  "page" : {
    "size" : 25,
    "totalElements" : 2,
    "totalPages" : 1,
    "number" : 0
  }
}
```