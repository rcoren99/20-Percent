#Development Journal
##Week 1
2/9/16

I was gone on Friday, but I did do research during the week on encryptions. I found out htat I will probably have to download a thing to help encrypt my program. Otherwise, I don't really know how to make a desktop app. Learning how to do this will be my next step.

Peace Out,
Rachel Orenstein

#Development Journal
##Week 2
2/13/16

This week, I researched how to make frames in Java! I read Java tutorials at the url https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html. This has instructions on how to make the frame, add components like text fields, radio buttons, password fields, change the visual appearance of the frame, and much more. The website even had a java class that you cound download that makes a window that says "HappyWorld". This in particular was very helpful, because you could see exactly what was going on code-wise. One thing I noticed was that this website only had instructions for three appearance themes, all of which were Windows XP style. I am wondering if there are other ways I can find different themes to make my application look pretty, which is one of my goals. Overall, I am for sure headed in the right direction. Next week, I hope to read through all of the relevant material on the website I found and clearly form a vision for my application.

Hasta la Vista,
Rachel Orenstein

#Developmnet Journal
##Week 3
2/21/16

I made a window appear!!! Hurray to small accomplishments. I also made a Password class with parameters for service, username, category, password, and comments. These will be the fields that the user can fill out to be able to sort, filter, and search their list of passwords. I have been doing more research into making a window, and its all very confusing. There are so many layers and things that you can add that it's a little overwhelming. However, I hope to have the basic window complete by Friday for the check point thing. I was really excited to see that they have password fields and text fields along with menu bars, and that everything is customization by color and size. I also figured out that the frame will take the appearance of whatever operating system in which the window is opened. I hope to be an expert at adding components by the end of this coming week!

See ya round like a donut,
Rachel Orenstein

#Development Journal
##Week 4
2/28/16

This week was very difficult. I had lots of problems figuring out how layouts work for components and how to make the components themselves do what I need them to do. I did make the classes necessary to create and store passwords on the inside of the code. However, the outside is far from finished. I need to figure out how to change the screen when the user needs to be directed to a different one. Currently, when a button is pressed that would do this, a new window appears instead. I also need to finish the GUI for each of the other screens that the application will need. For now, I have made good headway in laying out basic components, however, I anticipate problems when it comes to integrating the password storage system with the interface. Hopefully, the coding will become easier as my understanding of Swing components grows.

Smooth sailing,
Rachel

#Development Journal
##Week 5
3/6/16

Is it really week five already? Time flies when you have to fix every one of your 1980329875034850298 spelling mistakes every time you compile.
I feel as though I have finally figured Swing out this week. I can nest JPanels like a pro and now the screens switch without making a new JFrame every single time (CardLayout was the solution). I have also found that the explanations on the webpage generally suck, but the code from the example programs is really helpful. Don't really want to read their 5 paragraph explanations? Just copy the code into a new BlueJ class, run the program, look at the code, and BOOM you have all the knowledge. In all honesty, I am feeling more optimistic that I will complete this in time. My problem for next week is to store the data (passwords and such) without it resetting itself every time I run the program.

Wish me luck,
Rachel

#Development Journal
##Week 6
3/14/216

This week my computer broke. Just perfect, I know. :-| However, I did make some progress on the GUI for my main screen. I added most, if not all (I haven't finalized the design yet), of the buttons and labels, and I have decided that a table is the most efficient way to display the password data. I have yet to make this table, or figure out how to store data, but that is what I will figure out this coming week. After that, I will focus on possibly including an encryption and making the application's appearance more aesthetically pleasing. I hope I can get my computer working again and make good progress on my project.
How many weeks do we have left again?

Happy Pi Day,
Rachel

P.S.: I can't upload my changes to my project because of said computer problems. Sorry. :-(

#Development Journal
##Week 7

3/19/16

I have been hard at work adding new screens and connecting all of my JButtons to action events this week. I made a new screen for settings. This will enable users to change the name that is displayed on the main screen and the main password that unlocks the safe. The settings button on the main screen connects the settings screen to everything else, and "done" and "cancel" buttons save or discard the changes. One thing I am experimenting with in the settings screen is popup screens. In the settings screen, there are buttons for changing the name or main password. I want to make a separate screen pop up when either of those buttons are clicked, because there would only be one text field, an "ok" button, and a "cancel" button. My decision to do this factors into the appearance on the safe, because such a small amount of components would look weird on a full size screen. This coming week I will finish this and hopefully complete all of the screens and connect all of the JButtons.

Thank God for Spring Break,
Rachel

#Development Journal
##Week 8
4/3/16

At this point, I have finished one hundred percent of the GUI and most of the basic functionality. The functionality I need to put in includes finding a way to store the passwords without Java resetting them every time I close the program. I also need to implement the sorting function in the JTable in the main screen. In addition to this, there are a few little things I would like to fix, like clearing the main password field after login. After this is complete I will look into encryptions and some viable options for adding encryption to my program. Overall I am very happy with the results of my project so far. It is coming out exactly how I had envisioned it.
If you want to look through the program:
1. Unfortunately none of the info saves if you close out of the window, so keep that in mind.
2. The password for the login screen is "s", or you can create a new account. 
3. The sort function doesn't work yet.

Enjoy!
Rachel

#Development Journal
##Week ?
4/24/16

Since the last development journal, I have implemented a sort function and attempted to make the table expand and contract with the window. As it turns out, JTables have built in sort funcion that only took one line of code to implement. This allows the user to click the column header, which sorts the contents of the column in alphabetical order, or if the user clicks the column header again, the column's contents will sort in reverse alphabetical order. Of course, JTable has more advanced sorting and filtering functions, but based on other password vault applications and my target user base, a user will not need any more functionality.
As I was testing the main page of my application, I noticed that if the window's width went below a certain point, the table would kind of collapse into a little, unusable square. After some research, I discovered that this does not happen to every table. I obviously want to fix this problem, and I think it has something to do with either the lack of a minimum preffered size, the settings of the JTable, or the container that the ScrollPane is in. I haven't figured this out yet, so that will be one of my goals for this coming week.

Later Vader,
Rachel