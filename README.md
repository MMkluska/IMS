Coverage: 82,2%
# Inventory Managment System

  A simple Java code to operate MySQL database in comand line interface. It allows to edit customers, items and orders.  

## Getting Started

1. Fork this repository
2. Clone forked repository to your local device
3. In src/main/resources/db.properties enter the information for your local SQL database
4. Import project to your local IDE ie Eclipse

### Prerequisites

  Database - [MySQL Server 5.7+](https://www.mysql.com/products/workbench/)<br>
  Back-end Programming Language - [Java](https://www.java.com/) <br>
  Build Tool - [Maven](https://maven.apache.org/) <br>
  Unit Testing - [JUnit](https://junit.org/junit4/) <br>

### Installing

1. Set up your database using MySQL

```
CREATE DATABASE IF NOT EXISTS ims;
USE ims;

CREATE TABLE IF NOT EXISTS Customers (
  customer_id INT NOT NULL AUTO_INCREMENT,
  first_name varchar(25),
  last_name varchar(25),
  PRIMARY KEY (customer_id)
);

```

2. run src\main\java\com\qa\ims\Runner.java at your local IDE

```
Welcome to the Inventory Management System!
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application
```

## Running the tests

1. In your local IDE right click on src\test\java\com\qa\ims
2. Select JUnit 4
3. Run tests
4. Select coverage to check % of testing

### Unit Tests 

A unit is the smallest whole increment, from which this testing gets its name. It is by far one of the most important tests and it tests a small amount of code, usually a single method, to see if it returns the expected output.

```
	@Test
	public void testCreateN() {
		final Long id = 1L;
		final String choice = "n";
		final Order created = new Order(id);
 
		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(utils.getString()).thenReturn(choice);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, this.controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	} 
```

## Built With

* [Jira](https://mmkluska.atlassian.net/jira/software/projects/IMS/boards/2) - Agile Project Management
* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [GitHub](https://github.com/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Mateusz Kluska** - *Finished work* - [MMkluska](https://github.com/MMkluska/IMS)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Many thanks to tutors at QA Academy
* Google search engine 
* Stack Overflow
