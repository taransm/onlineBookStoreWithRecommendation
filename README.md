<body>
<header>
<h1 class="title" style="text-align: center;">Book Store with Recommendation System</h1>

</header>
<br>
<h2 id="introduction">Introduction</h2>
<p>The Internet by far plays a major role in people’s life. It has drastically improved the quality of life and the standard of living of so many people. It has widened its branches into many different levels and areas. The e-commerce business is one such branch that has gotten a lot of attention recently. Traditional bookstores are not always accessible; they are limited by their hours of operation, the availability of specific books, their location, and, most crucially, their capacity and the space required to store a large number of books. As a result of these disadvantages, e-commerce sectors have evolved. Such drawbacks have led to the evolution of e-commerce industries related to bookstores. The project is a simple website that includes a variety of books in various categories for consumers to view online.</p>
<p>With the growth of Youtube, Amazon, Netflix, and other similar web services over the last several decades, recommender systems have become increasingly important in our lives. Recommender systems are becoming ubiquitous in our everyday online journeys, from e-commerce (suggest articles to buyers that may be of interest) to online advertising (suggest the suitable contents to users based on their preferences). Recommender systems, in a broad sense, are algorithms that try to propose relevant items to consumers (items being movies to watch, text to read, products to buy or anything else depending on industries). In certain businesses, recommender systems are crucial since they may produce a large amount of revenue or serve as a method to differentiate yourself from rivals. As an example of the importance of recommender systems, Netflix held a competition (the "Netflix prize") a few years ago in which the objective was to create a recommender system that outperformed its own algorithm, with a reward of one million dollars on the line. </p>
<p>The main goal of this project is to make an online book recommendation system and examine the performance of the machine learning algorithm on a publicly available dataset from Kaggle. Weka API is used as the main tool to evaluate and recommend the books from the dataset.</p>
<p>Businesses rely on data scientists to derive insight from their enormous, ever-expanding, diverse set of data in today’s Big Data era. Many people think of data science as a job, but it’s more accurate to think of it as a way of thinking, a technique of extracting insights through the scientific process.</p>
<h2 id="problem-solving-and-algorithms">Problem solving and algorithms</h2>
<p>The Book dataset utilized in this project is available at Kaggle.com . The dataset can be viewed as either classification or regression tasks. This dataset can be used for building book recommendation system as it contains all the information for each book in the dataset. The dataset contains 9 descriptive features and 6238 instances. Books are identified by their respective Title. Moreover, some content-based information is given (Author, Edition, Reviews, Ratings, Synopsis, Genre, Book Category, and Price)</p>
<p>Data cleaning is extremely important before utilizing the data. In this project, the data is preprocessed by identifying and handling duplicate data, anomalous data, and other inconsistencies that could skew the analysis. This will ultimately enhance the performance of the model. The Book dataset will serve as the foundation for our project's book recommendation engine, as it contains all of the necessary data.</p>
<p>Weka implements a relatively complete set of classification algorithms, including many of the most popular. In this project, state-of-the-art unsupervised classification algorithm, k-means algorithm is used. As different descriptive features may impact the classifiers’ performance, we clean the data before doing descriptive analysis.</p>
<h2 id="proposed-system-design">Proposed System Design</h2>
<h3 id="system-components">System components</h3>
<ul>
<li>
<b>Login page -</b> Authentication (Login) has two roles (Admin, Customer)
</li>
<li>
<b>Admin user login -</b> Allows admin to search a book, view the list of books, add a book, modify a book, and delete a book
</li>
<li>
<b>Regular user login -</b> Allows a regular user to search a book and view the list of books
<li>
<b>View (along with Recommended books) -</b> when a user clicks a book, it will display details of the selected book, on this page we will recommend similar books, related to the item the user is looking for.
</li>
</ul>
<h3 id="preliminary-technical-tools">Technical tools</h3>
<ul>
<li>
Eclipse
</li>
<li>
MySql
</li>
<li>
Java EE
</li>
<li>
Weka API
</li>
<li>
Enterprise JavaBeans (EJB)
</li>
<li>
JavaServer Pages (JSP)
</li>
<li>
WildFly
</li>
</ul>
  <p>Dataset source : https://www.kaggle.com/datasets/anmolkumar/predict-book-prices</p>
 
    
![t2-01](https://user-images.githubusercontent.com/67748452/165387019-15f980aa-c003-4954-8a50-45f2383d0bc3.png)
![t2-02](https://user-images.githubusercontent.com/67748452/165387020-f7744688-fc63-4e55-b66d-fdae99a0b8b2.png)
![t2-03](https://user-images.githubusercontent.com/67748452/165387021-abefbfa4-d4cd-4467-a424-1c58e7202ba1.png)
![t3-01](https://user-images.githubusercontent.com/67748452/165387022-84a41433-4385-4c8e-a431-f6a2d8389ad6.png)
![t4-01](https://user-images.githubusercontent.com/67748452/165387024-c779e78c-0b1e-4f65-ab9e-b91940be366a.png)
![t5-01](https://user-images.githubusercontent.com/67748452/165387026-f853e7f8-20fe-4e90-93c8-9597e267f3aa.png)
![t5-02](https://user-images.githubusercontent.com/67748452/165387028-1c21ba02-d1e4-4625-bcc9-3bbb6e478b9c.png)
![t6-01](https://user-images.githubusercontent.com/67748452/165387030-82e0b1fc-5c4c-4fc9-9e7a-a2e266a77be2.png)
![t7-01](https://user-images.githubusercontent.com/67748452/165387031-e41e2f05-7ede-4b14-9aff-21e75dadcbb2.png)
![t7-02](https://user-images.githubusercontent.com/67748452/165387032-99a76442-0d67-4353-bef2-4d1aaf9a3d3b.png)
![t8-01](https://user-images.githubusercontent.com/67748452/165387033-c566330d-e22f-47d8-9f50-d756602ef195.png)
![t8-02](https://user-images.githubusercontent.com/67748452/165387036-f62a94cc-7555-410c-bb27-2edc2741117b.png)
![t8-03](https://user-images.githubusercontent.com/67748452/165387037-e7e81852-293a-4164-930d-4ad6ad0f5931.png)
![t8-04](https://user-images.githubusercontent.com/67748452/165387040-d8b2d1cf-bf19-42aa-a2c3-e81dcaf1a678.png)
![t8-05](https://user-images.githubusercontent.com/67748452/165387042-0036f435-772e-4c92-a3ad-8f813738f97a.png)
![t8-06](https://user-images.githubusercontent.com/67748452/165387054-39a96a22-e1c1-42dd-b1b9-a711e1245973.png)
![t8-07](https://user-images.githubusercontent.com/67748452/165387061-cbbdece5-543b-4ca0-96a5-54460d8db611.png)
![t8-08](https://user-images.githubusercontent.com/67748452/165387064-d46321bd-bde1-436e-851b-703498ef7f58.png)
![t9-01](https://user-images.githubusercontent.com/67748452/165387065-06f044f3-aa66-4c1d-900b-d38c045ee3f6.png)
![t9-02](https://user-images.githubusercontent.com/67748452/165387070-c7fc61ca-1f48-445d-bf69-d16b4fd4023b.png)
![t9-03](https://user-images.githubusercontent.com/67748452/165387072-1254d705-7607-4980-b714-99f66d7f8862.png)
![t9-04](https://user-images.githubusercontent.com/67748452/165387076-cc16d098-79b5-425b-b948-c78ad808c8a1.png)
    
