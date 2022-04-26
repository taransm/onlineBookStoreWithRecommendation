<body>
<header>
<h1 class="title" style="text-align: center;">Book Store with Recommendation System</h1>

</header>
<br>
<h2 id="introduction">Introduction</h2>
<p>The Internet by far plays a major role in people’s life. It has drastically improved the quality of life and the standard of living of so many people. It has widened its branches into many different levels and areas. The e-commerce business is one such branch that has gotten a lot of attention recently. Traditional bookstores are not always accessible; they are limited by their hours of operation, the availability of specific books, their location, and, most crucially, their capacity and the space required to store a large number of books. As a result of these disadvantages, e-commerce sectors have evolved. Such drawbacks have led to the evolution of e-commerce industries related to bookstores. Our project is a simple website that includes a variety of books in various categories for consumers to view online.</p>
<p>With the growth of Youtube, Amazon, Netflix, and other similar web services over the last several decades, recommender systems have become increasingly important in our lives. Recommender systems are becoming ubiquitous in our everyday online journeys, from e-commerce (suggest articles to buyers that may be of interest) to online advertising (suggest the suitable contents to users based on their preferences). Recommender systems, in a broad sense, are algorithms that try to propose relevant items to consumers (items being movies to watch, text to read, products to buy or anything else depending on industries). In certain businesses, recommender systems are crucial since they may produce a large amount of revenue or serve as a method to differentiate yourself from rivals. As an example of the importance of recommender systems, Netflix held a competition (the "Netflix prize") a few years ago in which the objective was to create a recommender system that outperformed its own algorithm, with a reward of one million dollars on the line. </p>
<p>The main goal of this project is to make an online book recommendation system and examine the performance of the machine learning algorithm on a publicly available dataset from Kaggle. Weka API is used as the main tool to evaluate and recommend the books from the dataset.</p>
<p>Businesses rely on data scientists to derive insight from their enormous, ever-expanding, diverse set of data in today’s Big Data era. Many people think of data science as a job, but it’s more accurate to think of it as a way of thinking, a technique of extracting insights through the scientific process.  Our personal motivation derives from our desire to work in the field of data science in the near future. As a result, we aim to get some practical experience from this project.</p>
<h2 id="problem-solving-and-algorithms">Problem solving and algorithms</h2>
<p>The Book dataset utilized in this project is available at Kaggle.com [1]. The dataset can be viewed as either classification or regression tasks. This dataset can be used for building book recommendation system as it contains all the information for each book in the dataset. The dataset contains 9 descriptive features and 6238 instances. Books are identified by their respective Title. Moreover, some content-based information is given (Author, Edition, Reviews, Ratings, Synopsis, Genre, Book Category, and Price)</p>
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
<h3 id="preliminary-technical-tools">Preliminary technical tools</h3>
<p>The project will be developed based on the EC components from the labs and assignments of the course, and use the following basic tools.</p>
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
  
   ![t8-04](https://user-images.githubusercontent.com/67748452/165385877-3f04b899-2aff-41d5-8991-e507850f293b.png)
![t8-05](https://user-images.githubusercontent.com/67748452/165385880-2cdd7d86-06bd-4995-afa0-0e45342bfccb.png)
![t8-06](https://user-images.githubusercontent.com/67748452/165385881-cddb4215-0271-4cfd-8985-5195b5c4d6c1.png)
![t8-07](https://user-images.githubusercontent.com/67748452/165385884-821ad8aa-613b-4984-b2d8-4bd271bd9c68.png)
![t8-08](https://user-images.githubusercontent.com/67748452/165385886-c7f8c28c-ba4c-4e88-9d9e-96b3e2a8a73b.png)
![t9-01](https://user-images.githubusercontent.com/67748452/165385889-1caec2cf-d461-466a-acd2-13ad0ef6a7f7.png)
![t9-02](https://user-images.githubusercontent.com/67748452/165385891-a8428d4c-99bd-4c93-97d0-001f3bc967f6.png)
![t9-03](https://user-images.githubusercontent.com/67748452/165385892-4ed8c77f-9e9a-4e39-9a8d-070286ccbf88.png)
![t9-04](https://user-images.githubusercontent.com/67748452/165385894-a841df18-51f0-45c8-9580-832acb7d45ad.png)
![t2-01](https://user-images.githubusercontent.com/67748452/165385896-e407de68-6e0c-4810-af38-2218f8da982d.png)
![t2-02](https://user-images.githubusercontent.com/67748452/165385897-1ec92dd3-9eda-41b1-8e17-40a30c57132a.png)
![t2-03](https://user-images.githubusercontent.com/67748452/165385899-46c5df74-82ba-4f17-beb4-effe65938177.png)
![t3-01](https://user-images.githubusercontent.com/67748452/165385902-02b00906-3a9f-4d7c-a7e1-ac63eb20c27b.png)
![t4-01](https://user-images.githubusercontent.com/67748452/165385906-d8fc7545-32e8-40d6-8bd7-930fda993e09.png)
![t5-01](https://user-images.githubusercontent.com/67748452/165385908-6e2c081b-1886-4b8e-b917-686a1f337c8e.png)
![t5-02](https://user-images.githubusercontent.com/67748452/165385910-75c885d6-7d28-42c4-99b3-e294dac29951.png)
![t6-01](https://user-images.githubusercontent.com/67748452/165385913-266c04e4-9c89-476f-ac68-4b4e72665c3d.png)
![t7-01](https://user-images.githubusercontent.com/67748452/165385914-53fe4230-4a74-40c5-9692-bba1b375568d.png)
![t7-02](https://user-images.githubusercontent.com/67748452/165385916-0f97ddf9-82ba-45f1-b390-fb2c544bdd64.png)
![t8-01](https://user-images.githubusercontent.com/67748452/165385917-42b5706a-a26c-44ee-8c32-6841ef2c04ba.png)
![t8-02](https://user-images.githubusercontent.com/67748452/165385920-09849084-4bff-4d3a-b99d-ce177cfaabb6.png)
![t8-03](https://user-images.githubusercontent.com/67748452/165385921-775ba7bc-d652-41f1-a22e-1c4e4ce8c7da.png)

