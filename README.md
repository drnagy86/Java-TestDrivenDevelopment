## Test Driven Development (TDD)

## Explaination
In "src" folder, Person.js is the in class work we did. SaleItem.js is an example. SalesTransaction.js is what I wrote for homework.

In the "tests" folder, PersonTest.js is the in class work and SaleItem.js is an example. SalesTransactionTest.js is what I wrote.

## Reflection

I didn't know anything about test driven development. I found that the process was a little tricky at first then extremely straight forward.

I found that if I wrote the validation methods in the class more useful than writing the test then creating the validation. It was easier for me to make sure that the specification for the attributes and behaviors of the class were being enforced in the class and then testing.

Also, I found that testing for bad values was hard at first but with some practice easy. If you can do it once and understand the logic, then the coding becomes straight forward.

Working with dates was a little harder than I was expecting. My problem was that the time was too accurate and was picking up on milliseconds. Picoseconds possibly? It seemed too precise for my needs. So, I tried to work around that by using the "trucateTo()" method in LocalDateTime and still had issues. Talked with my Java instructor Marc Hauschildt, and he saw that I wasn't doing an apples to apples comparison. I was testing two unequal items, and the test told me that they were not equal. Fixed that. I also added a static variable and method that would update the minimum time and changed the order of when the DateTime methods are called so that the minimum is always current.  


## Tests:

- [x] getTransactionId
- [x] getSalesPersonId
- [x] getTransactionDateTime
- [x] getItemId
- [x] getUnitPrice
- [x] getQuantitySold
- [x] toString
- [x] compareToDateBeforeOther
- [x] compareToDateSameAsOther
- [x] compareToDateAfterOther
- [x] setTransactionIdZeroGood
- [x] setTransactionIdPositiveGood
- [x] setTransactionIdNegativeBad
- [x] setSalesPersonIdPositiveGood
- [x] setSalesPersonIdZeroBad
- [x] setSalesPersonIdNegativeBad
- [x] setTransactionDateTimeTodayGood
- [x] setTransactionDateTime30DaysAgoGood
- [x] setTransactionDateTime31DaysAgoBad
- [x] setTransactionDateTimeTomorrowBad
- [x] setItemIdPositiveGood
- [x] setItemIdZeroBad
- [x] setItemIdNegativeBad
- [x] setUnitPricePositiveGood
- [x] setUnitPriceZeroGood
- [x] setUnitPriceNegativeBad
- [x] setUnitPriceDigitsBad (added this one)
- [x] setQuantitySoldPositiveGood
- [x] setQuantitySoldZeroBad
- [x] setQuantitySoldNegativeBad
