### The problem

Staff wish to gain some insights into the current student enrollment. They need an application that will help them understand which students are enrolled in which classes.

### Materials

You are provided with some student timetable data in this challenge.

### Task 1 - REST API

Provide a BACKEND REST API using Java Spring, .NET WebAPI or Node that will ingest the provided data, and outputs the following:

1. a list of unique subjects and their associated IDsx

2. a list of unique student IDs given a particular subject ID.

#### Data structure:

```json
{
	"student_id": "18362887",
	"class_details": [
		{
			"subject_code": "ACC3TAX",
			"subject_desc": "Taxation",
			"week_start_date": "2017-11-13",
			"week_end_date": "2017-11-19",
			"exact_class_date": "2017-11-13",
			"day_of_week": "Mon",
			"room_number": "1.09",
			"room": "1.09",
			"gps_coordinates": "-33.875641,151.209343",
			"start_time": "09:00",
			"end_time": "12:00",
			"campus_code": "SY",
			"hasStandardRoomDescription": false,
			"duration": 180,
			"duration_code": "I",
			"isHoliday": false
		}
	]
}
```

### Task 2 - Test automation

Create a basic test automation application that can verify the api results in Task 1. Test cases are upto your discretion.

Utilises the REST API endpoint you developed in Step 1.

### What we look at

- Coding Style
- Semantics
- Problem Solving
- Algorithms
- Design Patterns
- Error Handling to show meaningful messages
- User experience

### Swagger UI

http://localhost:8080/swagger-ui/index.html
