# Report
## Introduction
The software company aims to develop tools for numerology analysis, focusing on two scenarios:

For a given birthday, determine the Life Path Number, identify the Lucky Colour, and check if it's a master number. Also, compare Life Path Numbers if two birthdays are provided. 

Determine the generation a person belongs to based on their birthday. Only birthdays between 1901 and 2024 are considered, accepting input in both numeric and month name formats.

## Module Descriptions
### public int CheckTwoBirthdays(int date1, int mon1, int year1, int date2, int mon2, int year2)
This method compares two birthdays and returns the Life Path Number of the person with the higher Life Path Number. If the Life Path Numbers are the same, it returns 1 otherwise it returns 0.

### public int CheckTwoBirthdays(int date1, String mon1, int year1, int date2, String mon2, int year2)
This method compares two birthdays same as previous function. Difference is only in function parameters. It is an overloaded function.

### public int CheckTwoBirthdays(String birthdate1, String birthdate2)
This method compares two birthdays same as previous function. Difference is only in function parameters. It is an overloaded function.

### public String FindGeneration(String birthdate)
This method determines the generation a person belongs to based on their birthday. It returns the generation name.

### public String FindGeneration(int date, int mon, int year)
This method determines the generation a person belongs to based on their birthday. It returns the generation name. It is an overloaded function.

### public boolean MasterNumber(int lpn)
This method checks if the Life Path Number is a master number. It returns true if it is a master number, otherwise it returns false.

### public String LuckyColour(int lpn)
This method returns the lucky colour based on the Life Path Number.

### public int LifePathNumber(int date, int month, int year)
This method calculates the Life Path Number based on the birthday. It returns the Life Path Number.

### public int LifePathNumber(String birthdate)
This method calculates the Life Path Number based on the birthday. It returns the Life Path Number. It is an overloaded function.

### public int LifePathNumber(int date, String month, int year)
This method calculates the Life Path Number based on the birthday. It returns the Life Path Number. It is an overloaded function.

### private int sumLPN(int num)
This method calculates the sum of the digits of the Life Path Number until it becomes one digit It returns the sum.

### private int Month(String mon)
This method converts the month name to a number. It returns the month number.


