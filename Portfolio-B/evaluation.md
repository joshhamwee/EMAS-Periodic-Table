# **Evaluation**
In the initial client brief, five stages were outlined according to increasing importance and complexity. We were able to complete three stages. Below we discuss the evaluation of this project and the results obtained.

The evaluation process began with interviewing the clients. The plans for the initial stages were discussed and compared with the final product. After asking open-ended questions and going through possible use case tasks, the feedback we received was mostly positive. The clients did mention that they would like to be able to zoom-in, but that this is not a necessary feature and could be left for future development.

<br>

### Conducting the evaluation
For further evaluation, we conducted _observations_ by using the approach of _talk-throughs_ and concluded with a short survey. We decided not to evaluate based on quantitative measures and instead focus on qualitative assessment by allowing users to explore the app.

For each user, we suggested each task and prompted them to explain their thoughts as they performed said task, while we simultaneously took note of any struggle, hesitation and difficulties. Once every use case was completed, we requested the user to complete the short survey summarizing the experience.

<br>

### Results
As seen in the image below, majority of the feedback was positive with 4 or 5 stars on most questions.

![results](images/SurveyResults.png "results")

The evaluation pointed us to two bugs in our system- the search feature did not have a 'no result' case and secondly when previous/next element was pressed on the first and last element, the app would crash. We overcame these by adding a 'no results found' page , and by removing the previous button on the first element and vice-versa for the last, respectively.

The overall results were quite positive: users liked the colour scheme, appreciated the design of the home page and didnt have much trouble with operating the various features.

One change which we did make due to these results, was that of the unit/filter functions. As it was the result which was the most skewed, we believed that a change was needed, so we moved from an icon of three dots, to an icon of an actual filter. This seemed to eliminate any confusion by the user.

The final iteration of our app consisted of fixing the search feature and other bugs, completing the documentation and tying up other loose ends.

<br>

### Future Developments/Ideas
The next two stages would be the key areas to look into for developing the application in the future.

The fourth stage involves creating an Instrument Configuration Tool. This tool would equip the user with a list of all spectrometer-crystal combinations that they could use to detect each element. This would guide the user on how they should analyse an element and aid our client's in the work that they carry out as they would not have to look up these configurations in a book, nor remember these configurations.

The fifth stage involves an X-ray line look-up/interference tool. Our application currently contains a graph of the major X-ray lines for the elements, however there is no consideration for the range of minor lines. The client has outlined that interference from these minor lines is an important issue in the work that they carry out, so a graph depicting possible interfering element lines (based on the spectrometer and crystal used) would reduce the errors that they encounter in their work.

Finally, whilst we have implemented a section of the application to view graphs, in their initial specification the client requested that these graphs be interactive. This would allow them to view the precise values and ranges displayed on the graphs more accurately.

Additionally, we have also received the following feedback, from the user testing of our application, that can be further developments:
* As EMAS is a European society, a select language/translation feature would increase the accessibility of the application, whilst proving more convenient to the colleagues of our clients.
* A zooming feature, as mentioned by many test-takers, would enable users with smaller screen sizes to use the application more easily. Additionally, this feature could make the app more accessible to those visually-impaired.
