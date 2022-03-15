# lesson 2 part 1

🌟Databinding is not mandatory for simple apps, it is a recommended pattern that makes your code simpler and easier to read.

📌Data binding generates the Binding object at compile time for all views in the layout

📌Accessing views through the Binding object is more efficient than using findViewByID

📌For complex view hierarchies, data binding can be a significant performance gain

📌findviewbyID traverses the view hierarchy at runtime to find a view every time it's called IN OTHER WORDS - slows down the app if this is used instead of view binding ~

😂bonus discovery: I cannot spell binding properly without autocorrection... yay me
