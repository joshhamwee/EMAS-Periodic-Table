# Testing
<div style="text-align: justify">There are 6 main components in our architecture diagram, each of which will have its own set of unit tests, as well as an overall integration test to check whether the individual components work together as a whole. The initial phase of testing will be checking the correctness of the code written for each component. </div>


## Unit Tests
#### Periodic Table View
<div style="text-align: justify">The unit tests for this particular component will only check whether the display of the Periodic Table is correct, and will check the values in a few cells to see if they match the expected value. This will be done by getting the values from a set of cells in the Periodic Table and comparing the expected values to the values obtained from the table. </div>

#### Search Activity
<div style="text-align: justify">This component will be tested by checking the return value of the search function and the predicted search function by various inputs, and will be compared to the expected return value to check whether the code written is correct. There will be validation and verification tests as well, which will check if the search function works as expected on unusual inputs and with special characters. </div>

#### Current Element
<div style="text-align: justify">This component will be tested by checking whether it fetches the correct values from the database based on the element that is provided to the function, by comparing the return values to the expected values. It will also have some verification checks to see if it returns an error or a null value if an element that does not exist in the database is requested. </div>

#### Element View
<div style="text-align: justify">This component will be tested for its correctness in displaying the correct image. All the other information required will be provided by Current Element, so there won't be any tests required to check the rest of the information. The images will be labelled sensibly, so the function can be tested by requesting an image using a key from the database, and the file name of the image provided will be compared to the expected file name for the image. </div>

#### Element Button
<div style="text-align: justify">The tests for this component will check if it produces the correct output when an element from the Periodic Table is pressed. This will be done by checking the function that handles what happens when an element is clicked. The tests will provide the function with an element key, and will check if the value returned matches the element provided. </div>

## Integration Tests
<div style="text-align: justify">The integration test will check if all the software modules interact correctly when combined. Since most of the modules are dependent on each other, this is a crucial aspect of the testing phase to make sure the app functions properly. The Periodic Table View and the Search Activity will be integrated together, and we will need to test if they work properly together. Similarly, the Periodic Table View and Element Button will be integrated together, as the Periodic Table View will be populated by Element Buttons, and the integration test will check if the buttons are ordered correctly and don't cause clashes. Element Button and Element View will be integrated as well, and it will check if clicking on an Element Button will lead to the correct Element View. Element View and Current Element will be integrated together as well, and the tests will check if Element View can fetch the correct information from Current Element for display. </div>

## Testing Frameworks
We will be using JUnit to create our unit tests and the integration tests, while we will be testing our UI using the Espresso Testing Framework.
