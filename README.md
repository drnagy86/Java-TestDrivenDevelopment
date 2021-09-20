
## Test Driven Development (TDD)

I didn't know anything about test driven development. I found that the process was a little tricky at first then extremely straight forward.

I found that if I wrote the validation methods in the class more useful than writing the test then creating the validation.
It was easier for me to make sure that the specification for the attributes and behaviors of the class were being enforced in the class and then testing.

Also, I found that the testing for bad values to be hard at first but with some practice easy. 
It seems like if you can do it once, apply the logic to the method, then the coding becomes straight forward.

Working with dates was a little harder that I was expecting. My problem was that the time was too accurate and was picking up on milliseconds. Picoseconds possibly? It seemed outrageously accurate for what I was doing. It is interesting, and I am curious about how that could be used.
So, I worked around that by using the "trucateTo()" method in LocalDateTime. I hope that was an acceptable workaround and plan to look into it.


## Questions before turn in:
- About compareTo
- About testing constructors

## Tests to do:

- [x] getTransactionId
- [x] getSalesPersonId
- [x] getTransactionDateTime
- [x] getItemId
- [x] getUnitPrice
- [x] getQuantitySold
- [x] toString
- [x] compareToDateBeforeOther
- [x] compareToDateSameAsOther (Time is slightly off so truncated time to seconds)
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
